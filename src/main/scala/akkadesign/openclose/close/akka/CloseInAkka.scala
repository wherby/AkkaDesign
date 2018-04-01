package akkadesign.openclose.close.akka

import akka.actor.{Actor, ActorRef, Props}
import akkadesign.app.SimpleApp


/**
  * For akkadesign.openclose.close in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/4/1
  */


case class Msg()

case class MsgOne()

case class MsgTwo()


class AkkaChildOne extends Actor {
  override def receive: Receive = {
    case msg@MsgOne => println("Child one :" + msg.getClass.toString)
  }
}

class AkkaChildTwo extends Actor {
  override def receive: Receive = {
    case msg@MsgTwo => println("Child two :" + msg.getClass.toString)
  }
}


object CloseInAkka {

  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    val childOne = system.actorOf(Props[AkkaChildOne], "childone")
    val childTwo = system.actorOf(Props[AkkaChildTwo], "childtwo")
    val ls = childOne :: childTwo :: List.empty[ActorRef]
    for (tp <- ls) {
      tp ! MsgOne
      tp ! MsgTwo
    }
  }
}
