import com.typesafe.sbt.SbtNativePackager._


name := "LordBusiness"

version := "0.1"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "com.typesafe.akka" %% "akka-kernel" % "2.3.6",
  "com.typesafe.akka" %% "akka-cluster" % "2.3.6",
  "com.typesafe.akka" %% "akka-contrib" % "2.3.6")

packageArchetype.java_application
