package akkadesign.test

import akka.actor.Props
import akkadesign.advance.ask.Actor7
import akkadesign.app.SimpleApp
import akkadesign.msg.SimpleMSG.Hi


/**
  *   * Created by whereby[Tao Zhou](187225577@qq.com)  20/03/2018
  */
object TestActor7 {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    val actor7= system.actorOf(Props[Actor7], "Actor7")
    actor7 ! Hi

  }
}
