package wizzard.bus.tutu.ru.posts.list.words

import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.testtask.santa.core.presentation.view.BaseAdapter
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.data.word.common.Word


class WordsAdapter: BaseAdapter<Word, WordViewHolder>(DIFF_CALLBACK) {
    var posts: List<Word> = emptyList()

    override fun updateData(data: List<Word>) {
        this.posts = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size



}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Word>() {
    // Concert details may have changed if reloaded from the database,
    // but ID is fixed.
    override fun areItemsTheSame(oldConcert: Word,
                                 newConcert: Word): Boolean =
        oldConcert.hashCode() == newConcert.hashCode()

    override fun areContentsTheSame(oldConcert: Word,
                                    newConcert: Word): Boolean =
        oldConcert == newConcert
}
