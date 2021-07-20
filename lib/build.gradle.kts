repositories.mavenCentral()

plugins {
    apply(P.kotlinJvm)
}

project.version = Version.name

dependencies {
    testImplementation(D.jupiterApi)
    testRuntimeOnly(D.jupiterEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
