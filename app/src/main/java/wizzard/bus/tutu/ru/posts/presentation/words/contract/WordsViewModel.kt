package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.testtask.santa.core.presentation.viewmodel.BaseViewModel
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import javax.inject.Inject


class WordsViewModel @Inject constructor(
    private val postsInteractor: WordsInteractor
): BaseViewModel(), WordsContract {

    override var wordsPagin: LiveData<PagedList<Word>> = MutableLiveData()

    override val words: MutableLiveData<List<Word>> by lazy {
        MutableLiveData<List<Word>>()
    }

    override fun updateData() = launchUi {
        try {
            val wordsResult = postsInteractor.getWords()
            words.value = wordsResult
            Log.d("Logos", "updateData")
        } catch (e: Exception) {
            super.error.value = e
        } finally {
            super.isLoading.value = false
        }
    }

    override fun bindToPage() = launchUi({
        try {
            val wordsResultPaging = postsInteractor.getWordsPaging()
            wordsPagin = LivePagedListBuilder(wordsResultPaging, 20).build()
            Log.d("Logos", "bindToPage")
        } catch (e: Exception) {
            super.error.value = e
        } finally {
            super.isLoading.value = false
        }
    })
}

