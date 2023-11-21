plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-parent:2.7.6")
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.1")
    testImplementation("org.springframework.security:spring-security-test:6.1.0")
    implementation("org.springframework.security:spring-security-core:5.6.9")
    implementation("org.springframework.security:spring-security-web:5.6.9")
    implementation("org.springframework.security:spring-security-config:5.6.9")
    implementation("org.springframework.boot:spring-boot-maven-plugin:3.1.5")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}