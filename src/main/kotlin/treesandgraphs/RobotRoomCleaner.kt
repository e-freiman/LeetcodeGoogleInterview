package treesandgraphs

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
     fun move(): Boolean

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    fun turnLeft()
    fun turnRight()

    // Clean the current cell.
    fun clean()
}

class RobotRoomCleaner {
    private val visited = mutableSetOf<Pair<Int, Int>>()

    // first, second->
    // |
    // v
    // direction 0 - up, 1 - left, 2 - down, 3 - right
    private fun nextPos(pos: Pair<Int, Int>, direction: Int) = when(direction) {
        0 -> pos.first - 1 to pos.second
        1 -> pos.first to pos.second - 1
        2 -> pos.first + 1 to pos.second
        3 -> pos.first to pos.second + 1
        else -> throw IllegalArgumentException()
    }

    private fun nextDirection(direction: Int) = if (direction < 3) direction + 1 else 0

    private fun goClean(pos: Pair<Int, Int>, direction: Int, robot: Robot) {
        robot.clean()
        visited.add(pos)

        // cycle through all the directions
        var d = direction
        for (k in 0 until 4) {
            val nextPos = nextPos(pos, d)
            if (nextPos !in visited && robot.move()) {
                goClean(nextPos, d, robot)
                // returning back
                robot.turnRight()
                robot.turnRight()
                robot.move()
                robot.turnLeft()
                robot.turnLeft()
            }

            robot.turnLeft()
            d = nextDirection(d)
        }
    }

    fun cleanRoom(robot: Robot) {
        goClean(0 to 0, 0, robot)
    }
}
