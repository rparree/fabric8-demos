package com.edc4it

import scala.annotation.tailrec

/**
 * @author ${user.name}
 */
object App {


  @tailrec
  def foo(): Unit = {
    println( "Hello you look awesome.." )
    Thread.sleep(1000)
    foo()
  }

  def main(args : Array[String]) {
    foo()
  }

}
