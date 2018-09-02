import java.lang.ProcessBuilder.Redirect.INHERIT
import java.lang.ProcessBuilder.Redirect.PIPE

plugins {
  base
}

tasks {
  val buildAngularApp by creating(Exec::class.java) {
    doFirst {
      println("Building NG application")
    }
    var mainCommand: List<String> = listOf("ng", "build", "--prod")
    if (isWindows()) {
      mainCommand = listOf("cmd", "/c").union(mainCommand).toList()
    }
    commandLine = mainCommand
  }

  tasks.getByName("build").dependsOn(buildAngularApp)
}

fun isWindows() = System.getProperty("os.name").contains("win", ignoreCase = true)
