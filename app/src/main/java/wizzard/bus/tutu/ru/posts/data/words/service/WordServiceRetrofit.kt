package wizzard.bus.tutu.ru.posts.data.words.service

import wizzard.bus.tutu.ru.posts.common.network.Api
import wizzard.bus.tutu.ru.posts.data.words.entity.WordDto
import javax.inject.Inject


class WordServiceRetrofit @Inject constructor(
        val api: Api
): WordService {

    override fun loadWords(): List<WordDto> = api.loadAllWords()

}