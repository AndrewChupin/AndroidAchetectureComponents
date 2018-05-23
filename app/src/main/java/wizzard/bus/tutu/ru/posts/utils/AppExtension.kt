
package wizzard.bus.tutu.ru.posts.utils

import android.app.Activity
import wizzard.bus.tutu.ru.posts.app.AppDelegate

@Suppress("NOTHING_TO_INLINE")
inline fun Activity.delegate(): AppDelegate = application as AppDelegate
