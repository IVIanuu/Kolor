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

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi

inline var Activity.statusBarColor: Int
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = window.statusBarColor
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        window.statusBarColor = value
    }

inline var Activity.statusBarColorCompat: Int
    get() = window.statusBarColorCompat
    set(value) {
        window.statusBarColorCompat = value
    }

inline var Activity.isStatusBarLight: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.M)
    set(value) {
        window.isStatusBarLight = value
    }

inline var Activity.isStatusBarLightCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isStatusBarLightCompat = value
    }

inline var Activity.isDrawUnderStatusBar: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    set(value) {
        window.isDrawUnderStatusBar = value
    }

inline var Activity.isDrawUnderStatusBarCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isDrawUnderStatusBarCompat = value
    }

inline var Activity.isStatusBarTranslucent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
        window.isStatusBarTranslucent = value
    }

inline var Activity.isStatusBarTranslucentCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isStatusBarTranslucentCompat = value
    }

inline var Activity.isStatusBarTransparent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        window.isStatusBarTransparent = value
    }

inline var Activity.isStatusBarTransparentCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isStatusBarTranslucentCompat = value
    }

inline var Activity.isStatusBarHidden: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isStatusBarHidden = value
    }

inline var Activity.navigationBarColor: Int
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    get() = window.navigationBarColor
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        window.navigationBarColor = value
    }

inline var Activity.navigationBarColorCompat: Int
    get() = window.navigationBarColorCompat
    set(value) {
        window.navigationBarColorCompat = value
    }

inline var Activity.isNavigationBarTranslucent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
    }

inline var Activity.isNavigationBarTransparent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        window.isNavigationBarTransparent = value
    }

inline var Activity.isNavigationBarHidden: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
        window.isNavigationBarHidden = value
    }

inline var Activity.navigationBarDividerColor: Int
    @RequiresApi(Build.VERSION_CODES.P)
    get() = window.navigationBarDividerColor
    @RequiresApi(Build.VERSION_CODES.P)
    set(value) {
        window.navigationBarDividerColor = value
    }

inline var Activity.navigationBarDividerColorCompat: Int
    get() = window.navigationBarDividerColorCompat
    set(value) {
        window.navigationBarDividerColorCompat = value
    }

inline var Activity.isNavigationBarLight: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.O)
    set(value) {
        window.isNavigationBarLight = value
    }

inline var Activity.isNavigationBarLightCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        window.isNavigationBarLightCompat = value
    }
