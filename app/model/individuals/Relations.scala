package model.individuals

import model.spaces.Orders.Order


trait Relations extends Individuals {

  override type individual <: Individual
  type Relation[X <: individual, Y <: individual] <: individual
  type ∿[X <: individual, Y <: individual] = Relation[X, Y]

  def Relation[X <: individual, Y <: individual](x: X, y: Y)(implicit ev: X#order =:= Y#order): X ∿ Y

  trait Individual extends super.Individual {
    def ∿[A <: individual](A: A)(implicit x: self, y: A.self, ev: self#order =:= A.self#order): self ∿ A.self = Relation(x, y)
  }

  object ∿ {
    def apply[X <: individual, Y <: individual](implicit x: X, y: Y, ev: X#order =:= Y#order): X ∿ Y = Relation(x, y)
  }

  implicit def asRelation[X <: individual, Y <: individual](implicit x: X, y: Y, ev: X#order =:= Y#order): ∿[X, Y] = Relation(x, y)

}
