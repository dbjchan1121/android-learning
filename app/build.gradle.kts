plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") version "2.1.10-1.0.31" // ksp
    id("kotlin-kapt") // kapt
}


android {
    namespace = "com.example.demoproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.demoproject"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    aaptOptions {
        ignoreAssetsPattern = "!._"
    }

}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    //noinspection UseTomlInstead
//    api ("androidx.constraintlayout:2.1.4")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // rxhttp
//    val rxhttpVersion = "3.3.1"
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
//    implementation("com.github.liujingxing.rxhttp:rxhttp:$rxhttpVersion")
    // 选择 kapt 或 ksp，一般推荐 ksp（性能更好）
//    ksp("com.github.liujingxing.rxhttp:rxhttp-compiler:$rxhttpVersion")

    implementation("com.github.bumptech.glide:glide:4.12.0") {
//        exclude group: 'com.android.support'
        exclude(
            "com.android.support"
        )
    }

    kapt("com.github.bumptech.glide:compiler:4.12.0")
//
//    implementation(libs.androidx.exifinterface)


}