package wizzard.bus.tutu.ru.posts.data.word.repository

import android.arch.paging.PositionalDataSource
import com.testtask.santa.core.presentation.viewmodel.SuspendExtensions
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor

class WordDataPaging(
    private val postsInteractor: WordsInteractor
): PositionalDataSource<Word>(), SuspendExtensions {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Word>) {
        launchUi {
            val words = postsInteractor.getWordsRange(params.startPosition, params.loadSize)
            callback.onResult(words)
        }
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Word>) {
        launchUi {
            val words = postsInteractor.getWordsRange(params.requestedStartPosition, params.requestedLoadSize)
            callback.onResult(words, params.requestedStartPosition)
        }
    }
}
