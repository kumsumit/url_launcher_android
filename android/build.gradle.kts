plugins {
    id("com.android.library")
}

group = "io.flutter.plugins.urllauncher"
version = "1.0-SNAPSHOT"

repositories {
        google()
        mavenCentral()
    }

android {
    buildFeatures {
        buildConfig = true
    }

    namespace = "io.flutter.plugins.urllauncher"
    compileSdk = 37

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    lint {
        checkAllWarnings = true
        warningsAsErrors = true
        disable.addAll(setOf("AndroidGradlePluginVersion", "InvalidPackage", "GradleDependency", "NewerVersionAvailable"))
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
            all {
                it.outputs.upToDateWhen { false }
                it.testLogging {
                    events("passed", "skipped", "failed", "standardOut", "standardError")
                    showStandardStreams = true
                }
            }
        }
    }
}

dependencies {
    // Java language implementation
    implementation("androidx.core:core:1.18.0")
    implementation("androidx.annotation:annotation:1.10.0")
    implementation("androidx.browser:browser:1.10.0")
    testImplementation("org.mockito:mockito-core:5.23.0")
    testImplementation("androidx.test:core:1.7.0")
    testImplementation("org.robolectric:robolectric:4.16.1")
}
