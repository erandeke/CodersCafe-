package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kedar Erande
 */
public class HotelBookingsProbSolution {
    public static void main(String[] args) {
        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> depart = new ArrayList<>();
        arrive.add(1);
        arrive.add(3);
        arrive.add(5);
        depart.add(2);
        depart.add(6);
        depart.add(8);
        int K = 2;

        System.out.println(isAvailable(arrive, depart, K));
    }

    private static boolean isAvailable(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int ar = 0, de = 0, satisfy = 0, roomoccupancy = 0;
        while (ar < arrive.size() && de < depart.size()) {
            if (arrive.get(ar) < depart.get(de)) {//-- This means room is already occupied
                ar++;//increase the arrival
                roomoccupancy++;//increase the room occupancy
                satisfy = Math.max(roomoccupancy, satisfy);//check the max
            } else {//This means room has left unocuppied by the previous person as they got departed
                de++;
                roomoccupancy--;
            }
        }
        return (satisfy <= K) ? true : false;
    }
}

