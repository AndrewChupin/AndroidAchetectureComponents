package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.words.entity.Word

interface WordsInteractor {

    fun loadWords(): Deferred<List<Word>>
    fun refreshWords(): Deferred<List<Word>>

}
