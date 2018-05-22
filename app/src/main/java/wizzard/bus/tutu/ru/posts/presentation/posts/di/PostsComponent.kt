package wizzard.bus.tutu.ru.posts.presentation.posts.di

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import wizzard.bus.tutu.ru.posts.presentation.posts.contract.PostsContract
import wizzard.bus.tutu.ru.posts.presentation.posts.contract.PostsFragment
import wizzard.bus.tutu.ru.posts.presentation.posts.contract.PostsViewModel

@PostsScope
@Subcomponent(modules = [PostsComponent.PostsModule::class])
interface PostsComponent {

    @Subcomponent.Builder
    interface Builder {
        fun module(module: PostsModule): Builder
        fun build(): PostsComponent
    }

    @Module
    class PostsModule(private val fragment: Fragment) {

        @PostsScope
        @Provides
        fun provideHell(): PostsContract = ViewModelProviders.of(fragment).get(PostsViewModel::class.java)

    }

    fun inject(postsFragment: PostsFragment)

}
