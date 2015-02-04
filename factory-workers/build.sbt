import com.typesafe.sbt.SbtNativePackager._


name := "Workers"

version := "0.1"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "com.typesafe.akka" %% "akka-kernel" % "2.3.6",
  "com.typesafe.akka" %% "akka-cluster" % "2.3.6",
  "com.typesafe.akka" %% "akka-contrib" % "2.3.6",
  "org.scalatest" % "scalatest_2.10" % "2.1.6" % "test")

packageArchetype.java_application
