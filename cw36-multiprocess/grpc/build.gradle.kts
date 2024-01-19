import com.google.protobuf.gradle.*

plugins {
    id("java")
    id("com.google.protobuf") version "0.9.2"
}

group = "ru.otus.pro.psannikov"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("io.grpc:grpc-netty:1.57.2")
    implementation ("io.grpc:grpc-protobuf:1.57.2")
    implementation ("io.grpc:grpc-stub:1.57.2")
    implementation ("io.grpc:protoc-gen-grpc-java:1.58.0")
    implementation ("javax.annotation:javax.annotation-api:1.3.2")
}
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.22.3"
    }
    plugins {
        id ("grpc") {
            artifact = ("io.grpc:protoc-gen-grpc-java:1.57.2")
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
//            it.builtins {
//                id("java")
//            }
        }
    }

//    generateProtoTasks {
//        all().plugins {
//            grpc {
//
//            }
//        }
//    }
}
sourceSets {
    main {
        java {
            srcDirs ("build/generated/source/proto/main/grpc")
            srcDirs ("build/generated/source/proto/main/java")
        }
    }
}
tasks.test {
    useJUnitPlatform()
}