package akkadesign.Start

import SimpleMSG._
import akka.actor.{Actor, ActorLogging}
import play.api.libs.json.JsResult.Exception

/**
  * For akkadesign.Start in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
class ActorOne extends Actor with ActorLogging{
  def receive = {
    case Hi => log.info("hi")
    case Crash =>
      log.info("crashing...")
      throw new RuntimeException("Crashed")
    case msg:String=> log.info(msg)
  }
}
