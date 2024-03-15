import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    checkstyle
    java
    jacoco
    id("checkstyle")
    id("io.freefair.lombok") version "8.4"
    id("com.github.ben-manes.versions") version "0.50.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"
application { mainClass.set("hexlet.code.App") }

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:6.1.3")
    implementation("org.slf4j:slf4j-simple:2.0.10")//logger
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("gg.jte:jte:3.0.1")
    implementation("gg.jte:jte:3.0.1")

    implementation("com.googlecode.owasp-java-html-sanitizer:owasp-java-html-sanitizer:20220608.1")


    implementation("com.h2database:h2:2.2.220") //для работы с бd
    implementation("com.zaxxer:HikariCP:5.0.1")//бд хикари
    implementation("org.postgresql:postgresql:42.7.2") //для работы с  бд типа postgresql
    implementation("com.mysql:mysql-connector-j:8.3.0") //драйвер для работы с бд в принципе

    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("commons-validator:commons-validator:1.8.0")

    implementation("io.javalin:javalin-bundle:6.1.3")//для тестировония проекта на джавалине
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.1")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }