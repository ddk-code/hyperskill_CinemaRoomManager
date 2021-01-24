package cinema;

import java.util.Arrays;

public class CinemaTheatre {
    char[][] theatrePlan;
    int rows;
    int seatsInARow;
    int seats;

    private int soldTickets;
    private int currentIncome;
    private int totalIncome;

    public CinemaTheatre(int rows, int seatsInARow) {
        this.rows = rows;
        this.seatsInARow = seatsInARow;
        this.seats = rows * seatsInARow;
        this.theatrePlan = new char[rows][seatsInARow];
        for (int i = 0; i < this.theatrePlan.length; i++) {
            Arrays.fill(this.theatrePlan[i], 'S');
        }
        this.soldTickets = 0;
        this.currentIncome = 0;
        incomeCalculation();
    }

    private void incomeCalculation() {
        if (this.seats <= 60) {
            this.totalIncome = this.seats * 10;
        } else {
            this.totalIncome = this.rows / 2 * 10 * this.seatsInARow +
                    (this.rows - this.rows / 2) * 8 * this.seatsInARow;
        }
    }

    public void printTheatrePlan() {
        System.out.println("\nCinema:");
        for (int i = 0; i <= this.theatrePlan[0].length; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print(" " + i);
            }
        }
        System.out.println();
        for (int i = 0; i < this.theatrePlan.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < this.theatrePlan[i].length; j++) {
                System.out.print(" " + this.theatrePlan[i][j]);
            }
            System.out.println();
        }
    }

    public void seatReservation(int row, int seat) {
        if (row < 1 || row > this.rows || seat < 1 || seat > this.seatsInARow) {
            System.out.println("Wrong input!");
            Cinema.ticketBuying(this);
        } else if (this.theatrePlan[row - 1][seat - 1] == 'S') {
            this.theatrePlan[row - 1][seat - 1] = 'B';
            int temp = ticketCost(row, seat);
            this.currentIncome += temp;
            System.out.println("\nTicket price: $" + temp);
            ++this.soldTickets;
        } else {
            System.out.println("That ticket has already been purchased!");
            Cinema.ticketBuying(this);
        }
    }

    private int ticketCost(int row, int seat) {
        if (this.seats <= 60 || row <= this.rows / 2) {
            return 10;
        } else {
            return 8;
        }
    }

    public void printStatistics() {
        System.out.println("Number of purchased tickets: " + this.soldTickets);
        System.out.printf("Percentage: %.2f%%\n", 100 * (double) this.soldTickets / seats);
        System.out.println("Current income: $" + this.currentIncome);
        System.out.println("Total income: $" + this.totalIncome);
    }
}
