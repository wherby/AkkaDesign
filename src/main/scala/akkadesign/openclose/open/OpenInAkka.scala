package akkadesign.openclose.open

import akka.actor.{Actor, ActorRef, Props}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.openclose in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/4/1
  */
case class HiMsg(msg:String)

class AkkaChildOne  extends Actor {
  override def receive: Receive =  {
  case HiMsg(msg)=> println("Child one :" +msg)
  }
}

class AkkaChildTwo extends Actor {
  override def receive: Receive =  {
    case HiMsg(msg)=> println("Child two :" +msg)
  }
}

object TestOpenForAkka{
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    val childOne = system.actorOf(Props[AkkaChildOne],"childone")
    val childTwo = system.actorOf(Props[AkkaChildTwo],"childtwo")
    val ls = childOne::childTwo::List.empty[ActorRef]
    for(tp <-ls){
      tp !HiMsg("hello")
    }
  }
}
