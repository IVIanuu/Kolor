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

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.appcompat.widget.SwitchCompat

fun SwitchCompat.tint(color: Int) {
    setThumbColor(color)
    setTrackColor(color)
}

fun SwitchCompat.setThumbColor(color: Int) {
    thumbTintList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_checked),
            intArrayOf(android.R.attr.state_checked)
        ), intArrayOf(colorAttr(androidx.appcompat.R.attr.colorSwitchThumbNormal), color)
    )
}

fun SwitchCompat.setTrackColor(color: Int) {
    trackTintList = ColorStateList(
        arrayOf(
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf()
        ), intArrayOf(
            colorAttr(android.R.attr.colorForeground).adjustAlpha(0.1f),
            color.adjustAlpha(0.3f),
            colorAttr(android.R.attr.colorForeground).adjustAlpha(0.3f)
        )
    )
}