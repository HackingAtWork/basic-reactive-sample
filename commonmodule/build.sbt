name := "Common"

version := "SNAPSHOT"

organization := "org.ronin"

scalaVersion := "2.11.1"

parallelExecution in Test := false

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "anormcypher" at "http://repo.anormcypher.org/",
  "neo4j public" at "http://m2.neo4j.org/releases",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "mvrepo" at "http://mvnrepository.com/artifact"
)

libraryDependencies ++= Seq(
   "com.typesafe" % "config" % "1.2.1"
)
