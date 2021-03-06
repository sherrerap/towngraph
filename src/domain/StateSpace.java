package domain;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class StateSpace {
	private TSFGraph g;

	private LinkedList<State> states = new LinkedList<State>();

	public StateSpace(String filename) throws IOException, ParserConfigurationException, SAXException {
		g = new TSFGraph(filename);
	}

	public StateSpace() {
	}

	public LinkedList<Object[]> successors(State s) {
		LinkedList<Node> adj = g.adjacentNodes(s.getActualNode().getID());
		LinkedList<Node> o_list = s.getN_list();
		LinkedList<Node> n_list = new LinkedList<>();
		Object[] auxReturn = new Object[3];
		LinkedList<Object[]> toReturn = new LinkedList<Object[]>();
		LinkedList<Node> aux_list = new LinkedList<>();
		Arc ar = new Arc();
		State st = new State();

		for (Node a : adj) {
			auxReturn = new Object[3];
			n_list = new LinkedList<>();
			aux_list = new LinkedList<>();

			// Copying the content of the parent list for security
			for (Node i : o_list) {
				Node aux = (i);
				n_list.add(i);
				aux_list.add(i);
			}

			String a1 = "I am in " + s.getActualNode().getID() + " and I go to " + a.getID();
			st = new State(a, n_list);
			ar = g.returnArc(s.getActualNode().getID() + " " + a.getID());

			// aux_list = st.getN_list();
			for (Node b : aux_list) {
				if (b.getID().equals(st.getActualNode().getID())) {
					st.getN_list().remove(b);
				}
			}

			auxReturn[0] = (Object) a1;
			auxReturn[1] = (Object) st;
			auxReturn[2] = (Object) ar.getDistance();
			toReturn.add(auxReturn);
		}
		return toReturn;
	}

	public boolean belongNode(State s) {
		for (State a : states) {
			if (a.getActualNode().getID().equals(s.getActualNode().getID()))
				return true;
		}
		return false;
	}

	public TSFGraph getGraph() {
		return g;
	}
}
