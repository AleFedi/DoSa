/* Generated by JTB 1.4.7 */
package parser.visitor;

import parser.syntaxtree.*;
import java.util.*;

public class DepthFirstVoidVisitor implements IVoidVisitor {


  public void visit(final NodeChoice n) {
    n.choice.accept(this);
    return;
  }

  public void visit(final NodeList n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeListOptional n) {
    if (n.present()) {
      for (final Iterator<INode> e = n.elements(); e.hasNext();) {
        e.next().accept(this);
        }
      return;
    } else
      return;
  }

  public void visit(final NodeOptional n) {
    if (n.present()) {
      n.node.accept(this);
      return;
    } else
      return;
  }

  public void visit(final NodeSequence n) {
    for (final Iterator<INode> e = n.elements(); e.hasNext();) {
      e.next().accept(this);
    }
    return;
  }

  public void visit(final NodeTCF n) {
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return;
  }

  public void visit(final NodeToken n) {
    @SuppressWarnings("unused")
    final String tkIm = n.tokenImage;
    return;
  }

  public void visit(final Scope n) {
    // f0 -> ( %0 Gruppo()
    // .. .. | %1 Donatore()
    // .. .. | %2 Donazione() )*
    n.f0.accept(this);
    // f1 -> "."
    n.f1.accept(this);
  }

  public void visit(final Gruppo n) {
    // f0 -> "***GRUPPO DONATORI***"
    n.f0.accept(this);
    // f1 -> Nome()
    n.f1.accept(this);
    // f2 -> "- NUMERO:"
    n.f2.accept(this);
    // f3 -> <NUM>
    n.f3.accept(this);
    // f4 -> "- DATA FONDAZIONE:"
    n.f4.accept(this);
    // f5 -> Data()
    n.f5.accept(this);
    // f6 -> Indirizzo()
    n.f6.accept(this);
    // f7 -> "- PRESIDENTE:"
    n.f7.accept(this);
    // f8 -> Nome()
    n.f8.accept(this);
    // f9 -> "-"
    n.f9.accept(this);
    // f10 -> Cognome()
    n.f10.accept(this);
    // f11 -> "- SEGRETARIO:"
    n.f11.accept(this);
    // f12 -> Nome()
    n.f12.accept(this);
    // f13 -> "-"
    n.f13.accept(this);
    // f14 -> Cognome()
    n.f14.accept(this);
    // f15 -> "- NUMERO ISCRITTI:"
    n.f15.accept(this);
    // f16 -> <NUM>
    n.f16.accept(this);
    // f17 -> [ Sezione() ]
    n.f17.accept(this);
    // f18 -> ";"
    n.f18.accept(this);
  }

  public void visit(final Donatore n) {
    // f0 -> "***DONATORE***"
    n.f0.accept(this);
    // f1 -> Nome()
    n.f1.accept(this);
    // f2 -> Cognome()
    n.f2.accept(this);
    // f3 -> "- SESSO:"
    n.f3.accept(this);
    // f4 -> <SESSO>
    n.f4.accept(this);
    // f5 -> "- DATA NASCITA:"
    n.f5.accept(this);
    // f6 -> Data()
    n.f6.accept(this);
    // f7 -> "- STATO NASCITA:"
    n.f7.accept(this);
    // f8 -> <IDENTIFICATOR>
    n.f8.accept(this);
    // f9 -> [ CodiceFiscale() ]
    n.f9.accept(this);
    // f10 -> Indirizzo()
    n.f10.accept(this);
    // f11 -> [ #0 "- TELEFONO FISSO:" #1 Telefono() ]
    n.f11.accept(this);
    // f12 -> [ #0 "- TELEFONO CELLULARE:" #1 Telefono() ]
    n.f12.accept(this);
    // f13 -> [ EMail() ]
    n.f13.accept(this);
    // f14 -> "- CITTADINANZA:"
    n.f14.accept(this);
    // f15 -> <IDENTIFICATOR>
    n.f15.accept(this);
    // f16 -> "- GRUPPO SANGUIGNO:"
    n.f16.accept(this);
    // f17 -> <GRUPPOSANGUIGNO>
    n.f17.accept(this);
    // f18 -> "- RH:"
    n.f18.accept(this);
    // f19 -> <RH>
    n.f19.accept(this);
    // f20 -> "- DATA ISCRIZIONE:"
    n.f20.accept(this);
    // f21 -> Data()
    n.f21.accept(this);
    // f22 -> "- GRUPPO LOCALE:"
    n.f22.accept(this);
    // f23 -> <NUM>
    n.f23.accept(this);
    // f24 -> "- TESSERA GRUPPO LOCALE:"
    n.f24.accept(this);
    // f25 -> <NUM>
    n.f25.accept(this);
    // f26 -> NumeroDonazioni()
    n.f26.accept(this);
    // f27 -> Idoneo()
    n.f27.accept(this);
    // f28 -> DataProssimaDonazione()
    n.f28.accept(this);
    // f29 -> TipoDonatore()
    n.f29.accept(this);
    // f30 -> Sezione()
    n.f30.accept(this);
    // f31 -> ";"
    n.f31.accept(this);
  }

