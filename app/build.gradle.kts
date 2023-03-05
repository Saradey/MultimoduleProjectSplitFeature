plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.evgeny.goncharov.sample.multimodule"
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
        freeCompilerArgs = listOf("-Xexplicit-api=strict")
    }
    buildFeatures {
        viewBinding = true
    }
    flavorDimensions += "analytics"
    productFlavors {
        create("firebase") {
            dimension = "analytics"
        }
        create("huawei") {
            dimension = "analytics"
        }
    }
}

dependencies {
    implementation(project(":sources:engine:main-activity"))
    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:resources:theme"))
    implementation(project(":sources:resources:ui-kit"))
    implementation(project(":sources:core:analytics"))

    implementation(project(":sources:features:splash-screen-impl"))
    implementation(project(":sources:features:bottom-menu-impl"))
    implementation(project(":sources:features:catalog-impl"))
    implementation(project(":sources:features:home-impl"))
    implementation(project(":sources:features:like-impl"))
    implementation(project(":sources:features:registration-impl"))

    implementation(coreLibs.cicerone)
    implementation(coreLibs.dagger)
    kapt(coreLibs.daggerCompiler)
    implementation(devLibs.timber)

    debugImplementation(devLibs.leak.canary)
}