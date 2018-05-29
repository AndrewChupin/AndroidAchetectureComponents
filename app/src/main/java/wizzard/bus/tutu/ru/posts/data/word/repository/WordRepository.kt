package wizzard.bus.tutu.ru.posts.data.word.repository

import android.arch.paging.DataSource
import com.testtask.santa.core.data.repository.CurdRepository
import wizzard.bus.tutu.ru.posts.data.word.common.Word


interface WordRepository : CurdRepository<Word> {

    fun wordsPaging(): DataSource.Factory<Int, Word>

    fun wordsRange(from: Int, size: Int): List<Word>

}
