package college;

import java.time.LocalDateTime;
import java.io.IOException;
import java.util.ArrayList;

public class dnaprinter {
	String preCondition = "";
	String printConclusion = "";
	String printChain = "";
	String freqIntro = "";
	String frequencyValue ="";
	ArrayList<String> dnaIndex = new ArrayList<String>();
	ArrayList<String> dnaSubStringMatch = new ArrayList<String>();
	ArrayList<String> frequencyArray = new ArrayList<String>();
	String longestSubDnaString = "";

	dnaprinter()  {}


	public String setNewLine() {
		String newline = System.getProperty("line.separator");
		return newline;
	}
	public LocalDateTime setDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		return dateTime;
	}

	public String setLogestSubString (String arg) {
		this.longestSubDnaString = arg;
		return longestSubDnaString;
	}
	public String  setPrinterPreCondition (int arg) {

		if (arg == 0) {
			this.preCondition = "----printing results----"+setNewLine();
		} else if ( arg == 1) {
			this.preCondition = "-----System will iterate through result array----"+setNewLine();
		}
		return preCondition;
	}
	public String   setPrinterConclusion (int arg, String textToPrint) {

		if ( arg == 1 && textToPrint != null) {
			this.printConclusion = textToPrint+setNewLine()+"it-divein.com at "+setDateTime();
		} else {
			this.printConclusion = "it-divein.com at "+setDateTime();
		}
		return printConclusion;
	}
	public String setChainBuiler (String args1, String args2) {
		this.printChain = "Folowing DNA code chain "+setNewLine()+args1+setNewLine()+"has been tested against following sequence:"+setNewLine()+args2+setNewLine();
		return printChain;
	}
	public ArrayList<String>  setChunkArray(ArrayList<String> arrayOfChunks) {
		this.dnaSubStringMatch = arrayOfChunks;
		return dnaSubStringMatch;
	}
	public ArrayList<String> setFrequencyValue(ArrayList<String> arrayOfFrequencies) {
		this.frequencyArray = arrayOfFrequencies;
		return frequencyArray;
	}
	public String setFrequencyIntro (String intro) {
		this.freqIntro = intro;
		//System.out.println(freqIntro);
		return freqIntro;
	}
	/*   public String get... - should we use getters in this class */

	public void printResults() throws IOException {
		dnalogger writeLog = new dnalogger();
		System.out.println(preCondition);
		writeLog.writeLogLines(preCondition, "INFO");
		System.out.println(printChain);
		writeLog.writeLogLines(printChain, "INFO");
		for (String arg : dnaSubStringMatch) {
			System.out.println("Matched cycle:"+arg);
			writeLog.writeLogLines("Matched cycle:"+arg, "INFO");
		}
		System.out.println("Longest subDNA sequence matched: "+longestSubDnaString);
		writeLog.writeLogLines("Longest subDNA sequence matched: "+longestSubDnaString, "INFO");
		System.out.println(freqIntro);
		writeLog.writeLogLines(freqIntro, "INFO");
		for (String arg : frequencyArray) {
			System.out.println(arg);
			writeLog.writeLogLines(arg, "INFO");
		}
		System.out.println(printConclusion);
		writeLog.writeLogLines(printConclusion, "INFO");
		
	}
	public static void main(String[] args) throws IOException {
		ArrayList<String> pussyinceptor = new ArrayList<String>();
		pussyinceptor.add("woda");
		pussyinceptor.add("kloda");
		pussyinceptor.add("spoda");
		dnaprinter verifyOOP = new dnaprinter();
		verifyOOP.setPrinterPreCondition(0);
		//System.out.print((verifyOOP.preCondition));
		verifyOOP.setPrinterConclusion(1, "korsyka");
		String builder1 = "ABDBBDBDB";
		String builder2 = "CDJJDJD";
		verifyOOP.setChainBuiler(builder1, builder2);
		verifyOOP.setChunkArray(pussyinceptor);
		verifyOOP.printResults();
		//System.out.print((verifyOOP.preCondition));
		//System.out.print(verifyOOP.printChain);
		verifyOOP.setChunkArray(pussyinceptor);
		//System.out.print(verifyOOP.printConclusion);
	}
}