plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ali.hrhera.module.university_details"
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
    implementation(project(":base"))

    implementation(Libs.appcompat)
    implementation(Libs.material)
///////////////hilt
    implementation(Libs.hilt_android)
    implementation(Libs.hilt_worker)
    kapt(Libs.kapt_hilt_compiler)
    kapt(Libs.kapt_dagger_hilt_compiler)
    kapt(Libs.kapt_hilt_android_compiler)

    implementation(Libs.navigation_fragment)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}