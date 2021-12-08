package college;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class dnareader {

	String testChain = "";
	String matchChain = "";

	dnareader() {
	//	System.out.println("print at the high extraction level to make sure that reference variable which holds hashcode of object is created ");
	}
    /**
     * Reads test chain from file
     * @param fileName - full path to the file with the testchain
     * @return chain base for analysis in comparator
     * @throws IOException
     */
	public static String readTestChain (String fileName) throws IOException {
		dnalogger writeLog = new dnalogger();
		String readBase="";
		try {
			File inputFileTest = new File(fileName);
			Scanner tester = new Scanner(inputFileTest);
			writeLog.writeLogLines("imported DNA test chain from the file: "+fileName, "INFO");
			while (tester.hasNext()) {
				readBase = tester.next();
			}

			tester.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return  readBase;	    	

	}
    /**
     * 
     * @param fileName file with dnachain to match against testchain
     * @return matchbase for comparator analysis
     * @throws IOException
     */
	public static String readMatchChain (String fileName) throws IOException {
		dnalogger writeLog = new dnalogger();
		String matchbase= "";
		try {
			File inputFileMatch= new File(fileName);
			Scanner matcher = new Scanner(inputFileMatch);
			writeLog.writeLogLines("imported DNA match chain from the file: "+fileName, "INFO");
			while (matcher.hasNext()) {
				matchbase = matcher.next();
			}
			matcher.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			writeLog.writeLogError("ERROR", sStackTrace, e);
		}
		return matchbase;	    	
	}	    	
	public static void main(String[] args) throws IOException {
		dnareader verifyOOP = new dnareader();
		dnareader.readMatchChain("matcheasr.txt");
		dnareader.readTestChain("tedfsster.txt");
		System.out.println("my product only for a low lewel extraction  checking: "+verifyOOP.matchChain);
	}
}