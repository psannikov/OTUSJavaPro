rootProject.name = "otus-pro-homeworks"
include("cw36-multiprocess")
include("cw36-multiprocess:proccess")
findProject(":cw36-multiprocess:proccess")?.name = "proccess"
include("cw36-multiprocess:sockets")
findProject(":cw36-multiprocess:sockets")?.name = "sockets"
include("cw36-multiprocess:rmi")
findProject(":cw36-multiprocess:rmi")?.name = "rmi"
include("cw36-multiprocess:grpc")
findProject(":cw36-multiprocess:grpc")?.name = "grpc"
