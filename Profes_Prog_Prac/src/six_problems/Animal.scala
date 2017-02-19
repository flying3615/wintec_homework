package six_problems

/**
  * Created by liuyufei on 19/02/17.
  */
class Animal(val sound:String = "rustle")
class Bird(override val sound:String="call") extends Animal
class Chicken (override val sound:String="cluck") extends Bird

object Sayit{
  def say(animal: Animal): Unit ={
    println(animal.sound)
  }

  def say4All(animals:List[Animal]): Unit ={
    animals.foreach{say(_)}
  }
}


object Main extends App{

  val animal = new Animal
  val bird = new Bird
  val chicken = new Chicken



  println("*"*10+" single say "+"*"*10)

  Sayit.say(animal)
  Sayit.say(bird)
  Sayit.say(chicken)


  val animals = List(new Animal,new Animal,new Animal)
  val birds = List(new Bird,new Bird,new Bird)
  val chickens = List(new Chicken,new Chicken,new Chicken)

  println("*"*10+" Say 4 All "+"*"*10)
  //covariant
  Sayit.say4All(animals)
  Sayit.say4All(birds)
  Sayit.say4All(chickens)


}