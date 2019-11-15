package com.zhan.core

import android.graphics.Typeface
import android.util.TypedValue
import android.widget.TextView
import com.zhan.ktwing.ext.gone
import com.zhan.ktwing.ext.visible

/**
 *  @author:  hyzhan
 *  @date:    2019/11/15
 *  @desc:    TODO
 */
class TextInfo(val content: String, var textSize: Float, val textColor: Int, var textStyle: Int) {

    fun setTextView(textView: TextView) {

        if (content.isEmpty()) {
            textView.gone()
            return
        }

        textView.let {
            it.visible()
            it.text = content
            it.typeface = Typeface.defaultFromStyle(textStyle)
            it.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
            it.setTextColor(textColor)
        }
    }
}

