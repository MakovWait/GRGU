package by.mkwt.senla.training.list4.task1.carservice.models.items;

import java.math.BigDecimal;
import java.util.Date;

public class Order implements Item {

    private Long id;
    private Date fillingDate;
    private Date startingDate;
    private Date endingDate;
    private BigDecimal price;
    private OrderState state;

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

    public Date getFillingDate() {
        return fillingDate;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void shiftEndingDate(Date shiftedDate) {
        Long currentEndingDate = endingDate.getTime();

        this.endingDate = new Date(currentEndingDate + shiftedDate.getTime());
    }

    @Override
    public String toLine() {
        final String[] array = new String[]{
                String.valueOf(this.getId()),
                String.valueOf(this.getFillingDate().getTime()),
                String.valueOf(this.getStartingDate().getTime()),
                String.valueOf(this.getEndingDate().getTime()),
                String.valueOf(this.getPrice()),
                String.valueOf(this.getState())
        };
        return String.join("|", array);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Order) {
            return this.toLine().equals(((Order) obj).toLine());
        }

        return super.equals(obj);
    }
}
