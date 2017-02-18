package six_problems

/**
  * Created by liuyufei on 18/02/17.
  */
object Prog3 extends App{

  case class Foo(var x:Int = 100){
    def plusOne = x+=1

    def x_= (xxx:Int){
      x = xxx
    }
  }
  val f = Foo()
  f.x = 10
  println(f.x)

  new Thread(){
    0 to 10 foreach(i=>{
      Foo().plusOne
    })
  }.start()

}
