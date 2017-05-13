package templates

import util.GeneratorConfig

fun templateRootGradle(config: GeneratorConfig) = """
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:${config.standardConfig.android.plugin}"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:${config.standardConfig.android.kotlin}"
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
    gradleVersion = "${config.standardConfig.gradle.wrapper}"
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
""".trimStart()