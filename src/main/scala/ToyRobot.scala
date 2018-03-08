import java.util.Scanner
import scala.io.Source
import scala.io.StdIn

object ToyRobot extends App {
  val COMMANDS = Map[String, String](
    "PLACE" -> "place",
    "MOVE" -> "move",
    "LEFT" -> "left",
    "RIGHT" -> "right",
    "REPORT" -> "report"
  )

  // val Table = Array.ofDim[Char](5,5)
  // val Table = Array.tabulate(5,5)(".")

  class Robot(var x: Int = 0, var y: Int = 0, var facing: String = "NORTH") {
    val Move = Map[String,Map[Char,Int]] (
      "NORTH" -> Map[Char,Int]( 'x' ->  0, 'y' ->  1 ),
      "SOUTH" -> Map[Char,Int]( 'x' ->  0, 'y' -> -1 ),
      "EAST"  -> Map[Char,Int]( 'x' ->  1, 'y' ->  0 ),
      "WEST"  -> Map[Char,Int]( 'x' -> -1, 'y' ->  0 )
    )

    val SeparatorsRegex = "[ |,\\s*]"

    val Turn = Map[String,Map[String,String]] (
      "NORTH" -> Map[String,String]( "LEFT" -> "WEST",  "RIGHT" -> "EAST" ),
      "SOUTH" -> Map[String,String]( "LEFT" -> "EAST",  "RIGHT" -> "WEST" ),
      "EAST"  -> Map[String,String]( "LEFT" -> "NORTH", "RIGHT" -> "SOUTH" ),
      "WEST"  -> Map[String,String]( "LEFT" -> "SOUTH", "RIGHT" -> "NORTH" )
    )

    def exec(command: String, args: String) = {
      command match {
        case "PLACE" => place(args)
        case "MOVE" => move(args)
        case "LEFT" => left(args)
        case "RIGHT" => right(args)
        case "REPORT" => report(args)
        case default => "" // Do nothing
      }
    }

    def place(coordinates: String) {
      val Array(dx, dy, dFacing, _*) = coordinates.split(SeparatorsRegex)
      x = dx.toInt
      y = dy.toInt
      facing = dFacing
    }

    def report(_args: String) {
      println(s"$x, $y, $facing")
    }

    def left(_args: String) {
      facing = Turn(facing)("LEFT")
    }

    def right(_args: String) {
      facing = Turn(facing)("RIGHT")
    }

    def move(_args: String) {
      x += Move(facing)('x')
      y += Move(facing)('y')

      if (x < 0 || x > 4) {
        x -= Move(facing)('x')
      }

      if (y < 0 || y > 4) {
        y -= Move(facing)('y')
      }
    }
  }

  override def main(args: Array[String]) {
    val robot = new Robot(0, 0, "NORTH")

    if (args.length > 0) {
      val filename = args(0)
      for (line <- Source.fromFile(filename).getLines) {
        val input = line.split(" ")
        var commandMethodName = input(0)
        var commandArgs = ""

        if(input.length > 1){
          commandArgs = input(1)
        }

        if (commandMethodName != null && commandArgs != null) {
          robot.exec(commandMethodName, commandArgs)
        }
      }
    }
    else
    {
      var line = ""
      while ({line = StdIn.readLine(); line != "EXIT"}) {
        val input = line.split(" ")
        var commandMethodName = input(0)
        var commandArgs = ""

        if(input.length > 1){
          commandArgs = input(1)
        }

        if (commandMethodName != null && commandArgs != null) {
          robot.exec(commandMethodName, commandArgs)
        }
      }
    }
  }
}


// val Array(input, _*) = "PLACE 0,0,NORTH".split(SeparatorsRegex)
// var command, x, y, facing = ""
// (command, x, y, facing) = "PLACE 0,0,NORTH".split(SeparatorsRegex)
// == References:
// - [How to create and use multi\-dimensional arrays \(2D, 3D, etc\.\) in Scala \| alvinalexander\.com](https://alvinalexander.com/source-code/scala/how-create-and-use-multi-dimensional-arrays-2d-3d-etc-scala)
// - [dynamic \- Is there any Scala feature that allows you to call a method whose name is stored in a string? \- Stack Overflow](https://stackoverflow.com/questions/2060395/is-there-any-scala-feature-that-allows-you-to-call-a-method-whose-name-is-stored)
// - [Scala: How to use break and continue in for and while loops \| alvinalexander\.com](https://alvinalexander.com/scala/break-continue-for-while-loops-in-scala-examples-how-to)
