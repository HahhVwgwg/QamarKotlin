package e.muslim.prayer.utils.base_classes

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import e.muslim.prayer.R

abstract class BaseActivity : AppCompatActivity(), IResourcesIDListener {

    private var dialogForLoader: Dialog? = null
    private var isShowMsg = false

    //  Initialize all widget in layout
    protected abstract fun initViews(savedInstanceState: Bundle?)
    protected abstract fun onCreateUI(savedInstanceState: Bundle?)

//    override fun attachBaseContext(base: Context) {
//        LanguageProvider.setLocale(base, this)
//        super.attachBaseContext(LanguageProvider.updateBaseContextLocale(base))
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_1)
        super.onCreate(savedInstanceState)
        onCreateUI(savedInstanceState)
    }

    /*  Modal windows  */
    open fun toast(context: Context?, msg: Any, isDuration: Boolean = false) {
        context?.let {
            val duration = if (isDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
            when (msg) {
                is String ->
                    Toast.makeText(context, msg, duration).show()
                is Int ->
                    Toast.makeText(context, msg, duration).show()
            }
        }
    }

//    fun showLoader() {
//        hideLoader()
//        dialogForLoader = Dialog(this)
//        dialogForLoader?.let { dialog ->
//            dialog.setContentView(R.layout.loader_litro)
//            dialog.setCancelable(false)
//            dialog.setCanceledOnTouchOutside(false)
//            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            dialog.show()
//        }
//    }
//
//    fun hideLoader() {
//        dialogForLoader?.dismiss()
//        killDialog()
//    }
//
//    private fun killDialog() {
//        if (dialogForLoader != null)
//            dialogForLoader = null
//    }

//    open fun showMsg(msg: String) {
//        if (isShowMsg) return
//        Dialog(this).apply {
//            this.setContentView(R.layout.layout_msg)
//            this.setCancelable(false)
//            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            this.setCanceledOnTouchOutside(false)
//            this.findViewById<Button>(R.id.btnClose).setOnClickListener {
//                isShowMsg = false
//                dismiss()
//            }
//            this.findViewById<android.widget.TextView>(R.id.dialogContent).text = msg
//            this.show()
//            isShowMsg = true
//        }
//    }

//    open fun showMsg(msg: String, callback: (result: Boolean) -> Unit) {
//        if (isShowMsg) return
//        Dialog(this).apply {
//            this.setContentView(R.layout.layout_msg)
//            this.setCancelable(false)
//            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            this.setCanceledOnTouchOutside(false)
//            this.findViewById<Button>(R.id.btnClose).setOnClickListener {
//                isShowMsg = false
//                dismiss()
//                callback.invoke(true)
//            }
//            this.findViewById<android.widget.TextView>(R.id.dialogContent).text = msg
//            this.show()
//            isShowMsg = true
//        }
//    }

//    fun showBiometricPermission(type: Int, callback: (result: Boolean) -> Unit) {
//        if (isShowMsg) return
//        Dialog(this).apply {
//            this.setContentView(R.layout.layout_msg_two_option_with_icon)
//            this.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT)
//            this.setCancelable(false)
//            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            this.setCanceledOnTouchOutside(false)
//            this.findViewById<ImageView>(R.id.image)
//                .setImageResource(if (type == 1) R.drawable.face_id else R.drawable.touch_id)
//            this.findViewById<TextView>(R.id.dialogContent).text =
//                if (type == 1) getStr(R.string.use_face_id_agreement) else getStr(R.string.use_touch_id_agreement)
//            this.findViewById<Button>(R.id.cancel).setOnClickListener {
//                isShowMsg = false
//                callback.invoke(false)
//                dismiss()
//            }
//            this.findViewById<Button>(R.id.ok).setOnClickListener {
//                isShowMsg = false
//                callback.invoke(true)
//                dismiss()
//            }
//            this.show()
//            isShowMsg = true
//        }
//    }


//    open fun showMsgTwoOption() {
//        if (isShowMsg) return
//        Dialog(this).apply {
//            this.setContentView(R.layout.layout_msg_two_option_with_icon)
//            this.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//            this.setCancelable(false)
//            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            this.setCanceledOnTouchOutside(false)
//            this.findViewById<Button>(R.id.cancel).setOnClickListener {
//                isShowMsg = false
//                dismiss()
//            }
//            this.findViewById<Button>(R.id.ok).setOnClickListener {
//                isShowMsg = false
//                dismiss()
//            }
//            this.show()
//            isShowMsg = true
//        }
//    }

//    open fun showMsgTwoOption(
//        content: String,
//        header: String,
//        callback: (result: Boolean) -> Unit,
//    ) {
//        if (isShowMsg) return
//        Dialog(this).apply {
//            this.setContentView(R.layout.layout_msg_two_option)
//            this.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//            this.setCancelable(false)
//            this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            this.setCanceledOnTouchOutside(false)
//            this.findViewById<TextView>(R.id.header).text = header
//            this.findViewById<TextView>(R.id.dialogContent).text = content
//            this.findViewById<Button>(R.id.cancel).setOnClickListener {
//                callback.invoke(false)
//                isShowMsg = false
//                dismiss()
//            }
//            this.findViewById<Button>(R.id.ok).setOnClickListener {
//                callback.invoke(true)
//                isShowMsg = false
//                dismiss()
//            }
//            this.show()
//            isShowMsg = true
//        }
//    }

    /*  Resources ID getters  */

    /*
     *  If your app supported more one language,
     *  you can add your locale
     *  example -> yourResources.getString(id);
     */
    override fun getStr(@StringRes id: Int): String = getString(id)

    /*
     * Concat all your text, strings and resources,
     * to one String
     */
    override fun concatStr(text: String): String = text

    /*
     * Get drawable (png, jpg, svg, ....) by ID
     */
    @Nullable
    override fun getImg(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(this, id)

    /*
     * Get color by ID
     */
    @ColorInt
    override fun getClr(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)
}