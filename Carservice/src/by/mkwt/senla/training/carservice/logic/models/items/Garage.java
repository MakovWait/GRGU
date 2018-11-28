package by.mkwt.senla.training.carservice.logic.models.items;

public class Garage {

    private Long id;

    public Garage(Long id) {
        this.id = id;
    }

    public Garage() {

    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                '}' +
                "\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
