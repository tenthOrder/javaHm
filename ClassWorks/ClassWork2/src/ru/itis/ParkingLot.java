package ru.itis;

public class ParkingLot {
    Transport[] parkingLot;
    int size;

    public ParkingLot(int size) {
        this.parkingLot = new Transport[size];
        this.size = size;
    }

    /*
     *  if successful, returns the number of the parking spot where
     *  the transport was parked, and -1 otherwise
     */
    public int park(Transport transport) {
        int freeSpot = findFreeSpot();
        if (freeSpot != -1) {
            parkingLot[freeSpot] = transport;
        }
        return freeSpot;
    }

    //returns -1 if no free spot is found
    private int findFreeSpot() {
        for (int i = 0; i < size; i++) {
            if (parkingLot[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void leave(int spot) {
        parkingLot[spot] = null;
    }

    public void leave(String registrationNumber) {
        int spot = find(registrationNumber);
        if (spot != -1) {
            leave(spot);
        }
    }

    /*
     *  finds first Transport with a given registration number
     *  and returns its spot number,
     *  if no such element is found returns -1;
     */
    private int find(String registrationNumber) {
        for (int i = 0; i < size; i++) {
            if (registrationNumber.equals(parkingLot[i].getRegistrationNumber())) {
                return i;
            }
        }
        return -1;
    }

    //returns null if the spot is empty
    public String getRegistrationNumber(int spot) {
        if (parkingLot[spot] == null) {
            return null;
        }
        return parkingLot[spot].getRegistrationNumber();
    }
}


