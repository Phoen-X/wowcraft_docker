import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.*

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", "1.2.41"))
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.2.RELEASE")
    }
}

apply {
    plugin("kotlin")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

plugins {
    kotlin("jvm")
}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("one.util:streamex:0.6.7")
    compile("com.google.guava:guava:19.0")
    compile("org.liquibase:liquibase-core")
    runtime("mysql:mysql-connector-java")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}
