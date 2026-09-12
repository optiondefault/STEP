// Explanation: Passing the ParkingSlot array into these methods does not copy the slots themselves because Java passes object references by value.
// The array reference points to the same array object in memory, so modifications to the slots inside the method directly affect the original objects.

class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public void allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            System.out.println(vehicleNo + " allotted to slot " + slotNo);
        } else {
            System.out.println("Slot " + slotNo + " is full.");
        }
    }
}

public class assign3 {
    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot slot : slots) {
            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }
        return null;
    }

    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot != null) {
            slot.allot(vehicleNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    public static void main(String[] args) {
        ParkingSlot[] slots = {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        
        System.out.println("Slots: A1 (3/4), A2 (5/5)");
        safeAllot(slots, "TN09AB1234");
        
        System.out.println("Slots: A1 (4/4), A2 (5/5)");
        safeAllot(slots, "TN09AB1234");
    }
}
