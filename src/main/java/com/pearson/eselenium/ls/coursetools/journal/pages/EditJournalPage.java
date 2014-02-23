package com.pearson.eselenium.ls.coursetools.journal.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditJournalPage extends BasePageObject {

	/* UI Elements */
	private UIElement btncancel = createElement(UIType.Css,
			"input[value='Cancel']");
	private UIElement btnsave = createElement(UIType.Css,
			"input[value='Save Changes']");
	private UIElement lblheader = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement lblradEditorDisplayed = createElement(UIType.Xpath,
			"//html//body");
	private UIElement txtTitle = createElement(UIType.Xpath, "//*[@id='Title']");
	private UIElement lbleditInfo = createElement(UIType.Xpath, "");
	private UIElement txtentercontent = createElement(UIType.Xpath,
			"//html/body");
	private UIElement radValue = createElement(UIType.Xpath,
			"//input[contains(@title,'{1}')]");

	/* Variables */
	private String strToolID = "RadeEntryText";
	private String strFrameID = "RadeEntryText_contentIframe";

	/* Constructor */
	public EditJournalPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("## Edit Journal Page ##");
	}

	private VisualEditor visualEditor = new VisualEditor(uiDriver, strToolID,
			strFrameID, strToolID);

	public VisualEditor getVisulEditor() {
		return visualEditor;
	}

	/**
	 * Method helps to click on cancel button.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public JournalHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSRUCTION: CLICK ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btncancel, waitTime);
			btncancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'cancel' BUTTON"
					+ "\nMETHOD:clickCancelButton\n" + e.getLocalizedMessage());
		}
		return new JournalHomePage(uiDriver);
	}

	/**
	 * Method helps to click on save changes button.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public JournalHomePage clickSaveChanges() throws Exception {
		try {
			logInstruction("LOG INSRUCTION: CLICK ON SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnsave, waitTime);
			btnsave.click();
		} catch (Exception e) {

			throw new Exception("ISSUE IN CLICKING 'save changes' BUTTON"
					+ "\n METHOD:clickSaveChanges\n" + e.getLocalizedMessage());

		}
		return new JournalHomePage(uiDriver);
	}

	/**
	 * Method helps to get header title.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public String getHeaderTitle() throws Exception {
		String headername = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblheader, waitTime);
			headername = lblheader.getText().trim();

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'header' TITLE"
					+ "\nMETHOD:getHeaderTitle\n" + e.getLocalizedMessage());
		}

		return headername;
	}

	/**
	 * Method helps to edit the title.
	 * 
	 * @param editedText
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public EditJournalPage editTitleText(String editedText) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTER TEXT INTO EDIT TEXT INFO");
			frameSwitch.switchToFrameContent();
			txtTitle.clearAndSendKeys(editedText);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'edit'INFO"
					+ "\n METHOD:editTitleText \n");
		}
		return this;
	}

	/**
	 * Method helps to verify rad editor.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isRadEditorDisplayed() throws Exception {

		logInstruction("LOG INSTRUCTION: VERIFIYING RAD EDITOR");
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(lblradEditorDisplayed, waitTime);
			return lblradEditorDisplayed.isDisplayedAfterWaiting(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'rad'EDITOR"
					+ "\nMETHOD:isRadEditorDisplayed\n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to get error message.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public String getErrorMessgaeWhenSubjectFieldIsBlank() throws Exception {
		String message = null;
		try {
			logInstruction("LOG INSTRUCTION:GETTING THE ERROR MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBePresent(lbleditInfo, waitTime);
			if (lbleditInfo.isDisplayed()) {
				message = lbleditInfo.getText();
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'error' MESSAGE"
					+ "\nMETHOD:getErrorMessgaeWhenSubjectFieldIsBlank\n"
					+ e.getLocalizedMessage());
		}
		return message;
	}

	/**
	 * Method helps to enter content
	 * 
	 * @param Content
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public EditJournalPage enterContent(String Content) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE CONTENT");
			frameSwitch.switchToRadeEntryTextcontentIframe(); // changes
																// frame
			uiDriver.waitToBeDisplayed(txtentercontent, waitTime);
			txtentercontent.sendKeys(Content);

		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'content'"
					+ "\nMETHOD:enterContent\n" + e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to edit journal
	 * 
	 * @author amit.deshmukh
	 * @category Milestone2 Service Method
	 * @param title
	 * @param content
	 * @param radiobutton
	 * @return
	 * @throws Exception
	 */

	public JournalHomePage editJouranlEntry(String title, String content,
			String radiobutton, boolean Share, boolean Private)
			throws Exception {

		logInstruction("LOG INSTRUCTION : EDITING JOURNAL ENTRY");
		try {
			if (Share == true && Private == true) {
				logInstruction("LOG INSTRUCTION: ENTERING THE TITLE TEXT");
				frameSwitch.switchToFrameContent();
				txtTitle.clearAndSendKeys(title);
				logInstruction("LOG INSTRUCTION: ENTERING THE CONTENT TEXT");
				txtTitle.clearAndSendKeys(content);
				if (Share == true) {

					radValue.replaceValues("Share");
					radValue.clickNoWait();
				}

				if (Private == true) {

					radValue.replaceValues("Private");
					radValue.clickNoWait();
				}

				logInstruction("LOG INSTRUCTION : CLICKING ON SAVE CHANGES BUTTON");
				uiDriver.waitToBeDisplayed(btnsave, waitTime);
				btnsave.clickNoWait();

			}

		} catch (Exception e) {

			throw new Exception("UNABLE TO EDIT 'journal' "
					+ "\n METHOD:editJouranlEntry \n" + e.getLocalizedMessage());

		}

		return new JournalHomePage(uiDriver);

	}

}