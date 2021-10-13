package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Kedar Erande
 */
public class HotelBookings {
    public static void main(String[] args) {

        //13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8
        

        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> depart = new ArrayList<>();
        arrive.add(1);
        arrive.add(3);
        arrive.add(5);
        depart.add(2);
        depart.add(6);
        depart.add(8);
        int K = 2;
        System.out.println(hotel(arrive, depart, K));

    }

    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        HashMap<Integer, Integer> rooms = new HashMap<>();

        //sort the arrival

        Collections.sort(arrive);
        //sort the departure

        Collections.sort(depart);

        if (K == 0) {
            return false;
        }

        rooms.put(arrive.get(0), depart.get(0));
        K = K - 1;
        for (int i = 1; i < arrive.size(); i++) {
            for (int j = i; j <= i; j++) {
                int index = i - 1;
                if (arrive.get(i) > rooms.get(arrive.get(index))) {
                    K = K + 1;
                    rooms.put(arrive.get(i), depart.get(i));
                    K = K - 1;
                } else if (K > 0) {
                    rooms.put(arrive.get(i), depart.get(i));
                    K = K - 1;
                } else
                    return false;

            }

        }
        return true;
    }
}
