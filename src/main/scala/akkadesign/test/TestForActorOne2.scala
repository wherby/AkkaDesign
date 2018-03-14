package akkadesign.test

import akka.actor.Props
import akkadesign.start.ActorOne
import akkadesign.app.SimpleApp
import akkadesign.msg.SimpleMSG.{Crash, Hi}

/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/3/12
  */
object TestForActorOne2 {
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    val actone = system.actorOf(Props[ActorOne],"actorOne")
    actone ! Hi
    var i = 0
    for( i <- 1 to 200){
      actone ! Crash
    }
    actone ! Crash
    actone ! Hi
    actone ! "test"
  }
}
