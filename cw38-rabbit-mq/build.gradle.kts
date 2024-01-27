plugins {
    id("java")
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
    implementation("org.springframework.boot:spring-boot-starter:3.2.0")
//    implementation("org.springframework.boot:spring-boot-starter-amqp:3.2.0")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
}

tasks.test {
    useJUnitPlatform()
}
