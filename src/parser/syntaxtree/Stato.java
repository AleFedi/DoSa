package parser.syntaxtree;

import parser.visitor.IRetArguVisitor;
import parser.visitor.IRetVisitor;
import parser.visitor.IVoidArguVisitor;
import parser.visitor.IVoidVisitor;

public class Stato implements INode {
	public NodeToken f0;
	public NodeToken f1;

	public Stato() {
		f0 = null;
		f1 = null;
	}

	public Stato(NodeToken f0, NodeToken f1) {
		this.f0 = f0;
		this.f1 = f1;
	}

	public boolean present() {
		return (f0 != null);
	}

	public void setF0(NodeToken f0) {
		this.f0 = f0;
	}

	public void setF1(NodeToken f1) {
		this.f1 = f1;
	}

	public <R, A> R accept(IRetArguVisitor<R, A> vis, A argu) {
		return vis.visit(this, argu);
	}

	public <R> R accept(IRetVisitor<R> vis) {
		return vis.visit(this);
	}

	public <A> void accept(IVoidArguVisitor<A> vis, A argu) {
		vis.visit(this, argu);

	}

	public void accept(IVoidVisitor vis) {
		vis.visit(this);
	}

}
