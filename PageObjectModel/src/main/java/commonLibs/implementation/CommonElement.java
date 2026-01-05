package commonLibs.implementation;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElement;

public class CommonElement implements ICommonElement {

	public String getText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getText();
	}

	public void clickElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.click();
	}

	public String getAttribute(WebElement element, String atribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(atribute);
	}

	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(csspropertyName);

	}

	public boolean isElementEnabled(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	public boolean isElementVisiable(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}
	
	
	public boolean isElementSelected(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isSelected();
	}

	public void setText(WebElement element, String textToWrite) throws Exception {
		// TODO Auto-generated method stub		
		element.sendKeys(textToWrite);
	}

	public void clearText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.clear();
	}

	public void changeTextStatus(WebElement element, boolean expectedStatus) throws Exception {
		// TODO Auto-generated method stub
		boolean currentStatus = element.isSelected();
		if (currentStatus != expectedStatus) {
			element.click();
		}
	}

	public int getXLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().x;
	}

	public int getYLocation(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getLocation().y;
	}

}
