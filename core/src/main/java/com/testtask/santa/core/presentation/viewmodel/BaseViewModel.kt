package com.testtask.santa.core.presentation.viewmodel

import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


open class BaseViewModel: ViewModel(), SuspendExtensions

interface SuspendExtensions {

    fun launchUi(block: suspend () -> Unit) {
        launch(UI) {
            block()
        }
    }

    fun launchUiSafe(onTry: suspend () -> Unit,
                     onCache: suspend (Throwable) -> Unit = {},
                     onFinally: suspend () -> Unit = {}) {
        launch(UI) {
            try {
                onTry()
            } catch (e: Exception) {
                onCache(e)
            } finally {
                onFinally()
            }
        }
    }
}
