package model

import org.scalatestplus.play.PlaySpec

class RelationsSpec extends PlaySpec with Space {

  "A Relation" must {
    "be instantiable as a singleton" in {
      object aRelation extends Relation
    }
    "be an Universal" in {
      object aRelation extends Relation
      val aUniversal: Universal = aRelation
    }
    "be an Individual" in {
      object aRelation extends Relation
      val anIndividual: Individual = aRelation
    }
  }

}
