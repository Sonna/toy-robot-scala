// case class Vector2d(x: Int, y: Int) {
case class Vector2d(x: Int = 0, y: Int = 0) {
    // def initialize(x, y)
    //   @x = x.to_i
    //   @y = y.to_i
    // end

    // def ==(other)
    //   x == other.x && y == other.y
    // end
    // alias_method :eql?, :==

    // def -(other)
    //   self.class.new(x - other.x, y - other.y)
    // end

    // def +(other)
    //   self.class.new(x + other.x, y + other.y)
    // end

    // // Largest Y value to smallest
    // // Smallest X value to largest
    // def <=>(other)
    //   return -1 if y > other.y
    //   return -1 if y == other.y && x < other.x
    //   return 0 if y == other.y && x == other.x
    //   return 1 if y < other.y
    //   return 1 if y == other.y && x > other.x
    // rescue
    //   puts other
    // end

    // def hash
    //   # x.hash ^ y.hash # XOR # But high change of collision
    //   [x, y].hash
    // end

    // def to_s
    //   "#{x},#{y}"
    // end
}

// Companion object (with pesudo-static members in Scala)
object Vector2d {
  def down: Vector2d = new Vector2d(0, -1)
  def left: Vector2d = new Vector2d(-1, 0)
  def one: Vector2d = new Vector2d(1, 1)
  def right: Vector2d = new Vector2d(1, 0)
  def up: Vector2d = new Vector2d(0, 1)
  def zero: Vector2d = new Vector2d(0, 0)
}

// == References:
// - [How to create static members with Scala companion objects \| alvinalexander\.com](https://alvinalexander.com/scala/how-to-static-members-in-scala-companion-objects-fields-methods)
