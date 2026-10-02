plugins {
    kotlin("jvm") version "2.4.20"
    `java-library`
    `maven-publish`

    kotlin("plugin.serialization") version "2.4.20"
}

group = "org.matheusbentodev"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")

    implementation("io.arrow-kt:arrow-core:2.2.3")
    implementation("io.arrow-kt:arrow-fx-coroutines:2.2.3")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")


    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}