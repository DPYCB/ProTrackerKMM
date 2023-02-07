package com.dpycb.protrackerkmm.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(tasksModule())
}