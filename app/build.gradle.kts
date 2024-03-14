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
    implementation("io.javalin:javalin:5.6.1")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("io.javalin:javalin-rendering:5.6.0")
    implementation("gg.jte:jte:3.0.1")
    implementation("gg.jte:jte:3.0.1")
    implementation("io.javalin:javalin-rendering:5.6.2")
    implementation("org.slf4j:slf4j-simple:2.0.10")//logger
    implementation("com.h2database:h2:2.2.220") //для работы с бd
    implementation("com.zaxxer:HikariCP:5.0.1")//бд хикари

    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.1")
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }