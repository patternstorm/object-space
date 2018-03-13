package model.statements

import model.Facts

trait Derivables {
  self: Propositions with Assertables with Facts =>

  trait ⊢[P <: Proposition] {
    val proof: Proof
  }

  trait Refutables {
    implicit def refutablePossitiveAssertion[P <: Proposition : Assertable](implicit P: P, fact: ⊨[¬[P]]): Refutable[P] = Refutable(Set(fact))

    implicit def refutableNegativeAssertion[P <: Proposition : Assertable](implicit P: ¬[P], fact: ⊨[P]): Refutable[¬[P]] = Refutable(Set(fact))
  }

  trait Provables {
    implicit def provableAssertion[P <: Proposition : Assertable](implicit P: P, fact: ⊨[P]): Provable[P] = Provable(Set(fact))


    implicit def provableConjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev1: Provable[P], ev2: Provable[Q]): Provable[P ∧ Q] = new Provable(ev1.proof union ev2.proof)

    implicit def provableDisjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: Provable[P]): Provable[P ∨ Q] = new Provable(ev.proof)
  }

  trait Derivables extends Provables with Refutables


  case class Provable[P <: Proposition](proof: Proof) extends ⊢[P]

  case class Refutable[P <: Proposition](proof: Proof) extends ⊢[P]

  object ⊢ extends Derivables {
    def apply[P <: Proposition : ⊢](P: P): ⊢[P] = implicitly[⊢[P]]
  }

}
