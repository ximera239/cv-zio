import sbt.Keys._
import sbt._

object Common {
  object Dependencies {
    val zioVersion = "2.0.18"
    val zio ="dev.zio" %% "zio" % zioVersion
    val zioJson ="dev.zio" %% "zio-json" % "0.6.2"
    val zioHttp ="dev.zio" %% "zio-http" % "3.0.0-RC2"

    val zioTest = Seq(
      "dev.zio" %% "zio-test" % zioVersion % Test,
      "dev.zio" %% "zio-test-sbt" % zioVersion % Test,
      "dev.zio" %% "zio-test-magnolia" % zioVersion % Test,
    )
    val zioHttpTest = "dev.zio" %% "zio-http-testkit" % "3.0.0-RC2" % Test

  }
  lazy val scalafmtSettings: Seq[Def.Setting[Task[sbt.File]]] = {
    import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtConfig
    Seq(scalafmtConfig := appConfiguration.value.baseDirectory() / ".scalafmt.conf")
  }

  val baseSettings: Seq[Setting[_]] = Seq(
    organization := "zhoga",
    scalaVersion := "3.3.1",
    scalacOptions ++= Seq(
    ),
  ) ++ scalafmtSettings

  val settings: Seq[Setting[_]] = baseSettings
}
