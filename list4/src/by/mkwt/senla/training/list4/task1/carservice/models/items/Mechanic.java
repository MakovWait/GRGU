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
        String[] values;
        values = new String[]{
                String.valueOf(id),
                name
        };
        return String.join("|", values);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mechanic) {
            return this.toLine().equals(((Mechanic) obj).toLine());
        }

        return super.equals(obj);
    }
}
