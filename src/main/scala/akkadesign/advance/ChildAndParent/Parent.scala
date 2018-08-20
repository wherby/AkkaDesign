package akkadesign.advance.ChildAndParent

import akka.actor.{Actor, ActorLogging, Props}
import akkadesign.advance.ActorFive



class Parent extends Actor with ActorLogging{


  val child = context.actorOf(Props[Child],"child")
  override def preStart() = log.info("Yo, I am alive! As Parent")
  override def postStop() = log.info("Goodbye world! As Parent" )
  override def receive: Receive = {
    case Message(msg) if containsRestart(msg) =>
      println(msg); throw new RestartMeException
    case Message(msg) if containsResume(msg) =>
      println(msg); throw new ResumeMeException
    case Message(msg) if containsStop(msg) =>
      println(msg); throw new StopMeException
    case Message(msg) if containsSecret(msg) =>
      println(msg); throw new Throwable
    case Message(msg) =>
      child forward  Message(msg)
      log.info(msg)
  }

  private def containsRestart = containsWordCaseInsensitive("restart")_
  private def containsResume = containsWordCaseInsensitive("resume")_
  private def containsStop = containsWordCaseInsensitive("stop")_
  private def containsSecret = containsWordCaseInsensitive("secret")_

  private def containsWordCaseInsensitive(word: String)(msg: String) =  msg matches s".*(?i)$word.*"
}
