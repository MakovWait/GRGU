package by.mkwt.senla.training.carservice.logic.models.items;

import java.io.Serializable;

public class Garage implements Serializable{

    private static final long serialVersionUID = 8052444064394181518L;
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
