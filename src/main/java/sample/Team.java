package sample;

public class Team {
    String name;
    Long points;
    Long id;


    public Team(String name, Long points, Long id) {
        this.name = name;
        this.points = points;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getPoints() {
        return points;
    }

    public Long getId() {
        return id;
    }
}
