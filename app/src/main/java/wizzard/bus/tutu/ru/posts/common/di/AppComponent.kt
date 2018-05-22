package wizzard.bus.tutu.ru.posts.common.di

import android.app.Application
import com.testtask.santa.core.di.components.CoreComponent
import dagger.Component
import wizzard.bus.tutu.ru.posts.presentation.posts.di.PostsComponent

@Component(modules = [DatabaseModule::class])
interface AppComponent: CoreComponent {

    fun inject(application: Application)
    fun postsComponent(): PostsComponent.Builder

}