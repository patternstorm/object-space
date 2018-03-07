package model

trait Propositions {
  self: Individuals =>

  trait Proposition {
    def ∧[P <: Proposition](p: P): this.type ∧ P = new ∧(this, p)
    def ∨[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def ⊃[P <: Proposition](p: P): this.type ∨ P = new ∨(this, p)
    def unary_! = new !(this)
  }
  case class is[X <: Individual, A <: Quality]() extends Proposition
  case class by[X <: Individual, Y <: Individual, R <: Relation]() extends Proposition

  case class ∧[P1 <: Proposition, P2 <: Proposition](left: P1, right: P2) extends Proposition
  case class ∨[P1 <: Proposition, P2 <: Proposition](left: P1, right: P2) extends Proposition
  case class ⊃[P1 <: Proposition, P2 <: Proposition](left: P1, right: P2) extends Proposition
  case class ![P <: Proposition](arg: P) extends Proposition

  def ⊢[P <: Proposition](p: P)(implicit fact: P): P = fact

}
