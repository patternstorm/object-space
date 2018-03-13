package model.statements

import model.individuals.Individuals

trait Propositions {
  self: Individuals =>

  trait Proposition {
    def ∧[P <: Proposition](p: P): this.type ∧ P = new ∧(this, p)
    def ∨[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def ⊃[P <: Proposition](p: P): this.type ⊃ P = new ⊃(this, p)
  }

  trait AtomicProposition extends Proposition
  case class is[X <: Individual, A <: Quality]() extends AtomicProposition
  case class by[X <: Individual, Y <: Individual, R <: Relation]() extends AtomicProposition

  trait MolecularProposition extends Proposition
  case class ∧[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ∨[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ⊃[P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition

  case class ¬[P <: Proposition](arg: P) extends MolecularProposition

  object ¬ {
    def apply[P <: Proposition](P: P): ¬[P] = new ¬(P)
  }

  object Proposition {
    implicit def qualifyIndividual[X <: Individual, Q <: Quality](implicit x: X, Q: Q): X is Q = new is[X, Q]

    implicit def relateIndividuals[X <: Individual, Y <: Individual, R <: Relation](implicit x: X, y: Y, R: R): by[X, Y, R] = new by[X, Y, R]

    implicit def conjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∧ Q = ∧(P, Q)

    implicit def disjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∨ Q = ∨(P, Q)

    implicit def implication[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ⊃ Q = ⊃(P, Q)

    implicit def negation[P <: Proposition](implicit P: P): ¬[P] = new ¬(P)
  }

}
