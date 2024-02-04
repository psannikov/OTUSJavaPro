rootProject.name = "otus-pro-homeworks"
include("hw21-webflux")
include("hw21-webflux:reactive-service")
findProject(":hw21-webflux:reactive-service")?.name = "reactive-service"
include("hw21-webflux:slow-service")
findProject(":hw21-webflux:slow-service")?.name = "slow-service"
