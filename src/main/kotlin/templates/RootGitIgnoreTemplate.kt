package templates

fun templateRootGitIgnore() = """
.gradle
.idea
*.iml
local.properties
build/
worktree/
.DS_Store
""".trimStart()