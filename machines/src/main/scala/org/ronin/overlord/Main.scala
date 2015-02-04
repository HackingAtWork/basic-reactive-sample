package org.47ronin.overlord

import akka.actor.{ActorSystem, Props}

object Main {
  def main(args: Array[String]): Unit = {
    val systemName = "JGC"
    val system = ActorSystem(systemName)
    system.actorOf(Props[MemberListener], "memberListener")
  }
}
