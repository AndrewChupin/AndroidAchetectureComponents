package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.post.entity.Post


class PostsInteractorDefault constructor(): PostsInteractor {

    override fun loadPosts(): Deferred<List<Post>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refreshPosts(): Deferred<List<Post>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
