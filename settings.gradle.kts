rootProject.name = "otus-pro-homeworks"
include("cw30-spring-boot-security-https")
include("cw30-spring-boot-security-https:rest-service")
findProject(":cw30-spring-boot-security-https:rest-service")?.name = "rest-service"
