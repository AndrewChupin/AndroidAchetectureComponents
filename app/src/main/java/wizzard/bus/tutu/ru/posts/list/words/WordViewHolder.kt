package wizzard.bus.tutu.ru.posts.list.words

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_word.view.*
import wizzard.bus.tutu.ru.posts.data.word.common.Word

class WordViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun bind(post: Word) {
        itemView.post_name.text = post.name
    }

}