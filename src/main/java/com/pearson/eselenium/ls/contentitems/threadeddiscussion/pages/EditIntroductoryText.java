package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditIntroductoryText extends BasePageObject {

	/* Elements */
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	
	private UIElement btnSave = createElement(UIType.Xpath,
			"//input[@value='Save Changes']");
	private UIElement btnCancel = createElement(UIType.Xpath,
			"//input[@value='Cancel']");
 private String strEditIntroductoryTextRadToolId = "RadeEntryText";
    private String strEditIntroductoryTextRadFrameId = "RadeEntryText_contentIframe";
    private String strEditIntroductoryTextRadFooterId = "RadeEntryText_ModesWrapper";
    private VisualEditor objEditIntroductoryText = new VisualEditor(
            uiDriver,
            strEditIntroductoryTextRadToolId,
            strEditIntroductoryTextRadFrameId,strEditIntroductoryTextRadFooterId);
    boolean flag=false;

	/* Constructor */
	public EditIntroductoryText(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("## Thread Home Page ##");
	}

 public VisualEditor geteditIntroductoryTextRadEditor() throws Exception {
    	frameSwitch.switchToFrameContent();
        return objEditIntroductoryText;
    }

	/**
	 * Method helps to click on save button.
	 * 
	 * @return ThreadHomePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ThreadHomePage clickOnSave() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE SAVE TOPIC");
			frameSwitch.switchToFrameContent();
			if (!btnSave.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Save Button' DOES NOT EXISTS");
			}

			btnSave.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: SAVE BUTTON IS CLICKED");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'Save Button' \n METHOD: clickOnSave \n"
							+ e.getLocalizedMessage());
		}
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * Method helps to click on cancel button.
	 * 
	 * @return ThreadHomePage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ThreadHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			if (!btnCancel.isDisplayedAfterWaiting(waitTime)) {
				throw new Exception("'Cancel Button' DOES NOT EXISTS");
			}

			btnCancel.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CANCEL BUTTON IS CLICKED");
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON 'Cancel Button' \n METHOD: clickCancelButton \n"
							+ e.getLocalizedMessage());

		}
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * This Method will check is Edit Introductory Text RAD Editor Displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isEditIntroductoryTextRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER EDIT INTRODUCTORY TEXT RAD EDITOR IS BEING DISPLAYED");
			if (objEditIntroductoryText != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER  EDIT INTRODUCTORY TEXT RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isEditIntroductoryTextRADEditorDisplayed \n"
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

}