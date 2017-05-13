package util

import models.libraries.LibrariesConfig
import models.standard.StandardConfig

data class GeneratorConfig(
        val librariesConfig: LibrariesConfig,
        val standardConfig: StandardConfig,
        val applicationId: String,
        val rootProjectDirPath: String
)