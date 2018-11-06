package domain;

import java.util.LinkedList;
import java.util.Random;

public class TreeNode {
	private Node parent;
	private State currentState;
	private int pathcost;
	private LinkedList<State> action;
	private int d;
	private float f; // value that determines the insertion order in the frontier

	public TreeNode() {

	}

	public TreeNode(Node parent, State currentState, int pathcost, int d, float f, String strategy) {
		super();
		this.parent = parent;
		this.currentState = currentState;
		this.pathcost = pathcost;
		this.d = d;
		Random rnd = new Random();
		if (strategy == "BFS") {
			f = d;
		} else if (strategy.equals("DFS") || strategy.equals("DLS") || strategy.equals("IDS")) {
			f = -d;
		} else if (strategy.equals("UCS")) {
			f = pathcost;
		} else {
			this.f = rnd.nextFloat() * 1000 + 1;
		}
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public int getPathcost() {
		return pathcost;
	}

	public void setPathcost(int pathcost) {
		this.pathcost = pathcost;
	}

	public LinkedList<State> getAction() {
		return action;
	}

	public void setAction(LinkedList<State> action) {
		this.action = action;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public float getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

}
