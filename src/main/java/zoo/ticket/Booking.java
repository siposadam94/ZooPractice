package zoo.ticket;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Booking implements Serializable {

    private String bookingName;
    private LocalDate bookingDate;
    private LocalDate visitingDate;
    private Set<Ticket> tickets;
    private int discountPercentage;
    private double price;

    public Booking() {};

    public Booking(String bookingName, LocalDate bookingDate, LocalDate visitingDate) {
        this.bookingName = bookingName;
        this.bookingDate = bookingDate;
        this.visitingDate = visitingDate;
        tickets = new HashSet<>();
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
        this.price += ticket.getTicketPrice();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingName='" + bookingName + '\'' +
                ", bookingDate=" + bookingDate +
                ", visitingDate=" + visitingDate +
                ", tickets=" + tickets +
                ", discountPercentage=" + discountPercentage +
                ", price=" + price +
                '}';
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(LocalDate visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
