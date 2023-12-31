plugins {
    id("java")
    id("org.springframework.boot") version ("2.5.1")
    id ("io.spring.dependency-management") version ("1.0.11.RELEASE")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor ("org.projectlombok:lombok:1.18.30")

    compileOnly ("org.projectlombok:lombok:1.18.30")

    // cassandra
    implementation ("com.datastax.oss:java-driver-core:4.17.0")
    implementation ("com.datastax.oss:java-driver-query-builder:4.17.0")

    // mongo
    implementation ("org.mongodb:mongodb-driver-sync:4.11.1")
    implementation ("dev.morphia.morphia:morphia-core:2.4.7")
    implementation ("org.mongodb:mongodb-driver-core:4.11.1")
    implementation ("org.mongodb:bson:4.11.1")

    // mongo-reactive
    implementation ("org.mongodb:mongodb-driver-reactivestreams:4.11.1")

    // redis
    implementation ("redis.clients:jedis:5.0.2")

    // neo4j
    implementation ("org.neo4j.driver:neo4j-java-driver:4.4.12")
    implementation ("org.neo4j:neo4j:4.4.23")
    implementation ("org.neo4j:neo4j-ogm-core:3.1.22")
    implementation ("com.voodoodyne.jackson.jsog:jackson-jsog:1.1.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}