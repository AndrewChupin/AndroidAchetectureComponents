package wizzard.bus.tutu.ru.posts.data.word.common

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import com.testtask.santa.core.data.mapper.Mappable

@Entity(tableName = "posts")
data class Word(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String
): Mappable<WordDto> {

    override fun map(): WordDto = WordDto(id, name)

}

data class WordDto (
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String
): Mappable<Word> {

    override fun map(): Word = Word(id, name)

}
