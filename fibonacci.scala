/* Sum of Fibonacci sequence
 * fib(6) = 0+1+1+2+3+5 = 12
 * Recursion problem
 */
import scala.collection.mutable.ArrayBuffer
object fibonacci {
  
  def main (args : Array[String])
  {
    println("Enter no : ")
    val no = Console.readInt()
    
    var a = fibonacci(no)
    println("Sum of fibonacci series - " +a)
    
  }
  
  def fibonacci(number : Int) : Int = number match
  { 
    case 0|1 => number
    case _=> fibonacci(number - 1) + fibonacci(number - 2)    
  }
   
}
