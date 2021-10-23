package abstractfactory;

import abstractfactory.subclass.Alarm;
import abstractfactory.subclass.Button;

public interface ThemeFactory {
	Button createButton();
	Alarm createAlarm();
}
