package akkadesign.advance.ChildAndParent

import akka.actor.{Actor, ActorLogging}


class Child extends Actor with ActorLogging{
  override def preStart() = log.info("Yo, I am alive!")
  override def postStop() = log.info("Goodbye world!")
  override def receive: Receive = {
    case Message(msg) => log.info(msg)
  }
}
