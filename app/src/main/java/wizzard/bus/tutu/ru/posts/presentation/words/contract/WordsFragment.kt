package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wizzard.bus.tutu.ru.posts.R
import com.testtask.santa.core.presentation.adapter.DiffUtilCommon
import com.testtask.santa.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragments_words.*
import wizzard.bus.tutu.ru.posts.list.words.WordsAdapter
import wizzard.bus.tutu.ru.posts.presentation.words.di.WordsModule
import wizzard.bus.tutu.ru.posts.utils.delegate
import javax.inject.Inject

class WordsFragment: BaseFragment<WordsFragment>() {

    @Inject
    lateinit var contractFactory: WordsViewModelFactory

    private val postsContract: WordsContract by lazy {
        ViewModelProviders.of(this, contractFactory).get(WordsViewModel::class.java)
    }

    private var postAdapter: WordsAdapter? = null

    companion object {
        private val TAG = WordsFragment::class.java.name

        fun newInstance(): WordsFragment {
            val postsFragment = WordsFragment()
            val bundle = Bundle()
            postsFragment.arguments = bundle
            return postsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            it.delegate().appComponent
                    .postsComponent()
                    .module(WordsModule())
                    .build()
                    .inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragments_words, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Init adapter
        postAdapter = WordsAdapter()

        // Init recyclerView
        rv_posts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(context)
        }

        // Subscribe data
        postsContract.posts?.observeForever { posts ->
            postAdapter?.let {
                val diffResult = DiffUtil.calculateDiff(DiffUtilCommon(it.posts, posts!!), false)
                it.updateData(posts)
                diffResult.dispatchUpdatesTo(postAdapter)
            }
        }

        // LoadData
        postsContract.updateData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        postAdapter = null
    }

}
