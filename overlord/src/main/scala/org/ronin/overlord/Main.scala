package org.ronin.overlord

import akka.actor.{ActorLogging, Actor, ActorSystem, Props}
import akka.contrib.pattern.DistributedPubSubExtension
import akka.contrib.pattern.DistributedPubSubMediator.{Publish, Subscribe}
import org.ronin.Channels
import org.ronin.messages.{QuitJob, ComplainAboutWork, DoOvertime, StartedWork}

import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val systemName = "47Ronin"
    val system = ActorSystem(systemName)
    system.actorOf(Props[MemberListener], "memberListener")
    system.actorOf(Props[FactoryOverseer])
    system.actorOf(Props[FactoryManager])

    Console.println("overlord ready!")
  }
}

class FactoryOverseer extends Actor with ActorLogging {
  val mediator = DistributedPubSubExtension(context.system).mediator
  mediator ! Subscribe(Channels.personnelChanges, self)
  mediator ! Subscribe(Channels.factoryLine, self)
  mediator ! Subscribe(Channels.complaints, self)

  def receive = {
    case QuitJob() =>
      log.info("Ooops")
    case StartedWork(message) =>
      log.info(message)
      mediator ! Publish(Channels.factoryLine, DoOvertime(Random.nextInt(100)))

  }
}

class FactoryManager extends Actor with ActorLogging {
  val mediator = DistributedPubSubExtension(context.system).mediator
  mediator ! Subscribe(Channels.personnelChanges, self)
  mediator ! Subscribe(Channels.complaints, self)

  def receive = {
    case ComplainAboutWork(hours) =>
      log.info(s"Employeer dont like working $hours")
      mediator ! Publish(BusinessChannel.overseers, InternalMemos.SlowYourRoll())

  }
}

object InternalMemos{
  case class SlowYourRoll()
}

object BusinessChannel{
  val overseers="overseers"
}

class BoardOfDirectors{

}
