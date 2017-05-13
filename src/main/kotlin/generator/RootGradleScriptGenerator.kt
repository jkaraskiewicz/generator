package generator

import templates.templateRootGradle
import util.GeneratorConfig

class RootGradleScriptGenerator(private val config: GeneratorConfig) : Generator {

    override fun generate(): String {
        return templateRootGradle(config)
    }
}