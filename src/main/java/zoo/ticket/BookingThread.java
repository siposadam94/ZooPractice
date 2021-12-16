package zoo.ticket;

import zoo.Zoo;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BookingThread {

    private static final Booking b1 = new Booking(
                "name name",
                LocalDate.of(2019,07, 31),
                LocalDate.of(2019, 11, 11)
                        );

    static {

        b1.addTicket(
                new Ticket(Ticket.TicketPriceType.RETIRED, new TicketTypeFullDay(), 2.99)
        );
        b1.addTicket(
                new Ticket(Ticket.TicketPriceType.KID, new TicketTypeFullDay(), 1.69)
        );
    }

    public static void runOneThread(Zoo zoo) throws InterruptedException {

        Thread task = new Thread( () -> {
            for(int i = 0; i < 100000; i++) {
                zoo.addBooking(b1);
            }
        });

        long start1 = System.currentTimeMillis();
        task.start();
        task.join();
        System.out.println(zoo.getBookings().size());
        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;
        System.out.println("1 thread " + timeElapsed1);
        zoo.getBookings().clear();
    }

    public static void runTwoThread(Zoo zoo) throws InterruptedException {

        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });

        Thread task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });

        long start1 = System.currentTimeMillis();
        task1.start();
        task2.start();
        task1.join();
        task2.join();;
        System.out.println(zoo.getBookings().size());
        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;
        System.out.println("2 thread " + timeElapsed1);
        zoo.getBookings().clear();
    }


    public static void runFourThread(Zoo zoo) throws InterruptedException {

        Thread task1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 25000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });

        Thread task2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 25000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });
        Thread task3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 25000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });

        Thread task4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 25000; i++) {
                    zoo.addBooking(b1);
                }
            }
        });

        long start1 = System.currentTimeMillis();
        task1.start();
        task2.start();
        task3.start();
        task4.start();
        task1.join();
        task2.join();
        task3.join();
        task4.join();
        System.out.println(zoo.getBookings().size());
        long finish1 = System.currentTimeMillis();
        long timeElapsed1 = finish1 - start1;
        System.out.println("4 thread " + timeElapsed1);
        zoo.getBookings().clear();
    }

    public static void runExecutor(Zoo zoo) throws InterruptedException {

        Thread task = new Thread(() -> {
            for(int i = 0; i < 100000; i++) {
                zoo.addBooking(b1);
            }
        });

        ExecutorService ex = Executors.newFixedThreadPool(4);

		long start2 = System.currentTimeMillis();
			ex.submit(task);

			ex.shutdown();
			ex.awaitTermination(10, TimeUnit.SECONDS);
		long finish2 = System.currentTimeMillis();
		long timeElapsed2 = finish2 - start2;
        System.out.println(zoo.getBookings().size());
		System.out.println("Executor thread " + timeElapsed2);
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

