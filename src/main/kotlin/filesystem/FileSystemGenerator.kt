package filesystem

import generator.ModuleGradleScriptGenerator
import generator.RootGradleScriptGenerator
import templates.*
import util.GeneratorConfig
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class FileSystemGenerator(private val config: GeneratorConfig) {

    private val packageStructure = config.applicationId.replace('.', '/')

    private val rootDirPath = config.rootProjectDirPath

    private val moduleDirPath = "$rootDirPath/app"

    private val resDirPath = "$rootDirPath/app/src/main/res"

    private val srcDirPath = "$rootDirPath/app/src/main/java/$packageStructure"

    private val rootGradleScriptGenerator = RootGradleScriptGenerator(config)

    private val moduleGradleScriptGenerator = ModuleGradleScriptGenerator(config)

    fun generate() {
        generateDirectories()
        generateFiles()
    }

    fun generateGitIgnores() {
        val rootGitIgnoreFile = File("$rootDirPath/.gitignore")
        rootGitIgnoreFile.writeText(templateRootGitIgnore())

        val moduleGitIgnoreFile = File("$moduleDirPath/.gitignore")
        moduleGitIgnoreFile.writeText(templateModuleGitIgnore())
    }

    private fun generateDirectories() {
        File(srcDirPath).mkdirs()
        File("$srcDirPath/main").mkdir()

        File(resDirPath).mkdirs()
        File("$resDirPath/values").mkdir()
        File("$resDirPath/mipmap-anydpi").mkdir()
        File("$resDirPath/layout").mkdir()
    }

    private fun generateFiles() {
        generateRootGradleScript()
        generateModuleGradleScript()
        generatePropertiesFiles()
        generateAndroidStructures()
    }

    private fun generateAndroidStructures() {
        generateApplicationFile()
        generateActivityFile()
        generateAndroidManifest()
        prepareStandardResources()
    }

    private fun generateAndroidManifest() {
        val manifestFile = File("$moduleDirPath/src/main/AndroidManifest.xml")
        manifestFile.writeText(templateAndroidManifest(config))
    }

    private fun generateActivityFile() {
        val activityFile = File("$srcDirPath/main/MainActivity.kt")
        activityFile.writeText(templateAndroidActivity(config))
    }

    private fun generateApplicationFile() {
        val applicationFile = File("$srcDirPath/Application.kt")
        applicationFile.writeText(templateAndroidApplication(config))
    }

    private fun generatePropertiesFiles() {
        val gradlePropertiesFile = File("$rootDirPath/gradle.properties")
        gradlePropertiesFile.writeText(templateGradleProperties())
    }

    private fun generateRootGradleScript() {
        val rootGradleScriptFile = File("$rootDirPath/build.gradle")
        rootGradleScriptFile.writeText(rootGradleScriptGenerator.generate())
    }

    private fun generateModuleGradleScript() {
        val moduleGradleScriptFile = File("$rootDirPath/app/build.gradle")
        moduleGradleScriptFile.writeText(moduleGradleScriptGenerator.generate())
    }

    private fun prepareStandardResources() {
        val colorsFile = File("$resDirPath/values/colors.xml")
        colorsFile.writeText(templateAndroidResourcesColors())

        val stylesFile = File("$resDirPath/values/styles.xml")
        stylesFile.writeText(templateAndroidResourcesStyles())

        val stringsFile = File("$resDirPath/values/strings.xml")
        stringsFile.writeText(templateAndroidResourcesStrings(config))

        val launcherPath = Paths.get("assets/files/ic_launcher.png")
        val targetLauncherPath = Paths.get("$resDirPath/mipmap-anydpi/ic_launcher.png")
        Files.copy(launcherPath, targetLauncherPath)
    }
}