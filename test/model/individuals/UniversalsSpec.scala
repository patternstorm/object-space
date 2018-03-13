package model.individuals

import model.Space
import org.scalatestplus.play.PlaySpec

class UniversalsSpec extends PlaySpec with Space {

  "A Universal" must {
    "be implementable by a subclass of Individual" in {
      object x extends Individual
      implicit object asUniversal extends Universal[x.type]
    }
  }

}
