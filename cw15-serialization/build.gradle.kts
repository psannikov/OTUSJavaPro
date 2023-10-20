plugins {
    id("java")
    id("com.google.protobuf") version "0.9.2"
    id("idea")
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.google.guava:guava:21.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("org.glassfish:jakarta.json:2.0.1")
    implementation("com.google.protobuf:protobuf-java-util:3.24.3")

}

tasks.test {
    useJUnitPlatform()
}
val protoSrcDir = "$projectDir/build/generated"

idea {
    module {
        sourceDirs = sourceDirs.plus(file(protoSrcDir))
    }
}

sourceSets {
    main {
        proto {
            srcDir(protoSrcDir)
        }
    }
}

protobuf {
    generatedFilesBaseDir = protoSrcDir

    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }

    generateProtoTasks {
        ofSourceSet("main")
    }
}

afterEvaluate {
    tasks {
        getByName("generateProto").dependsOn(processResources)
    }
}