package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import android.arch.paging.DataSource
import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsInteractor {
    suspend fun getWords(): List<Word>
    suspend fun getWordsPaging(): DataSource.Factory<Int, Word>
}
