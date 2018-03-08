class ToyRobotAppTest extends org.scalatest.FunSuite {
  test("ToyRobot.main stdin") {
    val inStream = new java.io.ByteArrayInputStream(("REPORT\nEXIT").getBytes)
    val outStream = new java.io.ByteArrayOutputStream()

    Console.withOut(outStream) {
      Console.withIn(inStream) {
        ToyRobot.main(Array())
      }
    }

    assert(outStream.toString === "0, 0, NORTH\n")
  }

  test("ToyRobot.main filename") {
    val outStream = new java.io.ByteArrayOutputStream()

    Console.withOut(outStream) {
      ToyRobot.main(Array("src/test/resources/example_a.txt"))
    }

    assert(outStream.toString === "0, 0, NORTH\n")
  }
}

// == References:
// - [mocking \- How to mock scala readLine \- Stack Overflow](https://stackoverflow.com/questions/29474414/how-to-mock-scala-readline)
