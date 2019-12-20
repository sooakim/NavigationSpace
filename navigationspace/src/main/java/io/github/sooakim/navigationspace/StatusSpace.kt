package io.github.sooakim.navigationspace

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.TypedValue
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View

open class StatusSpace : View {
    open val space: Int
        get() {
            val resId = resources.getIdentifier(
                STATUS_BAR_HEIGHT,
                DEF_DIMEN,
                PACKAGE_ANDROID
            )
            return if (resId > 0) resources.getDimension(resId).toInt()
            else 0
        }

    constructor(context: Context?) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(
        context,
        attrs,
        defStyleAttr
    ){
        if (visibility == VISIBLE) visibility = INVISIBLE
    }

    @SuppressLint("MissingSuperCall")
    override fun draw(canvas: Canvas?) {

    }

    override fun setVisibility(visibility: Int) {
        if (visibility == VISIBLE) super.setVisibility(INVISIBLE)
        else super.setVisibility(visibility)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(
            getDefaultSize2(suggestedMinimumWidth, widthMeasureSpec),
            getDefaultSize2(space, heightMeasureSpec)
        )
    }

    private fun getDefaultSize2(size: Int, measureSpec: Int): Int {
        var result = size
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        when (specMode) {
            MeasureSpec.UNSPECIFIED -> result = size
            MeasureSpec.AT_MOST -> result = size.coerceAtMost(specSize)
            MeasureSpec.EXACTLY -> result = specSize
        }
        return result
    }

    companion object{
        private const val STATUS_BAR_HEIGHT = "status_bar_height"
        private const val DEF_DIMEN = "dimen"
        private const val PACKAGE_ANDROID = "android"
    }
}