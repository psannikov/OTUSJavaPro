plugins {
    id("java")
    id ("org.springframework.boot") version ("2.7.16")
    id ("io.spring.dependency-management") version ("1.0.15.RELEASE")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation ("org.springframework.boot:spring-boot-starter-webflux")
    implementation ("org.flywaydb:flyway-core")
    implementation ("org.springframework:spring-jdbc")
    runtimeOnly ("org.postgresql:postgresql")
    runtimeOnly ("org.postgresql:r2dbc-postgresql")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation ("io.projectreactor:reactor-test")
    compileOnly ("org.projectlombok:lombok:1.18.20")
    annotationProcessor ("org.projectlombok:lombok:1.18.20")
}

tasks.test {
    useJUnitPlatform()
}