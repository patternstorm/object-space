package model.individuals

import model.spaces.Orders._
import model.spaces.Space._
import org.scalatestplus.play.PlaySpec

class IndividualsSpec extends PlaySpec {

  "An Individual of Order N" must {
    "be implicitly instantiated through an scala.Object" in {
      type N = Z
      type x = x.self
      val x = Individual[N]
      implicitly[x] mustBe x.self
      implicitly[x <:< Individual {type order = N}]
    }
    "be different from any other Individual of Order N" in {
      type N = Z
      implicit object x extends AtomicIndividual[N]
      implicit object y extends AtomicIndividual[N]
      x mustNot be(y)
    }
    "be able to reference the type of its Order" in {
      type N = Z
      type x = x.self
      implicit object x extends AtomicIndividual[N]
      implicitly[x#order =:= N]
    }
    "be able to reference the type of its Successor Order and that type must be equal " +
      "to the Order of an Individual of Order N+1" in {
      type N = Z
      type x = x.self
      implicit object x extends AtomicIndividual[N]
      type y = y.self
      implicit object y extends AtomicIndividual[S[N]]
      implicitly[x#order =:= N]
      implicitly[y#order =:= S[N]]
      implicitly[x#order#succ =:= y#order]
      "implicitly[x#order#succ =:= x#order]" mustNot compile
    }
    "be able to reference the type of its Predecessor Order, which must be Nothing if N is Z, " +
      "or be equal to the Order of an Individual of Order N-1, otherwise" in {
      type N = Z
      type x = x.self
      implicit object x extends AtomicIndividual[N]
      type y = y.self
      implicit object y extends AtomicIndividual[S[S[N]]]
      type z = z.self
      implicit object z extends AtomicIndividual[S[N]]
      implicitly[x#order#pred =:= Nothing]
      implicitly[y#order#pred =:= z#order]
    }
  }

}
