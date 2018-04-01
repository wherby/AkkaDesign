package akkadesign.openclose.open

/**
  * For akkadesign.openclose in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/4/1
  */
abstract  class Parent {
    def say(info :String);
}

class ChildOne extends  Parent{
   override  def say(info: String): Unit = {
      println("child one: " + info)
   }
}
class ChildTwo extends Parent{
   override  def say(info: String): Unit = {
      println("Child two :" + info)
   }
}

object TestOpen {
   def main(args: Array[String]): Unit = {
      val  childOne = new ChildOne
      val childTwo = new ChildTwo
      val ls = childOne::childTwo::List.empty[Parent]
      for(t <-ls){
         t.say("hello")
      }
   }
}