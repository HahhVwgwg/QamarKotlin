package e.muslim.prayer.utils.notifcation

import android.app.Application
import android.content.Intent
import android.util.Log
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OneSignal


internal class NotificationOpenHandler(private val application: Application) :
    OneSignal.OSNotificationOpenedHandler {
    override fun notificationOpened(result: OSNotificationOpenedResult) {
        val data = result.notification.additionalData
        val type: String?
        val typeId: String?
        val id: String?
        val intent = Intent()
        if (data != null) {
            type = data.optString("type", null)
            typeId = data.optString("type_id", null)
            id = data.optString("order_id", null)
            Log.d("OneSignalExample", "type: $type")
            Log.d("OneSignalExample", "type_id: $id")
//
//            intent.putExtra(PUSH_TYPE, type)
//            intent.putExtra(PUSH_TYPE_ITEM_ID, id)
        }
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK
        application.baseContext.startActivity(intent)
    }
}