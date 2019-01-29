/*
 * Writer: Spenser Lehman
 * Date Made 1/24/2019
 * Date Compiled: 1/28/2019
 */

package SubTotalReport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class SubTotalReport {
	//declaring variables
	static boolean eof = false;
	//filescanner
	static Scanner filescanner;
	//printwriter for the subtotal format
	static PrintWriter subtotal;
	//printwriter for the summary format
	static PrintWriter summary;
	//format for the currency
	static NumberFormat nf;
	static String istudentid;
	static String igender;
	static String imajorcode;
	//hold field for the majorcode
	static String hmajorcode;
	static String omajorcode;
	static String ogender;
	static String istring2;
	static double idonation;
	static String string1;
	static int menctr;
	static double mendon;
	static String omendon;
	static double menavg;
	static String omenavg;
	static int womenctr;
	static double womendon;
	static String owomendon;
	static double womenavg;
	static String owomenavg;
	static int infotechctr;
	static double infotechdon;
	static String oinfotechdon;
	static double infotechavg;
	static String oinfotechavg;
	static int meninfotechctr;
	static double meninfotechdon;
	static String omeninfotechdon;
	static double meninfotechavg;
	static String omeninfotechavg;
	static int womeninfotechctr;
	static double womeninfotechdon;
	static String owomeninfotechdon;
	static double womeninfotechavg;
	static String owomeninfotechavg;
	static int manufacttechctr;
	static double manufacttechdon;
	static String omanufacttechdon;
	static double manufacttechavg;
	static String omanufacttechavg;
	static int menmanufacttechctr;
	static double menmanufacttechdon;
	static String omenmanufacttechdon;
	static double menmanufacttechavg;
	static String omenmanufacttechavg;
	static int womenmanufacttechctr;
	static double womenmanufacttechdon;
	static String owomenmanufacttechdon;
	static double womenmanufacttechavg;
	static String owomenmanufacttechavg;
	static int transporttechctr;
	static double transporttechdon;
	static String otransporttechdon;
	static double transporttechavg;
	static String otransporttechavg;
	static int mentransporttechctr;
	static double mentransporttechdon;
	static String omentransporttechdon;
	static double mentransporttechavg;
	static String omentransporttechavg;
	static int womentransporttechctr;
	static double womentransporttechdon;
	static String owomentransporttechdon;
	static double womentransporttechavg;
	static String owomentransporttechavg;
	static int overall;
	static double overalldon;
	static String ooveralldon;
	static double overallavg;
	static String ooverallavg;
	static int numberofsales;
	static double cdonation;
	static String odonation;
	static double csubtotal;
	static double cgrandtotaldonation;
	static String osubtotal;
	static String ograndtotaldonation;
	static int cgrandtotalctr;
	static String ograndtotalctr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		init();
		
		if (eof == true) {
			System.out.println("Failure to produce a output.");
		}
		
		while (eof == false) {
			
			if (!(imajorcode.equals(hmajorcode))) {
				
				subtotals();
				
				totals();
				
				numbercounter();
				
			}
				
			calcs();
				
			output();
			
			input();
	}
		//this is my output for my summary printout
		summary();
		//this is my grand totals
		grandtotals();
		
		//close the print writer
	    subtotal.close();
	    summary.close();
	    
	
	}

	public static void init() {
		
		try {
			filescanner = new Scanner(new File("IHCCFUND.dat"));
			filescanner.useDelimiter(System.getProperty("line.separator"));
		} 
		//checking if its not being importing in 
		catch (FileNotFoundException e1) { 
			System.out.println("File error");
			System.exit(1);
		}

		try {
			subtotal = new PrintWriter(new File ("SubtotalReport.prt"));
		} catch (FileNotFoundException e) {
			System.out.println("Output file error");
		}
		
		try {
			summary = new PrintWriter(new File ("SummaryReport.prt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Output File Error");
		}
		
		//currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
	
		subtotal.format("");
		
		input();
	}
	
	public static void input() {
		//this is for reading in the record to be able to print out
		String record;
		if (filescanner.hasNext()) {
			  record = filescanner.next();
			  		istudentid = record.substring(0,7);
			  		igender = record.substring(7,8);
			  		imajorcode = record.substring(8,10);
			  		string1 = record.substring(10,16);
			  		idonation = Double.parseDouble(string1);
			  		}
		else {
			eof=true;
		}
	}
	
	public static void calcs() {
		//checking the gender for male or femaile and then setting it to the ogender
		if (igender.equals("M")) {
			ogender = "MALE";
		}
		else {
			ogender = "FEMALE"; 
		}
		 
		//switch clause for the majorcode to see what the calculations are
		switch (imajorcode) {
			case "01":
				omajorcode = "COMPUTER SOFTWARE DEVELOPMENT";
				if (igender.toUpperCase().equals("M")) {
					//infotech counter for men, itself, and averages and donation addition for all coresponding major codes
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
				break;
			case "02":
				omajorcode = "DIESEL POWER SYSTEMS TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					mentransporttechctr = mentransporttechctr + 1;
					mentransporttechdon = mentransporttechdon + idonation;
					mentransporttechavg = mentransporttechdon/mentransporttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					womentransporttechctr = womentransporttechctr + 1;
					womentransporttechdon = womentransporttechdon + idonation;
					womentransporttechavg = womentransporttechdon/womentransporttechctr;
				}
				break;
			case "03":
				omajorcode = "AUTOMOTIVE TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					mentransporttechctr = mentransporttechctr + 1;
					mentransporttechdon = mentransporttechdon + idonation;
					mentransporttechavg = mentransporttechdon/mentransporttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					womentransporttechctr = womentransporttechctr + 1;
					womentransporttechdon = womentransporttechdon + idonation;
					womentransporttechavg = womentransporttechdon/womentransporttechctr;
				}
				break;
			case "04":
				omajorcode = "LASER/ELECTRO-OPTICS TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					menmanufacttechctr = menmanufacttechctr + 1;
					menmanufacttechdon = menmanufacttechdon + idonation;
					menmanufacttechavg = menmanufacttechdon/menmanufacttechctr;
					
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					womenmanufacttechctr = womenmanufacttechctr + 1;
					womenmanufacttechdon = womenmanufacttechdon + idonation;
					womenmanufacttechavg = womenmanufacttechdon/womenmanufacttechctr;
				}
				break;
			case "05":
				omajorcode = "ROBOTICS/AUTOMATION TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					menmanufacttechctr = menmanufacttechctr + 1;
					menmanufacttechdon = menmanufacttechdon + idonation;
					menmanufacttechavg = menmanufacttechdon/menmanufacttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					womenmanufacttechctr = womenmanufacttechctr + 1;
					womenmanufacttechdon = womenmanufacttechdon + idonation;
					womenmanufacttechavg = womenmanufacttechdon/womenmanufacttechctr;
				}
				break;
			case "06":
				omajorcode = "DIGITAL FORENSICS";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
				break;
			case "07":
				omajorcode = "MACHINE TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					menmanufacttechctr = menmanufacttechctr + 1;
					menmanufacttechdon = menmanufacttechdon + idonation;
					menmanufacttechavg = manufacttechdon/manufacttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					womenmanufacttechctr = womenmanufacttechctr + 1;
					womenmanufacttechdon = womenmanufacttechdon + idonation;
					womenmanufacttechavg = womenmanufacttechdon/womenmanufacttechctr;
				}
				break;
			case "08":
				omajorcode = "GEOSPATIAL TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
				break;
			case "09":
				omajorcode = "ADMINISTRATIVE ASSISTANT";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
				break;
			case "10":
				omajorcode = "ACCOUNTING ASSISTANT";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
				break;
			case "11":
				omajorcode = "WELDING TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					menmanufacttechctr = menmanufacttechctr + 1;
					menmanufacttechdon = menmanufacttechdon + idonation;
					menmanufacttechavg = menmanufacttechdon/menmanufacttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					manufacttechctr = manufacttechctr + 1;
					manufacttechdon = manufacttechdon + idonation;
					manufacttechavg = manufacttechdon/manufacttechctr;
					womenmanufacttechctr = womenmanufacttechctr + 1;
					womenmanufacttechdon = womenmanufacttechdon + idonation;
					womenmanufacttechavg = womenmanufacttechdon/womenmanufacttechctr;
				}
			case "12":
				omajorcode = "AUTOMOTIVE COLLISION TECHNOLOGY";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					mentransporttechctr = mentransporttechctr + 1;
					mentransporttechdon = mentransporttechdon + idonation;
					mentransporttechavg = mentransporttechdon/mentransporttechctr;
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr; 
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					womentransporttechctr = womentransporttechctr + 1;
					womentransporttechdon = womentransporttechdon + idonation;
					womentransporttechavg = womentransporttechdon/womentransporttechctr;
				}
				break;
			case "13":
				omajorcode = "AVAIATION PILOT TRAINING";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					mentransporttechctr = mentransporttechctr + 1;
					mentransporttechdon = mentransporttechdon + idonation;
					mentransporttechavg = mentransporttechdon/mentransporttechctr; 
				}
				else {
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					transporttechctr = transporttechctr + 1;
					transporttechdon = transporttechdon + idonation;
					transporttechavg = transporttechdon/transporttechctr;
					womentransporttechctr = womentransporttechctr + 1;
					womentransporttechdon = womentransporttechdon + idonation;
					womentransporttechavg = womentransporttechdon/womentransporttechctr;
				}
				break;
			default:
				omajorcode = "COMPUTER SOFTWARE DEVELOPMENT";
				if (igender.toUpperCase().equals("M")) {
					menctr = menctr + 1;
					mendon = mendon + idonation;
					menavg = mendon/menctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					meninfotechctr = meninfotechctr + 1;
					meninfotechdon = meninfotechdon + idonation;
					meninfotechavg = meninfotechdon/meninfotechctr;
				}
				else {
					//adding to the counters and donations for all information tech women and women counters and donation addons to themselves
					womenctr = womenctr + 1;
					womendon = womendon + idonation;
					womenavg = womendon/womenctr;
					infotechctr = infotechctr + 1;
					infotechdon = infotechdon + idonation;
					infotechavg = infotechdon/infotechctr;
					womeninfotechctr = womeninfotechctr + 1;
					womeninfotechdon = womeninfotechdon + idonation;
					womeninfotechavg = womeninfotechdon/womeninfotechctr;
				}
			} 
		//adding to the subtotal and the overall counter	 
		numberofsales = numberofsales + 1;
		overall = overall + 1;
		csubtotal = csubtotal + idonation;
	}
	
	public static void output() {
		//formating the donation
		odonation = nf.format(idonation);
		//printing stuff out for the subtotal report
		subtotal.format("%-10s%10s%-5s%10s%30s%10s%-10s\n\n" , istudentid , " " , ogender , " " , omajorcode , " " , odonation);
		
	}
	
	public static void subtotals() {
		//formating for the subtotal
		osubtotal = nf.format(csubtotal);
		
		subtotal.format("%-30s%10s%4s%10s%-15s\n\n" , omajorcode , " " , numberofsales , " " , osubtotal);
		//checking the majorcode
		hmajorcode = imajorcode;
		//adding to the subtotals
		cgrandtotaldonation = cgrandtotaldonation + csubtotal;
		cgrandtotalctr = cgrandtotalctr + numberofsales;
		//zeroing a the subtotal
		csubtotal = 0;
	}
	
	public static void summary() {
		//all formating for the calculated variables
		omendon = nf.format(mendon);
		owomendon = nf.format(womendon); 
		omenmanufacttechdon = nf.format(menmanufacttechdon);
		omanufacttechdon = nf.format(manufacttechdon);
		owomenmanufacttechdon = nf.format(womenmanufacttechdon);
		omeninfotechdon = nf.format(meninfotechdon);
		oinfotechdon = nf.format(infotechdon);
		owomeninfotechdon = nf.format(womeninfotechdon);
		otransporttechdon = nf.format(transporttechdon);
		omentransporttechdon = nf.format(mentransporttechdon);
		owomentransporttechdon = nf.format(womentransporttechdon);
		omenavg = nf.format(menavg);
		owomenavg = nf.format(womenavg);
		omenmanufacttechavg = nf.format(menmanufacttechavg);
		omanufacttechavg = nf.format(manufacttechavg);
		owomenmanufacttechavg = nf.format(womenmanufacttechavg);
		oinfotechavg = nf.format(infotechavg);
		omeninfotechavg = nf.format(meninfotechavg);
		owomeninfotechavg = nf.format(womeninfotechavg);
		otransporttechavg = nf.format(transporttechavg);
		omentransporttechavg = nf.format(mentransporttechavg);
		owomentransporttechavg = nf.format(womentransporttechavg);
		ooveralldon = nf.format(overalldon);
		ooverallavg = nf.format(overallavg);
		//Summary format and printout
		summary.format("%-6s%10s%5s%30s\n" , "DATE:" , java.time.LocalDate.now() , " " , "IHCC" );	
		summary.format("%20s%20s%18s%20s\n" , " " , " " , "COLLEGE DONATIONS" , " " );
		summary.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		summary.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		summary.format("%-20s%28s%6s%15s%18s%8s%20s\n" , "PEOPLE" , " " , "COUNT" , " " , "AMMOUNT RAISED" , " " , "AVERAGE DONATION");
		summary.format("%20s%20s%20s%20s\n" , " " , " " , " " , " ", " ");
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "MEN" , " " , menctr , " " , omendon , " " , omenavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "WOMEN" , " " , womenctr, " " , owomendon , " " , owomenavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "INFORMATION TECHNOLOGY" , " " , infotechctr , " " , oinfotechdon, " ", oinfotechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "MANUFACTURING TECHNOLOGY" , " " , manufacttechctr , " " , omanufacttechdon, " " , omanufacttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "TRANSPORTATION TECHNOLOGY" , " " , transporttechctr , " " , otransporttechdon , " " , otransporttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "MALE INFORMATION TECHNOLOGY" , " " , meninfotechctr , " " , omeninfotechdon , " " , omeninfotechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "FEMALE INFORMATION TECHNOLOGY" , " " , womeninfotechctr , " " , owomeninfotechdon , " " , owomeninfotechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "MALE MANUFACTURING TECHNOLOGY" , " " , menmanufacttechctr , " " , omenmanufacttechdon , " " , omenmanufacttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-17s%10s\n\n" , "FEMALE MANUFACTURING TECHNOLOGY" , " " , womenmanufacttechctr , " " , owomenmanufacttechdon , " " , owomenmanufacttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-17s%10s\n\n" , "MALE TRANSPORTATION TECHNOLOGY" , " " , mentransporttechctr , " " , omentransporttechdon , " " , omentransporttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "FEMALE TRANSPORTATION TECHNOLOGY" , " " , womentransporttechctr , " " , owomentransporttechdon , " " , owomentransporttechavg);
		summary.format("%-35s%-15s%6s%-15s%-11s%-15s%10s\n\n" , "OVERALL" , " " , overall , " " , ooveralldon , " " , ooverallavg);
		
	}
	//this is used to set the numberofsales to 0
	public static void numbercounter() {
		numberofsales = 0;
	}
	
	public static void totals() {
		//overall
		overalldon = overalldon + mendon + womendon + infotechdon + meninfotechdon + womeninfotechdon + manufacttechdon + menmanufacttechdon + womenmanufacttechdon + transporttechdon + mentransporttechdon + womentransporttechdon;
		overallavg = overalldon/overall;
	}
	
	public static void grandtotals() {
		//formating for the grandtotal
		ograndtotaldonation = nf.format(cgrandtotaldonation);
		//printout for the grandtotal
		subtotal.format("%-11s%10s%5s%10s%20s\n" , "GRAND TOTALS" , " " , cgrandtotalctr , " " , ograndtotaldonation);
	}
}
