import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

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
	float speed;
	SPEED_UNIT unit;
	public Speed(float speed, SPEED_UNIT unit) {
		this.speed = speed;
		this.unit = unit;
	}	
}

class Time implements Comparable{
	float time;
	TIME_UNIT unit;
	Time(float time, TIME_UNIT unit) {
        this.time = time;
        this.unit = unit;
	}
	@Override
	public int compareTo(Object arg0) {
        Time t2 = (Time)arg0;
        float time2 = t2.time;
        TIME_UNIT unit2 = t2.unit;
        
        if (unit == unit2){
        	return (int)(time - time2);
        }
        if (unit == TIME_UNIT.HOUR && unit2 == TIME_UNIT.MIN){
        	return (int)(time * 60 - time2);
        }
        assert (unit == TIME_UNIT.MIN && unit2 == TIME_UNIT.HOUR) : "possible bug";
        
    	return (int)(time - time2 * 60);
	}
	public void add(Time time2) {
		if (unit == time2.unit){
			time += time2.time; //TODO add getter
		}
        throw new IllegalArgumentException("Only hours unit is supported currently");
	}
}

class Distance {
	float dist;
	DISTANCE_UNIT unit;
	Distance(float dist, DISTANCE_UNIT unit) {
		super();
		this.dist = dist;
		this.unit = unit;
	}
	public void add(Distance dist2) {
		if (unit == dist2.unit){
			dist += dist2.dist; //TODO add getter
		}
        throw new IllegalArgumentException("Only miles unit is supported currently");
	}
    
}

class DistanceUtils {
	static Time getTime(Distance dist, Speed speed) {
		if (dist.unit == DISTANCE_UNIT.MILES){
			if (speed.unit == SPEED_UNIT.MILESPERHOUR){
                assert speed.speed > 0 : "speed should be positive";
				return new Time(dist.dist/(float)speed.speed, TIME_UNIT.HOUR);
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
		// TODO Auto-generated method stub
		return null;
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
		//TODO check for errors
        return new RoadSegment(r, new Distance(distance, DISTANCE_UNIT.MILES));
	}
	
	Time getTime(){
		Time time = DistanceUtils.getTime(distance, road.speed);
		
		Time minTime = road.getMinimumDrivingTime();
		
        return time.compareTo(minTime) > 0 ? time : minTime;
	}
	
	Distance getDistance(){
		return distance;
	}
}

class Route {
	Vector<RoadSegment> roadSegments;
}


interface Parser {
	RoadSegment getNextRoadSegment();
	boolean hasNextRoadSegment();
}

class LineParser implements Parser {
	Scanner sc;
    
	public LineParser(InputStream in) {
    	sc = new Scanner(System.in).useDelimiter(",|\n");
//    	sc = new Scanner(System.in).useDelimiter(",");
	}

	public LineParser(String str) {
    	sc = new Scanner(str).useDelimiter(",|\n");
//    	sc = new Scanner(System.in).useDelimiter(",");
	}
	@Override
	public RoadSegment getNextRoadSegment() {
        //TODO catch exceptions
        String roadName = sc.next();
        String roadType = sc.next();
        float dist = 0;//sc.nextFloat();
        sc.next();
        
        System.out.println("Read " + roadName + roadType + dist);
		return RoadSegment.getRoadSegment(roadName, roadType, dist);
	}

	@Override
	public boolean hasNextRoadSegment() {
		return sc.hasNext();
	}
	
}


public class ComputeDistance {

	public static void main(String[] args) {
		 
		String input = "apple,S,0.5\napple2,H,0.5\napple2,H,1.5";
		
//		Parser parser = new LineParser(System.in);//TODO move into factory method
		Parser parser = new LineParser(input);//TODO move into factory method
        
        Distance d = new Distance(0, DISTANCE_UNIT.MILES);
        Time t = new Time(0, TIME_UNIT.HOUR);
		while (parser.hasNextRoadSegment()){
			RoadSegment seg = parser.getNextRoadSegment();
			d.add(seg.getDistance());
			t.add(seg.getTime());
		}
        
		System.out.println("Total distance:" + d);
		System.out.println("Total time:" + t);
	}
}
