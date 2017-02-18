package six_problems

/**
  * Created by liuyufei on 18/02/17.

    Write a program that has four methods (exclude the main method) where calling any of these
    methods will result in an infinite loop of methods calling methods.
    b. Modify the program in part (a) and add parameters and conditions to the body of these
    methods so calling a method will not necessary results in an infinite loop.
  */
object Prog1 extends App{

  def A(times:Int):Unit = times match {
    case 0 => return
    case _ => println("A"); B(times-1)
  }

  def B(times:Int):Unit = times match {
    case 0 => return
    case _ => println("B"); C(times-1)
  }

  def C(times:Int):Unit = times match {
    case 0 => return
    case _ => println("C"); D(times-1)
  }

  def D(times:Int):Unit = times match {
    case 0 => return
    case _ => println("D"); A(times-1)
  }

  A(10)

}

