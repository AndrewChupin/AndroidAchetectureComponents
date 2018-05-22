package wizzard.bus.tutu.ru.posts.presentation.words.di

import com.testtask.santa.core.data.mapper.BaseMapper
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto
import wizzard.bus.tutu.ru.posts.data.word.common.WordDtoToDomain
import wizzard.bus.tutu.ru.posts.data.word.repository.WordRepository
import wizzard.bus.tutu.ru.posts.data.word.repository.WordRepositoryRoom
import wizzard.bus.tutu.ru.posts.data.word.service.WordService
import wizzard.bus.tutu.ru.posts.data.word.service.WordServiceRetrofit
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
    fun provideWordDtoToDomain(): WordDtoToDomain = WordDtoToDomain()

    @WordsScope
    @Provides
    fun provideWordRepository(wordRepositoryRoom: WordRepositoryRoom): WordRepository = wordRepositoryRoom

    @WordsScope
    @Provides
    fun provideWordService(wordServiceRetrofit: WordServiceRetrofit): WordService = wordServiceRetrofit

    @WordsScope
    @Provides
    fun provideWordsInteractor(wordsInteractor: WordsInteractorDefault): WordsInteractor = wordsInteractor

    @WordsScope
    @Provides
    fun provideWordsContract(wordsInteractor: WordsInteractor): WordsViewModelFactory = WordsViewModelFactory(wordsInteractor)

}
