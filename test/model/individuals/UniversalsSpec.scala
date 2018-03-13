package model.individuals

import model.Space
import org.scalatestplus.play.PlaySpec

class UniversalsSpec extends PlaySpec with Space {

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
