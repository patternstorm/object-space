package model.individuals

import model.statements.Propositions


trait Individuals {
  self: Propositions =>

  trait Rep {
    type self <: Individual

    def is(A: Rep)(implicit ev: Quality[A.self]): this.self is A.self = new is[this.self, A.self]

    def ~(x: Rep): this.self ~ x.self = new ~[this.self, x.self]
  }

  trait Individual {
    this: Individual with Singleton =>
    type self <: Individual
  }

  trait Particular[X <: Individual]

  trait Universal[X <: Individual]

  trait Quality[X <: Individual] extends Universal[X]

  trait Relation[X <: Individual] extends Universal[X]

  case class ~[X <: Individual, Y <: Individual]() {
    def by(R: Rep)(implicit ev: Relation[R.self]): by[X, Y, R.self] = new by[X, Y, R.self]
  }

}
