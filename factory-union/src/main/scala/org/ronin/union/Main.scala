package org.ronin.union

import akka.actor.{ActorLogging, Props, Actor, ActorSystem}
import akka.contrib.pattern.DistributedPubSubExtension
import akka.contrib.pattern.DistributedPubSubMediator.{Subscribe, Publish}
import org.ronin.Channels
import org.ronin.messages.{ComplainAboutWork, QuitJob, DoOvertime, StartedWork}

object Main {
  def main(args: Array[String]): Unit = {
    val systemName = "47Ronin"
    val system = ActorSystem(systemName)

    system.actorOf(Props[IrritableEmployee])


    val mediator = DistributedPubSubExtension(system).mediator

    while(true) {
      mediator ! Publish(Channels.factoryLine, StartedWork("The whole factory is at work"))
      Thread.sleep(1000)
    }
    Console.println("Started!")
  }
}

class IrritableEmployee extends Actor with ActorLogging{

  val mediator = DistributedPubSubExtension(context.system).mediator
  mediator ! Subscribe(Channels.factoryLine, self)
  mediator ! Subscribe(Channels.negotiation, self)

  def receive = {
    case DoOvertime(hours) =>
      log.info(s"Lord Business wants me horking $hours overtime")
      if(hours % 2 ==0){
        mediator ! Publish(Channels.personnelChanges, QuitJob())
      }
      else{
        mediator ! Publish(Channels.complaints, ComplainAboutWork(hours))
      }
  }
}

