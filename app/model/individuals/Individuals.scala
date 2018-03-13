package model.individuals

import model.statements.Propositions

trait Individuals {
  self: Propositions =>

  trait Rep {
    type self <: Individual
  }

  trait Individual {
    type self <: Individual

    def is[A <: Quality](A: A): self is A = new is[self, A]

    def ~(x: Rep): self ~ x.self = new ~[self, x.self]
  }

  trait Universal extends Individual

  trait Quality extends Universal

  trait Relation extends Universal

  case class ~[X <: Individual, Y <: Individual]() {
    def by[R <: Relation](R: R): by[X, Y, R] = new by[X, Y, R]
  }

}
