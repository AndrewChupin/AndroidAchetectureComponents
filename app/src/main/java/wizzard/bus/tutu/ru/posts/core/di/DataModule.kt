package wizzard.bus.tutu.ru.posts.core.di

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import wizzard.bus.tutu.ru.posts.app.Constants
import wizzard.bus.tutu.ru.posts.core.data.AppDatabase
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, Constants.APPLICATION_DATABASE_NAME).build()
    }

}
