plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.evgeny.goncharov.sample.multimodule.analytics"
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
    implementation(project(":sources:engine:di-core"))

    implementation(coreLibs.dagger)
    kapt(coreLibs.daggerCompiler)
    implementation(devLibs.timber)
}