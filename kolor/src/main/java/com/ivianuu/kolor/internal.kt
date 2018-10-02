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

import android.annotation.TargetApi
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import android.view.View
import androidx.annotation.RestrictTo

internal fun Context.colorAttr(attr: Int): Int {
    val attrs = theme.obtainStyledAttributes(intArrayOf(attr))
    val color = attrs.getColor(0, 0)
    attrs.recycle()
    return color
}

internal fun View.colorAttr(attr: Int) = context.colorAttr(attr)

val Int.isDark: Boolean
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    get() = !isLight

val Int.isLight: Boolean
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    get() {
        val darkness =
            1 - (0.299 * Color.red(this)
                    + 0.587 * Color.green(this)
                    + 0.114 * Color.blue(this)) / 255
        return darkness < 0.4
    }

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.stripAlpha(): Int = 0xff000000.toInt() or this

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.shifted(by: Float): Int {
    if (by == 1f) return this
    val alpha = Color.alpha(this)
    val hsv = FloatArray(3)
    Color.colorToHSV(this, hsv)
    hsv[2] *= by
    return (alpha shl 24) + (0x00ffffff and Color.HSVToColor(hsv))
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.darken(): Int = shifted(0.9f)

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.lighten(): Int = shifted(1.1f)

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.inverted(): Int {
    val r = 255 - Color.red(this)
    val g = 255 - Color.green(this)
    val b = 255 - Color.blue(this)
    return Color.argb(Color.alpha(this), r, g, b)
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.adjustAlpha(factor: Float): Int {
    val alpha = Math.round(Color.alpha(this) * factor)
    val red = Color.red(this)
    val green = Color.green(this)
    val blue = Color.blue(this)
    return Color.argb(alpha, red, green, blue)
}

@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
fun Int.withAlpha(alpha: Float): Int {
    val a = Math.min(255, Math.max(0, (alpha * 255).toInt())) shl 24
    val rgb = 0x00ffffff and this
    return a + rgb
}

fun Int.blendedWith(other: Int, ratio: Float): Int {
    val inverseRatio = 1f - ratio
    val a = Color.alpha(this) * inverseRatio + Color.alpha(other) * ratio
    val r = Color.red(this) * inverseRatio + Color.red(other) * ratio
    val g = Color.green(this) * inverseRatio + Color.green(other) * ratio
    val b = Color.blue(this) * inverseRatio + Color.blue(other) * ratio
    return Color.argb(a.toInt(), r.toInt(), g.toInt(), b.toInt())
}