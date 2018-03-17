package model.individuals

import model.spaces.Spaces
import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class ParticularsSpec extends PlaySpec with Individuals with Particulars with Propositions with Relations with Qualities {

  "A Particular" must {
    "exist after being instantiated as a Particular" in {
      val x = Particular
      type x = x.self
      implicitly[x] mustEqual x.self
      implicitly[Particular[x]] mustEqual x.self.asParticular
    }
    "be an Individual" in {
      val x: Individual = Particular
    }
    "be different from any other Particular" in {
      val x = Particular
      type x = x.self
      val y = Particular
      type y = y.self
      "implicitly[x =:= y]" mustNot compile
      implicitly[x] mustNot be(implicitly[y])
    }
  }

}
