package commonLibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonLibs.contracts.IDropdown;

public class DropdownControl implements IDropdown {

	private Select getSelect(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
		// TODO Auto-generated method stub

		getSelect(element).selectByVisibleText(visibleText);
	}

	public void selectViaValue(WebElement element, String value) throws Exception {
		// TODO Auto-generated method stub
		getSelect(element).selectByValue(value);
	}

	public void selectViaIndex(WebElement element, int index) throws Exception {
		// TODO Auto-generated method stub
		getSelect(element).selectByIndex(index);
	}

	public List<WebElement> getAllOption(WebElement element) {
		// TODO Auto-generated method stub
		return getSelect(element).getOptions();
	}

}
