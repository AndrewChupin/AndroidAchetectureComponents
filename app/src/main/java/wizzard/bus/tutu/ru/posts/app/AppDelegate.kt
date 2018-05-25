package wizzard.bus.tutu.ru.posts.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.testtask.santa.core.di.modules.AppModule
import wizzard.bus.tutu.ru.posts.common.di.AppComponent
import wizzard.bus.tutu.ru.posts.common.di.DaggerAppComponent
import wizzard.bus.tutu.ru.posts.common.di.DatabaseModule

class AppDelegate: Application() {

    val appComponent: AppComponent by lazy {
        val component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .databaseModule(DatabaseModule())
                .build()

        component.inject(this)
        component
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

}

