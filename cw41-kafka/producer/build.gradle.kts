plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.apache.kafka:kafka-clients")
    implementation ("ch.qos.logback:logback-classic")
    implementation ("com.fasterxml.jackson.core:jackson-databind")
    testImplementation ("org.junit.jupiter:junit-jupiter-engine")
    testImplementation ("org.assertj:assertj-core")
    testImplementation ("org.testcontainers:kafka")
}

tasks.test {
    useJUnitPlatform()
}