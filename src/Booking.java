import java.sql.Date;

public class Booking {
    int id;
    String title;
    String description;
    String type;
    String ticket;
    Date date;

    public Booking(int id, String title, String description, String type, String ticket, Date date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.ticket = ticket;
        this.date = date;
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
