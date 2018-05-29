package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.testtask.santa.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragments_words.*
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.list.words.WordsAdapter
import wizzard.bus.tutu.ru.posts.presentation.words.di.WordsModule
import wizzard.bus.tutu.ru.posts.utils.delegate
import javax.inject.Inject

class WordsFragment: BaseFragment<WordsContract>() {

    companion object {
        fun newInstance(): WordsFragment {
            val postsFragment = WordsFragment()
            val bundle = Bundle()
            postsFragment.arguments = bundle
            return postsFragment
        }
    }

    @Inject
    override lateinit var contract: WordsContract
    @LayoutRes
    override var layoutId: Int = R.layout.fragments_words

    private var postAdapter: WordsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.also {
            it.delegate().appComponent
                    .postsComponent()
                    .module(WordsModule(this))
                    .build()
                    .inject(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Init adapter
        postAdapter = WordsAdapter()

        // Init recyclerView
        rv_posts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(context)
        }

        contract.wordsPaging?.observe(this, Observer { newPosts ->
        postAdapter?.apply {
            Log.d("Logos", "submitList fragment $newPosts")
                if (newPosts != null) submitList(newPosts)
            }
        })

        // Subscribe data
        contract.words?.observe(this, Observer { newPosts ->
            /*postAdapter?.apply {
                if (newPosts != null) calculateDiffs(posts, newPosts)
            }*/
            contract.bindToPage()
            Log.d("Logos", "bindToPage fragment $newPosts")
        })

        // LoadData
        //contract.updateData()

        contract.bindToPage()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.postAdapter = null
    }

}
