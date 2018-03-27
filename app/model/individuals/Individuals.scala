package model.individuals

import model.spaces.Orders.Order


trait Individuals {

  type individual <: Individual
  type AtomicIndividual[N <: Order] <: individual {type order = N}

  def Individual[N <: Order]: AtomicIndividual[N]

  trait Individual {
    type order <: Order
    type self <: individual
  }

}
