package zoo.ticket;

import zoo.Zoo;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BookingThread {
 
    static Thread task1, task2, task3, task4;

    public static Booking randomGenerateBooking() {

        long minDay = LocalDate.of(2019, 5, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 1, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        Booking generatedBooking = new Booking("test name", randomDate, randomDate );

        generatedBooking.addTicket(
                new Ticket(Ticket.TicketPriceType.ADULT, new TicketTypeFullDay(), 10.99));
        generatedBooking.addTicket(
                new Ticket(Ticket.TicketPriceType.ADULT, new TicketTypeFullDay(), 10.99));
        generatedBooking.addTicket(
                new Ticket(Ticket.TicketPriceType.RETIRED, new TicketTypeFullDay(), 5.99));
        generatedBooking.addTicket(
                new Ticket(Ticket.TicketPriceType.KID, new TicketTypeFullDay(), 5.99));
        
        return generatedBooking;
    }

    public static void runOneThread(Zoo zoo) throws InterruptedException {

        task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    zoo.addBooking(randomGenerateBooking());
                }
            }
        });
        long start1 = System.currentTimeMillis();
        task1.start();
        task1.join();
        long timeElapsed1 = System.currentTimeMillis() - start1;

        System.out.println(zoo.getBookings().size());
        System.out.println("1 thread " + timeElapsed1);
        zoo.getBookings().clear();
    }

    public static void runTwoThread(Zoo zoo) throws InterruptedException {

        task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    zoo.addBooking(randomGenerateBooking());
                }
            }
        });

        task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    zoo.addBooking(randomGenerateBooking());
                }
            }
        });

        long start1 = System.currentTimeMillis();
        task1.start();
        task2.start();
        task1.join();
        task2.join();
        long timeElapsed1 = System.currentTimeMillis() - start1;

        System.out.println(zoo.getBookings().size());
        System.out.println("2 thread " + timeElapsed1);
        zoo.getBookings().clear();
    }

    public static void runExecutor(Zoo zoo, int threadNum) throws InterruptedException {

        ExecutorService ex = Executors.newFixedThreadPool(threadNum);

		long start2 = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
            ex.submit(() -> zoo.addBooking( randomGenerateBooking()));
        }

        long timeElapsed2 = System.currentTimeMillis() - start2;

		ex.shutdown();
        ex.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(zoo.getBookings().size());
		System.out.println(threadNum + " thread: " + timeElapsed2 + " ms");
			zoo.getBookings().clear();

    }
}






//
//		ex = Executors.newFixedThreadPool(10);
//
//		long start3 = System.currentTimeMillis();
//			ex.submit(task);
//		long finish3 = System.currentTimeMillis();
//		long timeElapsed3 = finish3 - start3;
//		System.out.println("4 thread " + timeElapsed3);
//			ex.shutdown();
//			zoo.getBookings().clear();

