/* Find Armstring no in a given range
 * 153 - 1^3 + 5^3 + 3^3 = 153 
 */

object armstrong {
  
  def main (args : Array[String])
  {
    println("Enter the range (0 to ?) : ")
    val range = Console.readInt()
    println("Range - " + range)
    
    var sum =0
  
    for (i <- 0 to range)
    {
        var rem = i
        while(rem > 0)
        {
          var  frem = rem%10
          sum = sum + frem*frem*frem
          rem = rem/10
        } 
        if(sum == i)
        {
          println("Armstrong no - " + i) 
        }
        sum = 0
    }
  }
  
}
