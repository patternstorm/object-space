package model

import org.scalatestplus.play.PlaySpec

class UniversalsSpec extends PlaySpec with Individuals {

  "A Universal" must {
    "be instantiable as a singleton" in {
      object aUniversal extends Universal
    }
    "be an Individual" in {
      object aUniversal extends Universal
      val anIndividual: Individual = aUniversal
    }
  }

}
