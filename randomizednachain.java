/* Wojciech Jan Sznurawa PP2 DSW 19.03.2021 */
package college;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class randomizednachain extends dnablock  {

	String[] dnaBlockArray;
	String dnaChain;
	String dnaChainArray;
	String nucleidAcid1 ="";
	String nucleidAcid2 ="";
	String nucleidAcid3 ="";
	String nucleidAcid4 ="";
    void test() {
    	super.test();
    	System.out.println("3:3");
    }

	public randomizednachain() {
		//System.out.println("test print at the high");
	}
	public void setCytosineChain() {
		//dnablock nucleidAcid = new dnablock();
		this.nucleidAcid1 = ADENINE;
		this.nucleidAcid2 = GUANINE;
		this.nucleidAcid3 = THYMINE;
		this.nucleidAcid4 = CYTOSINE;

	}
	public void setUracilChain() {
		// change final stat
		this.nucleidAcid1 = ADENINE;
		this.nucleidAcid2 = GUANINE;
		this.nucleidAcid3 = THYMINE;
		this.nucleidAcid4 = URACIL;

	}
	// change args for a specific var name and add boolean type in dnacomparator
	public String[] createMainChain(int args) {
		randomizednachain nucAcidChain = new randomizednachain();
		if (args == 0) {
			nucAcidChain.setCytosineChain();
		} else {
			nucAcidChain.setUracilChain();
		}
		String nucacid[] = new String[4];
		nucacid[0] = nucAcidChain.nucleidAcid1;
		nucacid[1] = nucAcidChain.nucleidAcid2;
		nucacid[2] = nucAcidChain.nucleidAcid3;
		nucacid[3] = nucAcidChain.nucleidAcid4;
		return nucacid;
	}
	// change var counter to chainLenght 
	public static String setChain(int flag, int chainLenght) {
		// changed new Random in iteration for one time declaration
		Random generator = new Random();
		ArrayList<String> baseconfig = new ArrayList<String>();
		ArrayList<String> codetemplate = new ArrayList<String>();
		randomizednachain nucleidacid = new randomizednachain();
		int i;
		for (i=0; i<4; i++) {
			baseconfig.add(nucleidacid.createMainChain(flag)[i]);
		}
		for (int y=0; y<chainLenght; y++) {

			int n = generator.nextInt(4);
			codetemplate.add(baseconfig.get(n));

		}
		String chaintomatch = String.join("", codetemplate);
		//this.dnaChain = chaintomatch;
		return chaintomatch;
	}

	// could add setter to change cytosine for uracil
	public static void main(String[] args) throws IOException {
		randomizednachain verifyOOP = new randomizednachain();
		//verifyOOP.
		// String[] puksia =  verifyOOP.createMainChain();
		// add flag 0 for setCytosineChain and flag 1 for setUracil
		setChain(0,20);
		System.out.println("my product only for a low lewel extraction null checking: "+verifyOOP.dnaChain);
		verifyOOP.test();
	}

}