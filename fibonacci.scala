/* Fibonacci sequence
 * 1,1,2,3,5,8,13.....
 * Recursion problem
 */
import scala.collection.mutable.ArrayBuffer
object fibonacci {
  
  def main (args : Array[String])
  {
    //println("Enter no : ")
    //val no = Console.readInt()
    
    var a = fibonacci(10)
    println("Sum of fibonacci series - " +a)
    
  }
  
  def fibonacci(number : Int) : Int = number match
  { 
    case 0|1 => number
    case _=> fibonacci(number - 1) + fibonacci(number - 2)    
  }
   
}
