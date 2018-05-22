package com.testtask.santa.core.di.components

import dagger.Component
import com.testtask.santa.core.di.modules.AppModule
import com.testtask.santa.core.di.modules.NetworkModule
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class])
interface CoreComponent
