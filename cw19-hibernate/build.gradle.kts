plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-logging:commons-logging:1.2")
    implementation("org.hibernate.orm:hibernate-core:6.2.7.Final")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    runtimeOnly("org.postgresql:postgresql:42.5.4")

    testImplementation("com.h2database:h2:2.2.224")
    testImplementation("commons-logging:commons-logging:1.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit.platform:junit-platform-suite-api:1.9.3")
}

tasks.test {
    useJUnitPlatform()
}