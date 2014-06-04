/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;

public interface IRetArguVisitor<R, A> {

  public R visit(final NodeChoice n, final A argu);

  public R visit(final NodeList n, final A argu);

  public R visit(final NodeListOptional n, final A argu);

  public R visit(final NodeOptional n, final A argu);

  public R visit(final NodeSequence n, final A argu);

  public R visit(final NodeTCF n, final A argu);

  public R visit(final NodeToken n, final A argu);

  public R visit(final Scope n, final A argu);

  public R visit(final Gruppo n, final A argu);

  public R visit(final Donatore n, final A argu);

  public R visit(final Donazione n, final A argu);

  public R visit(final Indirizzo n, final A argu);

  public R visit(final Sezione n, final A argu);

  public R visit(final CodiceFiscale n, final A argu);

  public R visit(final Telefono n, final A argu);

  public R visit(final EMail n, final A argu);

  public R visit(final Idoneo n, final A argu);

  public R visit(final DataProssimaDonazione n, final A argu);

  public R visit(final TipoDonatore n, final A argu);

  public R visit(final TipoDonazione n, final A argu);

  public R visit(final DatiDonatore n, final A argu);

  public R visit(final NumeroDonazioni n, final A argu);

  public R visit(final Nome n, final A argu);

  public R visit(final Cognome n, final A argu);

  public R visit(final Data n, final A argu);

}