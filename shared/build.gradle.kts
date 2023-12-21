plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("kotlinx-serialization")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    androidTarget()

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.materialIconsExtended)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api(compose.animation)
                //ktor
                implementation("io.ktor:ktor-client-core:2.3.3")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
                implementation("io.ktor:ktor-client-logging:2.3.3")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
                //koin
                implementation("io.insert-koin:koin-compose:1.1.0")
                implementation("io.insert-koin:koin-core:3.5.0")
                //datetime
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")
                //images
                api("io.github.qdsfdhvh:image-loader:1.7.1")
                //navigation & viewmodels
                api("moe.tlaster:precompose:1.5.7")
                api("moe.tlaster:precompose-viewmodel:1.5.7")
                api("moe.tlaster:precompose-koin:1.5.7")
                //moko
                api("dev.icerock.moko:resources:0.22.3")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                api("androidx.activity:activity-compose:1.7.2")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")
                //ktor
                implementation("io.ktor:ktor-client-okhttp:2.3.3")
                //koin
                implementation("io.insert-koin:koin-android:3.5.0")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //ktor
                implementation("io.ktor:ktor-client-darwin:2.3.3")
            }
        }
        val desktopMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.myapplication.common"
}

dependencies {
    commonMainApi("dev.icerock.moko:resources:0.23.0")
    commonMainApi("dev.icerock.moko:resources-compose:0.23.0")
    commonTestImplementation("dev.icerock.moko:resources-test:0.23.0")
}
