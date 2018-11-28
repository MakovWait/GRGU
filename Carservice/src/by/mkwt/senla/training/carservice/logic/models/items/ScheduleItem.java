package by.mkwt.senla.training.carservice.logic.models.items;

import java.io.Serializable;
import java.util.Date;

public class ScheduleItem implements Serializable{

    private static final long serialVersionUID = -8743159935353142357L;
    private Date date;
    private Long orderId;
    private Long mechanicId;
    private Long garageId;

    public ScheduleItem() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }
}
