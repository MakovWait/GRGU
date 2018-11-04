package by.mkwt.senla.training.carservice.models.items;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private Long id;
    private Date fillingDate;
    private Date startingDate;
    private Date endingDate;
    private BigDecimal price;
    private OrderState state;

    public Order() {

    }

    public Order(Long id, Date fillingDate, Date startingDate, Date endingDate, BigDecimal price, OrderState state) {
        this.id = id;
        this.fillingDate = fillingDate;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.price = price;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFillingDate() {
        return fillingDate;
    }

    public void setFillingDate(Date fillingDate) {
        this.fillingDate = fillingDate;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
