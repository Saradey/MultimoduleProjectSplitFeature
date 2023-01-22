plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
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
        freeCompilerArgs = listOf("-Xexplicit-api=strict")
    }
}

dependencies {
    implementation(project(":sources:engine:di-core"))
    implementation(androidLibs.fragment)
    implementation(androidLibs.fragment.ktx)
    implementation(coreLibs.cicerone)
    implementation(coreLibs.dagger)
    kapt(coreLibs.daggerCompiler)
}