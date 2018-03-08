// import org.scalatest.FunSuite

class RobotTest extends org.scalatest.FunSuite {
  test("Robot constructor") {
    val robot = new ToyRobot.Robot()
    assert(robot.x === 0)
    assert(robot.y === 0)
    assert(robot.facing === "NORTH")
  }

  test("Robot.x") {
    val robot = new ToyRobot.Robot(2)
    assert(robot.x === 2)
  }

  test("Robot.y") {
    val robot = new ToyRobot.Robot(0, 1)
    assert(robot.y === 1)
  }

  test("Robot.facing") {
    val robot = new ToyRobot.Robot(0, 0, "EAST")
    assert(robot.facing === "EAST")
  }

  test("Robot.place at 1,2,WEST") {
    val robot = new ToyRobot.Robot()
    robot.place("1,2,WEST")

    assert(robot.x === 1)
    assert(robot.y === 2)
    assert(robot.facing === "WEST")
  }

  test("Robot.report from origin") {
    val robot = new ToyRobot.Robot()
    val stream = new java.io.ByteArrayOutputStream()

    Console.withOut(stream) { robot.report("") }

    assert(stream.toString === "0, 0, NORTH\n")
  }

  test("Robot.left from origin") {
    val robot = new ToyRobot.Robot()
    robot.left("")
    assert(robot.facing === "WEST")
  }

  test("Robot.right from origin") {
    val robot = new ToyRobot.Robot()
    robot.right("")
    assert(robot.facing === "EAST")
  }

  test("Robot turned from origin to face SOUTH") {
    val robot = new ToyRobot.Robot()
    robot.right("")
    robot.right("")
    assert(robot.facing === "SOUTH")
  }

  test("Robot.move from origin") {
    val robot = new ToyRobot.Robot()
    robot.move("")
    assert(robot.x === 0)
    assert(robot.y === 1)
  }

  test("Robot.move from origin facing EAST") {
    val robot = new ToyRobot.Robot()
    robot.right("")
    robot.move("")
    assert(robot.x === 1)
    assert(robot.y === 0)
  }

  test("Robot.move will not fall off table from origin") {
    val robot = new ToyRobot.Robot()
    robot.left("")
    robot.move("")
    assert(robot.x === 0)
    assert(robot.y === 0)
  }

  test("Robot.move will not fall off table from opposite corner of the table") {
    val robot = new ToyRobot.Robot()
    robot.place("4,4,NORTH")
    robot.move("")
    assert(robot.x === 4)
    assert(robot.y === 4)
  }

  test("Robot.move will not fall off table from 0,4,NORTH") {
    val robot = new ToyRobot.Robot()
    robot.place("0,4,NORTH")
    robot.move("")
    assert(robot.x === 0)
    assert(robot.y === 4)
  }

  test("Robot.move will not fall off table from 4,0,EAST") {
    val robot = new ToyRobot.Robot()
    robot.place("4,0,EAST")
    robot.move("")
    assert(robot.x === 4)
    assert(robot.y === 0)
  }

  test("Robot.move will not fall off table from 4,0,SOUTH") {
    val robot = new ToyRobot.Robot()
    robot.place("4,0,SOUTH")
    robot.move("")
    assert(robot.x === 4)
    assert(robot.y === 0)
  }

  test("Robot.move will not fall off table from 0,4,WEST") {
    val robot = new ToyRobot.Robot()
    robot.place("0,4,WEST")
    robot.move("")
    assert(robot.x === 0)
    assert(robot.y === 4)
  }

  test("Robot.exec place at 1,2,WEST") {
    val robot = new ToyRobot.Robot()
    robot.exec("PLACE", "1,2,WEST")

    assert(robot.x === 1)
    assert(robot.y === 2)
    assert(robot.facing === "WEST")
  }

  test("Robot.exec report from origin") {
    val robot = new ToyRobot.Robot()
    val stream = new java.io.ByteArrayOutputStream()

    Console.withOut(stream) { robot.exec("REPORT", "") }

    assert(stream.toString === "0, 0, NORTH\n")
  }

  test("Robot.exec move from origin") {
    val robot = new ToyRobot.Robot()
    robot.exec("MOVE", "")
    assert(robot.x === 0)
    assert(robot.y === 1)
  }

  test("Robot.exec move from origin facing EAST") {
    val robot = new ToyRobot.Robot()
    robot.exec("RIGHT", "")
    robot.exec("MOVE", "")
    assert(robot.x === 1)
    assert(robot.y === 0)
  }

  test("Robot.exec move will not fall off table from origin") {
    val robot = new ToyRobot.Robot()
    robot.exec("LEFT", "")
    robot.exec("MOVE", "")
    assert(robot.x === 0)
    assert(robot.y === 0)
  }

  test("Robot.exec ignores unknown commands") {
    val robot = new ToyRobot.Robot()
    robot.exec("UNKNOWN", "")

    assert(robot.x === 0)
    assert(robot.y === 0)
    assert(robot.facing === "NORTH")
  }
}
