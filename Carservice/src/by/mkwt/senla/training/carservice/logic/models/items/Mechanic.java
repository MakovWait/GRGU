package by.mkwt.senla.training.carservice.logic.models.items;

import java.io.Serializable;

public class Mechanic implements Serializable{

    private static final long serialVersionUID = 7510526852689274225L;
    private Long id;
    private String name;

    private int busyness;

    public Mechanic() {

    }

    public Mechanic(Long id, String name) {

        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", busyness=" + busyness +
                '}'+
                "\n";
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
