package io.github.sooakim.navigationspace

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.util.AttributeSet
import android.view.View

class NavigationSpace : StatusSpace {
    override val space: Int
        get() {
            val resId = resources.getIdentifier(
                NAVIGATION_BAR_HEIGHT,
                DEF_DIMEN,
                PACKAGE_ANDROID
            )
            return if (resId > 0) resources.getDimension(resId).toInt()
            else 0
        }

    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    companion object {
        private const val NAVIGATION_BAR_HEIGHT = "navigation_bar_height"
        private const val DEF_DIMEN = "dimen"
        private const val PACKAGE_ANDROID = "android"
    }
}