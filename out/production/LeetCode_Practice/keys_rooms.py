class Solution(object):
    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        visited_rooms = set() # Create a set to store the collected keys from rooms, ensuring no duplicates
        q = [0] # A queue to keep track of rooms that are accessible for visiting

        while q:
            room = q.pop() # Get one accessible room for visiting
            if room not in visited_rooms:
                visited_rooms.add(room) # Add the room to the visited set
                for key in rooms[room]:
                    if key not in visited_rooms: # If a new key is found, add the corresponding room to the list of accessible rooms
                        q.append(key)

        return len(visited_rooms) == len(rooms)

if __name__ == "__main__":
    rooms = [[1],[2],[3],[]]
    # rooms = [[1,3],[3,0,1],[2],[0]]

    sol = Solution()

    res = sol.canVisitAllRooms(rooms)

    print(res)

# project description: https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75