package wizzard.bus.tutu.ru.posts.list.words

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.data.words.entity.Word


class WordsAdapter: RecyclerView.Adapter<WordViewHolder>() {

    var posts: List<Word> = emptyList()

    fun updateData(post: List<Word>) {
        this.posts = post
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder?, position: Int) {
        holder?.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

}
