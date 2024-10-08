plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.tofi_app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tofi_app"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //dependencies from modules
    implementation(project(":data"))
    implementation(project(":domain"))

    // Android Studio Preview support
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)

    //Integration with activities
    implementation(libs.androidx.activity.compose.v190)
    //Integration with ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    //Integration with LiveData
    implementation(libs.androidx.runtime.livedata)
    // Lifecycle utilities for Compose
    implementation(libs.androidx.lifecycle.runtime.compose)

    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)

    // Views/Fragments integration
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    // Feature module support for Fragments
    implementation(libs.androidx.navigation.dynamic.features.fragment)

    // Navigation with hilt di
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.hilt.navigation.fragment)

    // Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //Splash screen
    implementation(libs.androidx.core.splashscreen)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    //compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //accompanist_systemuicontroller
    implementation(libs.accompanist.systemuicontroller)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}