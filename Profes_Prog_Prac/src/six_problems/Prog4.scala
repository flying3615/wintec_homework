package six_problems

/**
  * Created by liuyufei on 20/02/17.
  */


trait Sortable {
  def sort(input:Array[Int]):Array[Int]
}

object BubbleSort extends Sortable{
  override def sort(input: Array[Int]) = {
    if(input.isEmpty) new Array[Int](0)
    for(i <- 0 until input.length-1; j <- 0 until input.length-1-i){
      if(input(j)>input(j+1)){
        val temp = input(j)
        input(j) = input(j+1)
        input(j+1) = temp
      }
    }
    input
  }
}


object QuickSort extends Sortable{
  override def sort(input: Array[Int]):Array[Int] = {
    if(input.length<2) input
    else{
      val pivot = input(input.length/2)
      sort(input filter (_<pivot)) ++ (input filter (_==pivot)) ++ sort(input filter (_>pivot))
    }
  }
}

object Prog4 extends App{

  def runWithTimer(input:Array[Int])(f:(Array[Int])=>Array[Int]) = {
    val start = System.currentTimeMillis()
    println(f(input).mkString(","))
    val end = System.currentTimeMillis()
    println(end-start)
  }

  //TODO generate Randome


  val a = Array(10,2,1,5,3,8,6,9,7,4)

  runWithTimer(a){
    BubbleSort.sort _
  }

  runWithTimer(a){
    QuickSort.sort _
  }

}
