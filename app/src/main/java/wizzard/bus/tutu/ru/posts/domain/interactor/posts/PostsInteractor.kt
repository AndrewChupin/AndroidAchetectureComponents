package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.post.entity.Post

interface PostsInteractor {

    fun loadPosts(): Deferred<List<Post>>
    fun refreshPosts(): Deferred<List<Post>>

}
