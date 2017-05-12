import generator.ModuleGenerator
import parser.parseLibraries
import parser.parseStandard
import templates.templateModuleGradle
import java.nio.file.Paths

fun main(args: Array<String>) {
    val librariesConfig = parseLibraries(Paths.get(args[0]))
    val standardConfig = parseStandard(Paths.get(args[1]))
    println(templateModuleGradle(ModuleGenerator(librariesConfig), standardConfig))
}