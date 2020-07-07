package akkadesign.test

import akka.actor.Props
import akkadesign.start.ActorTwo
import akkadesign.advance.{ActorFive, ActorSix}
import akkadesign.app.SimpleApp
import akkadesign.msg.SimpleMSG.{Crash, Hi}

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/3/12
  */
object TestActorSix {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    system.actorOf(Props[ActorTwo],"MsgActorforActorSix")
    val actorSix = system.actorOf(Props[ActorSix],"actorSix")
    Thread.sleep(1999)
    actorSix ! Hi
    actorSix ! Hi
    actorSix ! Hi
    actorSix ! Hi
    actorSix ! Hi
    Thread.sleep(1999)
    actorSix ! Crash
    actorSix ! Hi
    actorSix ! "test"
  }
}