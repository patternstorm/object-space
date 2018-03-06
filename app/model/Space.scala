package model

trait Space {

  case class is[X <: Individual, A <: Quality]()

  trait Individual {
    def is[A <: Quality](A: A): this.type is A = new is[this.type, A]
  }

  trait Particular extends Individual
  trait Universal extends Individual
  trait Quality extends Universal

  def ⊢[X](x: X)(implicit ev: X):X = x

}
