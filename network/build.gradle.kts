plugins {
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.android.library")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ali.hrhera.module.network"
    compileSdk = AndroidLibs.compileSdk

    defaultConfig {
        lint.targetSdk = AndroidLibs.targetSdk
        minSdk = AndroidLibs.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"http://universities.hipolabs.com/\"")
        }
        buildFeatures {
            buildConfig = true
        }
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
    implementation(Libs.core_ktx)

    /////networking

    implementation(Libs.gson)
    implementation(Libs.logging_interceptor)
    implementation(Libs.okhttp)
    implementation(Libs.converter_gson)
    implementation(Libs.retrofit2) {
        exclude(group = "android.net.http")
        exclude(module = "okhttp")
        exclude(module = "httpclient", group = "org.apache.httpcomponents")
    }
    ////////////////////


    //coroutines
    implementation(Libs.coroutines_android)
    implementation(Libs.coroutines_core)


     ///////////////hilt
     implementation(Libs.hilt_android)
     implementation(Libs.hilt_worker)
     kapt(Libs.kapt_hilt_compiler)
     kapt(Libs.kapt_dagger_hilt_compiler)
     kapt(Libs.kapt_hilt_android_compiler)




    // test and show api call response in notification
    // Chunk plugin to track apis response
    debugImplementation(Libs.chuckerDebug)
    releaseImplementation(Libs.chuckerRelease)
//
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}