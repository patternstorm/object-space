package model

import model.statements.Propositions

trait Individuals {
  self: Propositions =>

  trait Individual {
    def is[A <: Quality](A: A): this.type is A = new is[this.type, A]
    def ~[X <: Individual](x: X): this.type ~ X = new ~[this.type, X]
  }

  trait Particular extends Individual
  trait Universal extends Individual
  trait Quality extends Universal
  trait Relation extends Universal

  case class ~[X <: Individual, Y <: Individual]() {
    def by[R <: Relation](R: R): by[X, Y, R] = new by[X, Y, R]
  }

}
