package abstractfactory;

import abstractfactory.subclass.Alarm;
import abstractfactory.subclass.Button;
import abstractfactory.subclass.WindowsAlarm;
import abstractfactory.subclass.WindowsButton;

public class WindowsThemeFactory implements ThemeFactory{

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public Alarm createAlarm() {
		return new WindowsAlarm();
	}
}
