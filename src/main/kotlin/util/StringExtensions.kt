package util

fun String.trimLastNewLine() = trimEnd { it == '\n' }