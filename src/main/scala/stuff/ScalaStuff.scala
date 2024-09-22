package stuff

import java.util.UUID

object ScalaStuff:

  // Immutability

  case class Person(var id: UUID = null, name: String)

  def createPersonUnsafe(person: Person): Unit =
    Thread(() =>
      Thread.sleep(3000)
      person.id = UUID.randomUUID()
    ).start()

  def createPerson(person: Person): Person =
    person.copy(id = UUID.randomUUID())


  // Pure Functions

  var current = 0

  def addOne(i: Integer): Integer =
    current += 1
    if (current == 3) null
    else if (current == 4) throw new IllegalStateException
    else i + current


  // MISU
  opaque type Name = String
  
  object Name:
    def apply(s: String): Name = s
    
  extension (n: Name)
    def toLowercase: Name = n.toLowerCase