package model

trait Propositions {
  self: Individuals =>

  trait Proposition {
    def ∧[P <: Proposition](p: P): this.type ∧ P = new ∧(this, p)
    def ∨[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def ⊃[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def unary_! = new !(this)
  }

  def ⊢[P <: Proposition](P: P)(implicit ev: P): P = ev

  case class is[X <: Individual, A <: Quality]() extends Proposition
  case class by[X <: Individual, Y <: Individual, R <: Relation]() extends Proposition

  case class ∧[P <: Proposition, Q <: Proposition](left: P, right: Q) extends Proposition

  case class ∨[P <: Proposition, Q <: Proposition](left: P, right: Q) extends Proposition

  case class ⊃[P <: Proposition, Q <: Proposition](left: P, right: Q) extends Proposition
  case class ![P <: Proposition](arg: P) extends Proposition

  object Proposition {
    implicit def andIntro[P <: Proposition, Q <: Proposition](implicit P: P, Q: Q): P ∧ Q = new ∧(P, Q)

    //implicit def orIntro[P <: Proposition, Q <: Proposition](implicit P: P): P ∨ Q = new ∨(P,Q)
    implicit def modusPonens[P <: Proposition, Q <: Proposition](implicit R: P ⊃ Q, P: P): Q = R.right
  }

}
