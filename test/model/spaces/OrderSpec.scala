package model.spaces

import org.scalatestplus.play.PlaySpec

import model.spaces.Orders._

class OrderSpec extends PlaySpec {

  "An Order" must {
    "start at Z" in {
      implicitly[Z <:< Order]
    }
    "not be the greatest Order" in {
      val order = implicitly[S[S[S[S[Z]]]]]
      order.isInstanceOf[Order] mustBe true
      S(order).isInstanceOf[Order] mustBe true
    }
    "provide the type of its successor Order" in {
      val order = S(Z)
      implicitly[order.succ =:= S[S[Z]]]
    }
    "provide the type of its predecessor Order" in {
      val zero = Z
      val order = S(Z)
      implicitly[zero.pred =:= Nothing]
      implicitly[order.pred =:= Z]
    }
    "be different from its successor Order" in {
      "implicitly[Z =:= Z.succ]" mustNot compile
      "implicitly[S[Z] =:= S[Z]#succ]" mustNot compile
    }
    "be different from its predecessor Order" in {
      "implicitly[Z =:= Z.pred]" mustNot compile
      "implicitly[S[Z] =:= S[Z]#pred]" mustNot compile
    }
    "be comparable by < to another Order" in {
      implicitly[Z < S[S[Z]]]
      implicitly[S[Z] < S[S[Z]]]
      "implicitly[S[Z] < S[Z]]" mustNot compile
      "implicitly[S[S[Z]]] < S[Z]]" mustNot compile
    }
  }

}
