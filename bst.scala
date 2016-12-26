trait Tree[+A] {

  import scala.annotation.tailrec

  def value: Option[A] = this match {
    case n: Node[A] => Some(n.v)
    case l: Leaf[A] => Some(l.v)
    case Empty      => None
  }

  def left: Option[Tree[A]] = this match {
    case n: Node[A] => Some(n.l)
    case l: Leaf[A] => None
    case Empty      => None
  }

  def right: Option[Tree[A]] = this match {
    case n: Node[A] => Some(n.r)
    case l: Leaf[A] => None
    case Empty      => None
  }

  /**
   * Represents a deferred evaluation of a node value
   */
  private case class Eval[A](v: A) extends Tree[A]

  /**
   * represents common functionality of all traversal order folds
   */
  @tailrec
  private def foldLoop[A, B](a: List[Tree[A]], z: B)(f: (B, A) => B)(o: (Node[A], List[Tree[A]]) => List[Tree[A]]): B = a match {
    case (n: Node[A]) :: tl => foldLoop(o(n, tl), z)(f)(o) // never directly evaluate nodes, function o will create new accumulator
    case (l: Leaf[A]) :: tl => foldLoop(tl, f(z, l.v))(f)(o) // always evaluate Leaf 
    case (e: Eval[A]) :: tl => foldLoop(tl, f(z, e.v))(f)(o) // always evaluate Eval 
    case Empty :: tl        => foldLoop(tl, z)(f)(o) // ignore Empty
    case _                  => z // will be Nil (empty list)
  }


  def foldPreorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => Eval(n.v) :: n.l :: n.r :: tl }
  }
 
  def foldInorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => n.l :: Eval(n.v) :: n.r :: tl }
  }

  def foldPostorder[B](z: B)(f: (B, A) => B): B = {
    foldLoop(List(this), z)(f) { (n, tl) => n.l :: n.r :: Eval(n.v) :: tl }
  }

  def fold[B](z: B)(f: (B, A) => B): B = foldInorder(z)(f)

  def size: Int = fold(0) { (sum, v) => sum + 1 }

  def height: Int = {
    def loop(t: Tree[A]): Int = t match {
      case l: Leaf[A] => 1
      case n: Node[A] => Seq(loop(n.left.get), loop(n.right.get)).max + 1
      case _          => 0
    }
    loop(this) - 1
  }

  /**
   * P04
   * (*) Count the number of leaves in a binary tree.
   */
  def leafCount: Int = {
    @tailrec
    def loop(t: List[Tree[A]], z: Int): Int = t match {
      case (l: Leaf[A]) :: tl => loop(tl, z + 1)
      case (n: Node[A]) :: tl => loop(n.left.get :: n.right.get :: tl, z)
      case _ :: tl            => loop(tl, z)
      case _                  => z
    }
    loop(List(this), 0)
  }

  def toSeq = fold(List[A]()) { (l, v) => v :: l } reverse
  def toSeqPreorder= foldPreorder(List[A]()) { (l, v) => v :: l } reverse
  def toSeqInorder = foldInorder(List[A]()) { (l, v) => v :: l } reverse
  def toSeqPostorder = foldPostorder(List[A]()) { (l, v) => v :: l } reverse
}

case class Node[A](v: A, l: Tree[A], r: Tree[A]) extends Tree[A]
case class Leaf[A](v: A) extends Tree[A]
case object Empty extends Tree[Nothing]

object bst extends App {
  val t: Tree[Symbol] = Node('F, Node('B, Leaf('A), Node('D, Leaf('C), Leaf('E))), Node('G, Empty, Node('I, Leaf('H), Empty)))
  println("tree: " + t)

  println("count: " + t.size)
  assert(t.size == 9)

  println("height: " + t.height)
  assert(t.height == 3)

  println("leaft count: " + t.leafCount)
  assert(t.leafCount == 4)

  println("as seqPreorder: " + t.toSeqPreorder)
  println("as seqInorder: " + t.toSeqInorder)
  println("as seqPostorder: " + t.toSeqPostorder)


}