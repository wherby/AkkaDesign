package akkadesign.test

import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.actor.Props
import akkadesign.start.{ActorThree}
import akkadesign.app.SimpleApp

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object TestActorThree {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    val actthree = system.actorOf(Props[ActorThree],"actorThree")
    actthree ! Hi
    actthree ! Hi
    actthree ! Hi
    actthree ! Hi
    actthree ! Hi
    Thread.sleep(1999)
    actthree ! Crash
    actthree ! Hi
    actthree ! "test"
  }
}

