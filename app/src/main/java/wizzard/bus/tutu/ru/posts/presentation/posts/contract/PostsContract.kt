package wizzard.bus.tutu.ru.posts.presentation.posts.contract

import android.arch.lifecycle.MutableLiveData
import wizzard.bus.tutu.ru.posts.data.post.entity.Post

interface PostsContract {

    val posts: MutableLiveData<List<Post>>?

    fun refreshData()

}

