package com.pearson.eselenium.ls.contentitems.equella.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains methods related to EquellaImagesPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaImagesPage extends BasePageObject {

	/* UIElement declarations for EquellaImagesPage */
	private UIElement btnSelect = createElement(UIType.Xpath,
			"//div[@class='itemlist']//div[//div[h3//a[@title='{1}']]]//div[//div[input]]");

	/* Constructor */
	public EquellaImagesPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION :  ### EquellaImagesPage ###");
	}

	/**
	 * Method helps to switch the window
	 * 
	 * @author Pratush.Manglik
	 * @throws Exception
	 */
	public void switchToWindow() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION :SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception("UNABLE TO SWITCH THE WINDOW"
					+ "\n METHOD : switchToWindow \n" + e.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to click on Select button
	 * 
	 * @author Pratush.Manglik
	 * @param imgName
	 * @return EquellaSelectionPage
	 * @throws Exception
	 */
	public EquellaSelectionPage clickSelectButton(String imgName)
			throws Exception {
		logInstruction("LOG INSTRUCTION : CLICK ON SELECT BUTTON");
		try {
			frameSwitch.switchToAddLinkFrame();
			btnSelect.replaceValues(imgName);
			uiDriver.waitToBeDisplayed(btnSelect, waitTime);
			btnSelect.clickNoWait();
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON SELECT BUTTON"
					+ "\n METHOD : clickSelectButton \n"
					+ e.getLocalizedMessage());
		}
		return new EquellaSelectionPage(uiDriver);
	}
}
