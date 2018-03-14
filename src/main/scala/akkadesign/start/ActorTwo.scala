package akkadesign.start

import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.actor.{Actor, ActorLogging}

/**
  * For akkadesign.Start in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
class ActorTwo extends Actor with ActorLogging{
  var msgList: List[Any] = Nil
  def addMsg(msg:Any)={
    msgList = msg ::msgList
  }
  def receive = {
    case Hi => log.info("hi")
      addMsg(Hi)
      log.info(s"All msg: $msgList")
    case Crash =>
      addMsg(Crash)
      log.info("crashing...")
      log.info(s"All msg: $msgList")
      throw new RuntimeException("Crashed")
    case msg:String=> log.info(msg)
      addMsg(msg)
      log.info(s"All msg: $msgList")
  }
}

