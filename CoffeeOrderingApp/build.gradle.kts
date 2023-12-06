buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
        classpath("com.android.tools.build:gradle:4.2.1")
        repositories {
            google()
        }
        dependencies {
            val nav_version = "2.5.3"
            classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        }
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
}