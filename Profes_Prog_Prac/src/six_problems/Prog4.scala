package six_problems

/**
  * Created by liuyufei on 20/02/17.
  */
sealed trait Sortable {
  def sort(input: Array[Int]): Array[Int]
}

object BubbleSort extends Sortable {
  override def sort(input: Array[Int]) = {
    if (input.isEmpty) new Array[Int](0)
    for (i <- 0 until input.length - 1; j <- 0 until input.length - 1 - i) {
      if (input(j) > input(j + 1)) {
        val temp = input(j)
        input(j) = input(j + 1)
        input(j + 1) = temp
      }
    }
    input
  }
}


object QuickSort extends Sortable {
  override def sort(input: Array[Int]): Array[Int] = {
    if (input.length < 2) input
    else {
      val pivot = input(input.length / 2)
      sort(input filter (_ < pivot)) ++ (input filter (_ == pivot)) ++ sort(input filter (_ > pivot))
    }
  }
}

object Prog4 extends App {


  def generateArray(size: Int) = {
    val r = scala.util.Random
    (for (i <- 0 to size) yield r.nextInt(size)).toArray
  }

  def runWithTimer[A,B](input: A)(f: A => B):B = {
    val start = System.currentTimeMillis()
    val result = f(input)
    val end = System.currentTimeMillis()
    println(end - start)
    result
  }


  val a = generateArray(10000)

  //  println(a.mkString(","))

  runWithTimer(a) {
    QuickSort.sort _
  }

  runWithTimer(a) {
    BubbleSort.sort _
  }

}
