package org.ronin.messages

case class StartedWork(message:String)
case class Striking(message:String, raiseDemanded:Int)
case class DoOvertime(hours:Int)
case class ComplainAboutWork(overtime:Int)
case class RaisePayed()
case class RaiseRefused()
case class QuitJob()
case class Endure()
case class Fire()