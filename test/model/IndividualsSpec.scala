package model

import org.scalatestplus.play.PlaySpec

class IndividualsSpec extends PlaySpec with Individuals {

  "An Individual" must {
    "be instantiable as a singleton" in {
      object anIndividual extends Individual
    }
  }

}
