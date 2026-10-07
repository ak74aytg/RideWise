package model;

public class Rider extends User {
    private Location location;

    public Rider(String name, Location location) {
        super(name);
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Rider{" +
                "name=" + super.getName() +
                '}';
    }
}
