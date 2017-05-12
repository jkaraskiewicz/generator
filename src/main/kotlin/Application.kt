import parser.parseLibraries
import parser.parseStandard
import java.nio.file.Paths

fun main(args: Array<String>) {
    parseInputs(args[1], args[0])
}

fun parseInputs(standardPath: String, librariesPath: String) {
    val standardConfig = parseStandard(Paths.get(standardPath))
    val librariesConfig = parseLibraries(Paths.get(librariesPath))
}