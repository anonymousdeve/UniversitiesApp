plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")

}

android {
    namespace = "ali.hrhera.module.base"
    compileSdk = AndroidLibs.compileSdk

    defaultConfig {
        minSdk = AndroidLibs.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.retrofit2)
    implementation(Libs.gson)

    implementation(Libs.coroutines_core)
    implementation(Libs.coroutines_android)


    implementation(Libs.core_ktx)


    implementation(Libs.fragment)
    implementation(Libs.appcompat)
    implementation(Libs.activity)

    implementation(Libs.room_ktx)
    implementation(Libs.room_runtime)
    kapt(Libs.room_compiler)


    ///////////////hilt
    implementation(Libs.hilt_android)
    implementation(Libs.hilt_worker)
    kapt(Libs.kapt_hilt_compiler)
    kapt(Libs.kapt_dagger_hilt_compiler)
    kapt(Libs.kapt_hilt_android_compiler)


    implementation(Libs.recycler_view)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}