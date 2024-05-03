plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")

}

android {
    namespace = "ali.hrhera.module.universities"
    compileSdk = AndroidLibs.compileSdk

    defaultConfig {
        minSdk = AndroidLibs.minSdk
        lint.targetSdk = AndroidLibs.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(":network"))

///////////////dagger2
    implementation(Libs.dagger_android)
    kapt(Libs.dagger_compiler_kapt)
    kapt(Libs.dagger_processor_kapt)

    //coroutines
    implementation(Libs.coroutines_android)
    implementation(Libs.coroutines_core)

    //coroutines
    implementation(Libs.lifecycle_runtime)
    implementation(Libs.lifecycle_livedata_kt)
    implementation(Libs.lifecycle_viewmodel_kt)

    implementation(Libs.fragment)




    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}