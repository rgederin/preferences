package preferences;

import java.util.prefs.Preferences;

public class WindowsRegistryPreference {
	public static void main(String[] args) {
		String PREF_KEY = "org.username";
		// Write Preferences information to HKCU
		// (HKEY_CURRENT_USER),HKCU\Software\JavaSoft\Prefs\
		Preferences userPref = Preferences.userRoot();
		userPref.put(PREF_KEY, "a");

		System.out.println("Preferences = "
				+ userPref.get(PREF_KEY, PREF_KEY + " was not found."));

		// Write Preferences information to HKLM
		// (HKEY_LOCAL_MACHINE),HKLM\Software\JavaSoft\Prefs\
		Preferences systemPref = Preferences.systemRoot();
		systemPref.put(PREF_KEY, "b");

		System.out.println("Preferences = "
				+ systemPref.get(PREF_KEY, PREF_KEY + " was not found."));
		
	}
}
