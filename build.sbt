val commonSettings = Seq(
  scalaVersion := "2.12.3"
)

lazy val subproj1 = (project in file("sub-module/subproj1"))
  .settings(commonSettings)

lazy val subproj2 = (project in file("sub-module/subproj2"))
  .settings(commonSettings)

lazy val root = (project in file("."))
    .settings(
      commonSettings,
      organization := "com.nulabinc",
      name := """main-module-sample""",
      version := "1.0-SNAPSHOT",
      libraryDependencies += guice,
      libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.1" % Test
    ).enablePlugins(PlayScala).dependsOn(subproj1, subproj2)

