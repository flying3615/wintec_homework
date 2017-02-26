package six_problems

/**
  * Created by liuyufei on 19/02/17.
  */

trait flyable{
  def fly
}

trait soundable{
  def sound
}

abstract class Creature(val className:String){
  def eat
}

class Bird extends Creature(className = "Bird") with flyable with soundable {

  override def fly: Unit = println(className + " flies high")

  override def eat: Unit = println(className+ " eats worms")

  override def sound: Unit = println(className+" sounds tweet")
}

class Dragonfly  extends Creature(className = "Dragonfly") with flyable{

  override def eat: Unit = println(className+ " eats insects ")

  override def fly: Unit = println(className+" flies low ")
}

class Cicada extends Creature(className = "Cicada") with soundable{

  override def eat: Unit = println(className+" eats plant")

  override def sound: Unit = println(className+" sounds squeak")
}


object Main extends App{

  val bird = new Bird
  val dragonfly = new Dragonfly
  val cicada = new Cicada

  bird.eat
  bird.fly
  bird.sound

  println("*"*10+" single say "+"*"*10)

  dragonfly.eat
  dragonfly.fly

  println("*"*10+" single say "+"*"*10)

  cicada.eat
  cicada.sound


}