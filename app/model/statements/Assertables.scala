package model.statements

trait Assertables {
  self: Propositions =>

  trait Assertable[P <: Proposition]

  object Assertable {
    implicit def positiveAssertion[P <: AtomicProposition](implicit P: P): Assertable[P] = new Assertable[P] {}
    implicit def negativeAssertion[P <: AtomicProposition](implicit P: P): Assertable[¬[P]] = new Assertable[¬[P]] {}
  }

}
