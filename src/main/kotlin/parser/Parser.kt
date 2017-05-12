package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import models.libraries.LibrariesConfig
import models.standard.StandardConfig
import java.nio.file.Files
import java.nio.file.Path

val mapper by lazy {
    ObjectMapper(YAMLFactory()).apply {
        registerModule(KotlinModule())
    }
}

fun parseStandard(path: Path) = Files.newBufferedReader(path).use {
    mapper.readValue(it, StandardConfig::class.java)
}


fun parseLibraries(path: Path) = Files.newBufferedReader(path).use {
    mapper.readValue(it, LibrariesConfig::class.java)
}