plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.kafka:kafka-clients:3.6.1")
    implementation ("ch.qos.logback:logback-classic:1.4.14")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.1")
    testImplementation("org.assertj:assertj-core:3.25.2")
    testImplementation("org.testcontainers:kafka:1.19.4")
}

tasks.test {
    useJUnitPlatform()
}