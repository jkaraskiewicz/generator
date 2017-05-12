package generator

import models.libraries.LibrariesConfig
import util.trimLastNewLine

class ModuleGenerator(private val librariesConfig: LibrariesConfig) {

    fun generateDependencies() = StringBuilder().apply {
        librariesConfig.entities.forEach { entity ->
            entity.dependencies.compile?.forEach {
                appendln("compile \"$it:${entity.version}\"")
            }
            entity.dependencies.annotationProcessor?.forEach {
                appendln("annotationProcessor \"$it:${entity.version}\"")
            }
            entity.dependencies.provided?.forEach {
                appendln("provided \"$it:${entity.version}\"")
            }
            appendln()
        }
    }.toString().trimLastNewLine().prependIndent().trimStart()
}