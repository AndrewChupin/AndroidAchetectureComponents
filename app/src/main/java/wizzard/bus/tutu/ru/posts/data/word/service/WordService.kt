package wizzard.bus.tutu.ru.posts.data.word.service

import com.testtask.santa.core.data.Result
import com.testtask.santa.core.data.service.BaseService
import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto


interface WordService: BaseService {

    fun loadWords(): Deferred<Result<List<WordDto>>>

}
