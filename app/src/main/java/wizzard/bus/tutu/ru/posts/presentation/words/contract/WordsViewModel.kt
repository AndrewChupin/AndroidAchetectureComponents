package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.MutableLiveData
import com.testtask.santa.core.presentation.viewmodel.BaseViewModel
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import javax.inject.Inject


class WordsViewModel @Inject constructor(
    private val postsInteractor: WordsInteractor
): BaseViewModel(), WordsContract {

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
}

