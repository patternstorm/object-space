package model

import org.scalatestplus.play.PlaySpec

class PropositionsSpec extends PlaySpec with Space {

  "A Proposition P" must {
    "Combine with another Proposition Q, " +
      "using ∧ to yield another Proposition P ∧ Q, " +
      "which is true if both P and Q are true" in {
      type x = x.type
      object x extends Particular
      type y = y.type
      object y extends Particular
      type A = A.type
      object A extends Quality
      type B = B.type
      object B extends Quality
      implicit object P extends (x is A)
      implicit object Q extends (y is B)
      val p: Proposition = P ∧ Q
      (P ∧ Q).left mustBe P
      (P ∧ Q).right mustBe Q
      ⊢(P ∧ Q) mustBe p
    }
    "Combine with another Proposition Q, " +
      "using ∨ to yield another Proposition P ∨ Q, " +
      "which is true if P is true or Q is true" in {
      type x = x.type
      object x extends Particular
      object y extends Particular
      type A = A.type
      object A extends Quality
      object B extends Quality
      implicit object P extends (x is A)
      val Q = y is B
      val p: Proposition = P ∨ Q
      (P ∨ Q).left mustBe P
      (P ∨ Q).right mustBe Q
      //⊢(P ∨ Q) mustBe p
    }
    "Combine with another Proposition Q, " +
      "using ⊃ to yield another Proposition P ⊃ Q, " +
      "such that if P ⊃ Q is true and P is true then Q is true" in {
      type x = x.type
      object x extends Particular
      type A = A.type
      object A extends Quality
      type B = B.type
      object B extends Quality
      type P = P.type
      implicit object P extends (x is A)
      val Q = x is B
      implicit object R extends (P ⊃ (x is B))(P, Q)
      (P ⊃ Q).left mustBe P
      (P ⊃ Q).right mustBe Q
      ⊢(Q) mustBe Q
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
