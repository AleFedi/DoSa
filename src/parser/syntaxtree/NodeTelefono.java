package parser.syntaxtree;

import parser.visitor.IRetArguVisitor;
import parser.visitor.IRetVisitor;
import parser.visitor.IVoidArguVisitor;
import parser.visitor.IVoidVisitor;

public class NodeTelefono implements INode {

	public INode f0;
	public Telefono f1;

	public NodeTelefono() {
		f0 = null;
		f1 = null;
	}

	public boolean present() {
		return (f0 != null);
	}

	public void setF0(INode f0) {
		this.f0 = f0;
	}

	public void setF1(Telefono f1) {
		this.f1 = f1;
	}

	public <R, A> R accept(IRetArguVisitor<R, A> vis, A argu) {
		return vis.visit(this, argu);
	}

	public <R> R accept(IRetVisitor<R> vis) {
		return vis.visit(this);
	}

	public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
		vis.visit(this, argu);
	}

	public void accept(final IVoidVisitor vis) {
		vis.visit(this);
	}
}
