package akkadesign.test

import akkadesign.msg.SimpleMSG._
import akka.actor.Props
import akkadesign.app.SimpleApp
import akkadesign.start.ActorOne

/**
  * Created by TaoZhou(whereby@live.cn) on 13/10/2017.
  */
object TestActorOne {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    val actone = system.actorOf(Props[ActorOne],"actorOne")
    actone ! Hi
    actone ! Crash
    actone ! Hi
    actone ! "test"
  }
}
