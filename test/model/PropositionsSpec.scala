package model

import org.scalatestplus.play.PlaySpec

class PropositionsSpec extends PlaySpec with Space {

  "A Proposition" must {
    "Combine with another Proposition using ∧ to yield another Proposition" in {
      object x extends Particular
      object y extends Particular
      object A extends Quality
      object B extends Quality
      val p1 = x is A
      val p2 = x is B
      val p: Proposition = p1 ∧ p2
      (p1 ∧ p2).left mustBe p1
      (p1 ∧ p2).right mustBe p2
    }
    "Combine with another Proposition using ∨ to yield another Proposition" in {
      object x extends Particular
      object y extends Particular
      object A extends Quality
      object B extends Quality
      val p1 = x is A
      val p2 = x is B
      val p: Proposition = (x is A) ∨ (x is B)
      (p1 ∨ p2).left mustBe p1
      (p1 ∨ p2).right mustBe p2
    }
    "Combine with another Proposition using ⇒ to yield another Proposition" in {
      object x extends Particular
      object y extends Particular
      object A extends Quality
      object B extends Quality
      val p1 = x is A
      val p2 = x is B
      val p: Proposition = (x is A) ⊃ (x is B)
      (p1 ∨ p2).left mustBe p1
      (p1 ∨ p2).right mustBe p2
    }
    "Negatable to yield another proposition" in {
      object x extends Particular
      object A extends Quality
      val p = x is A
      val notp: Proposition = !(x is A)
      (!p).arg mustBe p
    }
  }

}
