package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This Class contains all methods related to the XhtmlValidatorpage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class XhtmlValidatorPage extends BasePageObject {
	
	/* Elements */
	private UIElement radValidationTyp=createElement(UIType.Xpath, "//td[label[contains(.,'{1}')]]");
	private UIElement lblValidationType=createElement(UIType.Xpath, "//td[label[contains(.,'{1}')]]");

	/* Constructor */
	public XhtmlValidatorPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## XHTML Validator Page ##");
	}

	public void switchToWindow() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception("UNABLE TO SWITCH THE WINDOW \n METHOD :switchToWindow  "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method is used to verify whether radio button is present or not
	 * 
	 * @author Pratush.Manglik
	 * @param String nameofOptions
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isOptionsPresent(String nameofOptions) throws Exception {
		boolean flag = false;
		try {
			logInstruction("LOG INSTRUCTION: IS RADIO BUTTON DISPLAYED");
			uiDriver.waitToBeDisplayed(lblValidationType, waitTime);
			lblValidationType.replaceValues(nameofOptions);
			flag = lblValidationType.isDisplayed();
		} catch (Exception e) {
			throw new Exception("RADIO BUTTON IS NOT DISPLAYED \n METHOD : isOptionsPresent"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method is used to select the radio button for XHTML validator
	 * 
	 * @author Pratush.Manglik
	 * @param String nameofOptions
	 * @return XHTMLValidatorPage
	 * @throws Exception
	 */
	public XhtmlValidatorPage selectOptions(String nameofOptions)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT RADIO BUTTON FOR VALIDATOR");
			uiDriver.waitToBeDisplayed(radValidationTyp, waitTime);
			radValidationTyp.replaceValues(nameofOptions);
			radValidationTyp.clickNoWait();
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT RADIO BUTTON \n METHOD :selectOptions "
					+ e.getLocalizedMessage());
		}
		return this;
	}
	
	/**
	 * This method will verify XHTML validator page 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isXHTMLValidatorDisplayed() throws Exception{
		boolean flag=false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING XHTML VALIDATOR PAGE ");
			uiDriver.getUIWindowLocator().switchToNewWindow();
			String title=uiDriver.getTitle().trim();
			if(title.equals("XHTML Validator")){
				flag=true;
			}
			uiDriver.close();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			
		}
		return flag;
	}
}
