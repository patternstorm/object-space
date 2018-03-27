package model.statements


import model.spaces.Orders._
import model.spaces.Space._
import org.scalatestplus.play.PlaySpec


class PropositionsSpec extends PlaySpec {

  "A Proposition P" must {
    "exist to express that an Individual of order N belongs to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      implicitly[x ∈ A]
    }
    "not exist to express that an Individual of order N belongs to another Individual of Order N" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      "implicitly[x is y]" mustNot compile
    }
    "not exist to express that an Individual of order N belongs to an Individual of Order N+2" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[S[Z]]]
      "implicitly[x is A]" mustNot compile
    }
    "exist to express the conjunction of two Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      val p: Proposition = implicitly[(x ∈ A) ∧ (y ∈ B)]
      p mustBe (implicitly[x ∈ A] ∧ implicitly[y ∈ B])
    }
    "exist to express the disjunction of two Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      val p: Proposition = implicitly[(x ∈ A) ∨ (y ∈ B)]
      p mustBe (implicitly[x ∈ A] ∨ implicitly[y ∈ B])
    }
    "exist to express the implication of two Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      val p: Proposition = implicitly[(x ∈ A) ⊃ (x ∈ B)]
      p mustBe (implicitly[x ∈ A] ⊃ implicitly[x ∈ B])
    }
    "exist to express the negation of a Proposition" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      val p: Proposition = implicitly[¬[x ∈ A]]
      p mustBe ¬(implicitly[x ∈ A])
    }
  }
}
