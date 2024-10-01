package PureFunctions

import stuff.ScalaStuff.addOne

import scala.collection.parallel.CollectionConverters.*

import java.text.SimpleDateFormat

// hidden mutable state
@main
def one =
  val i = addOne(2)

  val j = addOne(2)

  val k = addOne(2)

  val l = addOne(2)

  val m = addOne(2)

// concurrency & shared state
@main
def two =
  val formatter = new SimpleDateFormat("yyyy-MM-dd")

  val dates = Set("2023-01-01", "2023-02-15", "2023-03-30", "2023-04-12", "2023-05-25")

  // then try .par.foreach
  dates.foreach:
    date =>
      val parsed = formatter.parse(date)
      val formatted = formatter.format(parsed)
      println(date -> formatted)

// testable
@main
def three =
  assert(addOne(2) == 3)
  assert(addOne(3) == 4)

// errors as values
@main
def four =
  val names = List("Alice", "Bob", "Charlie")
  //val names = List.empty[String]

  println(names.head)
  //println(names.headOption)
