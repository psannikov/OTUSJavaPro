plugins {
    id("java")
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
    implementation("org.flywaydb:flyway-core:10.3.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor ("org.projectlombok:lombok:1.18.30")
    runtimeOnly("com.h2database:h2:2.2.224")
    implementation ("org.springframework.boot:spring-boot-starter-security:3.2.0")
    implementation ("org.apache.httpcomponents.client5:httpclient5:5.3")
}

tasks.test {
    useJUnitPlatform()
}