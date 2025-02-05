package com.whentogoout

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

// Jetpack Compose UI 정의
@Composable
fun MyComposeComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "splash Page", color = Color.Black)
    }
}

// ComposeView를 감싸는 Android 네이티브 뷰
class MyComposeView(context: Context) : FrameLayout(context) {
    init {
        val composeView = ComposeView(context).apply {
            setContent { MyComposeComponent() }
        }
        addView(composeView)
    }
}

// React Native에서 사용할 네이티브 뷰 매니저
class MyComposeViewManager(reactContext: ReactApplicationContext) :
    SimpleViewManager<View>() {

    override fun getName() = "MyComposeView"

    override fun createViewInstance(reactContext: ThemedReactContext): View {
        return MyComposeView(reactContext)
    }
}