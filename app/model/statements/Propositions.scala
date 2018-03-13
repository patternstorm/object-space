package model.statements

import model.individuals.{Individuals, Qualities, Relations}

trait Propositions {
  self: Individuals with Qualities with Relations =>

  trait Proposition {
    def ∧[P <: Proposition](p: P): this.type ∧ P = new ∧(this, p)
    def ∨[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def ⊃[P <: Proposition](p: P): this.type ⊃ P = new ⊃(this, p)
  }

  trait AtomicProposition extends Proposition

  case class is[X <: Individual, A <: Individual : Quality]() extends AtomicProposition

  case class by[X <: Individual, Y <: Individual, R <: Individual : Relation]() extends AtomicProposition

  trait MolecularProposition extends Proposition
  case class ∧[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ∨[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ⊃[P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition

  case class ¬[P <: Proposition](arg: P) extends MolecularProposition

  object ¬ {
    def apply[P <: Proposition](P: P): ¬[P] = new ¬(P)
  }

  object Proposition {
    implicit def qualifyIndividual[X <: Individual, Q <: Individual : Quality](implicit x: X, Q: Q): X is Q = new is[X, Q]

    implicit def relateIndividuals[X <: Individual, Y <: Individual, R <: Individual : Relation](implicit x: X, y: Y, R: R): by[X, Y, R] = new by[X, Y, R]

    implicit def conjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∧ Q = ∧(P, Q)

    implicit def disjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∨ Q = ∨(P, Q)

    implicit def implication[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ⊃ Q = ⊃(P, Q)

    implicit def negation[P <: Proposition](implicit P: P): ¬[P] = new ¬(P)
  }

}
