package com.dpott.giantclient

import android.app.Application
import com.dpott.giantclient.data.GiantDataManager

/**
 * Created by dpott on 8/13/2017.
 */

class GiantApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GiantDataManager.init(true)
    }

}
