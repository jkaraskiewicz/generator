package templates

import models.standard.StandardConfig

fun templateRootGradle(
        standardConfig: StandardConfig
) = """
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:${standardConfig.android.plugin}"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:${standardConfig.android.kotlin}"
    }
}

allprojects {
    repositories {
        jcenter()
        maven {
            url "https://oss.sonatype.org/content/repositories/snapshots"
        }
        maven {
            url "https://jitpack.io"
        }
    }
}

task wrapper(type: Wrapper) {
    gradleVersion = "${standardConfig.gradle.wrapper}"
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
"""