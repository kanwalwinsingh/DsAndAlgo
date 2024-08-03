package Gaana;

public class TicketDifference {

    public static int countFriendsWithTicketDifference(int N, int M, int k, int[] tickets) {
        if (N <= 0 || tickets == null || tickets.length == 0) {
            return 0;
        }

        // Jay's ticket count is the last element in the array
        int jayTickets = tickets[N];
        
        int count = 0;
        
        // Iterate through the friends' tickets
        for (int i = 0; i < N; i++) {
            int friendTickets = tickets[i];
            // Check if the difference with Jay's tickets is exactly k
            if (Math.abs(friendTickets - jayTickets) == k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 5; // Number of friends
        int M = 3; // Number of different types of tickets (not used in the solution directly)
        int k = 2; // Difference required
        int[] tickets = {3, 5, 7, 6, 8, 5}; // Example tickets array

        int result = countFriendsWithTicketDifference(N, M, k, tickets);
        System.out.println("Number of friends with ticket count differing from Jay's by " + k + " is: " + result);
    }
}