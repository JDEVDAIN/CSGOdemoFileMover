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
	static double demoFilesSizeInGb;

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		demoFilesSizeInGb = (((demoFilesSize / 1024) / 1024) / 1024);
		infoForConfirm= new String(demoFilesScanned.length + " Demos found, which are using \n "
				+ round(demoFilesSizeInGb, 2) + " GB of Storage");
		
		System.out.println(demoFilesScanned.length + " Demos found, which are using ");

		System.out.println(round(demoFilesSizeInGb, 2) + " GB of Storage"); // rounded now

	}

	public static void demoMover(String csgoPathString, String targetPathString) {

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
				System.out.println("moved:  " + file.getCanonicalPath());

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Done with moving .dem files");
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
