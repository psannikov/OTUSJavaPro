plugins {
    id("java")
    id ("org.springframework.boot") version ("3.1.4")
    id ("io.spring.dependency-management") version ("1.1.3")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}