package model.individuals

import model.spaces.Spaces
import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class QualitiesSpec extends PlaySpec with Individuals with Propositions with Relations with Qualities {

  "A Quality" must {
    "exist after being instantiated as a Quality" in {
      val A = Quality
      type A = A.self
      implicitly[A] mustEqual A.self
      implicitly[Quality[A]] mustEqual A.self.asQuality
    }
    "be an Individual" in {
      val x: Individual = Quality
    }
    "be an Universal" in {
      val A = Quality
      type A = A.self
      implicitly[Universal[A]] mustEqual A.self.asQuality
    }
    "be different from any other Particular" in {
      val A = Quality
      type A = A.self
      val B = Quality
      type B = B.self
      "implicitly[A =:= B]" mustNot compile
      implicitly[A] mustNot be(implicitly[B])
    }
  }

}
