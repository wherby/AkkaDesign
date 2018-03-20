package akkadesign.advance.ask

import akka.actor.{Actor, ActorLogging, Props}
import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.pattern._
import akka.util.Timeout
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit

import scala.concurrent.ExecutionContext.Implicits.global
/**
  *   * Created by whereby[Tao Zhou](187225577@qq.com)  20/03/2018
  */
class Actor7 extends Actor with ActorLogging{
  implicit val timeout = Timeout(Duration(20, TimeUnit.SECONDS))

  val child1 = context.actorOf(Props[Actor71],"child1")
  val child2 = context.actorOf(Props[Actor72],"child2")

  def receive = {
    case Hi => child2! Hi
      val reply= (child1 ? Hi) map{
        a => log.info("Received : " + a.toString)
      }

    case "TEST" =>{
      log.info("Start TEST ")
      val reply= (child2 ? Hi) map{
        a => log.info("Received : " + a.toString)
      }
    }

    case Crash =>
      log.info("crashing...")
      throw new RuntimeException("Crashed")
    case msg:String=> log.info(msg)
  }
}
