package templates

fun templateGradleProperties() = """
org.gradle.daemon=true
org.gradle.jvmargs=-Xmx6g -XX:MaxPermSize=512m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8
android.threadPoolSize=4
kotlin.incremental=true
android.enableD8=true
""".trimStart()