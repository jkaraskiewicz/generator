package templates

fun templateRootGitIgnore() = """
*.iml
.gradle
/local.properties
/.idea
.DS_Store
/build
/captures
.externalNativeBuild
""".trimStart()