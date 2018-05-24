package wizzard.bus.tutu.ru.posts.data.word.service

import com.testtask.santa.core.data.service.BaseService
import com.testtask.santa.core.data.service.ResponseResult
import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto


interface WordService: BaseService {

    fun loadWords(): Deferred<ResponseResult<List<WordDto>>>

}
