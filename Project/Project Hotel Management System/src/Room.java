class Room {
    private int roomId;
    private double price;
    private String roomType;

    public Room(int roomId, double price, String roomType) {
        this.roomId = roomId;
        this.price = price;
        this.roomType = roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public double getPrice() {
        return price;
    }

    public String getRoomType() {
        return roomType;
    }
}
