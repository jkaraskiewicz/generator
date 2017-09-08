package templates

import util.GeneratorConfig

fun templateRootGradle(config: GeneratorConfig) = """
buildscript {
  repositories {
    jcenter()
    google()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:${config.standardConfig.android.plugin}")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${config.standardConfig.android.kotlin}")
  }
}

allprojects {
  repositories {
    jcenter()
    google()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io")
  }
}

tasks {
  "clean"(Delete::class) {
    delete(buildDir)
  }
  "wrapper"(Wrapper::class) {
    gradleVersion = "${config.standardConfig.gradle.wrapper}"
  }
}
""".trimStart()

fun templateSettingsGradle() = """
rootProject.buildFileName = "build.gradle.kts"

include ':app'
""".trimStart()