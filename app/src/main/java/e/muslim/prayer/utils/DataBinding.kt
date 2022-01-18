package e.muslim.prayer.utils

import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import e.muslim.prayer.R

class DataBinding {
    companion object {

    }
}

@BindingAdapter("customTint")
fun ImageView.setImageTint(@ColorInt color: Int) {
    setColorFilter(color)
}

@BindingAdapter("customBottomNavigationColor")
fun setThemeAttrColor(
    tv: TextView,
    isActive: Boolean,
) { // This methods should not have any return type, = declaration would make it return that object declaration.
    val typedValue = TypedValue()
    val theme = tv.context.theme
    theme.resolveAttribute(
        if (isActive) R.attr.bottomSheetText else R.attr.bottomSheetTextNotActive,
        typedValue,
        true
    )
    tv.setTextColor(typedValue.data)
}

@BindingAdapter("customBottomNavigationImageTint")
fun setThemeAttrTint(
    image: ImageView,
    isActive: Boolean,
) { // This methods should not have any return type, = declaration would make it return that object declaration.
    val typedValue = TypedValue()
    val theme = image.context.theme
    theme.resolveAttribute(
        if (isActive) R.attr.bottomSheetText else R.attr.bottomSheetTextNotActive,
        typedValue,
        true
    )
    image.setColorFilter(typedValue.data, android.graphics.PorterDuff.Mode.SRC_IN)
}