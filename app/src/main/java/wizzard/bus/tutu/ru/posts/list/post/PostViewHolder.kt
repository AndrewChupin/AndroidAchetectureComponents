package wizzard.bus.tutu.ru.posts.list.post

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_post.view.*
import wizzard.bus.tutu.ru.posts.data.post.entity.Post

class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(post: Post) {
        itemView.post_name.text = post.name
    }

}