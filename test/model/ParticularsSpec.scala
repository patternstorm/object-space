package model

import org.scalatestplus.play.PlaySpec

class ParticularsSpec extends PlaySpec with Space {

  "A Particular" must {
    "be instantiable as a singleton" in {
      object aParticular extends Particular
    }
    "be an Individual" in {
      object aParticular extends Particular
      val anIndividual: Individual = aParticular
    }
  }

}
