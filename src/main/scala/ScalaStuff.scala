val addOne: Int => Int =
  i => i + 1

@main
def main =
  
  // Immutability
  val x = 1
  // x = 2 // Error
  
  
  
  val a = addOne(1)
  val b = addOne(1)
  println(a -> b)
