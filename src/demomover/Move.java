package demomover;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Move {
	static int numberOfDemoFiles;
	static String infoForConfirm;
	static File[] demoFilesScanned;
	static double demoFilesSize = 0L;
	static double demoFilesSizeInGb = 0L;
	static int demoAmountForConfirm;
	static int moveCounter = 0; // used for progressbar
	static double moveProgressCounter = 0;

	public static void demoScanner(String csgoPathString) {

		File csgofolder = new File(csgoPathString);
		FilenameFilter demFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {

				if (name.endsWith(".dem")) {
					return true;
				} else {
					return false;
				}
			}
		};
		File[] demoFilesScanned = csgofolder.listFiles(demFilter);
		for (File file : demoFilesScanned) {
			demoFilesSize += file.length();
			try {
				System.out.println("  " + file.getCanonicalPath());
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		demoFilesSizeInGb = (((demoFilesSize / 1024) / 1024) / 1024);
		infoForConfirm = new String(demoFilesScanned.length + " Demos found, which are using \n"
				+ round(demoFilesSizeInGb, 2) + " GB of Storage");

		System.out.println(demoFilesScanned.length + " Demos found, which are using ");
		demoAmountForConfirm = demoFilesScanned.length;
		System.out.println(round(demoFilesSizeInGb, 2) + " GB of Storage"); // rounded now
		demoFilesSize = 0L;
		
		numberOfDemoFiles = demoFilesScanned.length;
	}

	public static void demoMover(String csgoPathString, String targetPathString) {
		moveCounter = 0;
		File csgofolder = new File(csgoPathString); // redundant, can be cleaned
		FilenameFilter demFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {

				if (name.endsWith(".dem")) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = csgofolder.listFiles(demFilter);

		for (File file : files) {

			try {
				System.out.println("to be moved:  " + file.getCanonicalPath());

				file.renameTo(new File(targetPathString, file.getName()));
				double total = 100 / numberOfDemoFiles; //used for progressbar value
				total /= 100; //used for progressbar, max value is 1
				moveCounter++;
				moveProgressCounter = moveCounter * total;
			
				System.out.println(numberOfDemoFiles);
				System.out.println( total +"movecounter " + moveProgressCounter);
				System.out.println("moved:  " + file.getCanonicalPath());

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Done with moving .dem files");
		System.out.println("final movecounternumber " + moveCounter);
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
