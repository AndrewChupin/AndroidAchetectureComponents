package com.testtask.santa.core.presentation.view

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import com.testtask.santa.core.presentation.viewmodel.BaseContract
import com.testtask.santa.core.presentation.viewmodel.Error


abstract class BaseFragment<Type: BaseContract>: Fragment() {

    abstract var contract: Type
    var errorDelegate: ContractErrorDelegate? = null


    @CallSuper
    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contract.error.observe(this, Observer<Error> {
            it?.let {
                errorDelegate?.onReceiveError(it)
            }
        })
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        errorDelegate = null
    }

}


interface ContractErrorDelegate {

    fun onReceiveError(error: Error)

}
