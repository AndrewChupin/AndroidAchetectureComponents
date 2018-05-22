package wizzard.bus.tutu.ru.posts.list.post

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.data.post.entity.Post


class PostsAdapter: RecyclerView.Adapter<PostViewHolder>() {

    var posts: List<Post> = emptyList()

    fun updateData(post: List<Post>) {
        this.posts = post
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

}
