package abstractfactory;

import abstractfactory.subclass.Alarm;
import abstractfactory.subclass.Button;
import abstractfactory.subclass.MacOSAlarm;
import abstractfactory.subclass.MacOSButton;

public class MacOSThemeFactory implements ThemeFactory{

	@Override
	public Button createButton() {
		return new MacOSButton();
	}

	@Override
	public Alarm createAlarm() {
		return new MacOSAlarm();
	}
}
