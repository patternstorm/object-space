package model.individuals

import model.spaces.Spaces
import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class UniversalsSpec extends PlaySpec with Individuals with Propositions with Relations with Qualities {

  "A Universal" must {
    "be implementable by a subclass of Individual" in {
      object x extends Individual
      implicit object asUniversal extends Universal[x.type]
    }
  }

}
