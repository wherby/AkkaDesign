package akkadesign.openclose.close.oo




/**
  * For akkadesign.openclose in AkkaDesign
  * Created by whereby[Tao Zhou](187225577@qq.com) on 2018/4/1
  */
abstract class Msg {
  def isApply(obj : Parent):Boolean
  def apply():String
}



class MsgOne extends Msg{
  override def isApply(obj: Parent): Boolean = {
     obj.isInstanceOf[ChildOne]
  }

  override def apply(): String = {
    "Receive :" + this.getClass.toString
  }
}

class MsgTwo extends Msg{
  override def isApply(obj: Parent): Boolean = {
    obj.isInstanceOf[ChildTwo]
  }

  override def apply(): String = {
    "Receive :" + this.getClass.toString
  }
}

abstract  class Parent {
  def say(info :Msg);
}

class ChildOne extends Parent{
  override def say(info: Msg): Unit = {
    if(info.isApply(this)){
      println( "Child One: " + info.apply())
    }
  }
}

class ChildTwo extends Parent{
  override def say(info: Msg): Unit = {
    if(info.isApply(this)){
      println("ChildTwo :" + info.apply())
    }
  }
}


object TestOpen {
  def main(args: Array[String]): Unit = {
    val  childOne = new ChildOne
    val childTwo = new ChildTwo
    val ls = childOne::childTwo::List.empty[Parent]
    for(t <-ls){
      t.say(new MsgOne())
      t.say(new MsgTwo())
    }
  }
}


