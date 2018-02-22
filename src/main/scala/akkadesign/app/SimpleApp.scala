package akkadesign.app

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory

/**
  * For akkadesign.app in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/2/22
  */
object SimpleApp {
  def startup(ports: Seq[String]): Seq[ActorSystem] = {
    val config = ConfigFactory.load()
    val systems = ports map { port =>
      val sysConfig = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
        .withFallback(ConfigFactory.load())
      val system = ActorSystem("akkadesign", sysConfig)
      system
    }
    systems
  }

  def startupSignal(): ActorSystem = {
    val system = ActorSystem("akkadesign")
    system
  }
}
