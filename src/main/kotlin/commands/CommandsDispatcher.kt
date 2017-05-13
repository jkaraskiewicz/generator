package commands

import filesystem.FileSystemGenerator
import util.GeneratorConfig
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.file.Paths

class CommandsDispatcher(
        private val fileSystemGenerator: FileSystemGenerator,
        private val config: GeneratorConfig
) {

    fun dispatchCommands() {
        initializeGit()
        initializeGradleWrapper()
    }

    private fun initializeGit() {
        exec("git init")
        fileSystemGenerator.generateGitIgnores()
        exec("git add -A .")
        exec("git commit -m \"Initial commit\"")
    }

    private fun initializeGradleWrapper() {
        exec("gradle wrapper --distribution-type=${config.standardConfig.gradle.distribution}")
    }

    fun exec(command: String) {
        val process = Runtime.getRuntime().exec(command, null, Paths.get(config.rootProjectDirPath).toFile())
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        reader.lines().forEach { println(it) }
    }
}