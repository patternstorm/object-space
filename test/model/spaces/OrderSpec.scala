package model.spaces

import org.scalatestplus.play.PlaySpec

class OrderSpec extends PlaySpec with Orders {

  "An Order" must {
    "Start at zero" in {
      implicitly[Z <:< Order]
    }
    "Not be the greatest Order" in {
      val order = implicitly[S[S[S[S[Z]]]]]
      order.isInstanceOf[Order] mustBe true
      S(order).isInstanceOf[Order] mustBe true
    }
    "Provide the type of its successor and predecessor Orders" in {
      val order = S(Z)
      implicitly[order.succ =:= S[S[Z]]]
      implicitly[order.pred =:= Z]
    }
    "must be comparable to another Order" in {
      implicitly[Z < S[S[Z]]]
      implicitly[S[Z] < S[S[Z]]]
      "implicitly[S[Z] < S[Z]]" mustNot compile
      "implicitly[S[S[Z]]] < S[Z]]" mustNot compile
    }
  }

}
