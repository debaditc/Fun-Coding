/* Print Pascal's triangle 
 * 1      --- 0
 * 11     --- 1
 * 121    --- 2
 * 1331   --- 3
 * 14641  --- 4
 * Basic concept
 * pascal(2,4) - means 2nd column of 4th row which is "6"
 */
import scala.collection.mutable.ArrayBuffer

object pascaltriangle {
  
 def main (args : Array[String])
 {
   for (i <- 0 to 5)
   {
     for (j <- 0 to i)
     {
       print(pascal(j,i))
     }
     println("\n")
   }
 }
 
  def pascal(c: Int, r: Int): Int = {
    if  (c == 0 || c == r )  1
    else
      pascal(c, r - 1) + pascal(c - 1, r - 1)
  }
  
}