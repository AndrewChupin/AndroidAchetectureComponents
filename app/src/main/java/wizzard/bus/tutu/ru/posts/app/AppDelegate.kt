package wizzard.bus.tutu.ru.posts.app

import android.app.Application
import wizzard.bus.tutu.ru.posts.core.di.AppComponent
import wizzard.bus.tutu.ru.posts.core.di.DaggerAppComponent

class AppDelegate: Application() {

    val appComponent: AppComponent by lazy {
        val component = DaggerAppComponent.create()
        component.inject(this)
        component
    }

    override fun onCreate() {
        super.onCreate()
    }

}

