package model

import org.scalatestplus.play.PlaySpec

class SpaceSpec extends PlaySpec with Space {

  "A Space" must {
    "Allow to state the fact that an individual has a quality" in {
      object x extends Particular
      object A extends Quality
      x is A
    }
    "Allow to prove that an individual has a quality" in {
      object x extends Particular
      object A extends Quality
      implicit val fact = x is A
      ⊢(x is A) mustBe fact
    }
    "Allow to prove that an individual does not have a quality" in {
      object x extends Particular
      object A extends Quality
      object B extends Quality
      implicit val fact = x is A
      "⊢(x is B)" mustNot compile
    }
    "Allow to state the fact that two individuals are related by a relation" in {
      object x extends Particular
      object y extends Particular
      object R extends Relation
      x ~ y by R
    }
    "Allow to prove that two individuals are related by a relation" in {
      object x extends Particular
      object y extends Particular
      object R extends Relation
      implicit val fact = x ~ y by R
      ⊢(x ~ y by R) mustBe fact
    }
    "Allow to prove that two individuals are not related by a relation" in {
      object x extends Particular
      object y extends Particular
      object R1 extends Relation
      object R2 extends Relation
      implicit val fact = x ~ y by R1
      "⊢(x ~ y by R2)" mustNot compile
    }
  }

}
