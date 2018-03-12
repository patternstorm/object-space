package model

import org.scalatestplus.play.PlaySpec

class FactsSpec extends PlaySpec with Space {

  "A Fact" must {
    "Be able to make true a Proposition stating that an Individual has a Quality" in {
      type x = x.type
      implicit object x extends Particular
      type A = A.type
      implicit object A extends Quality
      implicit object Fact extends ⊨[x is A]
      ⊢(x is A) mustBe Set(Fact)
    }
    "Be able to make true a proposition stating that two Individuals are related by a Relation" in {
      type x = x.type
      implicit object x extends Particular
      type y = y.type
      implicit object y extends Particular
      type R = R.type
      implicit object R extends Relation
      implicit object Fact extends ⊨[by[x,y,R]]
      ⊢(x ~ y by R) mustBe Set(Fact)
    }
    "Be able, together with another fact, to make true a proposition standing for the conjunction of two Propositions" in {
      type x = x.type
      implicit object x extends Particular
      type y = y.type
      implicit object y extends Particular
      type A = A.type
      implicit object A extends Quality
      type B = B.type
      implicit object B extends Quality
      implicit object Fact1 extends ⊨[x is A]
      implicit object Fact2 extends ⊨[y is B]
      ⊢((x is A) ∧ (y is B)) mustBe Set(Fact1, Fact2)
    }
    "Be able to make true a proposition standing for the disjunction of two Propositions" in {
      type x = x.type
      implicit object x extends Particular
      type y = y.type
      implicit object y extends Particular
      type A = A.type
      implicit object A extends Quality
      type B = B.type
      implicit object B extends Quality
      implicit object Fact1 extends ⊨[x is A]
      ⊢((x is A) ∨ (y is B)) mustBe Set(Fact1)
    }
//    "Exist to express the implication of two Propositions" in {
//    }
//    "Exist to express the negation of a Proposition" in {
//    }
  }

}
