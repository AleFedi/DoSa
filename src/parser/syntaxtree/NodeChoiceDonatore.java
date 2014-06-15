package parser.syntaxtree;

public class NodeChoiceDonatore extends NodeChoice {

	public String insert;
	public String value;
	public String getScelta() {
		return scelta;
	}

	public void setScelta(String scelta) {
		this.scelta = scelta;
	}

	public String scelta;

	public NodeChoiceDonatore(INode node) {
		super(node);
	}

	public NodeChoiceDonatore(INode n3, int i, int j) {
		super(n3, i, j);
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
