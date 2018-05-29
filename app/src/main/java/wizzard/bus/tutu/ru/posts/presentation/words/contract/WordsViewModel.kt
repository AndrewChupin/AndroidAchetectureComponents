package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.annotation.SuppressLint
import android.arch.core.executor.ArchTaskExecutor
import android.arch.lifecycle.ComputableLiveData
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import android.util.Log
import com.testtask.santa.core.presentation.viewmodel.BaseViewModel
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.repository.WordDataPaging
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import javax.inject.Inject


class WordsViewModel @Inject constructor(
    private val postsInteractor: WordsInteractor
) : BaseViewModel(), WordsContract {

    @SuppressLint("RestrictedApi")
    override val wordsPaging: LiveData<PagedList<Word>> = object : ComputableLiveData<PagedList<Word>>(ArchTaskExecutor.getIOThreadExecutor()) {
        override fun compute(): PagedList<Word> {
            return PagedList.Builder(
                WordDataPaging(postsInteractor),
                PagedList.Config.Builder()
                    .setPageSize(10)
                    .setInitialLoadSizeHint(20)
                    .setEnablePlaceholders(false)
                    .build()
            ).build()
        }
    }.liveData


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

}
