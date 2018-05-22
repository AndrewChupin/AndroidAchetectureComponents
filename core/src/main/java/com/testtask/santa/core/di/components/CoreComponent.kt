package com.testtask.santa.core.di.components

import dagger.Component
import com.testtask.santa.core.di.modules.AppModule
import com.testtask.santa.core.di.modules.NetworkModule


@Component(modules = [AppModule::class, NetworkModule::class])
interface CoreComponent
