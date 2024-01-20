rootProject.name = "otus-pro-homeworks"
include("cw01-gradle")
include("cw02-unittest")
include("cw03-generic")
include("cw05-docker")
include("cw04-gc")
include("cw06-annotation")
include("cw07-functional-programming")
include("cw08-clean-code")
include("cw09-troubleshooting")
include("cw10-solid")
include("cw11-stream")
include("cw12-creational-patterns")
include("cw13-behavioral-patterns")
include("cw14-structural-patterns")
include("cw15-serialization")
include("cw16-nio-logging")
include("cw17-jdbc")
include("cw18-rdbms")
include("cw19-hibernate")
include("cw20-jpql")
include("cw21-references")
include("cw22-nosql")
include("cw23-web-server")
include("cw23-jetty")
include("cw23-spring")
include("cw23-template")
include("cw24-dependency-injection")
include("cw25-spring-boot-part1")
include("cw26-spring-boot-part2")
include("cw27-web-application")
include("cw28-spring-data-jdbc")
include("cw29-spring-boot-security")
include("cw30-spring-boot-security-https:rest-service")
findProject(":cw30-spring-boot-security-https:rest-service")?.name = "rest-service"
include("cw31-spring-boot-security-keycloak")
include("cw31-spring-boot-security-keycloak:rest-service")
findProject(":cw31-spring-boot-security-keycloak:rest-service")?.name = "rest-service"
include("cw32-thread")
include("cw33-executors")
include("cw34-jmm")
include("cw35-concurrent-collections")
include("cw36-multiprocess")
include("cw36-multiprocess:proccess")
findProject(":cw36-multiprocess:proccess")?.name = "proccess"
include("cw36-multiprocess:sockets")
findProject(":cw36-multiprocess:sockets")?.name = "sockets"
include("cw36-multiprocess:rmi")
findProject(":cw36-multiprocess:rmi")?.name = "rmi"
include("cw36-multiprocess:grpc")
findProject(":cw36-multiprocess:grpc")?.name = "grpc"
include("cw37-nio")
include("hw01-gradle")
include("hw02-unittest")
include("hw03-generic")
include("hw04-gc")
include("hw05-annotations")
include("hw05-additional")
include("hw06-solid")
include("hw07-patterns")
include("hw08-serialization")
include("hw09-jdbc")
include("hw10-jpql")
include("hw11-web-server")
include("hw12-cache-engine")
include("hw13-lru")
include("hw14-dependency-injection")
include("hw15-spring-boot-jdbc")
include("hw17-spring-boot-security-https")
include("hw17-spring-boot-security-https:approval-service")
findProject(":hw17-spring-boot-security-https:approval-service")?.name = "approval-service"
include("hw18-threads")
include("hw19-concurrent-collections")