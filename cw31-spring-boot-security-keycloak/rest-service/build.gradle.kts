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
    implementation ("org.springframework.boot:spring-boot-starter-web:3.2.0")

    implementation ("org.springframework.boot:spring-boot-starter-security:3.2.0")

    implementation ("org.apache.httpcomponents.client5:httpclient5:5.3")

    implementation ("org.springframework.boot:spring-boot-starter-oauth2-client:3.2.0")

    implementation ("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.2.0")
}

tasks.test {
    useJUnitPlatform()
}