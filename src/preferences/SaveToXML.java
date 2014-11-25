package preferences;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class SaveToXML {
	public static void main(String[] args) {
		try {
			exportInXML();
		} catch (IOException | BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void exportInXML() throws IOException, BackingStoreException {
		Preferences prefsRoot = Preferences.userRoot();
		Preferences myPrefs = prefsRoot.node("xml_example");

		myPrefs.put("A", "a");
		myPrefs.put("B", "b");
		myPrefs.put("C", "c");

		FileOutputStream fos = new FileOutputStream("prefs.xml");

		myPrefs.exportSubtree(fos);
		fos.close();
		myPrefs.removeNode();
	}
}
