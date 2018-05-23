package wizzard.bus.tutu.ru.posts.list.words

import android.view.LayoutInflater
import android.view.ViewGroup
import com.testtask.santa.core.presentation.view.BaseAdapter
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.data.word.common.Word


class WordsAdapter: BaseAdapter<Word, WordViewHolder>() {

    var posts: List<Word> = emptyList()

    override fun updateData(data: List<Word>) {
        this.posts = data
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
