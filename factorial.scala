/* Facorial no
 * 5! = 5*4*3*2*1
 * Recursion problem
 */

object factorial {
  
  def main (args : Array[String])
  {
    println("Enter no : ")
    val no = Console.readInt()
    
    var factorial = fact(no)
    println("Factorial - " + factorial)
    
  }
  
  def fact(number : Int) : Int =
  {
   val factorial=
   {
       if (number == 0)
        1
      else if (number < 0)
        0
      else
        (number*fact(number-1))
   }  
   factorial
   
  }
  
}