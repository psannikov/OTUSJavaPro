plugins {
    id("java")
    id("org.springframework.boot") version ("3.2.0")
    id("io.spring.dependency-management") version ("1.1.4")
    id("com.github.johnrengelman.shadow") version "7.1.0"

}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly ("com.h2database:h2:2.1.214")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    compileOnly("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.0")
    implementation ("org.flywaydb:flyway-core")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.0")
}
tasks.shadowJar {
    archiveBaseName.set("LruCache")
    archiveVersion.set("0.1")
    archiveClassifier.set("")
    manifest {
        attributes ["Main-Class"] = "ru.otus.pro.psannikov.lru.Main"
    }
}
tasks.test {
    useJUnitPlatform()
}