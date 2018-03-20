package akkadesign.advance.ask

import akka.actor.{Actor, ActorLogging, ActorRef, Cancellable}
import akkadesign.msg.SimpleMSG.{Crash, Hi}

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  *   * Created by whereby[Tao Zhou](187225577@qq.com)  20/03/2018
  */
class Actor72 extends Actor with ActorLogging {

  var cancellable: Option[Cancellable] = None
  var replyTo :ActorRef = null;
  def receive = {
    case Hi => log.debug("Start TICK...")
      if(cancellable == None){
        replyTo = sender()
        cancellable= Some(context.system.scheduler.schedule(0 seconds, 4 second, self, "test"))
      }
    case Crash =>
      log.info("crashing...")
      throw new RuntimeException("Crashed")
    case msg: String => log.info(msg)
      replyTo ! "Repy from actor 72 :" + msg
  }
}