package wizzard.bus.tutu.ru.posts.core.di

import android.app.Application
import dagger.Component
import wizzard.bus.tutu.ru.posts.presentation.posts.di.PostsComponent


@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(application: Application)
    fun plusPostsComponent(postsComponent: PostsComponent)

}
