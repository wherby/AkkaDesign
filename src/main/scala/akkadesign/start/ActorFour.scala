package akkadesign.start

import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.actor.{Actor, ActorLogging}

/**
  * For akkadesign.Start in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
class ActorFour extends Actor with ActorLogging {
  val childActor = context.actorSelection("/user/MsgActorforActorFour")
  override def receive: Receive = {
    case Hi => childActor ! Hi
    case Crash => log.info("ready to crash")
      throw new RuntimeException("Crashed")
    case msg => childActor ! msg
  }
}