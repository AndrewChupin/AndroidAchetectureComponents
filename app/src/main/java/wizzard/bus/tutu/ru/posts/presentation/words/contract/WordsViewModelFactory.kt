package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor


@Suppress("UNCHECKED_CAST")
class WordsViewModelFactory(
        private val interactor: WordsInteractor
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = WordsViewModel(interactor) as T

}
