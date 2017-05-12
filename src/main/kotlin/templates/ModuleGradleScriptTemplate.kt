package templates

import generator.ModuleGenerator
import models.standard.StandardConfig

fun templateModuleGradle(
        moduleGenerator: ModuleGenerator,
        standardConfig: StandardConfig
) = """
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion ${standardConfig.android.sdk.compileSdk}
    buildToolsVersion ${standardConfig.android.buildTools}

    repositories {
        mavenCentral()
        maven {
            url "https://jitpack.io"
        }
    }

    defaultConfig {
        applicationId "com.karaskiewicz.configgenerator"
        minSdkVersion ${standardConfig.android.sdk.minSdk}
        targetSdkVersion ${standardConfig.android.sdk.targetSdk}
        versionCode 1
        versionName "1.0"
    }

    dexOptions {
        preDexLibraries true
        javaMaxHeapSize "4g"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    packagingOptions {
        pickFirst "META-INF/LICENSE.txt"
        pickFirst "META-INF/NOTICE.txt"
    }
}

dependencies {
    ${moduleGenerator.generateDependencies()}
}
"""