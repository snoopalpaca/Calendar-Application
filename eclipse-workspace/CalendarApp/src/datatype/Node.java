package datatype;

public abstract class Node {
	private String label;
	private Integer currentID;
	private Integer parentID;
	
	public Node() {
		this.label = "unknown";
		this.currentID = 0;
		this.parentID = 0;
	}
	public Node(String name, Integer ID, Integer parentID){
		this.label = name;
		this.currentID = ID;
		this.parentID = parentID;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Integer getID() {
		return currentID;
	}
	public void setID(Integer iD) {
		currentID = iD;
	}
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	
}

