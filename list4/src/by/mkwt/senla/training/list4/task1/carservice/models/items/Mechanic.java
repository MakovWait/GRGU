package by.mkwt.senla.training.list4.task1.carservice.models.items;

public class Mechanic implements Item {
    private Long id;
    private String name;

    public Mechanic(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toLine() {
        String[] values = new String[]{
                String.valueOf(id),
                name
        };
        return String.join("|", values);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) {
            return true;
        }

        if(obj == null || !(getClass() == obj.getClass())){
            return false;
        } else {
            Mechanic tmpMechanic = (Mechanic) obj;

            if(tmpMechanic.id != this.id
                    || !tmpMechanic.name.equals(this.name)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
