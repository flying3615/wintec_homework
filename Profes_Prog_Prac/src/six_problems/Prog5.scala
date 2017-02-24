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
