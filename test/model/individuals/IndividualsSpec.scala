package model.individuals

import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class IndividualsSpec extends PlaySpec with Individuals with Propositions with Relations with Qualities {

  "An Individual" must {
    "be instantiable only as as a singleton" in {
      object x extends Individual
      "trait Concept extends Individual" mustNot compile
    }
  }

}
