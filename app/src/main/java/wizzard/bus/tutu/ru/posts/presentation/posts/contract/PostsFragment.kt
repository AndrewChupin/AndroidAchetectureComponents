package wizzard.bus.tutu.ru.posts.presentation.posts.contract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import wizzard.bus.tutu.ru.posts.core.presentation.view.BaseFragment
import wizzard.bus.tutu.ru.posts.utils.extensions.delegate
import javax.inject.Inject

class PostsFragment: BaseFragment<PostsFragment>() {

    @Inject
    lateinit var postsContract: PostsContract

    companion object {
        fun newInstance(): PostsFragment {
            val postsFragment = PostsFragment()
            val bundle = Bundle()
            postsFragment.arguments = bundle
            return postsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
        activity?.delegate()?.let {
            // TODO INJECT
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        postsContract.posts?.observeForever {

        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}
