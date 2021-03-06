package six_problems

/**
  * Created by liuyufei on 19/02/17.
  */

//Act as Java interface
trait flyable{
  def fly
}

trait soundable{
  def sound
}

//super class of Bird, Dragonfly and Cicada
//Creature must be able to eat something
abstract class Creature(val className:String){
  def eat
}

//Bird is a creature that can eat & sound & fly
class Bird extends Creature(className = "Bird") with flyable with soundable {

  //override flyable to Bird unique behavior
  override def fly: Unit = println(className + " flies high")

  //override eat to Bird's foods
  override def eat: Unit = println(className+ " eats worms")

  //override sound to Bird's tweet
  override def sound: Unit = println(className+" sounds tweet")
}

//Dragonfly is a creature that can eat & fly, but can't sound...
class Dragonfly  extends Creature(className = "Dragonfly") with flyable{

  override def eat: Unit = println(className+ " eats insects ")

  override def fly: Unit = println(className+" flies low ")
}

//Cicada is a creature that can eat & sound, but can't fly...
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