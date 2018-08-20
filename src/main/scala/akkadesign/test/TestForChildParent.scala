package akkadesign.test

import akka.actor.Props
import akkadesign.advance.ChildAndParent.{Message, ParentSupervisior}
import akkadesign.app.SimpleApp


object TestForChildParent{
  def main(args: Array[String]): Unit = {
    val system = SimpleApp.startupSingle()
    val printerSupervisor=system.actorOf(Props[ParentSupervisior],"ParentSuperVisor")
    printerSupervisor ! Message("...please, print me...")


    printerSupervisor ! Message("...why don't you restart?!")

    printerSupervisor ! Message("...please, print me... Again")
   // printerSupervisor ! Message("...you can STOP now!")
    printerSupervisor ! Message("...this is going to be our little secret...")
  }
}
