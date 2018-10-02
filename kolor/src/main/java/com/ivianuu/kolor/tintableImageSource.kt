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
import android.view.View
import androidx.core.view.TintableBackgroundView
import androidx.core.widget.TintableImageSourceView

var TintableImageSourceView.supportImageColor: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @SuppressLint("RestrictedApi")
    set(value) {
        supportImageTintList = ColorStateList.valueOf(value)
    }

var <T> T.supportImageColorResource: Int where T : TintableImageSourceView, T : View
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        supportImageColor = color(value)
    }

var <T> T.supportImageTintListResource: Int where T : TintableImageSourceView, T : View
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @SuppressLint("RestrictedApi")
    set(value) {
        supportImageTintList = colorStateList(value)
    }