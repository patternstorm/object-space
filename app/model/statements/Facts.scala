package model.statements

trait Facts {
  self: Propositions =>

  trait Assertable[P <: Proposition]

  case class ⊨[P <: Proposition : Assertable](P: P)

  object Assertable {
    implicit def positiveAssertion[P <: AtomicProposition](implicit P: P): Assertable[P] = new Assertable[P] {}

    implicit def negativeAssertion[P <: AtomicProposition](implicit P: P): Assertable[¬[P]] = new Assertable[¬[P]] {}
  }
  type Fact = ⊨[_ <: Proposition]
  type Proof = Set[Fact]

  object ⊨ {
    def apply[P <: Proposition : Assertable](implicit P: P): ⊨[P] = new ⊨[P](P)
  }

}
