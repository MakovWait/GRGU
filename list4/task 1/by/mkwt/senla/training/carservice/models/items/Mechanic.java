package by.mkwt.senla.training.carservice.models.items;

public class Mechanic {

    private Long id;
    private String name;

    private int busyness;

    public Mechanic() {

    }

    public Mechanic(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusyness() {
        return busyness;
    }

    public void setBusyness(int business) {
        this.busyness = business;
    }

}
