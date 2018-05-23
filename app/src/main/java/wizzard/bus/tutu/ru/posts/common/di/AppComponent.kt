package wizzard.bus.tutu.ru.posts.common.di

import android.app.Application
import com.testtask.santa.core.di.modules.AppModule
import com.testtask.santa.core.di.modules.NetworkModule
import com.testtask.santa.core.di.modules.PreferenceModule
import dagger.Component
import wizzard.bus.tutu.ru.posts.presentation.words.di.WordsComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DatabaseModule::class,
    ApiModule::class,
    AppModule::class,
    NetworkModule::class,
    PreferenceModule::class
])
interface AppComponent {

    fun inject(application: Application)
    fun postsComponent(): WordsComponent.Builder

}
