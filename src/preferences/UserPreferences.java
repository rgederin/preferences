package preferences;

import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.PreferenceChangeEvent;

import java.awt.Dimension;
import javax.swing.JFrame;

import java.io.FileOutputStream;

public class UserPreferences extends JFrame implements PreferenceChangeListener {
	private Preferences userPrefs;

	public UserPreferences() {
		// Здесь мы создаем объект класса Preferences
		userPrefs = Preferences.userRoot().node("prefexample");

		// Указываем слушателя для отслеживания изменений параметров
		userPrefs.addPreferenceChangeListener(this);

		// Устанавливаем первоначальные размеры
		setToPreferredSize();

		// Форма при закрытии завершает приложение и делаем форму видимой
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setToPreferredSize() {
		// Получить значение параметров и установить размеры формы
		int width = userPrefs.getInt("width", 100);
		int height = userPrefs.getInt("height", 200);
		setSize(width, height);
		System.out
				.println("Width = " + getWidth() + " Height = " + getHeight());
	}

	// Это наш обработчик событий при изменении параметров в реестре
	public void preferenceChange(PreferenceChangeEvent e) {
		setToPreferredSize();
	}

	// Основная рабочая функция
	public void resetDimensionsManyTimes() {
		for (int i = 0; i < 10; i++) {
			// Сохраняем случайные значения для высоты и ширины
			putRandomDimensions();

			// И «засыпаем» на 5 секунд – можно быстро посмотреть в реестр, что
			// там
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// А это просто пример экспорта данных из реестра в xml.
		try {
			userPrefs.exportNode(new FileOutputStream("config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Сохраняем параметры в виде случайных чисел
	private void putRandomDimensions() {
		userPrefs.putInt("width", getRandomInt());
		userPrefs.putInt("height", getRandomInt());
	}

	// Возвращаем случайное челое число от 100 до 400
	private int getRandomInt() {
		return (int) (Math.random() * 300 + 100);
	}

	// Данная функция нигде не вызывается. но если ее вызвать,
	// то все данные будут удалены из реестра
	public void clearPreferences() {
		try {
			userPrefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Создаем форму
		UserPreferences up = new UserPreferences();

		// Запускаем цикл изменений
		up.resetDimensionsManyTimes();
	}
}
