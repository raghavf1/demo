package com.pearson.eselenium.ls.contentitems.equella.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains methods related to EquellaHomePage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaLinkHomePage extends BasePageObject {

	/* UIElwement declarations for EquellaHomePage */
	private UIElement lnkBrowseResourceByFormat = createElement(UIType.Xpath,
			"//a[text()='Browse resources by format ']");

	/* Constructor */
	public EquellaLinkHomePage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION : ### EquellaHomePage ###");
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
	 * This method is used to click on browse resource by format link
	 * 
	 * @author Pratush.Manglik
	 * @return BrowseResourceByFormatPage
	 * @throws Exception
	 */
	public BrowseResourceByFormatPage clickBrowseResourceByFormat()
			throws Exception {
		logInstruction("LOG INSTRUCTION : CLICK BROWSE RESOURSE BY FORMAT LINK");
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lnkBrowseResourceByFormat, waitTime);
			lnkBrowseResourceByFormat.clickNoWait();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK BROWSE RESOURCE BY FORMAT LINK"
							+ "\n METHOD : clickBrowseResourceByFormat \n"
							+ e.getLocalizedMessage());
		}
		return new BrowseResourceByFormatPage(uiDriver);

	}

}
