package InitializersTest;

/**
 * Some implementation notes: The parser is not very strong i.e. it can get confused 
 * if the input is not in a certain format. It can only deal with whitespace in the road name.
 */

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

enum DISTANCE_UNIT {
	MILES,
	//KM
}

enum SPEED_UNIT {
	MILESPERHOUR,
	//KMPERHOUR
}

enum TIME_UNIT {
	HOUR,
	MIN
}

class Speed {
	private float speed;
	private adaptvprogrammingtest.SPEED_UNIT unit;
	public Speed(float speed, adaptvprogrammingtest.SPEED_UNIT unit) {
		this.speed = speed;
		this.unit = unit;
	}
	float getSpeed() {
		return speed;
	}
	adaptvprogrammingtest.SPEED_UNIT getUnit() {
		return unit;
	}	
}

class Time implements Comparable{
	private float time;
	private TIME_UNIT unit;
    
	Time(float time, TIME_UNIT unit) {
        this.time = time;
        this.unit = unit;
	}
    
	float getTime() {
		return time;
	}

	TIME_UNIT getUnit() {
		return unit;
	}

	void add(Time t2) {
        float time2 = t2.time;
        TIME_UNIT unit2 = t2.getUnit();
		if (unit == unit2){
			time += time2;
			return;
		} else if (unit == adaptvprogrammingtest.TIME_UNIT.HOUR && unit2 == TIME_UNIT.MIN){
        	time +=  time2/60;
        } else {
        	assert (unit == adaptvprogrammingtest.TIME_UNIT.MIN && unit2 == adaptvprogrammingtest.TIME_UNIT.HOUR) : "possible bug";
        	time +=  time2 * 60;
        }
	}
    
	@Override
	public int compareTo(Object arg0) {
        adaptvprogrammingtest.Time t2 = (adaptvprogrammingtest.Time)arg0;
        float time2 = t2.time;
        adaptvprogrammingtest.TIME_UNIT unit2 = t2.unit;
        
        float retval ;
        
        if (unit == unit2){
        	retval = (time - time2);
        } else if (unit == adaptvprogrammingtest.TIME_UNIT.HOUR && unit2 == adaptvprogrammingtest.TIME_UNIT.MIN){
        	retval = (time * 60 - time2);
        } else {
        	assert (unit == adaptvprogrammingtest.TIME_UNIT.MIN && unit2 == adaptvprogrammingtest.TIME_UNIT.HOUR) : "possible bug";
        	retval = (time - time2 * 60);
        }
        
        if (retval == 0)
        	return 0;
        else if (retval > 0)
        	return 1;
        return -1;
	}
    
	@Override
	public String toString() {
		return "[" + time + " " +  unit + "]";
	}
}

class Distance {
	private float dist;
	private adaptvprogrammingtest.DISTANCE_UNIT unit;
    
	Distance(float dist, adaptvprogrammingtest.DISTANCE_UNIT unit) {
        if (dist < 0) {
        	throw new IllegalArgumentException("distance should not be negative: " + dist);
        }
		this.dist = dist;
		this.unit = unit;
	}
    
	float getDist() {
		return dist;
	}

	adaptvprogrammingtest.DISTANCE_UNIT getUnit() {
		return unit;
	}

	public void add(adaptvprogrammingtest.Distance dist2) {
		if (unit == dist2.getUnit()){
			dist += dist2.getDist();
			return;
		}
        throw new IllegalArgumentException("Only miles unit is supported currently");
	}
    
	@Override
	public String toString() {
		return "[" + dist + " " + unit + "]";
	}
}

class DistanceUtils {
	static adaptvprogrammingtest.Time getTime(adaptvprogrammingtest.Distance dist, adaptvprogrammingtest.Speed speed) {
		if (dist.getUnit() == adaptvprogrammingtest.DISTANCE_UNIT.MILES){
			if (speed.getUnit() == adaptvprogrammingtest.SPEED_UNIT.MILESPERHOUR){
                assert speed.getSpeed() > 0 : "speed should be positive";
				return new adaptvprogrammingtest.Time(dist.getDist()/(float)speed.getSpeed(), adaptvprogrammingtest.TIME_UNIT.HOUR);
			}
		}
        throw new IllegalArgumentException("Only miles and hours are supported currently");
	}
}

abstract class Road {
	String name;
	adaptvprogrammingtest.Speed speed;
    
	adaptvprogrammingtest.Time minimumDrivingTime;

	public adaptvprogrammingtest.Speed getSpeed() {
		return speed;
	}

	public adaptvprogrammingtest.Time getMinimumDrivingTime() {
		return minimumDrivingTime;
	}	
}

