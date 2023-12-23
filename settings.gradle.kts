rootProject.name = "otus-pro-homeworks"
include("cw31-spring-boot-security-keycloak")
include("cw31-spring-boot-security-keycloak:rest-service")
findProject(":cw31-spring-boot-security-keycloak:rest-service")?.name = "rest-service"
