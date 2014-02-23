package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to Edit Topic Page
 * 
 * @author ganapati.bhat
 * 
 */
public class EditTopicPage extends BasePageObject {

	/* UIElement declarations for the edit topic page */
	private UIElement areaText = createElement(UIType.Xpath, "//html/body");
	private UIElement btnCancel = createElement(UIType.Css, "#btncancel1");
	private static final String strEditTopicRadToolId = "RadeEntryText";
	private static final String strEditTopicRadFrameId = "RadeEntryText_contentIframe";
	private UIElement btnSaveChanges = createElement(UIType.Css, "#btnAdd");
	private VisualEditor objEditTopic = new VisualEditor(uiDriver,
			strEditTopicRadToolId, strEditTopicRadFrameId,
			strEditTopicRadToolId);
	private UIElement txtErrorMessage = createElement(UIType.Xpath,
			"//td[@class='inlineerror']//tbody/tr/td[2]");
	private UIElement txtTitle = createElement(UIType.Css, "#topicTitle");

	/* Variables */
	private boolean flag = false;
	private String strResult = null;

	/* Constructor */
	public EditTopicPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## EditTopicPage ##");
	}

	public VisualEditor getEditTopicRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return objEditTopic;
	}

	/**
	 * return the text from the editor
	 * 
	 * @Author Ashish
	 * @return boolean
	 * @param String
	 * @throws Exception
	 */
	public boolean isTextDisplayed(String srtEditorMessage) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: RETURN THE TEXT FROM THE EDITOR");
			frameSwitch
					.switchToRadeEntryTextcontentIframethroughtopGeneralFrame();

			if (!areaText.isDisplayedAfterWaiting(waitTime)
					&& StringUtils.isNotBlank(srtEditorMessage)) {
				throw new Exception("'Radeditor Text' DOES NOT EXISTS");
			}
			flag = areaText.getText().equalsIgnoreCase(srtEditorMessage);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING THE 'Text in RadEditor' \n METHOD: isTextDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * method to click on Cancel
	 * 
	 * @author Soundarya
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickCancel() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON CANCEL");
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
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * @author Suchi.Singh
	 * @return Object
	 * @throws Exception
	 *             Method for clicking on SaveChanges button.
	 */

	public Object clickSaveChangesButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: clicking on SaveChanges button");
			frameSwitch.switchToFrameContent();

			btnSaveChanges.clickAndWait(waitTime);

			if (getErrorMessage() == null) {
				return new ThreadHomePage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception(
					"LOG INSTRUCTION: ISSUE IN CLICKING 'Save Changes Button'"
							+ "\n METHOD: clickSaveChangesButton \n"
							+ e.getLocalizedMessage());
		}
		return new EditTopicPage(uiDriver);
	}

	/*
	 * This method helps to get the error message when the add item button
	 * pressed without entering the title
	 * 
	 * @author:Suchi.Singh
	 * 
	 * @return:String
	 */
	public String getErrorMessage() throws Exception {
		strResult = null;
		try {
			frameSwitch.switchToFrameContent();
			if (txtErrorMessage.isDisplayedAfterWaiting()) {
				strResult = txtErrorMessage.getText();
			} else {
				strResult = null;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'Error' MESSAGE"
					+ "\n METHOD:getErrorMessage\n" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * This methods Add the title
	 * 
	 * @return EditTopicPage
	 * @param String
	 *            - description
	 * @author Suchi.Singh
	 * @throws Exception
	 */

	public EditTopicPage enterTitle(String description) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: INSIDE ENTER TITLE METHOD");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			txtTitle.clearAndSendKeys(description);

		} catch (Exception e) {
			throw new Exception("LOG INSTRUCTION: ISSUE IN ENTERING 'Title'"
					+ "\n METHOD: enterTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}
}
