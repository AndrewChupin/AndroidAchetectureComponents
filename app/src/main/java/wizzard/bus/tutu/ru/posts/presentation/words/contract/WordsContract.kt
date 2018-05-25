package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.testtask.santa.core.presentation.viewmodel.BaseContract
import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsContract: BaseContract {
    val words: MutableLiveData<List<Word>>?
    val wordsPagin: LiveData<PagedList<Word>>?
    fun updateData()
    fun bindToPage()
}

