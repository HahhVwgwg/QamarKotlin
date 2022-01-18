package e.muslim.prayer.utils

import android.os.SystemClock
import android.view.View
import android.view.animation.AnimationUtils
import e.muslim.prayer.R
import e.muslim.prayer.utils.App.Companion.lastTimeClicked

class SafeLongClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit
) : View.OnLongClickListener {

    override fun onLongClick(v: View): Boolean {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return false
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        v.startAnimation(AnimationUtils.loadAnimation(v.context, R.anim.fade_in))
        onSafeCLick(v)
        return true
    }
}