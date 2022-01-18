package e.muslim.prayer.utils

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.onesignal.OneSignal
import e.muslim.prayer.di.appModule
import e.muslim.prayer.di.networkModule
import e.muslim.prayer.di.repoModule
import e.muslim.prayer.di.storageModule
import e.muslim.prayer.utils.notifcation.NotificationOpenHandler
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        var lastTimeClicked: Long = 0
        private const val CHANNEL_LITRO_NOTIFICATION = "CHANNEL_QAMAR_NOTIFICATION"
        private const val LITRO_NOTIFICATION = "Qamar notification"
    }

    override fun onCreate() {
        super.onCreate()
//        createNotificationChannels()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, networkModule, repoModule, storageModule))
        }
//        initOneSignal()
    }

    private fun initOneSignal() {
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.setNotificationOpenedHandler(NotificationOpenHandler(this))
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_LITRO_NOTIFICATION,
                LITRO_NOTIFICATION,
                NotificationManager.IMPORTANCE_HIGH
            )//NotificationManager.IMPORTANCE_LOW
            channel1.description = "This is channel Qamar"
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
        }
    }
}
