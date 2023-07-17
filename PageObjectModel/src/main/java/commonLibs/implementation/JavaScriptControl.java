package commonLibs.implementation;

import javax.lang.model.element.Element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.contracts.IJavaScriptOperations;

public class JavaScriptControl implements IJavaScriptOperations {
	private JavascriptExecutor jsEngine;

	public JavaScriptControl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		jsEngine = (JavascriptExecutor) driver;
	}

	public void executeJavaScript(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		jsEngine.executeScript(scriptToExecute);
	}

	public void scrollDown(int x, int y) throws Exception {
		// TODO Auto-generated method stub
		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);
		jsEngine.executeScript(jsCommand);
	}

	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		// TODO Auto-generated method stub
		return jsEngine.executeScript(scriptToExecute).toString();
	}

	public void scrollToElement(WebElement x) throws Exception {
		// TODO Auto-generated method stub
		jsEngine.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'end'});", x);
	}
}
