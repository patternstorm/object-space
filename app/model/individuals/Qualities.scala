package model.individuals


trait Qualities {
  self: Individuals =>

  def Quality: RepQuality = new RepQuality() {}

  trait RepQuality extends Rep {
    override type self = self.type

    case object self extends Individual {
      override type self = this.type
      implicit val me: self = this

      implicit object asQuality extends Quality[self]

    }

  }

  implicit def repQuality2Individual(x: RepQuality): Individual {type self = x.self} = x.self

}
