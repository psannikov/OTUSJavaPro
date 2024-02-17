rootProject.name = "otus-pro-homeworks"
include("final-project")
include("final-project:target-db")
findProject(":final-project:target-db")?.name = "target-db"
include("final-project:configure-db")
findProject(":final-project:configure-db")?.name = "configure-db"
