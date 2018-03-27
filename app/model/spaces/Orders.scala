package model.spaces

object Orders {

  type Z = Z.type

  sealed trait Order {
    type succ <: Order
    type pred <: Order
  }

  case class <[N <: Order, M <: Order]()

  implicit object Z extends Order {
    override type succ = S[Z]
    override type pred = Nothing
  }

  case class S[N <: Order](n: N) extends Order {
    override type succ = S[S[N]]
    override type pred = N
  }

  object Order {
    implicit def nextOrder[N <: Order](implicit n: N): S[N] = S[N](n)
  }

  object < {
    implicit def less1[N <: Order]: N < S[N] = <[N, S[N]]
    implicit def less2[N <: Order, M <: Order](implicit ev: N < M): N < S[M] = <[N, S[M]]
  }

}
