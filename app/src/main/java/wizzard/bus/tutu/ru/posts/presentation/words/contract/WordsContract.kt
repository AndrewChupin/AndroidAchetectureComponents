package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.MutableLiveData
import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsContract {

    val posts: MutableLiveData<List<Word>>?

    fun updateData()

}

