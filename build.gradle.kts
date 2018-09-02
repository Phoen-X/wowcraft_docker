import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.*


buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", "1.2.41"))
    }
}

allprojects {
    repositories {
        mavenCentral()
    }

    buildscript {
        repositories {
            mavenCentral()
        }
    }
    version = "1.0-SNAPSHOT"
}
plugins {
    kotlin("jvm") version "1.2.41"
}

apply {
    plugin("kotlin")
}

dependencies {
    compile(kotlin("gradle-plugin"))
    compile(kotlin("stdlib-jdk8", "1.2.41"))
}

// In this section you declare where to find the dependencies of your project
repositories {
    mavenCentral()
}