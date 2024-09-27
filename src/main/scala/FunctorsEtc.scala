package FunctorsEtc

import scala.annotation.tailrec

@main
def main =
  val people = List("james", "bruce", "bill")

  println:
    people.map:
      s => s.toUpperCase

  println:
    people.foldRight(0):
      (person, total) =>
        total + person.length

  println:
    people.map(_.length).sum

  // early returns
  println:
    people.find(_.startsWith("j"))

  // from scratch

  @tailrec
  def findJ(s: String, in: List[String]): Option[String] =
    if in.isEmpty then
      None
    else
      if in.head == s then Some(s) else findJ(s, in.tail)

  println:
    findJ("james", people)


  println:
    people.filter(_.contains('j'))

  // filter from primitives
  println:
    people.flatMap:
      s =>
        if s.contains('b') then List(s) else List.empty

  // immutable values, transforms w/ pure functions
  // testable, grokable, optimizable, refactorable, composable, parallelizable
