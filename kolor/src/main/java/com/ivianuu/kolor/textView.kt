/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.kolor

import android.graphics.PorterDuff
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.lang.reflect.Field

// todo fix on android p
var TextView.cursorColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        try {
            val fCursorDrawableRes = TextView::class.field("mCursorDrawableRes")
            val mCursorDrawableRes = fCursorDrawableRes.getInt(this)
            val fEditor = TextView::class.field("mEditor")
            val editor = fEditor.get(this)
            val clazz = editor.javaClass
            val fCursorDrawable = clazz.field("mCursorDrawable")

            val drawables = arrayOf(
                ContextCompat.getDrawable(context, mCursorDrawableRes)?.apply { tint = value },
                ContextCompat.getDrawable(context, mCursorDrawableRes)?.apply { tint = value }
            )

            fCursorDrawable.set(editor, drawables)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

var TextView.selectionHighlightColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        //You would think you would modify mHighlightPaint, but no, you need to modify mHighlightColor,
        //as it gets set as the color on the paint on each draw call
        try {
            val fHighlightColor = TextView::class.field("mHighlightColor")
            fHighlightColor.set(this, value)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

var TextView.textHandleColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        try {
            val clazz = TextView::class

            val fTextSelectHandleLeftRes = clazz.field("mTextSelectHandleLeftRes")
            val fTextSelectHandleRightRes = clazz.field("mTextSelectHandleRightRes")
            val fTextSelectHandleCenterRes = clazz.field("mTextSelectHandleRes")

            val leftRes = fTextSelectHandleLeftRes.getInt(this)
            val rightRes = fTextSelectHandleRightRes.getInt(this)
            val centerRes = fTextSelectHandleCenterRes.getInt(this)

            val fEditor = clazz.field("mEditor")
            val editor = fEditor.get(this)

            val fHandleLeftDrawable = editor.javaClass.field("mSelectHandleLeft")
            val fHandleRightDrawable = editor.javaClass.field("mSelectHandleRight")
            val fHandleCenterDrawable = editor.javaClass.field("mSelectHandleCenter")

            setDrawable(editor, fHandleLeftDrawable, value, leftRes)
            setDrawable(editor, fHandleRightDrawable, value, rightRes)
            setDrawable(editor, fHandleCenterDrawable, value, centerRes)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

private fun TextView.setDrawable(editor: Any, field: Field, color: Int, drawableRes: Int) {
    val drawable = ContextCompat.getDrawable(context, drawableRes)?.mutate()?.apply {
        tintMode = PorterDuff.Mode.SRC_IN
        tint = color
    }
    field.set(editor, drawable)
}