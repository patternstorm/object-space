package model

trait Propositions {
  self: Individuals =>

  trait Proposition
  case class is[X <: Individual, A <: Quality]() extends Proposition
  case class by[X <: Individual, Y <: Individual, R <: Relation]() extends Proposition

  def ⊢[P <: Proposition](p: P)(implicit fact: P): P = fact

}
