package wizzard.bus.tutu.ru.posts.data.post.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String
)
