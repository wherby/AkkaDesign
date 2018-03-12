package akkadesign.advance

import akka.actor.SupervisorStrategy.Restart
import akka.actor.{Actor, ActorLogging, OneForOneStrategy, Props}
import akkadesign.msg.SimpleMSG.{Crash, Hi}

import scala.concurrent.duration._
import scala.util.Random

/**
  * For akkadesign.advance in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/3/12
  */
class ActorSix extends Actor with ActorLogging {

  override val supervisorStrategy =
    OneForOneStrategy(maxNrOfRetries = 20, withinTimeRange =1 minute) {
      case _: Exception     ⇒ Restart
    }
  val actfive = context.actorOf(Props[ActorFive],"actorFive")

  val childActor = context.actorSelection("/user/MsgActorforActorSix")
  override def receive: Receive = {
    case Hi => actfive ! Hi
    case Crash => log.info("ready to crash")
      throw new RuntimeException("Crashed")
    case msg => actfive ! msg
  }
}
