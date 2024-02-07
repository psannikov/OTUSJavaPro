plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.4.5")
    implementation("org.flywaydb:flyway-core:9.22.3")
    implementation("com.zaxxer:HikariCP:4.0.3")
    implementation("org.postgresql:postgresql:42.6.0")

    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.testcontainers:postgresql:1.18.3")
}

tasks.test {
    useJUnitPlatform()
}