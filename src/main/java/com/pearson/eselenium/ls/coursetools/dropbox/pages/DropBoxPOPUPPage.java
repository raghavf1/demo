package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class DropBoxPOPUPPage extends BasePageObject {

	public DropBoxPOPUPPage(UIDriver driver) {
		super(driver);

	}

	private String ToolID = "RadeEntryText";
	private String frameID = "RadeEntryText_contentIframe";
	private UIElement lnkrespond = createElement(UIType.LinkText,
			"Respond or Submit an Additional Assignment");
	private UIElement btnsubmit = createElement(UIType.Xpath,
			"//input[@id='save']");
	private VisualEditor visualEditor = new VisualEditor(uiDriver, ToolID,
			frameID, ToolID);
	private UIElement btnsaveandclose = createElement(UIType.Xpath,
			"//input[@id='SaveAndClose']");

	 public VisualEditor getVisualEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return visualEditor;
    }

	/**
	 * This Methpd will click on Respond or Submit Link.
	 * 
	 * @return
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public DropBoxPOPUPPage clickRespondOrSubmitAssignment() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON rESPOND LINK");
			uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
			uiDriver.waitToBeDisplayed(lnkrespond, waitTime);
			lnkrespond.click();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON RESPOND \n METHOD : clickRespondOrSubmitAssignment");
		}
		return this;
	}

	/**
	 * This Method will click on submit Assignment
	 * 
	 * @return
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public DropboxPage clickSubmitAssignmentButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION CLICKING ON SUBMIT BUTTON");
			uiDriver.switchTo().defaultContent();
			uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
			uiDriver.waitToBeDisplayed(btnsubmit, waitTime);
			btnsubmit.clickNoWait();
			uiDriver.getUIWindowLocator().switchToFirstWindow();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE SUBMIT BUTTON \n METHOD : clickSubmitAssignmentButton");
		}
		return new DropboxPage(uiDriver);
	}

	public boolean isPOPUPPageDisplayed() throws Exception {
		boolean flag = false;
		String title = "";
		try {
			logInstruction("LOG INSTRUCTION : VERIFYING THE PAGE ");
			title = uiDriver.getTitle();
			if (title.contains("Dropbox Basket Submission Details")) {
				flag = true;
			}
			uiDriver.close();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE PAGE \n METHOD :isPOPUPPageDisplayed ");
		}
		return flag;

	}

	/**
	 * This Method will click on save and close button
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public DropboxPage clickSaveAndCloseButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON SAVE AND CLOSE BUTTON");
			uiDriver.switchTo().defaultContent();
			uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
			uiDriver.waitToBeDisplayed(btnsaveandclose, waitTime);
			btnsaveandclose.click();
			uiDriver.getUIWindowLocator().switchToFirstWindow();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON SAVE AND CLOSE BUTTON \n METHOD : clickSaveAndCloseButton");
		}
		return new DropboxPage(uiDriver);
	}
}
