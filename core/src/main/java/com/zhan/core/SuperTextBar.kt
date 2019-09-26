package com.zhan.core

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.setPadding
import com.zhan.ktwing.ext.gone
import com.zhan.ktwing.ext.sp2px
import com.zhan.ktwing.ext.visible
import kotlinx.android.synthetic.main.super_textbar_view.view.*

/**
 *  @author:  hyzhan
 *  @date:    2019/7/25
 *  @desc:    TODO
 */
class SuperTextBar
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : RelativeLayout(context, attrs, defStyle) {

    private val smileDrawable = 0
    var leftIcon: Int = 0
    var rightIcon: Int = 0

    // 默认字体大小
    private val defaultSize = 14f.sp2px
    private val defaultColor = Color.BLACK

    var leftText: String = ""
        set(value) {
            field = value
            mTvLeft.visible()
            mTvLeft.text = value
        }


    var leftTextSize: Float
    var leftTextColor: Int


    var contentText: String = ""
        set(value) {
            field = value
            mTvContent.visible()
            mTvContent.text = value
        }
    var contentTextSize: Float
    var contentTextColor: Int

    var rightText: String = ""
        set(value) {
            field = value
            mTvRight.visible()
            mTvRight.text = value
        }
    var rightTextSize: Float
    var rightTextColor: Int

    var showTopLine: Boolean
    var showBottomLine: Boolean

    var padding: Int

    val topLineColor: Int
    val bottomLineColor: Int

    init {
        View.inflate(context, R.layout.super_textbar_view, this)

        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.SuperTextBar, defStyle, 0)
        with(typeArray) {
            padding = getDimensionPixelSize(R.styleable.SuperTextBar_padding, 0)

            leftIcon = getResourceId(R.styleable.SuperTextBar_leftIcon, smileDrawable)
            rightIcon = getResourceId(R.styleable.SuperTextBar_rightIcon, smileDrawable)

            leftText = getString(R.styleable.SuperTextBar_leftText) ?: ""
            leftTextSize = getDimension(R.styleable.SuperTextBar_leftTextSize, defaultSize)
            leftTextColor = getColor(R.styleable.SuperTextBar_leftTextColor, defaultColor)

            contentText = getString(R.styleable.SuperTextBar_contentText) ?: ""
            contentTextSize = getDimension(R.styleable.SuperTextBar_contentTextSize, defaultSize)
            contentTextColor = getColor(R.styleable.SuperTextBar_contentTextColor, defaultColor)

            rightText = getString(R.styleable.SuperTextBar_rightText) ?: ""
            rightTextSize = getDimension(R.styleable.SuperTextBar_rightTextSize, defaultSize)
            rightTextColor = getColor(R.styleable.SuperTextBar_rightTextColor, defaultColor)

            showTopLine = getBoolean(R.styleable.SuperTextBar_showTopLine, false)
            showBottomLine = getBoolean(R.styleable.SuperTextBar_showBottomLine, false)

            topLineColor = getColor(R.styleable.SuperTextBar_topLineColor, defaultColor)
            bottomLineColor = getColor(R.styleable.SuperTextBar_bottomLineColor, defaultColor)

            recycle()
        }

        drawSuperBar()
    }

    private fun drawSuperBar() {
        mLlContainer.setPadding(padding)

        mTopLine.setBackgroundColor(topLineColor)
        mBottomLine.setBackgroundColor(bottomLineColor)

        setImageSrc(mIvLeft, leftIcon)
        setImageSrc(mIvRight, rightIcon)

        setTextView(mTvLeft, leftText, leftTextSize, leftTextColor)

        setTextView(mTvContent, contentText, contentTextSize, contentTextColor)

        setTextView(mTvRight, rightText, rightTextSize, rightTextColor)

        mTopLine.apply { if (showTopLine) visible() else gone() }
        mBottomLine.apply { if (showBottomLine) visible() else gone() }
    }

    private fun setTextView(textView: TextView, content: String, textSize: Float, textColor: Int) {

        if (content.isEmpty()) {
            textView.gone()
            return
        }

        textView.run {
            visible()
            text = content
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
            setTextColor(textColor)
        }
    }

    private fun setImageSrc(imageView: ImageView, iconRes: Int) {
        if (iconRes == smileDrawable) {
            imageView.gone()
            return
        }

        imageView.run {
            visible()
            setImageResource(iconRes)
        }
    }
}