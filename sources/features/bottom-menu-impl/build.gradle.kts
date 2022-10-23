plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.evgeny.goncharov.multimodule.bottom_menu_impl"
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
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
}

dependencies {
    api(project(":sources:features:bottom-menu-api"))

    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:engine:di-core"))
    implementation(project(":sources:resources:ui-kit"))
    implementation(project(":sources:resources:theme"))
    implementation(project(":sources:core:base-core"))

    implementation(project(":sources:features:home-api"))
    implementation(project(":sources:features:catalog-api"))
    implementation(project(":sources:features:registration-api"))

    implementation(coreLibs.viewmodel)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
    implementation(uiLibs.app.compat)
    implementation(uiLibs.viewBindingPropertyDelegate)
    implementation(coreLibs.dagger)
    implementation(coreLibs.cicerone)
    implementation(androidLibs.fragment)
    implementation(androidLibs.fragment.ktx)

    kapt(coreLibs.daggerCompiler)
}