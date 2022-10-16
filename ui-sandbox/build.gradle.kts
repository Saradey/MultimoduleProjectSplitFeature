plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        applicationId = "com.evgeny.goncharov.sample.multimodule.ui_sandbox"
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":sources:resources:theme"))
    implementation(project(":sources:resources:ui-kit"))

    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
}