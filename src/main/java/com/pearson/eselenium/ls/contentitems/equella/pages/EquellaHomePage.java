package com.pearson.eselenium.ls.contentitems.equella.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to EquellaHomePage
 * 
 * @author Suchi.Singh
 * @param uiDriver
 */
public class EquellaHomePage extends BasePageObject {

	/* Elements */
	private UIElement txtEquellaResource = createElement(UIType.Xpath,
			"xpath=html/body/table/tbody/tr/td/h2");
	private UIElement lnkBrowseResourceByFormat = createElement(UIType.Xpath,
			"//a[text()='Browse resources by format ']");

	/* Variables */
	boolean flag;

	/* Constructor */
	public EquellaHomePage(UIDriver driver) {
		super(driver);
		logInstruction("## EquellaHomePage ##");
	}

	/**
	 * This method helps to verify whether Equella Document is present or not
	 * 
	 * @author Suchi.Singh
	 * @return boolean
	 * @throws Exception
	 * 
	 */
	public boolean isEquellaDocumentDisplayed() throws Exception {
		flag = false;

		try {
			logInstruction("LOG INSTRUCTION : VERIFYING WHETHER EQUELLA DOCUMENT IS PRESENT OR NOT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtEquellaResource, waitTime);
			if (txtEquellaResource.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY WHETHER EQUELLA DOCUMENT IS PRESENT OR NOT"
							+ "\n METHOD : isEquellaDocumentDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
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
