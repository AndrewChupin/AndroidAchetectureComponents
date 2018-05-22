package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import wizzard.bus.tutu.ru.posts.data.words.entity.Word
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import javax.inject.Inject


class WordsViewModel @Inject constructor(
        val postsInteractor: WordsInteractor
): ViewModel(), WordsContract {

    companion object {
        private val TAG = WordsViewModel::class.java.name
    }

    override val posts: MutableLiveData<List<Word>> by lazy {
        MutableLiveData<List<Word>>()
    }

    override fun updateData() {
        launch(UI) {
            posts.value = postsInteractor.loadWords().await()
        }
    }

}

