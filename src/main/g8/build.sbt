import Dependencies._

/* Project settings */
ThisBuild / name := "$name$"
ThisBuild / scalaVersion := "$scalaVersion$"
ThisBuild / version := "1.0.0-SNAPSHOT"
ThisBuild / description := "$description$"
ThisBuild / licenses := List(("MIT", url("https://opensource.org/license/mit")))
ThisBuild / developers ++= List(
  Developer(
    id = "$githubName$",
    name = "$fullName$",
    email = "$email$",
    url = url("https://github.com/$githubName$")
  )
)

/* Test settings */
ThisBuild / testFrameworks += new TestFramework("munit.Framework")

/* Scalafix settings */
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

/* Publish settings */
ThisBuild / publishMavenStyle := true

/* Compiler settings */
ThisBuild / scalacOptions ++= Seq(
  "-Wunused",
)

lazy val common = project
  .in(file("modules/common"))
  .settings(
    name := "common",
    moduleName := "$name$-common",
  )
  .settings(
    libraryDependencies ++= {
      Seq(
        munit % Test,
      )
    }
  )
  .enablePlugins(ScalafixPlugin)

lazy val $name$ = project
  .in(file("."))
  .settings(
    name := "$name$",
  )
  .aggregate(common)
