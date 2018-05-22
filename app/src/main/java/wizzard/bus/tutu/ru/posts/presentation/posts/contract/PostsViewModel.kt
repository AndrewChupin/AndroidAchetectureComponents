package wizzard.bus.tutu.ru.posts.presentation.posts.contract

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import wizzard.bus.tutu.ru.posts.data.post.entity.Post
import javax.inject.Inject


class PostsViewModel @Inject constructor(
): ViewModel(), PostsContract {

    override var posts: MutableLiveData<List<Post>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
                loadPosts()
            }
            return field
        }

    override fun refreshData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun loadPosts() {

    }

}
