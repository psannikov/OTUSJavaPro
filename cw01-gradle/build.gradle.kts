plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "ru.otus.pro.psannikov"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.guava:guava:32.1.2-jre")

}
tasks.shadowJar {
    archiveBaseName.set("gradleHelloWorld")
    archiveVersion.set("0.1")
    archiveClassifier.set("")
    manifest {
        attributes ["Main-Class"] = "ru.otus.pro.psannikov.HelloOtus"
    }
}
tasks.test {
    useJUnitPlatform()
}