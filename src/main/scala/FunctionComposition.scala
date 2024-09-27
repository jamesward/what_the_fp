package FunctionComposition


def upper(s: String): String = s.toUpperCase

def count(s: String): Int = s.length

@main
def one =
  val i = count(upper("hello"))
  println(i)

  val countUpper = upper.andThen(count)
  println(countUpper("hello"))

  // programs as values

  val up = upper("hello")
  val c = count(up)
  println(c)

  println:
    count:
      upper:
        "hello"
