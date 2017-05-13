package templates

import generator.ModuleGradleScriptGenerator
import util.GeneratorConfig

fun templateModuleGradle(config: GeneratorConfig, generator: ModuleGradleScriptGenerator) = """
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion ${config.standardConfig.android.sdk.compileSdk}
    buildToolsVersion "${config.standardConfig.android.buildTools}"

    repositories {
        mavenCentral()
        maven {
            url "https://jitpack.io"
        }
    }

    defaultConfig {
        applicationId "${config.applicationId}"
        minSdkVersion ${config.standardConfig.android.sdk.minSdk}
        targetSdkVersion ${config.standardConfig.android.sdk.targetSdk}
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
    ${generator.generateDependencies()}
}
""".trimStart()