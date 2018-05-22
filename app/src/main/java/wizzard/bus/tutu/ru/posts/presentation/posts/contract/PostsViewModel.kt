package wizzard.bus.tutu.ru.posts.presentation.posts.contract

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import wizzard.bus.tutu.ru.posts.data.post.entity.Post
import javax.inject.Inject


class PostsViewModel @Inject constructor(
): ViewModel(), PostsContract {

    companion object {
        private val TAG = PostsViewModel::class.java.name
    }

    override val posts: MutableLiveData<List<Post>> by lazy {
        val postsTemp = MutableLiveData<List<Post>>()
        postsTemp.value = getPosts()
        postsTemp
    }

    override fun refreshData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun loadPosts() {
        posts.value = getPosts()
    }

    fun getPosts() = List(100) {
        Post(it.toLong(), "Mike $it")
    }

}

