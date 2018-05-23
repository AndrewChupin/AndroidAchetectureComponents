package wizzard.bus.tutu.ru.posts.presentation.words.contract

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.testtask.santa.core.presentation.adapter.calculateDiffs
import com.testtask.santa.core.presentation.view.BaseFragment
import com.testtask.santa.core.presentation.view.ContractErrorDelegate
import com.testtask.santa.core.presentation.viewmodel.Error
import kotlinx.android.synthetic.main.fragments_words.*
import wizzard.bus.tutu.ru.posts.R
import wizzard.bus.tutu.ru.posts.list.words.WordsAdapter
import wizzard.bus.tutu.ru.posts.presentation.words.di.WordsModule
import wizzard.bus.tutu.ru.posts.utils.delegate
import javax.inject.Inject

class WordsFragment : BaseFragment<WordsContract>(), ContractErrorDelegate {

    companion object {
        private val TAG = WordsFragment::class.java.name

        fun newInstance(): WordsFragment {
            val postsFragment = WordsFragment()
            val bundle = Bundle()
            postsFragment.arguments = bundle
            return postsFragment
        }
    }

    @Inject
    override lateinit var contract: WordsContract
    var postAdapter: WordsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let {
            it.delegate().appComponent
                    .postsComponent()
                    .module(WordsModule(this))
                    .build()
                    .inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragments_words, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.errorDelegate = this

        // Init adapter
        postAdapter = WordsAdapter()


        // Init recyclerView
        rv_posts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(context)
        }

        // Subscribe data
        contract.posts?.observeForever { newPosts ->
            postAdapter?.apply {
                if (newPosts != null) calculateDiffs(posts, newPosts)
            }
        }

        // LoadData
        contract.updateData()
    }

    override fun onReceiveError(error: Error) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.postAdapter = null
    }

}
