rootProject.name = "otus-pro-homeworks"
include("cw31-spring-boot-security-application")
include("cw31-spring-boot-security-application:main")
findProject(":cw31-spring-boot-security-application:main")?.name = "main"
include("cw31-spring-boot-security-application:approve")
findProject(":cw31-spring-boot-security-application:approve")?.name = "approve"
