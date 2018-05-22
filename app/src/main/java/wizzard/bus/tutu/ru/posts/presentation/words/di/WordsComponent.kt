package wizzard.bus.tutu.ru.posts.presentation.words.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import wizzard.bus.tutu.ru.posts.app.AppDatabase
import wizzard.bus.tutu.ru.posts.data.words.repository.WordRepository
import wizzard.bus.tutu.ru.posts.data.words.repository.WordRepositoryRoom
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractor
import wizzard.bus.tutu.ru.posts.domain.interactor.posts.WordsInteractorDefault
import wizzard.bus.tutu.ru.posts.presentation.words.contract.WordsFragment
import wizzard.bus.tutu.ru.posts.presentation.words.contract.WordsViewModelFactory

@WordsScope
@Subcomponent(modules = [WordsModule::class])
interface WordsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun module(module: WordsModule): Builder
        fun build(): WordsComponent
    }

    fun inject(wordsFragment: WordsFragment)

}


@Module
class WordsModule {

    @WordsScope
    @Provides
    fun provideWordRepository(appDatabase: AppDatabase): WordRepository = WordRepositoryRoom(appDatabase)

    @WordsScope
    @Provides
    fun provideWordsInteractor(wordRepository: WordRepository): WordsInteractor = WordsInteractorDefault(wordRepository)

    @WordsScope
    @Provides
    fun provideWordsContract(wordsInteractor: WordsInteractor): WordsViewModelFactory = WordsViewModelFactory(wordsInteractor)

}
