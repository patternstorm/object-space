package model.individuals

import model.spaces.Spaces
import model.statements.Propositions
import org.scalatestplus.play.PlaySpec

class RelationsSpec extends PlaySpec with Individuals with Propositions with Relations with Qualities {

  "A Relation" must {
    "exist after being instantiated as a Relation" in {
      val R = Relation
      type R = R.self
      implicitly[R] mustEqual R.self
      implicitly[Relation[R]] mustEqual R.self.asRelation
    }
    "be an Individual" in {
      val x: Individual = Relation
    }
    "be an Universal" in {
      val R = Relation
      type R = R.self
      implicitly[Universal[R]] mustEqual R.self.asRelation
    }
    "be different from any other Particular" in {
      val A = Relation
      type A = A.self
      val B = Relation
      type B = B.self
      "implicitly[A =:= B]" mustNot compile
      implicitly[A] mustNot be(implicitly[B])
    }
  }

}
