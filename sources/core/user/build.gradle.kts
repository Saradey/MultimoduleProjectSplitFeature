plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.evgeny.goncharov.sample.multimodule.user"
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(coreLibs.dagger)

    kapt(coreLibs.daggerCompiler)
}