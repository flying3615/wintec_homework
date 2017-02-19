package six_problems

import scala.io.Source

/**
  * Created by liuyufei on 19/02/17.
  Suppose you have a text file with 100,000 words. Our task is to find the most frequent term in this
  file efficiently. Write a program that outputs the most frequent words.
  */
object Prog5 extends App{


  val filsSource = Source.fromFile("/Users/liuyufei/IdeaProjects/wintec_homework/Profes_Prog_Prac/src/six_problems/prog5_input.txt")

  val wordFreqMap = filsSource.getLines().toStream.flatMap(_.split("\\s+")).foldLeft(Map[String,Int]()){ (m,w)=>
    m + (w -> (m.getOrElse(w,0) + 1))
  }

  val topMostTuple = wordFreqMap.toArray.sortBy(_._2).reverse.head

  print(topMostTuple._1,topMostTuple._2)

  filsSource.close()

}
