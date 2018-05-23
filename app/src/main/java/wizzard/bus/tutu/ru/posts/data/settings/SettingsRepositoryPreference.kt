package wizzard.bus.tutu.ru.posts.data.settings

import android.content.SharedPreferences
import com.testtask.santa.core.di.qualifiers.RequestState
import com.testtask.santa.core.utils.StringConstants
import javax.inject.Inject


class SettingsRepositoryPreference @Inject constructor(
    @RequestState private val sharedPreferences: SharedPreferences
): SettingsRepository {

    override val wordsStateToken: String
        get() = sharedPreferences.getString(WORDS_STATE_TOKEN, StringConstants.EMPTY)

}
