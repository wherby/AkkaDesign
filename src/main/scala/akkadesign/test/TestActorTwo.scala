package akkadesign.test
import akkadesign.msg.SimpleMSG._
import akka.actor.Props
import akkadesign.start.{ ActorTwo}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object TestActorTwo {
def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    val actone = system.actorOf(Props[ActorTwo],"actorTwo")
    actone ! Hi
    actone ! Crash
    actone ! Hi
    actone ! "test"
  }
}
