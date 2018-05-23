package com.testtask.santa.core.data.service

import com.squareup.moshi.Types
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.Deferred
import retrofit2.*
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class ResultCallAdapterFactory private constructor() : CallAdapter.Factory() {
    companion object {
        @JvmStatic @JvmName("create")
        operator fun invoke() = ResultCallAdapterFactory()
    }

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Deferred::class.java != CallAdapter.Factory.getRawType(returnType)) {
            return null
        }
        if (returnType !is ParameterizedType) {
            throw IllegalStateException("Deferred return type must be parameterized")
        }
        val responseType = CallAdapter.Factory.getParameterUpperBound(0, returnType)


        val rawDeferredType = CallAdapter.Factory.getRawType(responseType)
        return if (rawDeferredType == Response::class.java) {
            if (responseType !is ParameterizedType) {
                throw IllegalStateException("Response must be parameterized")
            }
            ResponseCallAdapter<Any>(CallAdapter.Factory.getParameterUpperBound(0, responseType))
        } else {
            val typeA = if (responseType is ParameterizedType)
                Types.newParameterizedType(ServerResponse::class.java, CallAdapter.Factory.getParameterUpperBound(0, responseType))
            else
                Types.newParameterizedType(ServerResponse::class.java)
            BodyCallAdapter<Any>(typeA)
        }
    }

    private class BodyCallAdapter<T>(
        private val responseType: Type
    ) : CallAdapter<ServerResponse<T>, Deferred<Result<T>>> {

        override fun adapt(call: Call<ServerResponse<T>>): Deferred<Result<T>> {
            val deferred = CompletableDeferred<Result<T>>()

            deferred.invokeOnCompletion {
                if (deferred.isCancelled) {
                    call.cancel()
                }
            }

            call.enqueue(object : Callback<ServerResponse<T>> {
                override fun onFailure(call: Call<ServerResponse<T>>, t: Throwable) {
                    deferred.complete(Result.Exception(t))
                }

                override fun onResponse(call: Call<ServerResponse<T>>, response: Response<ServerResponse<T>>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            if (it.code > 0) {
                                deferred.complete(Result.Error(it.code))
                            } else {
                                deferred.complete(Result.Success(it.data))
                            }
                        }
                    } else {
                        deferred.complete(Result.Exception(HttpException(response)))
                    }
                }
            })
            return deferred
        }

        override fun responseType() = responseType
    }


    private class ResponseCallAdapter<T: Any>(
        private val responseType: Type
    ) : CallAdapter<ServerResponse<T>, Any> {

        override fun adapt(call: Call<ServerResponse<T>>): Any {
            val deferred = CompletableDeferred<Result<Any>>()

            deferred.invokeOnCompletion {
                if (deferred.isCancelled) {
                    call.cancel()
                }
            }

            call.enqueue(object : Callback<ServerResponse<T>> {
                override fun onFailure(call: Call<ServerResponse<T>>, t: Throwable) {
                    deferred.complete(Result.Exception(t))
                }

                override fun onResponse(call: Call<ServerResponse<T>>, response: Response<ServerResponse<T>>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            if (it.code > 0) {
                                deferred.complete(Result.Error(it.code))
                            } else {
                                deferred.complete(Result.Success(it.data))
                            }
                        }
                    } else {
                        deferred.complete(Result.Exception(HttpException(response)))
                    }
                }
            })
            return deferred
        }

        override fun responseType() = responseType
    }
}
