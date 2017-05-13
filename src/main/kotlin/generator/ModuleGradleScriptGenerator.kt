package generator

import templates.templateModuleGradle
import util.GeneratorConfig
import util.trimLastNewLine

class ModuleGradleScriptGenerator(private val config: GeneratorConfig) : Generator {

    override fun generate(): String {
        return templateModuleGradle(config, this)
    }

    fun generateDependencies() = StringBuilder().apply {
        config.librariesConfig.entities.forEach { (_, version, dependencies) ->
            dependencies.compile?.forEach {
                appendln("compile \"$it:$version\"")
            }
            dependencies.annotationProcessor?.forEach {
                appendln("annotationProcessor \"$it:$version\"")
            }
            dependencies.provided?.forEach {
                appendln("provided \"$it:$version\"")
            }
            appendln()
        }
    }.toString().trimLastNewLine().prependIndent().trimStart()
}