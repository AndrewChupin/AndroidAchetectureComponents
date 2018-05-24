package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.MutableLiveData
import com.testtask.santa.core.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import javax.inject.Inject


class WordsViewModel @Inject constructor(
    private val postsInteractor: WordsInteractor
): BaseViewModel(), WordsContract {

    companion object {
        private val TAG = WordsViewModel::class.java.name
    }

    override val words: MutableLiveData<List<Word>> by lazy {
        MutableLiveData<List<Word>>()
    }

    override fun updateData() = launchUi {
        try {
            val wordsResult = postsInteractor.getWords()
            words.value = wordsResult
        } catch (e: Exception) {
            super.error.value = e
        } finally {
            super.isLoading.value = false
        }
    }

    private fun launchUi(block: suspend () -> Unit) {
        launch(UI) {
            block()
        }
    }
}

