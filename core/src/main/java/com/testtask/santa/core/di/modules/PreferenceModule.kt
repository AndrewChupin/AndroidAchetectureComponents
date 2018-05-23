package com.testtask.santa.core.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.testtask.santa.core.BuildConfig
import com.testtask.santa.core.di.qualifiers.RequestState
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Singleton
    @Provides
    @RequestState
    fun providePreference(application: Application): SharedPreferences = application
        .getSharedPreferences(BuildConfig.SHARED_NAME, Context.MODE_PRIVATE)


}