  public void visit(final Donazione n) {
    // f0 -> "***DONAZIONE***"
    n.f0.accept(this);
    // f1 -> DatiDonatore()
    n.f1.accept(this);
    // f2 -> "- DATA DONAZIONE:"
    n.f2.accept(this);
    // f3 -> Data()
    n.f3.accept(this);
    // f4 -> TipoDonazione()
    n.f4.accept(this);
    // f5 -> "- UNITA' RACCOLTA:"
    n.f5.accept(this);
    // f6 -> <UNITARACCOLTA>
    n.f6.accept(this);
    // f7 -> "- COMUNE DONAZIONE:"
    n.f7.accept(this);
    // f8 -> <IDENTIFICATOR>
    n.f8.accept(this);
    // f9 -> "- ASL DONAZIONE:"
    n.f9.accept(this);
    // f10 -> ( %0 <IDENTIFICATOR>
    // ... .. | %1 <NUM> )*
    n.f10.accept(this);
    // f11 -> "- PUNTO PRELIEVO:"
    n.f11.accept(this);
    // f12 -> <NUM>
    n.f12.accept(this);
    // f13 -> ";"
    n.f13.accept(this);
  }

  public void visit(final Indirizzo n) {
    // f0 -> "- INDIRIZZO:"
    n.f0.accept(this);
    // f1 -> <IDENTIFICATOR>
    n.f1.accept(this);
    // f2 -> ( %0 <IDENTIFICATOR>
    // .. .. | %1 <NUM> )*
    n.f2.accept(this);
    // f3 -> "- CAP:"
    n.f3.accept(this);
    // f4 -> <NUM>
    n.f4.accept(this);
    // f5 -> "- COMUNE:"
    n.f5.accept(this);
    // f6 -> <IDENTIFICATOR>
    n.f6.accept(this);
    // f7 -> [ #0 "- STATO:" #1 <IDENTIFICATOR> ]
    n.f7.accept(this);
  }

  public void visit(final Sezione n) {
    // f0 -> "- SEZIONE:"
    n.f0.accept(this);
    // f1 -> [ <IDENTIFICATOR> ]
    n.f1.accept(this);
    // f2 -> [ <NUM> ]
    n.f2.accept(this);
    // f3 -> ( #0 "-"
    // .. .. . #1 [ <IDENTIFICATOR> ]
    // .. .. . #2 [ <NUM> ] )*
    n.f3.accept(this);
  }

  public void visit(final CodiceFiscale n) {
    // f0 -> "- CODICE FISCALE:"
    n.f0.accept(this);
    // f1 -> ( %0 <IDENTIFICATOR>
    // .. .. | %1 <NUM> )*
    n.f1.accept(this);
  }

  public void visit(final Telefono n) {
    // f0 -> <NUM>
    n.f0.accept(this);
    // f1 -> [ #0 "/" #1 <NUM> ]
    n.f1.accept(this);
  }

  public void visit(final EMail n) {
    // f0 -> "- EMAIL:"
    n.f0.accept(this);
    // f1 -> <EMAIL>
    n.f1.accept(this);
  }

  public void visit(final Idoneo n) {
    // f0 -> "- IDONEO:"
    n.f0.accept(this);
    // f1 -> <IDONEITA>
    n.f1.accept(this);
  }

  public void visit(final DataProssimaDonazione n) {
    // f0 -> "- PROSSIMA DATA DISPONIBILE PER DONAZIONE:"
    n.f0.accept(this);
    // f1 -> Data()
    n.f1.accept(this);
  }

  public void visit(final TipoDonatore n) {
    // f0 -> "- TIPOLOGIA DONATORE:"
    n.f0.accept(this);
    // f1 -> <TIPO>
    n.f1.accept(this);
  }

  public void visit(final TipoDonazione n) {
    // f0 -> "- TIPO DI DONAZIONE:"
    n.f0.accept(this);
    // f1 -> <TIPODONAZIONE>
    n.f1.accept(this);
  }

  public void visit(final DatiDonatore n) {
    // f0 -> "- DONATORE:"
    n.f0.accept(this);
    // f1 -> ( %0 #0 Nome() #1 "-" #2 Cognome()
    // .. .. | %1 CodiceFiscale() )
    n.f1.accept(this);
  }

  public void visit(final NumeroDonazioni n) {
    // f0 -> "- NUMERO DI DONAZIONI:"
    n.f0.accept(this);
    // f1 -> <NUM>
    n.f1.accept(this);
  }

  public void visit(final Nome n) {
    // f0 -> ( %0 "Nome:"
    // .. .. | %1 "- NOME:" )
    n.f0.accept(this);
    // f1 -> <IDENTIFICATOR>
    n.f1.accept(this);
  }

  public void visit(final Cognome n) {
    // f0 -> ( %0 "Cognome:"
    // .. .. | %1 "- COGNOME:" )
    n.f0.accept(this);
    // f1 -> <IDENTIFICATOR>
    n.f1.accept(this);
  }

  public void visit(final Data n) {
    // f0 -> <NUM>
    n.f0.accept(this);
    // f1 -> "/"
    n.f1.accept(this);
    // f2 -> <NUM>
    n.f2.accept(this);
    // f3 -> "/"
    n.f3.accept(this);
    // f4 -> <NUM>
    n.f4.accept(this);
  }

}
