plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
    id("maven-publish")
}

group = "lev"
version = "1.0"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/leverage86rus/localdateserializers")
            credentials {
                username = project.findProperty("gpr.user") as String
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = "lev"
            artifactId = "local-date-serializers"
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core-jvm:1.6.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}