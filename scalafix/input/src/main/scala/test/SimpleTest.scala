/*
rule = ResetSnapshots
 */
package simple

trait TestStub {
  def assertInlineSnapshot[A](actual: A, expected: A): Unit = ()

  def test(name: String)(f: Unit): Unit = ()
}

object SimpleTest extends TestStub {

  test("simple") {
    assertInlineSnapshot(1, 2)
  }
}
