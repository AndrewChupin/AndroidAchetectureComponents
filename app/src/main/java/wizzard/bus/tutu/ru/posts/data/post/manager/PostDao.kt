package wizzard.bus.tutu.ru.posts.data.post.manager

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import wizzard.bus.tutu.ru.posts.data.post.entity.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM posts")
    fun findPosts(): List<Post>

}
