plugins {
    base
}

tasks {
    val createContainer by creating(Exec::class.java) {
        val containerName = this.project.name
        val containerVersion = this.project.version

        println("Building docker container $containerName:$containerVersion")

        var cmd: List<String> = listOf("docker", "build",
                                       "-t", "$containerName:$containerVersion",
                                       ".")

        if (isWindows()) {
            cmd = listOf("cmd", "/c") + cmd
        }

        this.commandLine = cmd

        doLast {
            println("Container $containerName:$containerVersion built successfully")
        }
    }

    tasks.getByName("build").dependsOn(createContainer)
}

fun isWindows() = System.getProperty("os.name").contains("win", ignoreCase = true)