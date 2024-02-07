plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("io.netty:netty-all:4.1.106.Final")
    implementation("org.apache.logging.log4j:log4j-core:2.22.1")
    implementation("org.apache.logging.log4j:log4j-api:2.22.1")
}

tasks.test {
    useJUnitPlatform()
}