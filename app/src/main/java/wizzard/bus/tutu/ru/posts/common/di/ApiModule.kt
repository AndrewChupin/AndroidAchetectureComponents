package wizzard.bus.tutu.ru.posts.common.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import wizzard.bus.tutu.ru.posts.common.network.Api
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

}
