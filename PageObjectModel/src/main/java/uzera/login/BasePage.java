package uzera.login;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.AlertControl;
import commonLibs.implementation.CommonElement;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.FrameControl;
import commonLibs.implementation.MouseControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;

public class BasePage {

	
	// this is base class which define object & initialize
	// so we just extend this to all other class (reusing code via extends)

	protected AlertControl alertControl;
	protected CommonElement elementControl;
	protected DropdownControl dropdownControl;
	protected FrameControl frameControl;
	protected MouseControl mouseControl;
	
	

	public BasePage(WebDriver driver) {
		alertControl = new AlertControl(driver);
		elementControl = new CommonElement();
		dropdownControl = new DropdownControl();
		frameControl = new FrameControl(driver);
		mouseControl = new MouseControl(driver);
	}

}
