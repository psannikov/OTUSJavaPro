rootProject.name = "otus-pro-homeworks"
include("cw40-webflux")
include("cw40-webflux:reactive-service")
findProject(":cw40-webflux:reactive-service")?.name = "reactive-service"
include("cw40-webflux:slow-service")
findProject(":cw40-webflux:slow-service")?.name = "slow-service"
