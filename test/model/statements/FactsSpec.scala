package model.statements

import model.spaces.Orders._
import org.scalatestplus.play.PlaySpec
import model.spaces.Space._

class FactsSpec extends PlaySpec {

  "A Fact" must {
    "be able to assert any Proposition stating that an Individual of Order N belongs to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      ⊨[x ∈ A]
    }
    "be able to assert any Proposition stating that an Individual of Order N does not belong to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      ⊨[¬[x ∈ A]]
    }
    "not be able to assert a Proposition stating that an Individual of Order N belongs to an Individual of Order N" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      "⊨[x ∈ A]" mustNot compile
    }
    "not be able to assert a Proposition stating that an Individual of Order N does not belong to an Individual of Order N" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      "⊨[¬[x ∈ A]]" mustNot compile
    }
  }

}
