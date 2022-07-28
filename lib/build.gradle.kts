repositories.mavenCentral()

plugins {
    apply(P.kotlinJvm)
}

dependencies {
    testImplementation(D.jupiterApi)
    testRuntimeOnly(D.jupiterEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

project.version = Version.name

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks

"Snapshot".also { type ->
    val groupId = "com.github.kepocnhh"
    val artifactId = rootProject.name
    val versionName = project.version.toString() + "-SNAPSHOT"
    task<Jar>("assemble$type") {
        dependsOn(compileKotlin)
        archiveBaseName.set(artifactId)
        archiveVersion.set(versionName)
        from(compileKotlin.destinationDir)
    }
    task("assemble${type}Pom") {
        doLast {
            val parent = File(buildDir, "libs")
            if (!parent.exists()) parent.mkdirs()
            val file = File(parent, "$artifactId-$versionName.pom")
            if (file.exists()) file.delete()
            file.createNewFile()
            check(file.exists()) { "File by path: ${file.absolutePath} must be exists!" }
            val text = MavenUtil.pom(
                modelVersion = "4.0.0",
                groupId = groupId,
                artifactId = artifactId,
                version = versionName,
                packaging = "jar"
            )
            file.writeText(text)
        }
    }
}
