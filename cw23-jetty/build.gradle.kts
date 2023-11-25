plugins {
    id("java")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.eclipse.jetty:jetty-server:11.0.15")
    implementation ("org.eclipse.jetty:jetty-servlet:11.0.15")

    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}