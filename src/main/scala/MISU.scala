package MISU

import java.util.UUID
import stuff.ScalaStuff.*

import scala.util.Random

@main
def one =

  def addOne(i: Int): Int = i + 1

  def addOneSafe(i: Int): Option[Int] =
    Option.unless(i == Int.MaxValue)(i + 1)


  // nullability

  case class PersonSafe(id: Option[UUID], name: String)

  val bill = PersonSafe(None, "Bill")
  val billId = if bill.id.isDefined then bill.id.get.toString else "undefined"
  println(billId)


  // generics: constraints liberate
  def doThing[A](a: A): A = ???

  def doNothing(): String = "nothing"

  def doNothing2(s: String): Unit = ()

  def doSomething[A](a: List[A]): List[A] = a.tail


  // specialized "primitives"

  def onlyName(n: Name) = n //.toUpperCase

  //onlyName("asdf")

  val n: Name = Name("asdf")
  onlyName(n)


  // Neotypes

  import neotype.*

  object NonEmptyString extends Newtype[String]:
    override inline def validate(input: String): Boolean =
      input.nonEmpty

  NonEmptyString("Hello") // OK
  // NonEmptyString("")      // Compile Error

  val a = if Random.nextBoolean() then "Hello" else ""
  val nea = NonEmptyString.make(a)
  println(nea.getOrElse("was empty"))
