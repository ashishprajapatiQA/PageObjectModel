package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.contracts.IFrames;

public class FrameControl implements IFrames {

	private WebDriver driver;

	public FrameControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void switchToFrame(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		driver.switchTo().frame(element);
	}

	public void switchToFrame(int index) throws Exception {
		// TODO Auto-generated method stub
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String id) throws Exception {
		// TODO Auto-generated method stub
		driver.switchTo().frame(id);

	}

	public void switchToParentpage() throws Exception {
		// TODO Auto-generated method stub
		driver.switchTo().defaultContent();

	}

}
