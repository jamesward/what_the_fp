package Monads

import scala.util.{Random, Try}

@main
def main =
  val settings = Map("KEY" -> "value")

  val maybeKey = Option.when(Random.nextBoolean)("KEY")
  val maybeValue = maybeKey.flatMap(key => settings.get(key))
  println(maybeValue)

  println:
    for
      key <- maybeKey
      value <- settings.get(key)
    yield
      value

  // sequencing other data types

  def maybeThrow: Try[String] =
    Try(if Random.nextBoolean then "Success" else throw new Exception("Failure"))

  val onetwo =
    for
      one <- maybeThrow
      two <- maybeThrow
    yield
      one + two

  println(onetwo)
