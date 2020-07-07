

lazy val docs = (project in file("docs"))
  .enablePlugins(ParadoxMaterialThemePlugin)
  .settings(
    name := "document for akka design",
    paradoxTheme := Some(builtinParadoxTheme("generic")),
    paradoxIllegalLinkPath := raw".*\\.md".r,
    Compile / paradoxMaterialTheme ~= {
      _.withGoogleAnalytics("UA-43080126-2") // Remember to change this!
    },
    paradoxProperties in Compile ++=Map("project.description" -> "Akka design case",
      "github.base_url" -> s"https://github.com/wherby/akkadesign/tree/master")
  )


// Define task to  copy html files
val copyDocs = taskKey[Unit]("Copy html files from src/main/html to cross-version target directory")

// Implement task
copyDocs := {
  import Path._

  val src = baseDirectory.value  /"docs" /"target" / "paradox"/"site"/ "main"

  val dest = baseDirectory.value /"public" /"docs"
  IO.delete(dest)
  dest.mkdir()
  // Copy files to source files to target
  IO.copyDirectory(src,dest)
}

