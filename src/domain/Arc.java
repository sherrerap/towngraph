package domain;

public class Arc {

	private String id;
	private String source;
	private String target;
	private String name = "Unnamed";
	private String distance;

	public Arc(String id, String source, String target, String name, String distance) {
		this.id = id;
		this.source = source;
		this.target = target;
		this.name = name;
		this.distance = distance;
	}

	public Arc() {

	}

	public String getID() {
		return id;
	}

	public String getSource() {
		return source;
	}

	public String getTarget() {
		return target;
	}

	public void setSource(String id) {
		this.source = id;
	}

	public void setTarget(String id) {
		this.target = id;
	}

	public String getName() {
		return name;
	}

	public String getDistance() {
		return distance;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}