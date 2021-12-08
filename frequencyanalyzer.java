package college;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class frequencyanalyzer extends dnablock   {

	public frequencyanalyzer() {
		//System.out.println("analyzer");
	}
	
	String[] dnaBlockArray;
	String dnaChain;
	String dnaChainArray;
	String nucleidAcid1 ="";
	String nucleidAcid2 ="";
	String nucleidAcid3 ="";
	String nucleidAcid4 ="";
/*	void test() {
		super.test();
		System.out.println("3:3");
	}*/

	private void prepareCytosineChain() {
		//dnablock nucleidAcid = new dnablock();
		this.nucleidAcid1 = ADENINE;
		this.nucleidAcid2 = GUANINE;
		this.nucleidAcid3 = THYMINE;
		this.nucleidAcid4 = CYTOSINE;

	}
	private void prepareUracilChain() {
		// change final stat
		this.nucleidAcid1 = ADENINE;
		this.nucleidAcid2 = GUANINE;
		this.nucleidAcid3 = THYMINE;
		this.nucleidAcid4 = URACIL;

	}
	// change args for a specific var name and add boolean type in dnacomparator
	public String[] prepareFrequencyMatch(int args) {
		frequencyanalyzer nucAcidChain = new frequencyanalyzer();
		if (args == 0) {
			nucAcidChain.prepareCytosineChain();
		} else {
			nucAcidChain.prepareUracilChain();
		}
		String nucacid[] = new String[4];
		nucacid[0] = nucAcidChain.nucleidAcid1;
		nucacid[1] = nucAcidChain.nucleidAcid2;
		nucacid[2] = nucAcidChain.nucleidAcid3;
		nucacid[3] = nucAcidChain.nucleidAcid4;
		return nucacid;
	}
	// change var counter to chainLenght 
	public static ArrayList<String> startFrequencyCalculation(int flag, String freqTestString) {
		//frequencyinterface freq = new frequencytester();
		//freq.one();
		int countacid =0;
		double freqValue;
		ArrayList<String> resultTable = new ArrayList<String>();
		ArrayList<String> baseconfig = new ArrayList<String>();
		frequencyanalyzer nucleidacid = new frequencyanalyzer();
		int i;
		for (i=0; i<4; i++) {
			baseconfig.add(nucleidacid.prepareFrequencyMatch(flag)[i]);
		}
		// changed new Random in iteration for one time declaration

		for (String acid : baseconfig) {

			for (int y=0; y<freqTestString.length(); y++) {
				if (acid.equals(String.valueOf(freqTestString.charAt(y))) ) {
					countacid++;
				}
			}
			DecimalFormat df = new DecimalFormat("###.##");
			freqValue = frequencyinterface.getEnzimesFrequency(countacid, freqTestString.length());
			resultTable.add("frequency: "+String.valueOf(df.format(freqValue))+" of nucleid: "+acid);
			countacid = 0;


		}
		//this.dnaChain = chaintomatch;
		notioninterface freq = new frequencytester();
		freq.two();
		return resultTable;
	}

	// could add setter to change cytosine for uracil
	public static void main(String[] args) throws IOException {
		ArrayList<String> resultTable = new ArrayList<String>();
		//frequencyanalyzer verifyOOP = new frequencyanalyzer();

		resultTable = startFrequencyCalculation(1,"ATUUUUUUUUUUGGGGAAAAAAUUUUGGAAA");
		//frequencyinterface freq = new frequencytester();
		//freq.one();
		for (String xx : resultTable) {
			System.out.println("my product only for a low lewel extraction checking: "+xx);
		}
	}
}