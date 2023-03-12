plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.evgeny.goncharov.sample.multimodule.authorization_impl"
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

    api(project(":sources:features:authorization-api"))
    implementation(project(":sources:engine:navigation"))
    implementation(project(":sources:engine:di-core"))

    implementation(project(":sources:resources:theme"))

    implementation(uiLibs.constraint.layout)
    implementation(coreLibs.cicerone)
    implementation(coreLibs.dagger)
    implementation(androidLibs.fragment)
    implementation(androidLibs.fragment.ktx)

    kapt(coreLibs.daggerCompiler)
}