class Street extends adaptvprogrammingtest.Road {
	Street(String roadName){
		speed = new adaptvprogrammingtest.Speed(30, adaptvprogrammingtest.SPEED_UNIT.MILESPERHOUR);
        minimumDrivingTime = new adaptvprogrammingtest.Time(0, adaptvprogrammingtest.TIME_UNIT.MIN);
	}
}

class Highway extends adaptvprogrammingtest.Road {
	Highway(String roadName){
		speed = new adaptvprogrammingtest.Speed(65, adaptvprogrammingtest.SPEED_UNIT.MILESPERHOUR);
        minimumDrivingTime = new adaptvprogrammingtest.Time(1, adaptvprogrammingtest.TIME_UNIT.MIN);
	}
}

class RoadFactory {
	static adaptvprogrammingtest.Road getRoad(String roadName, String roadType){
		adaptvprogrammingtest.Road r;
		if ("S".equals(roadType)) {
			 r = new adaptvprogrammingtest.Street(roadName);
		} else if ("H".equals(roadType)) {
			 r = new adaptvprogrammingtest.Highway(roadName);
		} else {
			throw new IllegalArgumentException("road type not supported:" + roadType);
		}
        return r;		
	}
}

class RoadSegment {
	adaptvprogrammingtest.Road road;
	adaptvprogrammingtest.Distance distance;
    
	public RoadSegment(adaptvprogrammingtest.Road road, adaptvprogrammingtest.Distance distance) {
        this.road = road;
        this.distance = distance;
	}

	static adaptvprogrammingtest.RoadSegment getRoadSegment(String roadName, String roadType, float distance){
		adaptvprogrammingtest.Road r = adaptvprogrammingtest.RoadFactory.getRoad(roadName, roadType);
        return new adaptvprogrammingtest.RoadSegment(r, new adaptvprogrammingtest.Distance(distance, adaptvprogrammingtest.DISTANCE_UNIT.MILES));
	}
	
	adaptvprogrammingtest.Time getTime(){
		adaptvprogrammingtest.Time time = adaptvprogrammingtest.DistanceUtils.getTime(distance, road.speed);
		
		if (time.getTime() == 0){
			return time;
		}
		adaptvprogrammingtest.Time minTime = road.getMinimumDrivingTime();
		
        return time.compareTo(minTime) > 0 ? time : minTime;
	}
	
	adaptvprogrammingtest.Distance getDistance(){
		return distance;
	}
}

/**
 * The parser interface. I have written LineParser. We can create other parsers as well like XMLParser
 */
interface Parser {
	adaptvprogrammingtest.RoadSegment getNext();
	boolean hasNext();
    
	void close();
}

class LineParser implements adaptvprogrammingtest.Parser {
	Scanner sc;
    
	public LineParser(InputStream in) {
    	sc = new Scanner(in);
	}

	public LineParser(String str) {
    	sc = new Scanner(str);
	}
    
	@Override
	public adaptvprogrammingtest.RoadSegment getNext() {
        Scanner sc2 = null;
        try {
            String line = sc.nextLine();
            sc2 = new Scanner(line).useDelimiter("[,]");
            String roadName = sc2.next();
            String roadType = sc2.next();
            float dist      = sc2.nextFloat();
            
            //System.out.println("Read: " + roadName + " " + roadType + " " + dist);
    		return adaptvprogrammingtest.RoadSegment.getRoadSegment(roadName, roadType, dist);
        } finally {
            if (sc2 != null) {
				sc2.close();
			}
        }
	}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public void close() {
		if (sc != null) {
			sc.close();
		}
	}
}

public class ComputeDistance {

	public static void main(String[] args) {
        computeDist(System.in, System.out);
	}
    
	public static void computeDist(InputStream stream, PrintStream out) {
		 
		adaptvprogrammingtest.Parser parser = new adaptvprogrammingtest.LineParser(stream); //can move into factory method
        
        adaptvprogrammingtest.Distance d = new adaptvprogrammingtest.Distance(0, adaptvprogrammingtest.DISTANCE_UNIT.MILES);
        adaptvprogrammingtest.Time t = new adaptvprogrammingtest.Time(0, adaptvprogrammingtest.TIME_UNIT.HOUR);
		while (parser.hasNext()){
			adaptvprogrammingtest.RoadSegment seg = parser.getNext();
            if (seg == null) break;
			d.add(seg.getDistance());
			t.add(seg.getTime());
		}
        
		parser.close();
        
		out.println("Total distance: " + d);
		out.println("Total time: " + t);
	}
}
