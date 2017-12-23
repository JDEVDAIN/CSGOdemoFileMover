package demomover;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Move {
	public static void demoMover(String csgoPathString, String targetPathString) {

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

		File[] files = csgofolder.listFiles(demFilter);
		for (File file : files) {

			try {
				System.out.println("to be moved:  " + file.getCanonicalPath());
				// file.renameTo(new File("C:\\Users\\Jannis\\Desktop\\demos",
				// file.getName())); // add input mode
				file.renameTo(new File(targetPathString, file.getName()));
				System.out.println("moved:  " + file.getCanonicalPath());

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("Done with moving .dem files");
	}
}


