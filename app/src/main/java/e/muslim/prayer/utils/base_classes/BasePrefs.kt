package e.muslim.prayer.utils.base_classes

import android.content.Context
import android.content.SharedPreferences

abstract class BasePrefs(context: Context, prefsName: String) {

    var prefs: SharedPreferences? = null

    companion object {
        private const val LANGUAGE = "language"
        private const val LANGUAGE_URL = "language_url"
    }

    init {
        prefs = context.getSharedPreferences(
            getDefaultSharedPreferencesName(context),
            Context.MODE_PRIVATE
        )
    }

    private fun getDefaultSharedPreferencesName(context: Context)
            : String =
        context.packageName + "_preferences"

}