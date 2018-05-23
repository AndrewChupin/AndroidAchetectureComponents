package wizzard.bus.tutu.ru.posts.common.di

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import wizzard.bus.tutu.ru.posts.app.AppDatabase
import wizzard.bus.tutu.ru.posts.app.Constants
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase =
         Room.databaseBuilder(application, AppDatabase::class.java, Constants.APPLICATION_DATABASE_NAME).build()

}
