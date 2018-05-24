package com.testtask.santa.core.presentation.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.testtask.santa.core.presentation.viewmodel.BaseContract
import com.testtask.santa.core.presentation.viewmodel.BaseContractDelegate

abstract class BaseFragment<Type: BaseContract>: Fragment(), BaseContractDelegate {

    abstract var layoutId: Int
    abstract var contract: Type
    var delegateBase: BaseContractDelegate? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.delegateBase = this
        contract.error.observe(this, Observer<Throwable> {
            it?.let {
                delegateBase?.onReceiveError(it)
            }
        })
        contract.isLoading.observe(this, Observer {
            it?.let {
                delegateBase?.onReceiveLoading(it)
            }
        })
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        this.delegateBase = null
    }

    override fun onReceiveError(error: Throwable) {
        when(error) {
            is IllegalStateException -> {
                // TODO SOMETHING
            }
        }
    }

    override fun onReceiveLoading(isLoading: Boolean) {
        if (isLoading) {
            // TODO SOMETHING
        } else {
            // TODO SOMETHING
        }
    }
}

