package akkadesign.test
import SimpleMSG._
import akka.actor.Props
import akkadesign.Start.{ ActorTwo}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object TestActorTwo {
def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    val actone = system.actorOf(Props[ActorTwo],"actorone")
    actone ! Hi
    actone ! Crash
    actone ! Hi
    actone ! "test"
  }
}
