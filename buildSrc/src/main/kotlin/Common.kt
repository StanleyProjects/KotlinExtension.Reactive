import sp.kx.gradle.entity.dependency
import sp.kx.gradle.entity.plugin

object Version {
    const val jupiter = "5.6.2"
    const val kotlin = "1.4.20"
    const val name = "0.0.2"
}

object Group {
    const val jetbrains = "org.jetbrains"
    const val jupiter = "org.junit.jupiter"
    const val kotlin = "$jetbrains.kotlin"
}

object D {
    val kotlinGradlePlugin = dependency(
        group = Group.kotlin,
        name = "kotlin-gradle-plugin",
        version = Version.kotlin
    )
    val kotlinStdlib = dependency(
        group = Group.kotlin,
        name = "kotlin-stdlib",
        version = Version.kotlin
    )
    val jupiterApi = dependency(
        group = Group.jupiter,
        name = "junit-jupiter-api",
        version = Version.jupiter
    )
    val jupiterEngine = dependency(
        group = Group.jupiter,
        name = "junit-jupiter-engine",
        version = Version.jupiter
    )
}

object P {
    val application = plugin(
        name = "org.gradle.application"
    )
    val kotlinJvm = plugin(
        name = Group.kotlin + ".jvm",
        version = Version.kotlin
    )
}
