//Swap 2 variables without 3rd variable
object swap {
 def main(args : Array[String])
  {
    var a =5
    var b = 3
    println("Before a - " + a + "  b - " +b)
    a = a+b
    b = a-b
    a = a-b
    println("After a - " + a + "  b - " +b)
  }
}