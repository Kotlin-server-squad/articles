plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "articles"

include(":article-001")
include(":article-002")
include("article-007")
