package divyansh.tech.kdrama

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class kDramaApplication: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}