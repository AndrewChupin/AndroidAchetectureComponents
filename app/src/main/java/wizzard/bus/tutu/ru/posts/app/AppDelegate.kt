package wizzard.bus.tutu.ru.posts.app

import android.app.Application
import wizzard.bus.tutu.ru.posts.common.di.AppComponent
import wizzard.bus.tutu.ru.posts.common.di.DaggerAppComponent

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

