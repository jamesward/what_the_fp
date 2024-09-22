package ExpressionOriented

import scala.util.Random

@main
def main =
  val s = "Hello, World"

  val ss = if Random.nextBoolean() then
    s.toUpperCase
  else
    s.toLowerCase

  println(ss)

  // refactorability

  def nesterEgg(s: String): String =
    if s.isEmpty then
      return "empty"
    else
      var other = "asdf"
      if Random.nextBoolean() then
        other = s.toUpperCase

      return other

  def betterEgg(s: String): String =
    if s.isEmpty then
      "empty"
    else
      if Random.nextBoolean() then
        s.toUpperCase
      else
        "asdf"

  def upperOrDefault(s: String): String =
    if Random.nextBoolean() then
      s.toUpperCase
    else
      "asdf"
