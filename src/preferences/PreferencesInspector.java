package preferences;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class PreferencesInspector implements PreferenceChangeListener {
	private Preferences userPrefs;

	public static final String NAMEPREF = "name";

	public static final String EMAILPREF = "email";

	public static final String AGEPREF = "age";

	public static final String PHONEPREF = "phone";

	public static void main(String args[]) {
		new PreferencesInspector();
	}

	public PreferencesInspector() {
		userPrefs = Preferences.userNodeForPackage(PreferencesInspector.class);

		System.out.println(userPrefs.get(NAMEPREF, ""));
		System.out.println(userPrefs.get(EMAILPREF, ""));
		System.out.println(userPrefs.get(AGEPREF, ""));
		System.out.println(userPrefs.get(PHONEPREF, ""));

		userPrefs.put(NAMEPREF, "name");
		userPrefs.put(AGEPREF, "Text");
		userPrefs.put(EMAILPREF, "email");
		userPrefs.put(PHONEPREF, "phone");
		System.out.println("Preferences stored");

		Preferences.userNodeForPackage(PreferencesInspector.class)
				.addPreferenceChangeListener(this);

	}

	public void preferenceChange(PreferenceChangeEvent evt) {

		String key = evt.getKey();
		String val = evt.getNewValue();

		if (key.equals(NAMEPREF)) {
			System.out.println(val);
		} else if (key.equals(EMAILPREF)) {
			System.out.println(val);
		} else if (key.equals(AGEPREF)) {
			System.out.println(val);
		} else if (key.equals(PHONEPREF)) {
			System.out.println(val);
		}
	}

}
