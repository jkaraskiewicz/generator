package commands

import util.GeneratorConfig
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.nio.file.Paths

class CommandsExecutor(
  private val config: GeneratorConfig,
  private val verboseMode: Boolean
) {
  fun exec(command: String) = launchProcess(createProcess(command, Paths.get(config.rootProjectDirPath).toFile()))

  fun exec(vararg commands: String) = launchProcess(createProcess(commands, Paths.get(config.rootProjectDirPath).toFile()))

  private fun createProcess(command: String, workingDir: File): Process {
    return Runtime.getRuntime().exec(command, null, workingDir)
  }

  private fun createProcess(commands: Array<out String>, workingDir: File): Process {
    return Runtime.getRuntime().exec(commands, null, workingDir)
  }

  private fun launchProcess(process: Process) {
    process.apply { waitFor() }.takeIf { verboseMode }?.let {
      val reader = BufferedReader(InputStreamReader(it.inputStream))
      reader.lines().forEach { println(it) }
    }
  }
}