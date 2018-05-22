package wizzard.bus.tutu.ru.posts.data.words.service

import com.testtask.santa.core.data.service.BaseService
import wizzard.bus.tutu.ru.posts.data.words.entity.WordDto


interface WordService: BaseService {

    fun loadWords(): List<WordDto>

}