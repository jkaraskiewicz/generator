package templates

import generator.ModuleGradleScriptGenerator
import util.GeneratorConfig

fun templateModuleGradle(config: GeneratorConfig, generator: ModuleGradleScriptGenerator) = """
import com.android.build.gradle.AppExtension

plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-android-extensions")
  id("kotlin-kapt")
}

android {
  compileSdkVersion(${config.standardConfig.android.sdk.compileSdk})
  buildToolsVersion = "${config.standardConfig.android.buildTools}"

  defaultConfig {
    applicationId = "${config.applicationId}"
    minSdkVersion(${config.standardConfig.android.sdk.minSdk})
    targetSdkVersion(${config.standardConfig.android.sdk.targetSdk})
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    maybeCreate("debug").apply {
      isMinifyEnabled = false
      isDebuggable = true
    }
    maybeCreate("release").apply {
      isMinifyEnabled = true
      setProguardFiles(listOf(getDefaultProguardFile("proguard-android.txt"), "../proguard-rules.pro"))
    }
  }

  sourceSets {
    maybeCreate("main").apply {
      java.srcDir("src/main/kotlin")
    }
  }

  lintOptions {
    isAbortOnError = false
  }
}

dependencies {
${generator.generateDependencies()}
}
""".trimStart()