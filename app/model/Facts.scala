package model

import model.statements.{Assertables, Propositions}

trait Facts {
  self: Propositions with Assertables =>

  case class ⊨[P <: Proposition : Assertable]()
  type Fact = ⊨[_ <: Proposition]
  type Proof = Set[Fact]


  object ⊨ {
    def apply[P <: Proposition : Assertable](P: P): ⊨[P] = new ⊨[P]
  }


}
