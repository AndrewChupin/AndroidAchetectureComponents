package wizzard.bus.tutu.ru.posts.app

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.repository.WordDao


@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postsDao(): WordDao
}
