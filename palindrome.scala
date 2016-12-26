/* Find palidromic no in given range without reverse command
 * 11,22,...111,121...949,959,...1331...etc
 */
import scala.collection.mutable.ArrayBuffer

object palindrome {
  
  def main (args : Array[String])
  {
    println("Enter the range (0 to ?) : ")
    val range = Console.readInt()
    println("Range - " + range)
    
    
  
    for (i <- 0 to range)
    {
        var sum = ArrayBuffer[String]()
        var rem = i
        while(rem > 0)
        {
          var  frem = rem%10
          sum += frem.toString()
          rem = rem/10
        } 
        //println(sum.mkString + " ---- " + i.toString())
        if(sum.mkString == i.toString())
        {
          println("Palindromic no - " + i) 
        }
        
    }
  }
  
}
