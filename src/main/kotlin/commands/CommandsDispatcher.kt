package commands

import filesystem.FileSystemGenerator
import util.GeneratorConfig

class CommandsDispatcher(
        private val fileSystemGenerator: FileSystemGenerator,
        private val config: GeneratorConfig
) {
    private val executor = CommandsExecutor(config)

    fun dispatchCommands() {
        initializeGradleWrapper()
        initializeGit()
    }

    private fun initializeGit() {
        executor.exec("git", "init")
        fileSystemGenerator.generateGitIgnores()
        executor.exec("git", "add", "-A", ".")
        executor.exec("git", "commit", "-m", "Initial commit")
    }

    private fun initializeGradleWrapper() {
        executor.exec("gradle wrapper --distribution-type=${config.standardConfig.gradle.distribution}")
    }
}