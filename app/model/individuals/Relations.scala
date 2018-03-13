package model.individuals


trait Relations {
  self: Individuals =>

  def Relation: RepRelation = new RepRelation() {}

  trait RepRelation extends Rep {
    override type self = self.type

    case object self extends Individual {
      override type self = this.type
      implicit val me: self = this

      implicit object asRelation extends Relation[self]

    }

  }

  implicit def repRelation2Individual(x: RepRelation): Individual {type self = x.self} = x.self

}
