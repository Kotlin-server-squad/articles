val kotlinx_version: String by extra
val kotest_version: String by extra
val junit_version: String by extra

dependencies {
    implementation(project(":utils"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinx_version")
    implementation("org.slf4j:slf4j-log4j12:2.0.7")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
    testImplementation("io.kotest:kotest-runner-junit5:$kotest_version")
    testImplementation("io.kotest:kotest-assertions-core:$kotest_version")
}
