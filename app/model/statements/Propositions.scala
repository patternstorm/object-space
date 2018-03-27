package model.statements

import model.individuals.Relations


trait Propositions extends Relations {

  override type individual <: Individual

  trait Individual extends super.Individual {
    def ∈[A <: individual](A: A)(implicit x: self, y: A.self, ev: self#order#succ =:= A.self#order): self ∈ A.self = new ∈(x, y)
  }

  trait Proposition {
    def ∧[P <: Proposition](p: P): this.type ∧ P = new ∧(this, p)
    def ∨[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def ⊃[P <: Proposition](p: P): this.type ⊃ P = new ⊃(this, p)
  }

  trait AtomicProposition extends Proposition

  case class ∈[X <: Individual, A <: Individual](particular: X, universal: A)(implicit ev: X#order#succ =:= A#order) extends AtomicProposition


  trait MolecularProposition extends Proposition
  case class ∧[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ∨[+P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ⊃[P <: Proposition, Q <: Proposition](left: P, right: Q) extends MolecularProposition
  case class ¬[P <: Proposition](arg: P) extends MolecularProposition

  object ¬ {
    def apply[P <: Proposition](P: P): ¬[P] = new ¬(P)
  }

  object Proposition {
    implicit def qualifyIndividual[X <: individual, A <: individual](implicit x: X, A: A, ev: X#order#succ =:= A#order): X ∈ A = new ∈[X, A](x, A)
    implicit def conjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∧ Q = ∧(P, Q)
    implicit def disjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∨ Q = ∨(P, Q)
    implicit def implication[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ⊃ Q = ⊃(P, Q)
    implicit def negation[P <: Proposition](implicit P: P): ¬[P] = new ¬(P)
  }
}
