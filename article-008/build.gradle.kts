val kotlinx_version: String by extra
val kotest_version: String by extra

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework:spring-context-support")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation(project(":utils"))

    implementation("io.ktor:ktor-client-cio:2.3.12")
    implementation("io.ktor:ktor-client-json:2.3.12")
    implementation("io.ktor:ktor-client-serialization:2.3.12")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}
