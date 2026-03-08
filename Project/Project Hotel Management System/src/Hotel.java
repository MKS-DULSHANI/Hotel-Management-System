import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotel {
    private String hotelName;
    private String location;
    private List<Room> rooms;

    public Hotel(String hotelName, String location) {
        this.hotelName = hotelName;
        this.location = location;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void displayHotelInfo() {
        System.out.println("Hotel: " + hotelName + ", Location: " + location);
        System.out.println();
        System.out.println("Available Rooms:");
        System.out.println();
        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getRoomId() + ", Type: " + room.getRoomType() + ", Price: Rs. " + room.getPrice());
        }
    }

    public Room getRoomById(Scanner scanner) {
        System.out.print("Enter Room ID to book: ");
        int roomId = scanner.nextInt();
        for (Room room : rooms) {
            if (room.getRoomId() == roomId) {
                return room;
            }
        }
        return null;
    }
}
