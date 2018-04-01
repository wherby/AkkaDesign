package akkadesign.test

import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.actor.Props
import akkadesign.start.{ActorFour, ActorTwo}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object TestActorFour {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    system.actorOf(Props[ActorTwo],"MsgActorforActorFour")
    val actfour = system.actorOf(Props[ActorFour],"actorFour")
    actfour ! Hi
    actfour ! Hi
    actfour ! Hi
    actfour ! Hi
    actfour ! Hi
    Thread.sleep(1999)
    actfour ! Crash
    actfour ! Hi
    actfour ! "test"
  }
}
