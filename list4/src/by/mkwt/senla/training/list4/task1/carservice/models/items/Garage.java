package by.mkwt.senla.training.list4.task1.carservice.models.items;

public class Garage implements Item {

    private Long id;

    public Garage(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toLine() {
        final String[] array = new String[]{
                String.valueOf(this.getId())
        };
        return String.join("|", array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Garage) {
            return this.toLine().equals(((Garage) obj).toLine());
        }

        return super.equals(obj);
    }
}
