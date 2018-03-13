package model.individuals

import model.Space
import org.scalatestplus.play.PlaySpec

class QualitiesSpec extends PlaySpec with Space {

  "A Quality" must {
    "be instantiable as a singleton" in {
      object aQuality extends Quality
    }
    "be an Universal" in {
      object aQuality extends Quality
      val aUniversal: Universal = aQuality
    }
    "be an Individual" in {
      object aQuality extends Quality
      val anIndividual: Individual = aQuality
    }
  }

}
