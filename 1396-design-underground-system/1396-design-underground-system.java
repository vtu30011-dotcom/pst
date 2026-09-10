import java.util.*;
class UndergroundSystem {
    private HashMap<Integer, CheckInData> checkIns;
    private HashMap<String, double[]> trips;
    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInData(stationName, t));
    }
    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkIns.get(id);
        String startStation = data.station;
        int startTime = data.time;
        int travelTime = t - startTime;
        String key = startStation + "#" + stationName;
        if (!trips.containsKey(key)) {
            trips.put(key, new double[]{0, 0});
        }
        trips.get(key)[0] += travelTime;
        trips.get(key)[1]++;
        checkIns.remove(id);
    }
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;
        double[] data = trips.get(key);
        return data[0] / data[1];
    }
    class CheckInData {
        String station;
        int time;
        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}