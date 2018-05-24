package wizzard.bus.tutu.ru.posts.data.word.service

import com.testtask.santa.core.data.service.ResponseResult
import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.common.network.Api
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto
import javax.inject.Inject


class WordServiceRetrofit @Inject constructor(
    private val api: Api
) : WordService {
    override fun loadWords(): Deferred<ResponseResult<List<WordDto>>> = api.loadAllWords()
}
