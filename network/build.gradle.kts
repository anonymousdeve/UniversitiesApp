plugins {
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.android.library")
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


     ///////////////dagger2
     implementation(Libs.dagger_android)
     kapt(Libs.dagger_compiler_kapt)
     kapt(Libs.dagger_processor_kapt)

    // test and show api call response in notification
    // Chunk plugin to track apis response
    debugImplementation(Libs.chuckerDebug)
    releaseImplementation(Libs.chuckerRelease)
//
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}