name := "what_the_fp"

scalaVersion := "3.5.1"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.9",
  "dev.zio" %% "zio-direct" % "1.0.0-RC7",
  "dev.zio" %% "zio-http" % "3.0.0",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
  "io.github.kitlangton" %% "neotype" % "0.3.5",
  "dev.zio" %% "zio-prelude" % "1.0.0-RC31"
)
