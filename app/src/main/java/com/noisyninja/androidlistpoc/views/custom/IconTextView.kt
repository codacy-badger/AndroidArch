package com.noisyninja.androidlistpoc.views.custom

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.Gravity
import android.widget.TextView


/**
 * to create icons using f
 * Created by sudiptadutta on 13/05/18.
 */

class IconTextView : TextView {

    private var mContext: Context

    constructor(context: Context) : super(context) {
        this.mContext = context
        createView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.mContext = context
        createView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        this.mContext = context
        createView()
    }

    private fun createView() {
        gravity = Gravity.CENTER

        val tf = Typeface.createFromAsset(context.assets, "fontawesome.ttf")
        setTypeface(tf, 1)
    }
}