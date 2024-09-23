package TypeClasses

import scala.language.strictEquality

@main
def subclasspoly =

  trait Serializable:
    def write: String = "something"

  case class Book(name: String) extends Serializable

  def doit(s: Serializable): String = s.write

  val eop = Book("Effect Oriented Programming")
  val s = doit(eop)

  // val s2 = doit("asdf")



@main
def adhocpoly =
  case class Company(name: String)

  trait Serializable[T]:
    extension (t: T) def write: String

  def doit[A: Serializable](a: A): String =
    a.write

  val acme = Company("Acme")

  given Serializable[Company] with
    extension (t: Company) def write = t.name

  val s = doit(acme)




case class Person(name: String) derives CanEqual

case class Employee(person: Person, role: String) derives CanEqual:
  override def equals(that: Any): Boolean = that match
    case p: Person =>
      this.person == p
    case e: Employee =>
      this == e
    case _ =>
      false

@main
def main =
  val linda = Person("Linda")
  val sam = Person("Sam")

  println(linda == sam)

  val e1 = Employee(linda, "Developer")

  // println(linda == e1)

  given CanEqual[Employee, Person] = CanEqual.derived

  println(e1 == linda)
  println(e1 == sam)
