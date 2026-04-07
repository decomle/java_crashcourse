package test.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class UndergroundSystem {
    private Map<Integer, CheckIn> checkedIn;
    private Map<Route, TimeReport> travelTimes;

    private record CheckIn(String station, int time) {};
    private record Route(String start, String end) {};
    private record TimeReport(int total, int count){};

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!checkedIn.containsKey(id)) {
            checkedIn.put(id, new CheckIn(stationName, t));
        } else {
            System.out.println("Already checkedin");
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if(checkedIn.containsKey(id)) {
            CheckIn checkin = checkedIn.get(id);

            String startStation = checkin.station;
            int duration = t - checkin.time;

            Route route = new Route(startStation, stationName);
            travelTimes.compute(route,
                    (theRoute, theReport) -> {
                        if(theReport == null) {
                            return new TimeReport(duration, 1);
                        } else {
                            return new TimeReport(theReport.total+ duration, theReport.count + 1);
                        }
                    });
            checkedIn.remove(id);
        } else {
            System.out.println("Already checked out");
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        TimeReport report = travelTimes.get(route);
        if(report == null) {
            return 0.0;
        }

        return (double) report.total/report.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */