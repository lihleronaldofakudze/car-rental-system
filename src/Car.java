public class Car {
    int id;
    String number;
    String type;
    String category;
    String description;
    int ownerId;

    public Car(int id, String number, String type, String category, String description, int ownerId) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.category = category;
        this.description = description;
        this.ownerId = ownerId;
    }

    public boolean add () {
        return false;
    }

    public boolean update () {
        return false;
    }

    public boolean delete () {
        return false;
    }
}
