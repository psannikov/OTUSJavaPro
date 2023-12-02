plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor ("org.projectlombok:lombok:1.18.30")

    compileOnly ("org.projectlombok:lombok:1.18.30")
    implementation ("org.springframework.boot:spring-boot-starter-web:2.2.0.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa:2.2.0.RELEASE")
    implementation ("com.h2database:h2:1.4.200")
    implementation ("org.ehcache:ehcache:3.1.3")
}

tasks.test {
    useJUnitPlatform()
}