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
  }

}
