package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.MutableLiveData
import com.testtask.santa.core.presentation.viewmodel.BaseContract
import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsContract: BaseContract {
    val words: MutableLiveData<List<Word>>?
    fun updateData()
}

