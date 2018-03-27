package model.individuals

import model.spaces.Orders._
import org.scalatestplus.play.PlaySpec
import model.spaces.Space._

class RelationsSpec extends PlaySpec {

  "A Relation" must {
    "exist, forming a new Individual of Order N out of a pair of Individuals of order N" in {
      type N = Z
      type x = x.self
      val x = Individual[N]
      type y = y.self
      val y = Individual[N]
      type z = z.self
      implicitly[x]
      implicitly[x <:< Individual]
      implicitly[y]
      implicitly[y <:< Individual]
      implicitly[x#order =:= y#order]
      asRelation[x, y]
      val z = implicitly[∿[x, y]]
      type zz = zz.self
      val zz = implicitly[∿[z, z]]
      implicitly[∿[z, z] <:< Individual]
      implicitly[z <:< Individual {type order = N}]
      implicitly[zz <:< Individual {type order = N}]
      implicitly[∿[x, y]] mustBe z
      implicitly[∿[z, z]] mustBe ((x ∿ y) ∿ (x ∿ y))
    }
    "not be able to form a new Individual out of a pair of Individuals of different Order" in {
      type N = Z
      type x = x.type
      implicit object x extends AtomicIndividual[N]
      type y = y.type
      implicit object y extends AtomicIndividual[S[N]]
      "∿[x,y]" mustNot compile
    }
  }

}
