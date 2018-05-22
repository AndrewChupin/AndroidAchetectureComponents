package wizzard.bus.tutu.ru.posts.data.word.common

import com.testtask.santa.core.data.mapper.BaseMapper
import javax.inject.Inject

class WordDtoToDomain @Inject constructor(): BaseMapper<List<WordDto>, List<Word>> {

    override fun map(from: List<WordDto>): List<Word> = from.map { Word(it.id, it.name) }

}
