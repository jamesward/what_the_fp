package HigherOrderFunctions

@main
def main =
  def doSomethingToString(s: String, f: String => String): String =
    f(s)

  println:
    doSomethingToString("hello", s => s.toUpperCase)

  case class Req(body: String)
  case class Resp(body: String)
  def requestHandler(s: String): Req => Resp =
    req =>
      Resp(s + req.body.toUpperCase)

  println(requestHandler("hello"))
  println(requestHandler("hello")(Req("world")))
  println(requestHandler("hello")(Req("james")))
