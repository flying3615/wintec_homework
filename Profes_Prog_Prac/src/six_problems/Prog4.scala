package six_problems

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liuyufei on 20/02/17.
QuickSort took 5 ms
BubbleSort took 1 ms
--------------------
sort 10 size array
QuickSort took 0 ms
BubbleSort took 1 ms
--------------------
sort 50 size array
QuickSort took 2 ms
BubbleSort took 0 ms
--------------------
sort 100 size array
QuickSort took 3 ms
BubbleSort took 1 ms
--------------------
sort 500 size array
QuickSort took 7 ms
BubbleSort took 5 ms
--------------------
sort 1000 size array
QuickSort took 4 ms
BubbleSort took 6 ms
--------------------
sort 2000 size array
QuickSort took 3 ms
BubbleSort took 11 ms
--------------------
sort 10000 size array
QuickSort took 14 ms
BubbleSort took 379 ms
--------------------
sort 50000 size array
QuickSort took 80 ms
BubbleSort took 7829 ms
--------------------
sort 100000 size array
QuickSort took 167 ms
BubbleSort took 30671 ms
--------------------
sort 1000000 size array
QuickSort took 1667 ms
BubbleSort took N/A
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

  def generateArrayListDup(sizes: Int*) = {
    val r = scala.util.Random
    val arrayList = new ArrayBuffer[Array[Int]]()
    sizes foreach { s=>
      arrayList += (for (i <- 0 until s) yield r.nextInt(s)).toArray
    }
    arrayList
  }


  def generateArrayListShuffle(sizes:Int*) = {
    val arrayList = new ArrayBuffer[Array[Int]]()
    sizes foreach { s =>
      arrayList += util.Random.shuffle(((1 to s).toList)).toArray
    }
    arrayList
  }

  def runWithTimer[A,B](input: A, algorithmName:String)(f: A => B):B = {
    val start = System.currentTimeMillis()
    val result = f(input)
    val end = System.currentTimeMillis()
    println(algorithmName+ " took "+(end - start)+" ms")
    result
  }

  val arrayOfArray = generateArrayListShuffle(5,10,50,100,500,1000,2000,10000,50000,100000,1000000)

  arrayOfArray foreach { array=>

    println("sort "+array.length+" size array")

    runWithTimer(array,"QuickSort") {
      QuickSort.sort
    }

    runWithTimer(array,"BubbleSort") {
      BubbleSort.sort
    }

    println("-"*20)
  }


}
