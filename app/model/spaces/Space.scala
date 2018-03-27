package model.spaces

import model.individuals.{Individuals, Relations}
import model.spaces.Orders.Order
import model.statements.{Derivables, Facts, Propositions}

object Space extends Individuals with Relations with Propositions with Facts with Derivables {

  override type individual = Individual

  override def Individual[N <: Order]: AtomicIndividual[N] = new AtomicIndividual[N]

  override def Relation[X <: individual, Y <: individual](x: X, y: Y)(implicit ev: X#order =:= Y#order): X ∿ Y = new Relation(x, y)

  class AtomicIndividual[N <: Order] extends Individual {
    override type order = N
    override type self = self.type

    case object self extends Individual {
      override type self = this.type
      override type order = N
      implicit val me: self = this
    }

  }

  case class Relation[X <: individual, Y <: individual](x: X, y: Y)(implicit ev: X#order =:= Y#order) extends Individual {
    override type order = X#order
    override type self = X ∿ Y
  }


}
