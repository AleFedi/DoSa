/* Generated by JTB 1.4.7 */
package parser.syntaxtree;

import parser.visitor.*;

public class Indirizzo implements INode {

  public NodeToken f0;

  public NodeToken f1;

  public NodeListOptional f2;

  public NodeToken f3;

  public NodeToken f4;

  public NodeToken f5;

  public NodeToken f6;

  public NodeOptional f7;

  private static final long serialVersionUID = 147L;

  public Indirizzo(final NodeToken n0, final NodeToken n1, final NodeListOptional n2, final NodeToken n3, final NodeToken n4, final NodeToken n5, final NodeToken n6, final NodeOptional n7) {
    f0 = n0;
    f1 = n1;
    f2 = n2;
    f3 = n3;
    f4 = n4;
    f5 = n5;
    f6 = n6;
    f7 = n7;
  }

  public <R, A> R accept(final IRetArguVisitor<R, A> vis, final A argu) {
    return vis.visit(this, argu);
  }

  public <R> R accept(final IRetVisitor<R> vis) {
    return vis.visit(this);
  }

  public <A> void accept(final IVoidArguVisitor<A> vis, final A argu) {
    vis.visit(this, argu);
  }

  public void accept(final IVoidVisitor vis) {
    vis.visit(this);
  }

}
