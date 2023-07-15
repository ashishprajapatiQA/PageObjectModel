package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IMouseOperation;

public class MouseControl implements IMouseOperation {

	private Actions action;

	public MouseControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		action = new Actions(driver);
	}

	public void dragAndDrop(WebElement source, WebElement target) throws Exception {
		// TODO Auto-generated method stub
		action.dragAndDrop(source, target).build().perform();
	}

	public void moveTOElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		action.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		action.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		action.doubleClick(element).build().perform();
	}

	public void moveTOElementAndClick(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		action.moveToElement(element).click(element).build().perform();
	}

}
