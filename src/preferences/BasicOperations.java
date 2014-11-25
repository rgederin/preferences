package preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class BasicOperations {

	private static final String STRING_KEY = "string";
	private static final String BOOLEAN_KEY = "boolean";
	private static final String DOUBLE_KEY = "double";
	private static final String INTEGER_KEY = "integer";

	public static void main(String[] args) {
		try {
			new BasicOperations().preferences();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private void preferences() throws BackingStoreException {
		/**
		 * Getting root user and system node
		 */
		Preferences preferencesUserRoot = Preferences.userRoot();
		Preferences preferencesSystemRoot = Preferences.systemRoot();

		/**
		 * Getting node for our package
		 */
		Preferences myPreferences = Preferences.userNodeForPackage(getClass());

		/**
		 * Put key-value pairs
		 */
		myPreferences.put(STRING_KEY, "Ruslan");
		myPreferences.putBoolean(BOOLEAN_KEY, true);
		myPreferences.putDouble(DOUBLE_KEY, 12.2);

		System.out.println("Node's absolute path: "
				+ myPreferences.absolutePath());

		/**
		 * Get key-value pairs
		 */
		System.out.println("String preference: "
				+ myPreferences.get(STRING_KEY, "default"));
		System.out.println("Boolean preference: "
				+ myPreferences.get(BOOLEAN_KEY, "default"));
		System.out.println("Double preference: "
				+ myPreferences.get(DOUBLE_KEY, "default"));
		System.out.println("Integer preference: "
				+ myPreferences.get(INTEGER_KEY, "default"));

		/**
		 * Get childrenNames from Preferences
		 */
		System.out.println("\nNode's children: ");
		for (String s : Preferences.userRoot().childrenNames()) {
			System.out.println(s + "");
		}

		/**
		 * Get keys from Preferences
		 */
		System.out.println("\nNode's keys: ");
		for (String s : myPreferences.keys()) {
			System.out.println(s + "");
		}

		/**
		 * Get name and parent from Preference
		 */
		System.out.println("\nNode's name: " + myPreferences.name());
		System.out.println("Node's parent: " + myPreferences.parent());
		System.out.println("NODE: " + myPreferences);

		/**
		 * Get value from Preferences with the loop
		 */
		System.out.println("\nUse loop for go throught preferences");
		for (String s : myPreferences.keys()) {
			System.out.println("" + s + "= " + myPreferences.get(s, ""));
		}	    
	    
	    /**
	     * Getting the Maximum Size of a Preference Key and Value 
	     */
		System.out.println("\nGetting the Maximum Size of a Preference Key and Value");
		System.out.println("Max key length: " + Preferences.MAX_KEY_LENGTH);
		System.out.println("Max value length: " + Preferences.MAX_VALUE_LENGTH);
		System.out.println("Max byte arr length: " + Preferences.MAX_VALUE_LENGTH *3/4);
	    
	   
		/**
		 * Remove preference node
		 */
		myPreferences.removeNode();
	}
}

