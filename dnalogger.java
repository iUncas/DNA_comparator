package college;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;



public class dnalogger extends dnaprinter {

	String logLine = "";
	

	dnalogger() {
		System.out.println("print at the high extraction level to make sure that reference variable which holds hashcode of object is created ");
	}
    /**
     * 
     * @param logLine writing methods output to the logfile - 
     * @throws IOException
     */
	public void writeLogLines(String logLine, String LogLevel) throws IOException {
		Writer dnaLog = new FileWriter("dnalog.txt", true);
		try {
			
			dnaLog.write(setDateTime()+" ["+LogLevel+"]"+" - "+" "+logLine+setNewLine());
			dnaLog.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param logArray array of data to be logged into the logfile - 
	 * @throws IOException
	 */
	public void writeLogArray(ArrayList<String> logArray, String arrayLineHeader, String LogLevel) throws IOException {
		Writer dnaLog = new FileWriter("dnalog.txt", true);
		
		try {
			for (String logLine: logArray) {
			dnaLog.write(setDateTime()+" ["+LogLevel+"]"+" - "+arrayLineHeader+" - "+logLine+setNewLine());
			}
			dnaLog.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public void writeLogError(String LogLevel, String sStacktrace, IOException e2) throws IOException {
		Writer dnaLog = new FileWriter("dnalog.txt", true);
		
		try {

			dnaLog.write(setDateTime()+" ["+LogLevel+"]"+" - "+e2+" - "+sStacktrace+setNewLine());

			dnaLog.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		dnalogger verifyOOP = new dnalogger();
		verifyOOP.writeLogLines("pussy", "PUSSYTEST");
	}
}