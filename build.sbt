name := "what_the_fp"

scalaVersion := "3.6.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.17",
  "dev.zio" %% "zio-direct" % "1.0.0-RC7",
  "dev.zio" %% "zio-http" % "3.2.0",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.2.0",
  "io.github.kitlangton" %% "neotype" % "0.3.23",
  "dev.zio" %% "zio-prelude" % "1.0.0-RC39"
)
