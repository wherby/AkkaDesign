package akkadesign.advance.ask

import akka.actor.{Actor, ActorLogging}
import akkadesign.msg.SimpleMSG.{Crash, Hi}

/**
  *   * Created by whereby[Tao Zhou](187225577@qq.com)  20/03/2018
  */
class Actor71 extends Actor with ActorLogging{

  def receive = {
    case Hi =>
      Thread.sleep(10000)
      log.debug("reply ")
      sender() ! "reply from actor71 :" +"ree"
    case Crash =>
      log.info("crashing...")
      throw new RuntimeException("Crashed")
    case msg:String=> log.info(msg)
  }
}
