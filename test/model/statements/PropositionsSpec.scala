package model.statements

import model.Space
import org.scalatestplus.play.PlaySpec

class PropositionsSpec extends PlaySpec with Space {

  "A Proposition P" must {
    "Exist to express that an Individual has a given Quality" in {
      type x = x.self
      val x = Particular
      type A = A.self
      val A = Quality
      implicitly[is[x, A]]
      val p: Proposition = implicitly[is[x, A]]
      p mustBe (x is A)
    }
    "Exist to express that two Individuals are related by a Relation" in {
      type x = x.self
      val x = Particular
      type y = y.self
      val y = Particular
      type R = R.self
      val R = Relation
      val p: Proposition = implicitly[by[x, y, R]]
      p mustBe (x ~ y by R)
    }
    "Exist to express the conjunction of two Propositions" in {
      type x = x.self
      val x = Particular
      type y = y.self
      val y = Particular
      type A = A.self
      val A = Quality
      type B = B.self
      val B = Quality
      val p: Proposition = implicitly[∧[is[x, A], is[y, B]]]
      p mustBe (implicitly[x is A] ∧ implicitly[y is B])
    }
    "Exist to express the disjunction of two Propositions" in {
      type x = x.self
      val x = Particular
      type y = y.self
      val y = Particular
      type A = A.self
      val A = Quality
      type B = B.self
      val B = Quality
      val p: Proposition = implicitly[∨[is[x, A], is[y, B]]]
      p mustBe (implicitly[x is A] ∨ implicitly[y is B])
    }
    "Exist to express the implication of two Propositions" in {
      type x = x.self
      val x = Particular
      type A = A.self
      val A = Quality
      type B = B.self
      val B = Quality
      val p: Proposition = implicitly[⊃[is[x, A], is[x, B]]]
      p mustBe (implicitly[x is A] ⊃ implicitly[x is B])
    }
    "Exist to express the negation of a Proposition" in {
      type x = x.self
      val x = Particular
      type A = A.self
      val A = Quality
      val p: Proposition = implicitly[¬[is[x, A]]]
      p mustBe ¬(implicitly[is[x, A]])
    }
  }

}
