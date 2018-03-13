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

    implicit def refutableConjunction1[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: Refutable[P]): Refutable[P ∧ Q] = Refutable(ev.proof)

    implicit def refutableConjunction2[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: Refutable[Q]): Refutable[P ∧ Q] = Refutable(ev.proof)

    implicit def refutableDisjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev1: Refutable[P], ev2: Refutable[Q]): Refutable[P ∨ Q] = Refutable(ev1.proof union ev2.proof)
  }

  trait Provables {
    implicit def provableAssertion[P <: Proposition : Assertable](implicit P: P, fact: ⊨[P]): Provable[P] = Provable(Set(fact))

    implicit def provableConjunction[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev1: Provable[P], ev2: Provable[Q]): Provable[P ∧ Q] = Provable(ev1.proof union ev2.proof)

    implicit def provableDisjunction1[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: Provable[P]): Provable[P ∨ Q] = Provable(ev.proof)

    implicit def provableDisjunction2[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: Provable[Q]): Provable[P ∨ Q] = Provable(ev.proof)
  }

  case class Provable[P <: Proposition](proof: Proof) extends ⊢[P]

  case class Refutable[P <: Proposition](proof: Proof) extends ⊢[P]

  object ⊢ extends Provables with Refutables {
    def apply[P <: Proposition : ⊢](P: P): ⊢[P] = implicitly[⊢[P]]
  }

}
