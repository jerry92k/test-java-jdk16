package abstractfactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import abstractfactory.subclass.Alarm;
import abstractfactory.subclass.MacOSAlarm;
import abstractfactory.subclass.MacOSButton;
import abstractfactory.subclass.WindowsAlarm;
import abstractfactory.subclass.WindowsButton;

public class ThemeService {

	@Test
	void 추상_팩토리_패턴_윈도우_테마(){
		ThemeFactory windowsThemeFactory = new WindowsThemeFactory();
		Assertions.assertEquals(windowsThemeFactory.createAlarm().getClass(), WindowsAlarm.class);
		Assertions.assertEquals(windowsThemeFactory.createButton().getClass(), WindowsButton.class);
	}

	@Test
	void 추상_팩토리_패턴_맥_테마(){
		ThemeFactory macOSThemeFactory = new MacOSThemeFactory();
		Assertions.assertEquals(macOSThemeFactory.createAlarm().getClass(), MacOSAlarm.class);
		Assertions.assertEquals(macOSThemeFactory.createButton().getClass(), MacOSButton.class);
	}
}
