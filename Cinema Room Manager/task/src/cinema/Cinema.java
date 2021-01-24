package cinema;

import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        CinemaTheatre cinemaTheatre = newCinemaTheatre();
//        cinemaTheatre.printTheatrePlan();
//        ticketBuying(cinemaTheatre);
//
        start(newCinemaTheatre());




//        incomeCalculation(cinemaTheatre);
    }

    public static void start(CinemaTheatre cinemaTheatre) {
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            switch (scanner.nextInt()) {
                case 1:
                    cinemaTheatre.printTheatrePlan();
                    break;
                case 2:
                    ticketBuying(cinemaTheatre);
                    break;
                case 3:
                    cinemaTheatre.printStatistics();
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Wrong! Choose again");
                    break;
            }
        }
    }


    public static CinemaTheatre newCinemaTheatre() {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInARow = scanner.nextInt();
        return new CinemaTheatre(rows, seatsInARow);
    }

    public static void ticketBuying(CinemaTheatre cinemaTheatre) {
        int seat;
        int row;
        System.out.println("\nEnter a row number:");
        row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seat = scanner.nextInt();


//        while (true) {
//            System.out.println("\nEnter a row number:");
//            row = scanner.nextInt();
//            if (row > cinemaTheatre.rows || row < 1) {
//                System.out.println("Choose row from 1 to " + cinemaTheatre.rows);
//            } else {
//                break;
//            }
//        }
//        while (true) {
//            System.out.println("Enter a seat number in that row:");
//            seat = scanner.nextInt();
//            if (seat > cinemaTheatre.seatsInARow || seat < 1) {
//                System.out.println("Choose seat from 1 to " + cinemaTheatre.seatsInARow);
//            } else {
//                break;
//            }
//        }
        cinemaTheatre.seatReservation(row, seat);
    }
}