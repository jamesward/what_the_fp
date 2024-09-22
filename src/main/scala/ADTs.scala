package ADTs

import scala.util.Random

@main
def main =

  // Sum Type
  val a: Int | String =
    if Random.nextBoolean then
      1
    else
      "a"

  println(a)

  // Enum Type
  enum IntOrString:
    case I(i: Int) extends IntOrString
    case S(s: String) extends IntOrString

  val b: IntOrString = if Random.nextBoolean then IntOrString.I(1) else IntOrString.S("a")
  println(b)

  // Pattern Matching

  a match
    case i: Int => println(s"an int: $i")
    case s: String => println(s"a string: $s")

  b match
    case IntOrString.I(i) => println(s"an int: $i")
    case IntOrString.S(s) => println(s"a string: $s")

  // Products
  val p = (1, "a")

  case class Pair(i: Int, s: String)
  val p2 = Pair(1, "a")


  // Naming
  val c: Boolean | Boolean = true
  val d: Either[Boolean, Boolean] = Right(true)

  enum Trither(b: Boolean):
    case Left(b: Boolean) extends Trither(b)
    case Middle(b: Boolean) extends Trither(b)
    case Right(b: Boolean) extends Trither(b)

  // 2 + 2 + 2
  // union / sum
  // OR

  val bs: (Boolean, Boolean, Boolean) = (true, true, true)

  // 2 * 2 * 2
  // itersection / product
  // AND