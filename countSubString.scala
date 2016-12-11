/*
 * Count of distinct substrings of a string using Suffix 
 * 
 *  Input  : str = “ababa”
    Output : 9
    Total number of distinct substring are 10, which are,
     "a", "b", "ab", "ba", "aba", "bab", "abab", "baba"
    and "ababa"
 * 
 */

// Traverse in array and find combnation of sub-string - Easiest way

// Another way - Form Suffix tree and traverse the tree - like  "aba-ab-a-ROOT-b-ba-bab" and so on.

import scala.collection.mutable.ArrayBuffer

object countSubString {
  
  def main( args : Array[String])
  {
    var str = "ababa"
    var arr = str.toArray
   
    var star = ArrayBuffer[String]()
    var star1 = ArrayBuffer[String]()
    var count = 0
    for(i <- 0 to arr.length-1)
    {
       star += arr(i).toString()
       println("Star - " + star.mkString)
       count=count+1
       if (i < arr.length-1)
       {
         star1 += arr(i+1).toString()
         println("Star - " + star1.mkString) 
         count = count +1
       }
    }
    println("Count - " + count)
    
  }
}
