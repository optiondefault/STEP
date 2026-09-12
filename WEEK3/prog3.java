// Explanation: Passing the HostelRoom array into methods passes the *reference* to the array object, not a copy of the array or its contents.
// Therefore, modifying a room's state inside the method affects the original objects in the array.

class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    public HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public void allot(String name) {
        if (occupied < beds) {
            occupied++;
            System.out.println(name + " allotted to room " + roomNo);
        } else {
            System.out.println("Room " + roomNo + " is full.");
        }
    }
}

public class prog3 {
    public static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (HostelRoom room : rooms) {
            if (room.occupied < room.beds) {
                return room;
            }
        }
        return null;
    }

    public static void safeAllot(HostelRoom[] rooms, String studentName) {
        HostelRoom room = findAvailableRoom(rooms);
        if (room != null) {
            room.allot(studentName);
        } else {
            System.out.println("No rooms available for " + studentName);
        }
    }

    public static void main(String[] args) {
        HostelRoom[] availableRooms = {
            new HostelRoom("C-214", 3, 2),
            new HostelRoom("C-507", 2, 2)
        };
        System.out.println("Rooms: C-214 (2/3), C-507 (2/2)");
        safeAllot(availableRooms, "Divya");

        System.out.println("\nRooms: C-214 (3/3), C-507 (2/2)");
        safeAllot(availableRooms, "Divya");
    }
}
