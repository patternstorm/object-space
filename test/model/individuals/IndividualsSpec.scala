package model.individuals

import model.Space
import org.scalatestplus.play.PlaySpec

class IndividualsSpec extends PlaySpec with Space {

  "An Individual" must {
    "be instantiable only as as a singleton" in {
      object x extends Individual
      "trait Concept extends Individual" mustNot compile
    }
  }

}
