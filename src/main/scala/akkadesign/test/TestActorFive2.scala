package akkadesign.test

import akka.actor.{ActorRef, ActorSystem, OneForOneStrategy, Props}
import akka.actor.SupervisorStrategy.Restart
import akka.util.Timeout
import akkadesign.start.ActorTwo
import akkadesign.advance.ActorFive
import akkadesign.app.SimpleApp
import akkadesign.msg.SimpleMSG.{Crash, Hi}
import akka.pattern.ask

import scala.concurrent.Await
import scala.util.Random
/**
  * For akkadesign.test in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/3/12
  */
object TestActorFive2 {
  def getActorFive(system:ActorSystem): ActorRef ={
    var actfive:ActorRef = null
    import scala.concurrent.duration._

      implicit val timeout = Timeout(0.1 seconds)
      val i = Random.nextInt(19999999)
      actfive = system.actorOf(Props[ActorFive],"actorFive" + i.toString)
      val future = actfive ? "ping"
      try{
        val result = Await.result(future, timeout.duration).asInstanceOf[String]

          println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
          return actfive

      }catch {
        case e=>println( "timeout")
      }



    return null

  }

  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSignal()
    system.actorOf(Props[ActorTwo],"MsgActorforActorFour")
    var actfive:ActorRef = null

    while(actfive ==null){
      actfive =getActorFive(system)
    }
    println(actfive)
    Thread.sleep(1999)
    actfive ! Hi
    actfive ! Hi
    actfive ! Hi
    actfive ! Hi
    actfive ! Hi
    Thread.sleep(1999)
    actfive ! Crash
    actfive ! Hi
    actfive ! "test"
  }
}
