package model.individuals

import model.Space
import org.scalatestplus.play.PlaySpec

class IndividualsSpec extends PlaySpec with Space {

  "An Individual" must {
    "be instantiable as a singleton" in {
      object anIndividual extends Individual
    }
    "be different from any other individual" in {
      object x extends Individual
      object y extends Individual
      x mustNot equal(y)
    }
  }

}
