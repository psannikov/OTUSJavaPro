plugins {
    id("java")
    id ("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.postgresql:postgresql:42.6.0")
    implementation("com.oracle.database.jdbc:ojdbc8:12.2.0.1")
}

tasks.test {
    useJUnitPlatform()
}