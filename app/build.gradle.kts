plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")

}

android {
    compileSdk = AndroidLibs.compileSdk
    namespace = AndroidLibs.namespace

    defaultConfig {
        applicationId = AndroidLibs.applicationId
        minSdk = AndroidLibs.minSdk
        targetSdk = AndroidLibs.targetSdk
        versionCode = AndroidLibs.versionCode
        versionName = AndroidLibs.versionName

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
    implementation(project(":universities"))
    implementation(project(":base"))
    implementation(project(":network"))

    implementation(Libs.core_ktx)
    implementation(Libs.material)
    implementation(Libs.appcompat)

    implementation(Libs.navigation_fragment)
    implementation(Libs.navigation_fragment_ui)


    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}