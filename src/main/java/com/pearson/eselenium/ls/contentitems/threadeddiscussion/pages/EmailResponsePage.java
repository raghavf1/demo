package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EmailResponsePage extends BasePageObject {

	/* Elements */
	private UIElement btnCancel = createElement(
			UIType.Xpath,
			"//*[@id='respondToAuthorView']/table[4]/tbody/tr/td/table[1]/tbody/tr/td/input[2]");
	private String strEmailResponseRadToolId = "RadeEntryText";
	private String strEmailResponseRadFrameId = "RadeEntryText_contentIframe";
	private VisualEditor objEmailResponse = new VisualEditor(uiDriver,
			strEmailResponseRadToolId, strEmailResponseRadFrameId,
			strEmailResponseRadToolId);
	private UIElement btnSendMsg = createElement(UIType.Xpath,
			"//input[@onclick='sendMail()']");
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
    boolean flag=false;
	/* Constructor */
	public EmailResponsePage(UIDriver driver) {
		super(driver);
		logInstruction("##EmailResponsePage##");
	}



	public VisualEditor getemailResponseRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return objEmailResponse;
    }

	/**
	 * This method will help to click on Cancel button.
	 * 
	 * @Author suchi.singh
	 * @return EmailResponsePage
	 */
	public EmailResponsePage clickCancel() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();

			if (!btnCancel.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Cancel Button' DOES NOT EXISTS");
			}

			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'Cancel Button' \n METHOD: clickCancel \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This Method will check is Email Response RAD Editor Displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isEmailResponseRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER EMAIL RESPONSE RAD EDITOR IS BEING DISPLAYED");
			if (objEmailResponse != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER  EMAIL RESPONSE RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isEmailResponseRADEditorDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify Alternative Editor Present or not..
	 * 
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author suchi.singh
	 */
	public boolean isEditorSwitchDisplayed() throws Exception {
	flag = false;
        logInstruction("LOG INSTRUCTION: ALTERNATIVE EDITOR PRESENT OR NOT...");
        try {
        	flag = lnkEditorSwitch.isDisplayedAfterWaiting(waitTime);
	      	  logInstruction("LOG INSTRUCTION: VERIFYING ALTERNATIVE EDITOR PRESENT");

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION." + "\n METHOD : isEditorSwitchDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
	}

	/**
	 * This method will click on send Message button
	 * 
	 * @return ThreadHomePage
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public ThreadHomePage clickSendMessage() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : CLICKING ON SEND MESSGAE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSendMsg, waitTime);
			btnSendMsg.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON SEND MESSAGE."
					+ "\n METHOD : clickSendMessage \n"
					+ e.getLocalizedMessage());
		}
		return new ThreadHomePage(uiDriver);
	}
}
