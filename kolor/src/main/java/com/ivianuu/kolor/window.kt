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

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi

inline var Window.statusBarColorCompat: Int
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        statusBarColor
    } else {
        0
    }
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            statusBarColor = value
        }
    }

inline var Window.isStatusBarLight: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.M)
    set(value) {
        setSystemUiVisibilityFlag(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR, value)
    }

inline var Window.isStatusBarLightCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            isStatusBarLight = value
        }
    }

inline var Window.isDrawUnderStatusBar: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    set(value) {
        setSystemUiVisibilityFlag(
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN,
            value
        )
    }

inline var Window.isDrawUnderStatusBarCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            isDrawUnderStatusBar = value
        }
    }

inline var Window.isStatusBarTranslucent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
        setWindowAttribute(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, value)
    }

inline var Window.isStatusBarTranslucentCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            isStatusBarTranslucent = value
        }
    }

inline var Window.isStatusBarTransparent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        setWindowAttribute(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS, value)
        isDrawUnderStatusBar = value
        if (value) statusBarColor = Color.TRANSPARENT
    }

inline var Window.isStatusBarTransparentCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            isStatusBarTransparent = value
        }
    }

inline var Window.isStatusBarHidden: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        setWindowAttribute(WindowManager.LayoutParams.FLAG_FULLSCREEN, value)
    }

inline var Window.navigationBarColorCompat: Int
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        navigationBarColor
    } else {
        0
    }
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            navigationBarColor = value
        }
    }

inline var Window.isNavigationBarTranslucent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
        setWindowAttribute(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, value)
    }

inline var Window.isNavigationBarTransparent: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    set(value) {
        setWindowAttribute(
            WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS
                    or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, value
        )
    }

inline var Window.isNavigationBarHidden: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    set(value) {
        setWindowAttribute(
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_IMMERSIVE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY, value
        )
    }

inline var Window.navigationBarDividerColorCompat: Int
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        navigationBarDividerColor
    } else {
        0
    }
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            navigationBarDividerColor = value
        }
    }

inline var Window.isNavigationBarLight: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    @RequiresApi(Build.VERSION_CODES.O)
    set(value) {
        setSystemUiVisibilityFlag(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR, value)
    }

inline var Window.isNavigationBarLightCompat: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR)
    get() = noGetter()
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            isNavigationBarLight = value
        }
    }

@PublishedApi
internal fun Window.setSystemUiVisibilityFlag(flag: Int, enabled: Boolean) {
    val decorView = decorView
    val systemUiVisibility = decorView.systemUiVisibility
    if (enabled) {
        decorView.systemUiVisibility = systemUiVisibility or flag
    } else {
        decorView.systemUiVisibility = systemUiVisibility and flag.inv()
    }
}

@PublishedApi
internal fun Window.setWindowAttribute(flag: Int, enabled: Boolean) {
    if (enabled) {
        addFlags(flag)
    } else {
        clearFlags(flag)
    }
}