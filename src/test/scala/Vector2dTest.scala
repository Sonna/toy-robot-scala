// import org.scalatest.FunSuite

class Vector2dTest extends org.scalatest.FunSuite {
  test("Vector2d") {
    assert(Vector2d(0, 0).x === 0)
    assert(Vector2d(0, 0).y === 0)
  }

  test("Vector2d.down") {
    assert(Vector2d.down.x === 0)
    assert(Vector2d.down.y === -1)
  }

  test("Vector2d.left") {
    assert(Vector2d.left.x === -1)
    assert(Vector2d.left.y === 0)
  }

  test("Vector2d.one") {
    assert(Vector2d.one.x === 1)
    assert(Vector2d.one.y === 1)
  }

  test("Vector2d.right") {
    assert(Vector2d.right.x === 1)
    assert(Vector2d.right.y === 0)
  }

  test("Vector2d.up") {
    assert(Vector2d.up.x === 0)
    assert(Vector2d.up.y === 1)
  }

  test("Vector2d.zero") {
    assert(Vector2d.zero.x === 0)
    assert(Vector2d.zero.y === 0)
  }
}
