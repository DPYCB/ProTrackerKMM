package com.dpycb.protrackerkmm.android

import android.app.Application
import com.dpycb.protrackerkmm.di.androidTasksModule
import com.dpycb.protrackerkmm.di.tasksModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ProTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ProTrackerApp)
            androidLogger()
            modules(tasksModule() + androidTasksModule(this@ProTrackerApp))
        }
    }
}