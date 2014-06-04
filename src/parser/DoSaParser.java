/* Generated By:JavaCC: Do not edit this line. DoSaParser.java */
package parser;

import parser.visitor.*;
import parser.syntaxtree.*;

public class DoSaParser implements DoSaParserConstants {

	public static void main(String args[]) {
		System.out.println("Inserire i dati");
		new DoSaParser(System.in);
		try {
			Scope scope = DoSaParser.Scope();
			DepthFirstVoidVisitor v = new MyVisitor();
			scope.accept(v);
		} catch (Exception e) {
			System.out.println("Oops.");
			System.out.println(e.getMessage());
		}
	}

	static final public Scope Scope() throws ParseException {
		// --- JTB generated node declarations ---
		NodeListOptional n0 = new NodeListOptional();
		NodeChoice n1 = null;
		Gruppo n2 = null;
		Donatore n3 = null;
		Donazione n4 = null;
		NodeToken n5 = null;
		Token n6 = null;
		label_1: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case 18:
			case 26:
			case 38:
				;
				break;
			default:
				jj_la1[0] = jj_gen;
				break label_1;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case 18:
				n2 = Gruppo();
				n1 = new NodeChoice(n2, 0, 3);
				break;
			case 26:
				n3 = Donatore();
				n1 = new NodeChoice(n3, 1, 3);
				break;
			case 38:
				n4 = Donazione();
				n1 = new NodeChoice(n4, 2, 3);
				break;
			default:
				jj_la1[1] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			n0.addNode(n1);
		}
		n0.nodes.trimToSize();
		n6 = jj_consume_token(17);
		n5 = JTBToolkit.makeNodeToken(n6);
		{
			if (true)
				return new Scope(n0, n5);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Gruppo Gruppo() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		Nome n2 = null;
		NodeToken n3 = null;
		Token n4 = null;
		NodeToken n5 = null;
		Token n6 = null;
		NodeToken n7 = null;
		Token n8 = null;
		Data n9 = null;
		Indirizzo n10 = null;
		NodeToken n11 = null;
		Token n12 = null;
		Nome n13 = null;
		NodeToken n14 = null;
		Token n15 = null;
		Cognome n16 = null;
		NodeToken n17 = null;
		Token n18 = null;
		Nome n19 = null;
		NodeToken n20 = null;
		Token n21 = null;
		Cognome n22 = null;
		NodeToken n23 = null;
		Token n24 = null;
		NodeToken n25 = null;
		Token n26 = null;
		NodeOptional n27 = new NodeOptional();
		Sezione n28 = null;
		NodeToken n29 = null;
		Token n30 = null;
		n1 = jj_consume_token(18);
		n0 = JTBToolkit.makeNodeToken(n1);
		n2 = Nome();
		n4 = jj_consume_token(19);
		n3 = JTBToolkit.makeNodeToken(n4);
		n6 = jj_consume_token(NUM);
		n5 = JTBToolkit.makeNodeToken(n6);
		n8 = jj_consume_token(20);
		n7 = JTBToolkit.makeNodeToken(n8);
		n9 = Data();
		n10 = Indirizzo();
		n12 = jj_consume_token(21);
		n11 = JTBToolkit.makeNodeToken(n12);
		n13 = Nome();
		n15 = jj_consume_token(22);
		n14 = JTBToolkit.makeNodeToken(n15);
		n16 = Cognome();
		n18 = jj_consume_token(23);
		n17 = JTBToolkit.makeNodeToken(n18);
		n19 = Nome();
		n21 = jj_consume_token(22);
		n20 = JTBToolkit.makeNodeToken(n21);
		n22 = Cognome();
		n24 = jj_consume_token(24);
		n23 = JTBToolkit.makeNodeToken(n24);
		n26 = jj_consume_token(NUM);
		n25 = JTBToolkit.makeNodeToken(n26);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 48:
			n28 = Sezione();
			n27.addNode(n28);
			break;
		default:
			jj_la1[2] = jj_gen;
			;
		}
		n30 = jj_consume_token(25);
		n29 = JTBToolkit.makeNodeToken(n30);
		{
			if (true)
				return new Gruppo(n0, n2, n3, n5, n7, n9, n10, n11, n13, n14,
						n16, n17, n19, n20, n22, n23, n25, n27, n29);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Donatore Donatore() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		Nome n2 = null;
		Cognome n3 = null;
		NodeToken n4 = null;
		Token n5 = null;
		NodeToken n6 = null;
		Token n7 = null;
		NodeToken n8 = null;
		Token n9 = null;
		Data n10 = null;
		NodeToken n11 = null;
		Token n12 = null;
		NodeToken n13 = null;
		Token n14 = null;
		NodeOptional n15 = new NodeOptional();
		CodiceFiscale n16 = null;
		Indirizzo n17 = null;
		NodeOptional n18 = new NodeOptional();
		NodeSequence n19 = null;
		NodeToken n20 = null;
		Token n21 = null;
		Telefono n22 = null;
		NodeOptional n23 = new NodeOptional();
		NodeSequence n24 = null;
		NodeToken n25 = null;
		Token n26 = null;
		Telefono n27 = null;
		NodeOptional n28 = new NodeOptional();
		EMail n29 = null;
		NodeToken n30 = null;
		Token n31 = null;
		NodeToken n32 = null;
		Token n33 = null;
		NodeToken n34 = null;
		Token n35 = null;
		NodeToken n36 = null;
		Token n37 = null;
		NodeToken n38 = null;
		Token n39 = null;
		NodeToken n40 = null;
		Token n41 = null;
		NodeToken n42 = null;
		Token n43 = null;
		Data n44 = null;
		NodeToken n45 = null;
		Token n46 = null;
		NodeToken n47 = null;
		Token n48 = null;
		NodeToken n49 = null;
		Token n50 = null;
		NodeToken n51 = null;
		Token n52 = null;
		NumeroDonazioni n53 = null;
		Idoneo n54 = null;
		DataProssimaDonazione n55 = null;
		TipoDonatore n56 = null;
		Sezione n57 = null;
		NodeToken n58 = null;
		Token n59 = null;
		n1 = jj_consume_token(26);
		n0 = JTBToolkit.makeNodeToken(n1);
		n2 = Nome();
		n3 = Cognome();
		n5 = jj_consume_token(27);
		n4 = JTBToolkit.makeNodeToken(n5);
		n7 = jj_consume_token(SESSO);
		n6 = JTBToolkit.makeNodeToken(n7);
		n9 = jj_consume_token(28);
		n8 = JTBToolkit.makeNodeToken(n9);
		n10 = Data();
		n12 = jj_consume_token(29);
		n11 = JTBToolkit.makeNodeToken(n12);
		n14 = jj_consume_token(IDENTIFICATOR);
		n13 = JTBToolkit.makeNodeToken(n14);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 49:
			n16 = CodiceFiscale();
			n15.addNode(n16);
			break;
		default:
			jj_la1[3] = jj_gen;
			;
		}
		n17 = Indirizzo();
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 30:
			n19 = new NodeSequence(2);
			n21 = jj_consume_token(30);
			n20 = JTBToolkit.makeNodeToken(n21);
			n19.addNode(n20);
			n22 = Telefono();
			n19.addNode(n22);
			n18.addNode(n19);
			break;
		default:
			jj_la1[4] = jj_gen;
			;
		}
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 31:
			n24 = new NodeSequence(2);
			n26 = jj_consume_token(31);
			n25 = JTBToolkit.makeNodeToken(n26);
			n24.addNode(n25);
			n27 = Telefono();
			n24.addNode(n27);
			n23.addNode(n24);
			break;
		default:
			jj_la1[5] = jj_gen;
			;
		}
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 51:
			n29 = EMail();
			n28.addNode(n29);
			break;
		default:
			jj_la1[6] = jj_gen;
			;
		}
		n31 = jj_consume_token(32);
		n30 = JTBToolkit.makeNodeToken(n31);
		n33 = jj_consume_token(IDENTIFICATOR);
		n32 = JTBToolkit.makeNodeToken(n33);
		n35 = jj_consume_token(33);
		n34 = JTBToolkit.makeNodeToken(n35);
		n37 = jj_consume_token(GRUPPOSANGUIGNO);
		n36 = JTBToolkit.makeNodeToken(n37);
		n39 = jj_consume_token(34);
		n38 = JTBToolkit.makeNodeToken(n39);
		n41 = jj_consume_token(RH);
		n40 = JTBToolkit.makeNodeToken(n41);
		n43 = jj_consume_token(35);
		n42 = JTBToolkit.makeNodeToken(n43);
		n44 = Data();
		n46 = jj_consume_token(36);
		n45 = JTBToolkit.makeNodeToken(n46);
		n48 = jj_consume_token(NUM);
		n47 = JTBToolkit.makeNodeToken(n48);
		n50 = jj_consume_token(37);
		n49 = JTBToolkit.makeNodeToken(n50);
		n52 = jj_consume_token(NUM);
		n51 = JTBToolkit.makeNodeToken(n52);
		n53 = NumeroDonazioni();
		n54 = Idoneo();
		n55 = DataProssimaDonazione();
		n56 = TipoDonatore();
		n57 = Sezione();
		n59 = jj_consume_token(25);
		n58 = JTBToolkit.makeNodeToken(n59);
		{
			if (true)
				return new Donatore(n0, n2, n3, n4, n6, n8, n10, n11, n13, n15,
						n17, n18, n23, n28, n30, n32, n34, n36, n38, n40, n42,
						n44, n45, n47, n49, n51, n53, n54, n55, n56, n57, n58);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Donazione Donazione() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		DatiDonatore n2 = null;
		NodeToken n3 = null;
		Token n4 = null;
		Data n5 = null;
		TipoDonazione n6 = null;
		NodeToken n7 = null;
		Token n8 = null;
		NodeToken n9 = null;
		Token n10 = null;
		NodeToken n11 = null;
		Token n12 = null;
		NodeToken n13 = null;
		Token n14 = null;
		NodeToken n15 = null;
		Token n16 = null;
		NodeListOptional n17 = new NodeListOptional();
		NodeChoice n18 = null;
		NodeToken n19 = null;
		Token n20 = null;
		NodeToken n21 = null;
		Token n22 = null;
		NodeToken n23 = null;
		Token n24 = null;
		NodeToken n25 = null;
		Token n26 = null;
		NodeToken n27 = null;
		Token n28 = null;
		n1 = jj_consume_token(38);
		n0 = JTBToolkit.makeNodeToken(n1);
		n2 = DatiDonatore();
		n4 = jj_consume_token(39);
		n3 = JTBToolkit.makeNodeToken(n4);
		n5 = Data();
		n6 = TipoDonazione();
		n8 = jj_consume_token(40);
		n7 = JTBToolkit.makeNodeToken(n8);
		n10 = jj_consume_token(UNITARACCOLTA);
		n9 = JTBToolkit.makeNodeToken(n10);
		n12 = jj_consume_token(41);
		n11 = JTBToolkit.makeNodeToken(n12);
		n14 = jj_consume_token(IDENTIFICATOR);
		n13 = JTBToolkit.makeNodeToken(n14);
		n16 = jj_consume_token(42);
		n15 = JTBToolkit.makeNodeToken(n16);
		label_2: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
			case NUM:
				;
				break;
			default:
				jj_la1[7] = jj_gen;
				break label_2;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
				n20 = jj_consume_token(IDENTIFICATOR);
				n19 = JTBToolkit.makeNodeToken(n20);
				n18 = new NodeChoice(n19, 0, 2);
				break;
			case NUM:
				n22 = jj_consume_token(NUM);
				n21 = JTBToolkit.makeNodeToken(n22);
				n18 = new NodeChoice(n21, 1, 2);
				break;
			default:
				jj_la1[8] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			n17.addNode(n18);
		}
		n17.nodes.trimToSize();
		n24 = jj_consume_token(43);
		n23 = JTBToolkit.makeNodeToken(n24);
		n26 = jj_consume_token(NUM);
		n25 = JTBToolkit.makeNodeToken(n26);
		n28 = jj_consume_token(25);
		n27 = JTBToolkit.makeNodeToken(n28);
		{
			if (true)
				return new Donazione(n0, n2, n3, n5, n6, n7, n9, n11, n13, n15,
						n17, n23, n25, n27);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Indirizzo Indirizzo() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		NodeListOptional n4 = new NodeListOptional();
		NodeChoice n5 = null;
		NodeToken n6 = null;
		Token n7 = null;
		NodeToken n8 = null;
		Token n9 = null;
		NodeToken n10 = null;
		Token n11 = null;
		NodeToken n12 = null;
		Token n13 = null;
		NodeToken n14 = null;
		Token n15 = null;
		NodeToken n16 = null;
		Token n17 = null;
		NodeOptional n18 = new NodeOptional();
		NodeSequence n19 = null;
		NodeToken n20 = null;
		Token n21 = null;
		NodeToken n22 = null;
		Token n23 = null;
		n1 = jj_consume_token(44);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(IDENTIFICATOR);
		n2 = JTBToolkit.makeNodeToken(n3);
		label_3: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
			case NUM:
				;
				break;
			default:
				jj_la1[9] = jj_gen;
				break label_3;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
				n7 = jj_consume_token(IDENTIFICATOR);
				n6 = JTBToolkit.makeNodeToken(n7);
				n5 = new NodeChoice(n6, 0, 2);
				break;
			case NUM:
				n9 = jj_consume_token(NUM);
				n8 = JTBToolkit.makeNodeToken(n9);
				n5 = new NodeChoice(n8, 1, 2);
				break;
			default:
				jj_la1[10] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			n4.addNode(n5);
		}
		n4.nodes.trimToSize();
		n11 = jj_consume_token(45);
		n10 = JTBToolkit.makeNodeToken(n11);
		n13 = jj_consume_token(NUM);
		n12 = JTBToolkit.makeNodeToken(n13);
		n15 = jj_consume_token(46);
		n14 = JTBToolkit.makeNodeToken(n15);
		n17 = jj_consume_token(IDENTIFICATOR);
		n16 = JTBToolkit.makeNodeToken(n17);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 47:
			n19 = new NodeSequence(2);
			n21 = jj_consume_token(47);
			n20 = JTBToolkit.makeNodeToken(n21);
			n19.addNode(n20);
			n23 = jj_consume_token(IDENTIFICATOR);
			n22 = JTBToolkit.makeNodeToken(n23);
			n19.addNode(n22);
			n18.addNode(n19);
			break;
		default:
			jj_la1[11] = jj_gen;
			;
		}
		{
			if (true)
				return new Indirizzo(n0, n2, n4, n10, n12, n14, n16, n18);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Sezione Sezione() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeOptional n2 = new NodeOptional();
		NodeToken n3 = null;
		Token n4 = null;
		NodeOptional n5 = new NodeOptional();
		NodeToken n6 = null;
		Token n7 = null;
		NodeListOptional n8 = new NodeListOptional();
		NodeSequence n9 = null;
		NodeToken n10 = null;
		Token n11 = null;
		NodeOptional n12 = null;
		NodeToken n13 = null;
		Token n14 = null;
		NodeOptional n15 = null;
		NodeToken n16 = null;
		Token n17 = null;
		n1 = jj_consume_token(48);
		n0 = JTBToolkit.makeNodeToken(n1);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case IDENTIFICATOR:
			n4 = jj_consume_token(IDENTIFICATOR);
			n3 = JTBToolkit.makeNodeToken(n4);
			n2.addNode(n3);
			break;
		default:
			jj_la1[12] = jj_gen;
			;
		}
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case NUM:
			n7 = jj_consume_token(NUM);
			n6 = JTBToolkit.makeNodeToken(n7);
			n5.addNode(n6);
			break;
		default:
			jj_la1[13] = jj_gen;
			;
		}
		label_4: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case 22:
				;
				break;
			default:
				jj_la1[14] = jj_gen;
				break label_4;
			}
			n12 = new NodeOptional();
			n15 = new NodeOptional();
			n9 = new NodeSequence(3);
			n11 = jj_consume_token(22);
			n10 = JTBToolkit.makeNodeToken(n11);
			n9.addNode(n10);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
				n14 = jj_consume_token(IDENTIFICATOR);
				n13 = JTBToolkit.makeNodeToken(n14);
				n12.addNode(n13);
				break;
			default:
				jj_la1[15] = jj_gen;
				;
			}
			n9.addNode(n12);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case NUM:
				n17 = jj_consume_token(NUM);
				n16 = JTBToolkit.makeNodeToken(n17);
				n15.addNode(n16);
				break;
			default:
				jj_la1[16] = jj_gen;
				;
			}
			n9.addNode(n15);
			n8.addNode(n9);
		}
		n8.nodes.trimToSize();
		{
			if (true)
				return new Sezione(n0, n2, n5, n8);
		}
		throw new Error("Missing return statement in function");
	}

	static final public CodiceFiscale CodiceFiscale() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeListOptional n2 = new NodeListOptional();
		NodeChoice n3 = null;
		NodeToken n4 = null;
		Token n5 = null;
		NodeToken n6 = null;
		Token n7 = null;
		n1 = jj_consume_token(49);
		n0 = JTBToolkit.makeNodeToken(n1);
		label_5: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
			case NUM:
				;
				break;
			default:
				jj_la1[17] = jj_gen;
				break label_5;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case IDENTIFICATOR:
				n5 = jj_consume_token(IDENTIFICATOR);
				n4 = JTBToolkit.makeNodeToken(n5);
				n3 = new NodeChoice(n4, 0, 2);
				break;
			case NUM:
				n7 = jj_consume_token(NUM);
				n6 = JTBToolkit.makeNodeToken(n7);
				n3 = new NodeChoice(n6, 1, 2);
				break;
			default:
				jj_la1[18] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			n2.addNode(n3);
		}
		n2.nodes.trimToSize();
		{
			if (true)
				return new CodiceFiscale(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Telefono Telefono() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeOptional n2 = new NodeOptional();
		NodeSequence n3 = null;
		NodeToken n4 = null;
		Token n5 = null;
		NodeToken n6 = null;
		Token n7 = null;
		n1 = jj_consume_token(NUM);
		n0 = JTBToolkit.makeNodeToken(n1);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 50:
			n3 = new NodeSequence(2);
			n5 = jj_consume_token(50);
			n4 = JTBToolkit.makeNodeToken(n5);
			n3.addNode(n4);
			n7 = jj_consume_token(NUM);
			n6 = JTBToolkit.makeNodeToken(n7);
			n3.addNode(n6);
			n2.addNode(n3);
			break;
		default:
			jj_la1[19] = jj_gen;
			;
		}
		{
			if (true)
				return new Telefono(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public EMail EMail() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		n1 = jj_consume_token(51);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(EMAIL);
		n2 = JTBToolkit.makeNodeToken(n3);
		{
			if (true)
				return new EMail(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Idoneo Idoneo() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		n1 = jj_consume_token(52);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(IDONEITA);
		n2 = JTBToolkit.makeNodeToken(n3);
		{
			if (true)
				return new Idoneo(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public DataProssimaDonazione DataProssimaDonazione()
			throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		Data n2 = null;
		n1 = jj_consume_token(53);
		n0 = JTBToolkit.makeNodeToken(n1);
		n2 = Data();
		{
			if (true)
				return new DataProssimaDonazione(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public TipoDonatore TipoDonatore() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		n1 = jj_consume_token(54);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(TIPO);
		n2 = JTBToolkit.makeNodeToken(n3);
		{
			if (true)
				return new TipoDonatore(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public TipoDonazione TipoDonazione() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		n1 = jj_consume_token(55);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(TIPODONAZIONE);
		n2 = JTBToolkit.makeNodeToken(n3);
		{
			if (true)
				return new TipoDonazione(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public DatiDonatore DatiDonatore() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeChoice n2 = null;
		NodeSequence n3 = null;
		Nome n4 = null;
		NodeToken n5 = null;
		Token n6 = null;
		Cognome n7 = null;
		CodiceFiscale n8 = null;
		n1 = jj_consume_token(56);
		n0 = JTBToolkit.makeNodeToken(n1);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 58:
		case 59:
			n3 = new NodeSequence(3);
			n4 = Nome();
			n3.addNode(n4);
			n6 = jj_consume_token(22);
			n5 = JTBToolkit.makeNodeToken(n6);
			n3.addNode(n5);
			n7 = Cognome();
			n3.addNode(n7);
			n2 = new NodeChoice(n3, 0, 2);
			break;
		case 49:
			n8 = CodiceFiscale();
			n2 = new NodeChoice(n8, 1, 2);
			break;
		default:
			jj_la1[20] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		{
			if (true)
				return new DatiDonatore(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public NumeroDonazioni NumeroDonazioni() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		n1 = jj_consume_token(57);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(NUM);
		n2 = JTBToolkit.makeNodeToken(n3);
		{
			if (true)
				return new NumeroDonazioni(n0, n2);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Nome Nome() throws ParseException {
		// --- JTB generated node declarations ---
		NodeChoice n0 = null;
		NodeToken n1 = null;
		Token n2 = null;
		NodeToken n3 = null;
		Token n4 = null;
		NodeToken n5 = null;
		Token n6 = null;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 58:
			n2 = jj_consume_token(58);
			n1 = JTBToolkit.makeNodeToken(n2);
			n0 = new NodeChoice(n1, 0, 2);
			break;
		case 59:
			n4 = jj_consume_token(59);
			n3 = JTBToolkit.makeNodeToken(n4);
			n0 = new NodeChoice(n3, 1, 2);
			break;
		default:
			jj_la1[21] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		n6 = jj_consume_token(IDENTIFICATOR);
		n5 = JTBToolkit.makeNodeToken(n6);
		{
			if (true)
				return new Nome(n0, n5);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Cognome Cognome() throws ParseException {
		// --- JTB generated node declarations ---
		NodeChoice n0 = null;
		NodeToken n1 = null;
		Token n2 = null;
		NodeToken n3 = null;
		Token n4 = null;
		NodeToken n5 = null;
		Token n6 = null;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case 60:
			n2 = jj_consume_token(60);
			n1 = JTBToolkit.makeNodeToken(n2);
			n0 = new NodeChoice(n1, 0, 2);
			break;
		case 61:
			n4 = jj_consume_token(61);
			n3 = JTBToolkit.makeNodeToken(n4);
			n0 = new NodeChoice(n3, 1, 2);
			break;
		default:
			jj_la1[22] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		n6 = jj_consume_token(IDENTIFICATOR);
		n5 = JTBToolkit.makeNodeToken(n6);
		{
			if (true)
				return new Cognome(n0, n5);
		}
		throw new Error("Missing return statement in function");
	}

	static final public Data Data() throws ParseException {
		// --- JTB generated node declarations ---
		NodeToken n0 = null;
		Token n1 = null;
		NodeToken n2 = null;
		Token n3 = null;
		NodeToken n4 = null;
		Token n5 = null;
		NodeToken n6 = null;
		Token n7 = null;
		NodeToken n8 = null;
		Token n9 = null;
		n1 = jj_consume_token(NUM);
		n0 = JTBToolkit.makeNodeToken(n1);
		n3 = jj_consume_token(50);
		n2 = JTBToolkit.makeNodeToken(n3);
		n5 = jj_consume_token(NUM);
		n4 = JTBToolkit.makeNodeToken(n5);
		n7 = jj_consume_token(50);
		n6 = JTBToolkit.makeNodeToken(n7);
		n9 = jj_consume_token(NUM);
		n8 = JTBToolkit.makeNodeToken(n9);
		{
			if (true)
				return new Data(n0, n2, n4, n6, n8);
		}
		throw new Error("Missing return statement in function");
	}

	static private boolean jj_initialized_once = false;
	/** Generated Token Manager. */
	static public DoSaParserTokenManager token_source;
	static SimpleCharStream jj_input_stream;
	/** Current token. */
	static public Token token;
	/** Next token. */
	static public Token jj_nt;
	static private int jj_ntk;
	static private int jj_gen;
	static final private int[] jj_la1 = new int[23];
	static private int[] jj_la1_0;
	static private int[] jj_la1_1;
	static {
		jj_la1_init_0();
		jj_la1_init_1();
	}

	private static void jj_la1_init_0() {
		jj_la1_0 = new int[] { 0x4040000, 0x4040000, 0x0, 0x0, 0x40000000,
				0x80000000, 0x0, 0x14000, 0x14000, 0x14000, 0x14000, 0x0,
				0x4000, 0x10000, 0x400000, 0x4000, 0x10000, 0x14000, 0x14000,
				0x0, 0x0, 0x0, 0x0, };
	}

	private static void jj_la1_init_1() {
		jj_la1_1 = new int[] { 0x40, 0x40, 0x10000, 0x20000, 0x0, 0x0, 0x80000,
				0x0, 0x0, 0x0, 0x0, 0x8000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
				0x40000, 0xc020000, 0xc000000, 0x30000000, };
	}

	/** Constructor with InputStream. */
	public DoSaParser(java.io.InputStream stream) {
		this(stream, null);
	}

	/** Constructor with InputStream and supplied encoding */
	public DoSaParser(java.io.InputStream stream, String encoding) {
		if (jj_initialized_once) {
			System.out
					.println("ERROR: Second call to constructor of static parser.  ");
			System.out
					.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		try {
			jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
		} catch (java.io.UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		token_source = new DoSaParserTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	/** Reinitialise. */
	static public void ReInit(java.io.InputStream stream) {
		ReInit(stream, null);
	}

	/** Reinitialise. */
	static public void ReInit(java.io.InputStream stream, String encoding) {
		try {
			jj_input_stream.ReInit(stream, encoding, 1, 1);
		} catch (java.io.UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	/** Constructor. */
	public DoSaParser(java.io.Reader stream) {
		if (jj_initialized_once) {
			System.out
					.println("ERROR: Second call to constructor of static parser. ");
			System.out
					.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		jj_input_stream = new SimpleCharStream(stream, 1, 1);
		token_source = new DoSaParserTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	/** Reinitialise. */
	static public void ReInit(java.io.Reader stream) {
		jj_input_stream.ReInit(stream, 1, 1);
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	/** Constructor with generated Token Manager. */
	public DoSaParser(DoSaParserTokenManager tm) {
		if (jj_initialized_once) {
			System.out
					.println("ERROR: Second call to constructor of static parser. ");
			System.out
					.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	/** Reinitialise. */
	public void ReInit(DoSaParserTokenManager tm) {
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 23; i++)
			jj_la1[i] = -1;
	}

	static private Token jj_consume_token(int kind) throws ParseException {
		Token oldToken;
		if ((oldToken = token).next != null)
			token = token.next;
		else
			token = token.next = token_source.getNextToken();
		jj_ntk = -1;
		if (token.kind == kind) {
			jj_gen++;
			return token;
		}
		token = oldToken;
		jj_kind = kind;
		throw generateParseException();
	}

	/** Get the next Token. */
	static final public Token getNextToken() {
		if (token.next != null)
			token = token.next;
		else
			token = token.next = token_source.getNextToken();
		jj_ntk = -1;
		jj_gen++;
		return token;
	}

	/** Get the specific Token. */
	static final public Token getToken(int index) {
		Token t = token;
		for (int i = 0; i < index; i++) {
			if (t.next != null)
				t = t.next;
			else
				t = t.next = token_source.getNextToken();
		}
		return t;
	}

	static private int jj_ntk() {
		if ((jj_nt = token.next) == null)
			return (jj_ntk = (token.next = token_source.getNextToken()).kind);
		else
			return (jj_ntk = jj_nt.kind);
	}

	static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
	static private int[] jj_expentry;
	static private int jj_kind = -1;

	/** Generate ParseException. */
	static public ParseException generateParseException() {
		jj_expentries.clear();
		boolean[] la1tokens = new boolean[62];
		if (jj_kind >= 0) {
			la1tokens[jj_kind] = true;
			jj_kind = -1;
		}
		for (int i = 0; i < 23; i++) {
			if (jj_la1[i] == jj_gen) {
				for (int j = 0; j < 32; j++) {
					if ((jj_la1_0[i] & (1 << j)) != 0) {
						la1tokens[j] = true;
					}
					if ((jj_la1_1[i] & (1 << j)) != 0) {
						la1tokens[32 + j] = true;
					}
				}
			}
		}
		for (int i = 0; i < 62; i++) {
			if (la1tokens[i]) {
				jj_expentry = new int[1];
				jj_expentry[0] = i;
				jj_expentries.add(jj_expentry);
			}
		}
		int[][] exptokseq = new int[jj_expentries.size()][];
		for (int i = 0; i < jj_expentries.size(); i++) {
			exptokseq[i] = jj_expentries.get(i);
		}
		return new ParseException(token, exptokseq, tokenImage);
	}

	/** Enable tracing. */
	static final public void enable_tracing() {
	}

	/** Disable tracing. */
	static final public void disable_tracing() {
	}

}

class MyVisitor extends DepthFirstVoidVisitor {

	public void visit(NodeToken n) {
		System.out.println("visit " + n.tokenImage);
	}
}

class JTBToolkit {

	static NodeToken makeNodeToken(final Token t) {
		return new NodeToken(t.image.intern(), t.kind, t.beginLine,
				t.beginColumn, t.endLine, t.endColumn);
	}
}
