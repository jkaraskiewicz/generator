package generator

import models.label
import templates.templateModuleGradle
import util.GeneratorConfig
import util.trimLastNewLine

class ModuleGradleScriptGenerator(private val config: GeneratorConfig) : Generator {

  override fun generate(): String {
    return templateModuleGradle(config, this)
  }

  fun generateDependencies() = StringBuilder().apply {
    config.librariesConfig.entities.forEach { (_, version, configurations) ->
      configurations.forEach { configuration ->
        configuration.values.forEach {
          appendln("  \"${configuration.type.label}\"(\"$it:$version\")")
        }
      }
      appendln()
    }
  }.toString().trimLastNewLine()
}