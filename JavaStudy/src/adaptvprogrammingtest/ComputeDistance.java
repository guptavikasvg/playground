package adaptvprogrammingtest;

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
	private SPEED_UNIT unit;
	public Speed(float speed, SPEED_UNIT unit) {
		this.speed = speed;
		this.unit = unit;
	}
	float getSpeed() {
		return speed;
	}
	SPEED_UNIT getUnit() {
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
		} else if (unit == TIME_UNIT.HOUR && unit2 == TIME_UNIT.MIN){
        	time +=  time2/60;
        } else {
        	assert (unit == TIME_UNIT.MIN && unit2 == TIME_UNIT.HOUR) : "possible bug";
        	time +=  time2 * 60;
        }
	}
    
	@Override
	public int compareTo(Object arg0) {
        Time t2 = (Time)arg0;
        float time2 = t2.time;
        TIME_UNIT unit2 = t2.unit;
        
        float retval ;
        
        if (unit == unit2){
        	retval = (time - time2);
        } else if (unit == TIME_UNIT.HOUR && unit2 == TIME_UNIT.MIN){
        	retval = (time * 60 - time2);
        } else {
        	assert (unit == TIME_UNIT.MIN && unit2 == TIME_UNIT.HOUR) : "possible bug";
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
	private DISTANCE_UNIT unit;
    
	Distance(float dist, DISTANCE_UNIT unit) {
        if (dist < 0) {
        	throw new IllegalArgumentException("distance should not be negative: " + dist);
        }
		this.dist = dist;
		this.unit = unit;
	}
    
	float getDist() {
		return dist;
	}

	DISTANCE_UNIT getUnit() {
		return unit;
	}

	public void add(Distance dist2) {
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
	static Time getTime(Distance dist, Speed speed) {
		if (dist.getUnit() == DISTANCE_UNIT.MILES){
			if (speed.getUnit() == SPEED_UNIT.MILESPERHOUR){
                assert speed.getSpeed() > 0 : "speed should be positive";
				return new Time(dist.getDist()/(float)speed.getSpeed(), TIME_UNIT.HOUR);
			}
		}
        throw new IllegalArgumentException("Only miles and hours are supported currently");
	}
}

abstract class Road {
	String name;
	Speed speed;	
    
	Time minimumDrivingTime;

	public Speed getSpeed() {
		return speed;
	}

	public Time getMinimumDrivingTime() {
		return minimumDrivingTime;
	}	
}

class Street extends Road {
	Street(String roadName){
		speed = new Speed(30, SPEED_UNIT.MILESPERHOUR);
        minimumDrivingTime = new Time(0, TIME_UNIT.MIN);
	}
}

class Highway extends Road {
	Highway(String roadName){
		speed = new Speed(65, SPEED_UNIT.MILESPERHOUR);
        minimumDrivingTime = new Time(1, TIME_UNIT.MIN);
	}
}

class RoadFactory {
	static Road getRoad(String roadName, String roadType){
		Road r;
		if ("S".equals(roadType)) {
			 r = new Street(roadName);
		} else if ("H".equals(roadType)) {
			 r = new Highway(roadName);
		} else {
			throw new IllegalArgumentException("road type not supported:" + roadType);
		}
        return r;		
	}
}

class RoadSegment {
	Road road;
	Distance distance;
    
	public RoadSegment(Road road, Distance distance) {
        this.road = road;
        this.distance = distance;
	}

	static RoadSegment getRoadSegment(String roadName, String roadType, float distance){
		Road r = RoadFactory.getRoad(roadName, roadType);
        return new RoadSegment(r, new Distance(distance, DISTANCE_UNIT.MILES));
	}
	
	Time getTime(){
		Time time = DistanceUtils.getTime(distance, road.speed);
		
		if (time.getTime() == 0){
			return time;
		}
		Time minTime = road.getMinimumDrivingTime();
		
        return time.compareTo(minTime) > 0 ? time : minTime;
	}
	
	Distance getDistance(){
		return distance;
	}
}

/**
 * The parser interface. I have written LineParser. We can create other parsers as well like XMLParser
 */
interface Parser {
	RoadSegment getNext();
	boolean hasNext();
    
	void close();
}

class LineParser implements Parser {
	Scanner sc;
    
	public LineParser(InputStream in) {
    	sc = new Scanner(in);
	}

	public LineParser(String str) {
    	sc = new Scanner(str);
	}
    
	@Override
	public RoadSegment getNext() {
        Scanner sc2 = null;
        try {
            String line = sc.nextLine();
            sc2 = new Scanner(line).useDelimiter("[,]");
            String roadName = sc2.next();
            String roadType = sc2.next();
            float dist      = sc2.nextFloat();
            
            //System.out.println("Read: " + roadName + " " + roadType + " " + dist);
    		return RoadSegment.getRoadSegment(roadName, roadType, dist);
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
		 
		Parser parser = new LineParser(stream); //can move into factory method
        
        Distance d = new Distance(0, DISTANCE_UNIT.MILES);
        Time t = new Time(0, TIME_UNIT.HOUR);
		while (parser.hasNext()){
			RoadSegment seg = parser.getNext();
            if (seg == null) break;
			d.add(seg.getDistance());
			t.add(seg.getTime());
		}
        
		parser.close();
        
		out.println("Total distance: " + d);
		out.println("Total time: " + t);
	}
}
