package wizzard.bus.tutu.ru.posts.data.settings

internal const val WORDS_STATE_TOKEN = "words_state_token"

interface SettingsRepository {
    val wordsStateToken: String
}
