package wizzard.bus.tutu.ru.posts.app

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import wizzard.bus.tutu.ru.posts.data.post.entity.Post
import wizzard.bus.tutu.ru.posts.data.post.manager.PostDao


@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postsDao(): PostDao
}
