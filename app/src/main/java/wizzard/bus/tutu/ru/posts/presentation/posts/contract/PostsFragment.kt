package wizzard.bus.tutu.ru.posts.presentation.posts.contract

import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wizzard.bus.tutu.ru.posts.R
import com.testtask.santa.core.presentation.adapter.CommonDiffUtill
import com.testtask.santa.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.fragments_posts.*
import wizzard.bus.tutu.ru.posts.list.post.PostsAdapter
import wizzard.bus.tutu.ru.posts.presentation.posts.di.PostsModule
import wizzard.bus.tutu.ru.posts.utils.delegate
import javax.inject.Inject

class PostsFragment: BaseFragment<PostsFragment>() {

    @Inject
    lateinit var postsContract: PostsContract
    private var postAdapter: PostsAdapter? = null

    companion object {
        private val TAG = PostsFragment::class.java.name

        fun newInstance(): PostsFragment {
            val postsFragment = PostsFragment()
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
                    .module(PostsModule(this))
                    .build()
                    .inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragments_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postAdapter = PostsAdapter()

        rv_posts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(context)
        }

        postsContract.posts?.observeForever { posts ->
            Log.d(TAG, "Logos | onViewCreated : ")
            postAdapter?.let {
                val diffResult = DiffUtil.calculateDiff(CommonDiffUtill(it.posts, posts!!), false)
                it.updateData(posts)
                diffResult.dispatchUpdatesTo(postAdapter)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        postAdapter = null
    }

}
