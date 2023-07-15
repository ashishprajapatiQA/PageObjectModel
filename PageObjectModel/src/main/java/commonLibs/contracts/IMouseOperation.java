package commonLibs.contracts;

import org.openqa.selenium.WebElement;

public interface IMouseOperation {

	public void dragAndDrop(WebElement source, WebElement target) throws Exception;

	public void moveTOElement(WebElement element) throws Exception;

	public void rightClick(WebElement element) throws Exception;

	public void doubleClick(WebElement element) throws Exception;

	public void moveTOElementAndClick(WebElement element) throws Exception;

}
