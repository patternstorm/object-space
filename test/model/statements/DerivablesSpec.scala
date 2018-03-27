package model.statements

import model.spaces.Orders._
import org.scalatestplus.play.PlaySpec
import model.spaces.Space._

class DerivablesSpec extends PlaySpec {

  "A Derivable" must {
    "be instantiable to prove any asserted Proposition stating that an Individual of Order N belongs to an Individual of Order N+1" in {
      type x = x.self
      val x = Individual[Z]
      type A = A.self
      val A = Individual[S[Z]]
      implicit val fact = ⊨(x ∈ A)
      ⊢(x ∈ A) mustBe Provable(Set(fact))
    }
    "not be instantiable to prove nor refute any non-asserted Proposition stating that an Individual of Order N belongs to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      "⊢(x ∈ A)" mustNot compile
    }
    "be instantiable to refute the negation of any asserted Proposition stating that an Individual of Order N belongs to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(x ∈ A)
      ⊢(¬(x ∈ A)) mustBe Refutable(Set(fact))
    }
    "not be instantiable to prove nor refute the negation of any non-asserted Proposition stating that an Individual of Order N belongs to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      "⊢(¬(x ∈ A))" mustNot compile
    }
    "be instantiable to prove any asserted Proposition stating that an Individual of Order N does not belong to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(x ∈ A))
      ⊢(¬(x ∈ A)) mustBe Provable(Set(fact))
    }
    "be instantiable to refute the negation of any asserted Proposition stating that an Individual of Order N does not belong to an Individual of Order N+1" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(x ∈ A))
      ⊢(x ∈ A) mustBe Refutable(Set(fact))
    }
    "be instantiable to prove the conjunction of two asserted Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(x ∈ A)
      implicit val fact2 = ⊨(y ∈ B)
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Provable(Set(fact1, fact2))
    }
    "be instantiable to refute the conjunction of an asserted Proposition with a Proposition whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(x ∈ A)
      implicit val fact2 = ⊨(¬(y ∈ B))
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Refutable(Set(fact2))
    }
    "not be instantiable to prove nor refute the conjunction of an asserted Proposition with a non-asserted one" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(x ∈ A)
      "⊢((x ∈ A) ∧ (y ∈ B))" mustNot compile
    }
    "be instantiable to refute the conjunction of a Proposition, whose negation is asserted, with an asserted Proposition" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(¬(x ∈ A))
      implicit val fact2 = ⊨(y ∈ B)
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Refutable(Set(fact1))
    }
    "be instantiable to refute the conjunction of two Propositions whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(¬(x ∈ A))
      implicit val fact2 = ⊨(¬(y ∈ B))
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Refutable(Set(fact1))
    }
    "be instantiable to refute the conjunction of a Proposition, whose negation is asserted, with a non-asserted Proposition" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(x ∈ A))
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Refutable(Set(fact))
    }
    "not be instantiable to prove nor refute the conjunction of a non-asserted Proposition with an asserted one" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(y ∈ B)
      "⊢((x ∈ A) ∧ (y ∈ B))" mustNot compile
    }
    "be instantiable to refute the conjunction of a non-asserted Proposition with a Proposition whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(y ∈ B))
      ⊢((x ∈ A) ∧ (y ∈ B)) mustBe Refutable(Set(fact))
    }
    "not be instantiable to prove nor refute the conjunction of two non-asserted Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      "⊢((x ∈ A) ∧ (y ∈ B))" mustNot compile
    }


    "be instantiable to prove the disjunction of two asserted Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(x ∈ A)
      implicit val fact2 = ⊨(y ∈ B)
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Provable(Set(fact1))
    }
    "be instantiable to prove the disjunction of an asserted Proposition with a Proposition whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(x ∈ A)
      implicit val fact2 = ⊨(¬(y ∈ B))
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Provable(Set(fact1))
    }
    "be instantiable to prove the disjunction of an asserted Proposition with a non-asserted one" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(x ∈ A)
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Provable(Set(fact))
    }
    "be instantiable to prove the disjunction of a Proposition, whose negation is asserted, with an asserted Proposition" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(¬(x ∈ A))
      implicit val fact2 = ⊨(y ∈ B)
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Provable(Set(fact2))
    }
    "be instantiable to refute the disjunction of two Propositions whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact1 = ⊨(¬(x ∈ A))
      implicit val fact2 = ⊨(¬(y ∈ B))
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Refutable(Set(fact1, fact2))
    }
    "not be instantiable to prove nor refute the disjunction of a Proposition, whose negation is asserted, with a non-asserted Proposition" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(x ∈ A))
      "⊢((x ∈ A) ∨ (y ∈ B))" mustNot compile
    }
    "be instantiable to prove the disjunction of a non-asserted Proposition with an asserted one" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(y ∈ B)
      ⊢((x ∈ A) ∨ (y ∈ B)) mustBe Provable(Set(fact))
    }
    "not be instantiable to prove nor refute the disjunction of a non-asserted Proposition with a Proposition whose negation is asserted" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      implicit val fact = ⊨(¬(y ∈ B))
      "⊢((x ∈ A) ∨ (y ∈ B))" mustNot compile
    }
    "not be instantiable to prove nor refute the disjunction of two non-asserted Propositions" in {
      type x = x.self
      implicit object x extends AtomicIndividual[Z]
      type y = y.self
      implicit object y extends AtomicIndividual[Z]
      type A = A.self
      implicit object A extends AtomicIndividual[S[Z]]
      type B = B.self
      implicit object B extends AtomicIndividual[S[Z]]
      "⊢((x ∈ A) ∨ (y ∈ B))" mustNot compile
    }
    "be instantiable to prove that every pair of Individuals x, y, of Order N, " +
      "such that x ∈ X and y ∈ Y, belong to the Relation X ∿ Y" in {
      type x = x.self
      val x = Individual[Z]
      type y = y.self
      val y = Individual[Z]
      type X = X.self
      val X = Individual[S[Z]]
      type Y = Y.self
      val Y = Individual[S[Z]]
      implicit val fact1 = ⊨[x ∈ X]
      implicit val fact2 = ⊨[y ∈ Y]
      ⊢((x ∿ y) ∈ (X ∿ Y)) mustBe Provable(Set(fact1, fact2))
    }
  }
}
