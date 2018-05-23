package com.testtask.santa.core.di.modules

import android.app.Application
import android.content.Context
import com.testtask.santa.core.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun providePreference(application: Application) = application
        .getSharedPreferences(BuildConfig.SHARED_NAME, Context.MODE_PRIVATE)


}
