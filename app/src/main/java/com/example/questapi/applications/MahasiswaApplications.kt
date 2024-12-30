package com.example.questapi.applications

import android.app.Application
import com.example.questapi.dependenciesinjection.AppContainer
import com.example.questapi.dependenciesinjection.MahasiswaContainer

class MahasiswaApplications : Application() {
    lateinit var container: AppContainer


    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}
