package college;

import java.util.HashSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author Wojciech Jan Sznurawa
 * main method allowing to extract all unique combinations of the amino-acids 
 * algorithm used - longest substring in string
 */
public class dnacomparator  {
	/* Wojciech Jan Sznurawa PP2 DSW 19.03.2021 */
	String testDNA = "";
	String matchDNA = "";


	public dnacomparator() {
	}

	public static void main(String[] args) throws IOException {
		// dnacomparator prepareDnaChain = new dnacomparator();
		String dnaT = "";
		String dnaM = "";
		int uracilChainFlag=0;
		if (args.length == 0) {

			// if flag 1 Uracil based chain will be set / flag 0 cytosine based chain is set
			uracilChainFlag = 0;
			int dnaChainLenghtFlag = 1000;
			dnaT = randomizednachain.setChain(uracilChainFlag, dnaChainLenghtFlag);
			dnaChainLenghtFlag = 20;
			dnaM = randomizednachain.setChain(uracilChainFlag, dnaChainLenghtFlag);
		} else {

			String fileTestChain = args[0];
			String fileMatchChain = args[1];
			dnaT = dnareader.readTestChain(fileTestChain);
			dnaM = dnareader.readMatchChain(fileMatchChain);
		}
	
		createResultArray(dnaT, dnaM, uracilChainFlag);
		
		// System.out.println(dnaT); add to log

	}
/**
 * algorithm used - longest common substring - 1. gather indexes of repeatable symbols - do not gather duplicated entries
 * add it to the Hashset
 * in order to allow filter in Collections add trailing zeros to allow minimum value identification (00, 0000, 0000)
 * read index / position and add sequence of symbols accordingly
 * @param dnaT DNA code input
 * @param dnaM DNA matcher
 * @param uracilChainFlag - flag setup
 * @throws IOException
 */
	public static void createResultArray(String dnaT, String dnaM, int uracilChainFlag) throws IOException {
		dnalogger writeLog = new dnalogger();
		ArrayList<String> resultTable = new ArrayList<String>();
		String btest = dnaT;
		String amatch = dnaM;
		HashSet<String> indexHolder = new HashSet<String>();
		ArrayList<ArrayList<Integer>> Interceptor = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> matchingStringHolder = new ArrayList<String>();
		ArrayList<Integer> hashcoding = new ArrayList<Integer>();
		ArrayList<Integer> minusholding = new ArrayList<Integer>();
		String stringHolder = "";
		int m = amatch.length();
		int n = btest.length();
		HashSet<Integer> test_chain = new HashSet<Integer>();
		int ax = Integer.parseInt(m + "" + n);
		test_chain.add(ax);
		String inlow = String.valueOf(m);
		String inhigh = String.valueOf(n);

		// indexHolder.add(inlow+"."+inhigh);
		String indexParser = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				inlow = String.valueOf(j);
				inhigh = String.valueOf(i);
				if (i < 10) {
					indexParser = inlow + ".000000000" + inhigh;
				} else if (i < 100) {
					indexParser = inlow + ".00000000" + inhigh;
				} else if (i < 1000) {
					indexParser = inlow + ".0000000" + inhigh;
				} else if (i < 10000) {
					indexParser = inlow + ".000000" + inhigh;
				} else if (i < 100000) {
					indexParser = inlow + ".00000" + inhigh;
				} else if (i < 1000000) {
					indexParser = inlow + ".0000" + inhigh;
				} else if (i < 10000000) {
					indexParser = inlow + ".000" + inhigh;
				} else if (i < 100000000) {
					indexParser = inlow + ".00" + inhigh;
				} else if (i < 1000000000) {
					indexParser = inlow + ".0" + inhigh;
				}

				if (amatch.charAt(j) == btest.charAt(i)) {
					writeLog.writeLogLines("index parser: " + indexParser, "INFO");
					// if (!(indexHolder.contains(indexParser))) {
					indexHolder.add(indexParser);
					// System.out.println("test: " + indexParser); FOR LOGGING!
					// } //*end of if (!(test_chain.contains(indexJoiner)))
				} // * end of if (amatch.charAt(j) == btest.charAt(i))

			} // *end of for (int j=0; j < m; j++)
		} // *end of for (int i=0; i < n; i++)

		for (String xx : indexHolder) {

			Pattern pattern1 = Pattern.compile("(^[0-9]+)");
			Pattern pattern2 = Pattern.compile("([0-9]+$)");
			Matcher matcher1 = pattern1.matcher(xx);
			Matcher matcher2 = pattern2.matcher(xx);
			while ((matcher1.find()) && (matcher2.find())) {
				Integer xp = Integer.parseInt(matcher1.group());
				Integer yp = Integer.parseInt(matcher2.group());
				ArrayList<Integer> dynamicHolder = new ArrayList<Integer>();
				dynamicHolder.add(xp);
				dynamicHolder.add(yp);
				writeLog.writeLogLines("dynamicholder" + dynamicHolder, "INFO");
				Interceptor.add(dynamicHolder);
			}

		}

		for (int xxz = 0; xxz < indexHolder.size(); xxz++) {
			stringHolder = "";
			hashcoding.clear();
			minusholding.clear();
			String minimumx = Collections.min(indexHolder, null);
			writeLog.writeLogLines("current minimum value is set@: "+minimumx, "INFO");
			// class
			Pattern pattern1 = Pattern.compile("(^[0-9]*)");
			Pattern pattern2 = Pattern.compile("([0-9]*$)");
			Matcher matcher1 = pattern1.matcher(minimumx);
			Matcher matcher2 = pattern2.matcher(minimumx);
			matcher1.find();
			matcher2.find();

			Integer lookup = Integer.parseInt(matcher1.group());
			Integer matchup = Integer.parseInt(matcher2.group());
			int mxy = 0;
			stringHolder = String.valueOf(amatch.charAt(lookup + mxy));
			indexHolder.remove(minimumx);
			hashcoding.add(lookup);

			hashcoding.add(matchup);
			hashcoding.clear();
			minusholding.add(lookup - mxy);
			minusholding.add(matchup - mxy);
			hashcoding.add(lookup + mxy);
			hashcoding.add(matchup + mxy);

			indexHolder.remove(minimumx);
			if (!Interceptor.contains(hashcoding)) {
				stringHolder = String.valueOf(amatch.charAt(lookup));
				writeLog.writeLogLines("plus" + hashcoding,"INFO");
				writeLog.writeLogLines("our string " + stringHolder, "INFO");
				matchingStringHolder.add(stringHolder);
				resultTable.add(String.valueOf(lookup + mxy) + "," + String.valueOf(matchup + mxy));
				resultTable.add(stringHolder);

				stringHolder = "";

			} else {
				stringHolder = "";

				do {

					writeLog.writeLogLines("plus" + hashcoding,"INFO");
					resultTable.add(String.valueOf(lookup + mxy) + "," + String.valueOf(matchup + mxy));
					Interceptor.remove(hashcoding);
					hashcoding.clear();
					stringHolder = stringHolder + String.valueOf(amatch.charAt(lookup + mxy));
					String remover = lookup + mxy + "." + matchup + mxy;

					indexHolder.remove(remover);
					mxy++;
					hashcoding.add(lookup + mxy);
					hashcoding.add(matchup + mxy);

				} while (Interceptor.contains(hashcoding));
				writeLog.writeLogLines("our string " + stringHolder,"INFO");
				resultTable.add(stringHolder);
				matchingStringHolder.add(stringHolder);

			}

		}
		
		ArrayList<String> frequencyTable = new ArrayList<String>();
		frequencyTable = frequencyanalyzer.startFrequencyCalculation(uracilChainFlag,dnaT);
		String lineDescription = "matched cycle";
		writeLog.writeLogArray(matchingStringHolder, lineDescription, "INFO");
		String max = Collections.max(matchingStringHolder, Comparator.comparing(String::length));
		writeLog.writeLogLines("longest cycle:" + max, "INFO");

		// System.out.println(resultTable);
		String printConclusion = "test version of DNA chain comparator";
		dnaprinter verifyOOP = new dnaprinter();
		verifyOOP.setPrinterPreCondition(0);
		verifyOOP.setPrinterConclusion(1, printConclusion);
		verifyOOP.setChainBuiler(btest, amatch);
		verifyOOP.setChunkArray(matchingStringHolder);
		verifyOOP.setLogestSubString(max);
		verifyOOP.setFrequencyValue(frequencyTable);
		verifyOOP.printResults();
	}
}


