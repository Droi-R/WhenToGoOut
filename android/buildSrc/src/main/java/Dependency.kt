object Versions {
    const val HILT_VERSION = "2.50"
    const val COMPOSE_VERSION = "1.5.3"
    const val KOTLIN_VERSION = "1.9.21"
}


object Kotlin {
    const val SDK = "org.jetbrains.java:java-stdlib-jdk8:1.5.21"
}

object AndroidX {
    const val MATERIAL = "androidx.compose.material:material:1.0.0-rc02"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.0"
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.7.0"
    const val LEGACY = "androidx.legacy:legacy-support-v4:1.0.0"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val ACTIVITY = "androidx.activity:activity-ktx:1.3.1"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:1.3.6"
    const val DATASTORE = "androidx.datastore:datastore-preferences:1.0.0"
}

object KTX {
    const val CORE = "androidx.core:core-ktx:1.15.0"
}

object Google {
    const val MATERIAL = "com.google.android.material:material:1.12.0"
}

object Test {
    const val JUNIT = "junit:junit:4.+"
    const val ANDROID_JUNIT_RUNNER = "AndroidJUnitRunner"
}

object AndroidTest {
    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val TEST_RUNNER = "androidx.test:runner:1.4.0"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
}

object DaggerHilt {
    const val DAGGER_HILT = "com.google.dagger:hilt-android:${Versions.HILT_VERSION}"
    const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT_VERSION}"
    const val DAGGER_HILT_COMPOSE = "androidx.hilt:hilt-navigation-compose:1.1.0"
}

object Retrofit {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val CONVERTER_JAXB = "com.squareup.retrofit2:converter-jaxb:2.9.0"
}

object OkHttp {
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.1"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.1"
}

object Coroutines {
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
}

object CameraX {
    const val CAMERA_CORE = "androidx.camera:camera-core:1.0.2"
    const val CAMERA_CAMERA2 = "androidx.camera:camera-camera2:1.0.2"
    const val CAMERA_LIFECYCLE = "androidx.camera:camera-lifecycle:1.0.2"
    const val CAMERA_VIEW = "androidx.camera:camera-view:1.0.0-alpha29"
    const val CAMERA_EXTENSIONS = "androidx.camera:camera-extensions:1.0.0-alpha29"
}

object Compose {
    const val MATERIAL3 = "androidx.compose.material3:material3:1.1.0"
    const val ACTIVITY = "androidx.activity:activity-compose:1.7.2"
    const val UI = "androidx.compose.ui:ui:1.5.3"
    const val TOOLING = "androidx.compose.ui:ui-tooling:1.5.3"
    const val FOUNDATION = "androidx.compose.foundation:foundation:1.5.3"
}