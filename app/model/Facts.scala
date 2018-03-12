package model

trait Facts {
  self: Propositions =>

  case class ⊨[P <: AtomicProposition]()
  type Fact = ⊨[_ <: AtomicProposition]
  type Facts = Set[Fact]
  case class ⊢[P <: Proposition](proof: Facts)

  object ⊢ {
    implicit def atomicIntro[P <: AtomicProposition](implicit P: P, fact: ⊨[P]): ⊢[P] = new ⊢[P](Set(fact))
    implicit def andIntro[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev1: ⊢[P], ev2: ⊢[Q]): ⊢[P ∧ Q] = new ⊢[P ∧ Q](ev1.proof union ev2.proof)
    implicit def orIntro[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q, ev: ⊢[P]): ⊢[P ∨ Q] = new ⊢[P ∨ Q](ev.proof)
  }

  object ⊨ {
    def apply[P <: AtomicProposition](P: P): ⊨[P] = new ⊨[P]
  }

  def ⊢[P <: Proposition](P: P)(implicit ev: ⊢[P]): Facts = ev.proof

}
