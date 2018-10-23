package by.mkwt.senla.training.list4.task1.carservice.models.items;

import java.util.Date;

public class Schedule implements Item {

    private Date date;
    private Long orderID;
    private Long mechanicID;
    private Long garageID;

    public Schedule(Date date, Long orderID, Long mechanicID, Long garageID) {
        this.date = date;
        this.orderID = orderID;
        this.mechanicID = mechanicID;
        this.garageID = garageID;
    }

    public Date getDate() {
        return date;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Long getMechanicID() {
        return mechanicID;
    }

    public Long getGarageID() {
        return garageID;
    }

    @Override
    public String toLine() {
        final String[] array = new String[]{
                String.valueOf(this.getDate().getTime()),
                String.valueOf(this.getOrderID()),
                String.valueOf(this.getMechanicID()),
                String.valueOf(this.getGarageID())
        };
        return String.join("|", array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Schedule) {
            return this.toLine().equals(((Schedule) obj).toLine());
        }

        return super.equals(obj);
    }
}
