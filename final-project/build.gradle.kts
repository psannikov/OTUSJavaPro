plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
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
    implementation("org.springframework.boot:spring-boot-starter-parent:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("com.oracle.database.jdbc:ojdbc8:12.2.0.1")
    implementation("org.flywaydb:flyway-core")
    implementation("ch.qos.logback:logback-classic:1.4.5")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")
    implementation("org.telegram:telegrambots:6.9.7.0")
    implementation("org.telegram:telegrambots-spring-boot-starter:6.9.7.0")
}

tasks.test {
    useJUnitPlatform()
}