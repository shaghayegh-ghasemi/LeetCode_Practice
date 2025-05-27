from collections import deque

class Solution(object):   
    def nearestExit(self, maze, entrance):
        """
        :type maze: List[List[str]]
        :type entrance: List[int]
        :rtype: int
        """
        rows, cols = len(maze), len(maze[0]) # The dimension of the maze
        q = deque([(entrance[0], entrance[1], 0)]) # x, y, steps
        visited_cells = set((entrance[0], entrance[1])) # Keep track of visited cells
        valid_moves = [(-1, 0), (0, 1), (1, 0), (0, -1)] # Up, Right, Down, Left

        while q:
            x, y, steps = q.popleft() # check a cell from queue

            # Explore the neighbors
            for dx, dy in valid_moves: 
                neighbor_x, neighbor_y = x + dx, y + dy # Get the x and y of the neighbor
                
                # Check if the neighbor is within the boundries, it's not a wall and is not already checked
                if 0 <= neighbor_x < rows and 0 <= neighbor_y < cols and maze[neighbor_x][neighbor_y] == '.' and (neighbor_x, neighbor_y) not in visited_cells:
                    # Check if the cell is an exit 
                    if (neighbor_x == 0 or neighbor_x == rows - 1 or neighbor_y == 0 or neighbor_y == cols - 1) and (neighbor_x != entrance[0] or neighbor_y != entrance[1]):
                        return steps + 1 # Return steps if you find the exit

                    visited_cells.add((neighbor_x, neighbor_y)) # If cell was not exit add it to visited to avoid revisiting it later
                    q.append((neighbor_x, neighbor_y, steps + 1)) # If cell was not exit add it to queue to check its neighbors

        return -1 # If no exit was found, return -1

if __name__ == "__main__":
    # maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]
    # entrance = [1,2]

    # maze = [["+","+","+"],[".",".","."],["+","+","+"]]
    # entrance = [1,0]

    # maze = [[".","+"]]
    # entrance = [0,0]

    maze = [["+",".","+","+","+","+","+"],["+",".","+",".",".",".","+"],["+",".","+",".","+",".","+"],["+",".",".",".","+",".","+"],["+","+","+","+","+","+","."]]
    entrance = [0,1]

    sol = Solution()

    res = sol.nearestExit(maze, entrance)

    print(res)

# Project description: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75