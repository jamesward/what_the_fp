package Applicatives

import zio.prelude.Validation


@main
def main =

  // Functors: 1:1 transform
  // Monads: m:1 binary tree
  // Applicatives: m:s|s transform

  // parsers, validators, error accumulators

  def validatePositive(n: Int): Either[String, Int] =
    if (n > 0) Right(n) else Left(s"$n is not positive")

  val numbers = List(1, 2, 3, -4, 5, -99)

  type ValidationResult = Either[List[String], List[Int]]

  def validateAll(acc: ValidationResult, item: Int): ValidationResult =
    (acc, validatePositive(item)) match
      case (Left(errors), Left(error)) => Left(errors :+ error)
      case (Right(_), Left(error)) => Left(List(error))
      case (Left(errors), Right(_)) => Left(errors)
      case (Right(acc), Right(value)) => Right(acc :+ value)

  println:
    numbers.foldLeft(Right(List.empty))(validateAll)

  val goodNums = List(1, 2, 3)

  println:
    goodNums.foldLeft(Right(List.empty))(validateAll)

  // validation

  extension (list: List[Int])
    def validate: List[Validation[String, Int]] =
      list.map:
        i =>
          Validation.fromEither:
            validatePositive(i)

  println:
    Validation.validateAll:
      numbers.validate

  println:
    Validation.validateAll:
      goodNums.validate
