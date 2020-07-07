package akkadesign.advance

import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import akkadesign.msg.SimpleMSG.{Crash, Hi}

import scala.util.Random

/**
  * For akkadesign.advance in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/3/12
  */
class ActorFive extends Actor with ActorLogging {
    val rand = Random.nextInt(5)
    val start = if(rand != 0){
      log.error("about to fail")
      throw  new RuntimeException("Crashed for bad luck")
    }

  val childActor = context.actorSelection("/user/MsgActorforActorFive")
  override def receive: Receive = {
    case Hi => childActor ! Hi
    case Crash => log.info("ready to crash")
      throw new RuntimeException("Crashed")
    case "ping" =>sender() !"pong"
    case msg => childActor ! msg

  }
}
