package six_problems

import scala.io.Source

/**
  * Created by liuyufei on 19/02/17.
  Suppose you have a text file with 100,000 words. Our task is to find the most frequent term in this
  file efficiently. Write a program that outputs the most frequent words.
  */
object Prog5 extends App{


  val fileSource = Source.fromFile("/Users/liuyufei/IdeaProjects/wintec_homework/Profes_Prog_Prac/src/six_problems/prog5_input.txt")

  //read from a file by lines, then flat lines to word list by separating with space,
  //use map to store word->frequency, fold map and increase frequency if the word already exists.
  val wordFreqMap = fileSource.getLines().flatMap(_.split("\\s+")).foldLeft(Map[String,Int]()){ (m, w)=>
    m + (w -> (m.getOrElse(w,0) + 1))
  }

  //sort the map by value(frequency), reverse the ascending, then get the head of the sorted map
  val topMostTuple = wordFreqMap.toArray.sortBy(_._2).reverse.head

  //print out the most appeared word and its frequency
  print(topMostTuple._1,topMostTuple._2)

  //close file handler
  fileSource.close()

}

//simple implement of flatMap, just for general analysis
//a file has n lines and n words in each line, O(n^2)
class FlatMappable[A](elements:A*){
  def flatMap[B](f:A => List[B]):List[B] = {
    val result = collection.mutable.MutableList[B]()
    elements.foreach{
      f.apply(_).foreach{
        result += _
      }
    }
    result.toList
  }
}

//simple implement of foldLeft, just for general analysis, O(n)
class FolderLeftable[A](elements:A*){
  def foldLeft[B](seed:B)(f:(B,A)=>B):B = {
    var result = seed
    elements.foreach{ x=>
      result=f(result,x)
    }
    result
  }
}
// for the sort part, using java build-in binary insertion sort
//* Sorts the specified portion of the specified array using a binary
//* insertion sort.  This is the best method for sorting small numbers
//* of elements.  It requires O(n log n) compares, but O(n^2) data
//* movement (worst case).

// for reverse, it's O(n)

//totally, O(n^2)+O(n)+O(n log n)+O(n) = O(n^2)
