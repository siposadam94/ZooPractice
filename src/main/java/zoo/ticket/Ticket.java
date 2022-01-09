package zoo.ticket;

import java.io.Serializable;

public class Ticket implements Serializable {

    public enum TicketPriceType {
        ADULT, KID, RETIRED, GROUP
    }

    public enum TicketType {
        FULLDAY("kifutók", "fóka show", "terrárium"),
        MORNING("kifutók"),
        AFTERNOON("kifutók", "fóka show");

        private final String[] visitableSites;

        TicketType(String... visitableSites)
        {
            this.visitableSites = visitableSites;
        }

        public String[] getVisitableSites() {
            return visitableSites;
        }
    }

    private TicketPriceType ticketPriceType;
    private TicketType ticketType;
    private double ticketPrice;

    public Ticket() {};

    public Ticket(TicketPriceType ticketPriceType, TicketType ticketType, double ticketPrice) {
        this.ticketPriceType = ticketPriceType;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }

    public TicketPriceType getTicketPriceType() {
        return ticketPriceType;
    }

    public void setTicketPriceType(TicketPriceType ticketPriceType) {
        this.ticketPriceType = ticketPriceType;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
