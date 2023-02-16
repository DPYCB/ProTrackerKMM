plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.dpycb.protrackerkmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.dpycb.protrackerkmm.android"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:1.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.foundation:foundation:1.3.1")
    implementation("androidx.compose.material:material:1.3.1")
    implementation("androidx.activity:activity-compose:1.6.1")

    implementation ("io.insert-koin:koin-android:3.3.2")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.1")

    implementation("androidx.compose.runtime:runtime-rxjava2:1.1.1")

    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")

    implementation("com.badoo.reaktive:reaktive:1.2.3")
    implementation ("com.badoo.reaktive:rxjava2-interop:1.2.3")

    implementation("androidx.room:room-runtime:2.2.2")
    implementation("com.google.code.gson:gson:2.8.6")
    configurations["kapt"].dependencies.add(
        org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency(
            "androidx.room",
            "room-compiler",
            "2.2.2"
        )
    )
}