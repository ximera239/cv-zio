name := "cv-zio"

Global / cancelable := false

lazy val core = (project in file("modules/core"))
  .settings(Common.settings)
  .settings(
    libraryDependencies ++= Seq(
      Common.Dependencies.zio,
      Common.Dependencies.zioJson,
      Common.Dependencies.zioHttp,
    ),
  )

lazy val ziomicroservice = (project in file("modules/ziomicroservice"))
  .settings(Common.settings)
  .settings(
    libraryDependencies ++= Seq(
      Common.Dependencies.zio,
      Common.Dependencies.zioJson,
      Common.Dependencies.zioHttp,
    ),
    libraryDependencies ++= Common.Dependencies.zioTest,
    libraryDependencies ++= Seq(
      Common.Dependencies.zioHttpTest,
    ),
  )

lazy val root = (project in file("."))
  .settings(Common.settings)
  .dependsOn(core, ziomicroservice)
  .aggregate(core, ziomicroservice)

