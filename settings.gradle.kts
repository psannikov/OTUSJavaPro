rootProject.name = "otus-pro-homeworks"
include("cw41-kafka")
include("cw41-kafka:consumer")
findProject(":cw41-kafka:consumer")?.name = "consumer"
include("cw41-kafka:producer")
findProject(":cw41-kafka:producer")?.name = "producer"
