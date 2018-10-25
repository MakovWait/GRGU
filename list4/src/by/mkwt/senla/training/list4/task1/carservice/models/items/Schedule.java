package by.mkwt.senla.training.list4.task1.carservice.models.items;

import java.util.Date;

public class Schedule implements Item {

    private Date date;
    private Long orderId;
    private Long mechanicId;
    private Long garageId;

    public Schedule(Date date, Long orderId, Long mechanicId, Long garageId) {
        this.date = date;
        this.orderId = orderId;
        this.mechanicId = mechanicId;
        this.garageId = garageId;
    }

    public Date getDate() {
        return date;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public Long getGarageId() {
        return garageId;
    }

    @Override
    public String toLine() {
        final String[] array = new String[]{
                String.valueOf(this.getDate().getTime()),
                String.valueOf(this.getOrderId()),
                String.valueOf(this.getMechanicId()),
                String.valueOf(this.getGarageId())
        };
        return String.join("|", array);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == this) {
            return true;
        }

        if(obj == null || !(getClass() == obj.getClass())){
            return false;
        } else {
            Schedule tmpSchedule = (Schedule) obj;
            if(tmpSchedule.date != this.date
                    || !tmpSchedule.orderId.equals(this.orderId)
                    || !tmpSchedule.mechanicId.equals(this.mechanicId)
                    || !tmpSchedule.garageId.equals(this.garageId)) {
                return false;
            } else {
                return true;
            }
        }
    }
}
