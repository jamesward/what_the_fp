package Immutability

import stuff.ScalaStuff.*

import scala.collection.parallel.CollectionConverters.*

@main
def main =
  // make val not var
  val a = 1
  // a = 2 // error: reassignment to val
  

  // linear flow
  val jim = Person(name = "Jim")
  createPersonUnsafe(jim)
  println(jim.id)
  Thread.sleep(4000)
  println(jim.id)

  val sally = Person(name = "Sally")
  println(sally.id)
  val sallyWithId = createPerson(sally)
  println(sally.id)
  println(sallyWithId.id)


  // concurrency
  var i = 0
  (0 until 1000).par.foreach:
    _ => i += 1

  println(i)
