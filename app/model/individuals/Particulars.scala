package model.individuals

trait Particulars {
  self: Individuals =>

  def Particular: RepParticular = new RepParticular() {}

  trait RepParticular extends Rep {
    override type self = self.type

    case object self extends Individual {
      override type self = this.type
      implicit val me: self = this

      implicit object asParticular extends Particular[self]

    }

  }

  implicit def repParticular2Individual(x: RepParticular): Individual {type self = x.self} = x.self

}
