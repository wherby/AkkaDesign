package akkadesign.test

import SimpleMSG.{Crash, Hi}
import akka.actor.Props
import akkadesign.Start.{ActorThree}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object TestActorThree {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    val actone = system.actorOf(Props[ActorThree],"actorone")
    actone ! Hi
    actone ! Hi
    actone ! Hi
    actone ! Hi
    actone ! Hi
    Thread.sleep(1999)
    actone ! Crash
    actone ! Hi
    actone ! "test"
  }
}

