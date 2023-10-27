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
    implementation("ch.qos.logback:logback-classic")
    implementation("org.flywaydb:flyway-core:9.22.3")
    implementation("com.zaxxer:HikariCP:4.0.3")
    implementation("org.postgresql:postgresql")
    implementation("org.slf4j:slf4j-api:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}