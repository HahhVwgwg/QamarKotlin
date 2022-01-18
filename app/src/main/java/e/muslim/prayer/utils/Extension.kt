package e.muslim.prayer.utils

import android.annotation.SuppressLint
import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat

fun Context.getStyledResourceId(id: Int): Int {
    val attrs = intArrayOf(id)
    val typedArray = this.theme.obtainStyledAttributes(attrs)
    return typedArray.getResourceId(0, android.R.color.black)
}

fun View.onLong(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeLongClickListener {
        onSafeClick(it)
    }
    setOnLongClickListener(safeClickListener)
}

internal fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun AppCompatActivity.getNavHostFragmentA(@IdRes id: Int): NavHostFragment? {
    return supportFragmentManager.findFragmentById(id) as NavHostFragment?
}

fun Context.retrievingResources(resourceName: String, resourceType: String): Int =
    resources.getIdentifier(resourceName, resourceType, packageName)

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

fun String?.phoneIsValid(): Boolean {
    if (this == null) {
        return false
    }
    val regex = Regex(PHONE_MASK_REGEX)
    return this.trim().matches(regex)
}


fun String.underLine(): SpannableString {
    val spanStr = SpannableString(this)
    spanStr.setSpan(UnderlineSpan(), 0, spanStr.length, 0)
    return spanStr
}

fun String.insert(index: Int, string: String): String {
    return this.substring(0, index) + string + this.substring(index, this.length)
}

fun View.showKeyboard() {
    this.requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

@SuppressLint("SimpleDateFormat")
fun String.dateFormat(): String {
    return try {
        SimpleDateFormat("dd.MM.yyyy").format(
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(
                this.substring(0, 19)
            )!!
        )
    } catch (e: Exception) {
        ""
    }
}

fun String.colorMyText(
    startIndex: Int,
    endIndex: Int,
    textColor: Int,
): Spannable {
    val outPutColoredText: Spannable = SpannableString(this)
    outPutColoredText.setSpan(
        ForegroundColorSpan(textColor), startIndex, endIndex,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return outPutColoredText
}

fun String.findDigitIndex(): Int {
    this.forEachIndexed { index: Int, c: Char ->
        if (c.isDigit()) {
            return index
        }
    }
    return -1
}

fun String.toHex(): String {
    return try {
        val split = this.split(".")
        "#${"%02x".format(split[0].toInt())}${"%02x".format(split[1].toInt())}${
            "%02x".format(split[2].toInt())
        }"
    } catch (e: Exception) {
        e.printStackTrace()
        "#ffffff"
    }
}

fun <T> Fragment.getNavigationResult(key: String = "result") =
    findNavController().currentBackStackEntry?.savedStateHandle?.get<T>(key)

fun <T> Fragment.getNavigationResultLiveData(key: String = "result") =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

fun <T> Fragment.setNavigationResult(result: T, key: String = "result") {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}
