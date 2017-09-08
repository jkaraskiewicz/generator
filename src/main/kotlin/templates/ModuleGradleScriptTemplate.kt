package templates

import generator.ModuleGradleScriptGenerator
import util.GeneratorConfig

fun templateModuleGradle(config: GeneratorConfig, generator: ModuleGradleScriptGenerator) = """
import com.android.build.gradle.AppExtension

apply {
  plugin("com.android.application")
  plugin("kotlin-android")
  plugin("kotlin-android-extensions")
  plugin("kotlin-kapt")
}

the<AppExtension>().apply {
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