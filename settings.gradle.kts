pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://dl.bintray.com/badoo/maven")
    }
}

rootProject.name = "ProTrackerKMM"
include(":androidApp")
include(":shared")