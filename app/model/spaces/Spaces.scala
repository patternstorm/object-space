package model.spaces

import model.spaces.Orders._
import model.statements.{Facts, Propositions}

trait Spaces {
  self: Propositions with Facts =>

  type Space0 = Space0.type
  type Space1 = Space1.type

  implicit case object Space0 extends Space[Z]

  type Space2 = Space2.type

  implicit case object Space1 extends Space[S[Z]]

  trait Succ[N <: Order, S <: Space[N]]

  implicit case object Space2 extends Space[S[S[Z]]]

  trait Space[N <: Order] {
    type superSpace = Space[N#succ]
    type supraSpace = Space[N#pred]
    //    trait Particular extends AtomicIndividual[N#succ]
    //    trait Universal extends AtomicIndividual[N#succ#succ]
    //    implicit object Particular extends Particular
    //    implicit object Universal extends Universal

    def superSpace(implicit s: Space[N#succ]): superSpace = s

    def supraSpace(implicit s: Space[N#pred]): supraSpace = s
  }

  object Space {
    //implicit def initialSpace: Space[Z] = new Space
    //implicit def nextSpace[N <: Order](implicit n: N, space: Space[N]): Space[S[N]] = new Space(S(n))
    //def apply[N <: Order](implicit n: N): Space[N] = new Space(n)
  }

  //  implicit def individualAsParticular[X <: Individual {type order = Z}](implicit x: X, space: Space0): ⊨[X ∈ Space0.Particular] = ⊨(new ∈(x, Space0.Particular))
  //  implicit def particularAsUniversal(implicit space: Space0): ⊨[Space0.Particular ∈ Space0.Universal] = ⊨(new ∈(space.Particular, space.Universal))
  //  implicit def particularAsSuperParticular(implicit space: Space0, superSpace: Space1): ⊨[Space0.Particular ∈ Space1.Particular] = ⊨(new ∈(space.Particular.self, superSpace.Particular.self))
  //  implicit def universalAsSuperSuperParticular(implicit space: Space0, superSpace: Space2): ⊨[Space0.Universal ∈ Space2.Particular] = ⊨(new ∈(space.Universal.self, superSpace.Particular.self))

  //  implicit def asSpaceParticular[N <: Order](implicit space: Space[N],
  //                                             ev: Assertable[space.Particular ∈ space.superSpace#Particular]): ⊨[space.Particular ∈ space.superSpace#Particular] = ⊨[space.Particular ∈ space.superSpace#Particular]

}
