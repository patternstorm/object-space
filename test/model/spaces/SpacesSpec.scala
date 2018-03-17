package model.spaces

import model.individuals.{Individuals, Qualities, Relations}
import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class SpacesSpec extends PlaySpec with Spaces with Orders with Individuals with Propositions with Qualities with Relations {

  "A Space" must {
    //    "must exit for each Order" in {
    //      implicitly[Space[Z]] mustBe Void
    //      implicitly[Space[S[Z]]] mustBe Space(implicitly[Space[Z]])
    //      implicitly[Space[S[S[S[S[S[S[Z]]]]]]]] mustBe Space(implicitly[Space[S[S[S[S[S[Z]]]]]]])
    //    }
    //    "must have an Order" in {
    //      val space = implicitly[Space[S[S[Z]]]]
    //      import space.layer._
    //      order mustBe 1
    //    }
    //    "must allow to create Particulars as Individuals of the Space Order which are in turn Universals of its supra Space" in {
    //      type N = S[S[Z]]
    //      val space = implicitly[Space[N]]
    //      val x = space.Particular()
    //      implicitly[x.self <:< Individual {type order = N}]
    //      val supraspace = implicitly[Space[N#pred]]
    //      ⊢(x is space.Particular) ∧ (x is supraspace.Universal)
    //    }
    //    "must allow to create Qualities as Particulars of its super Space" in {
    //      type N = S[S[Z]]
    //      val space = implicitly[Space[N]]
    //      val A = space.Quality()
    //      implicitly[A.self <:< Individual {type order = N#succ}]
    //      val superspace = implicitly[Space[N#succ]]
    //      ⊢(A is space.Quality) ∧ (A is superspace.Particular)
    //    }
  }
}
