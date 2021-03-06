package com.parassidhu.coronavirusapp

import android.app.Application
import com.parassidhu.coronavirusapp.di.ApplicationComponent
import com.parassidhu.coronavirusapp.di.ApplicationModule
import com.parassidhu.coronavirusapp.di.DaggerApplicationComponent

class CoronaApp: Application() {

   /* @Inject
    lateinit var networkFlipperPlugin: NetworkFlipperPlugin*/

    override fun onCreate() {
        super.onCreate()
        instance = this

        initDagger()
        initFlipper()
    }

    private fun initDagger() {
        component =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    private fun initFlipper() {
        /*SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            val client = AndroidFlipperClient.getInstance(this).apply {

                addPlugin(InspectorFlipperPlugin(this@CoronaApp, DescriptorMapping.withDefaults()))
                addPlugin(networkFlipperPlugin)
                start()
            }
        }*/
    }

    companion object {
        lateinit var instance: CoronaApp
            private set
        lateinit var component: ApplicationComponent
            private set
    }
}