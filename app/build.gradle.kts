plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int

    defaultConfig {
        applicationId = "com.evgeny.goncharov.sample.multimodule"
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode = rootProject.ext["versionCodeApp"] as Int
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

    implementation(coreLibs.core.ktx)
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
    testImplementation(devLibs.junit)
    androidTestImplementation(devLibs.test.ext)
    androidTestImplementation(devLibs.espresso)
}