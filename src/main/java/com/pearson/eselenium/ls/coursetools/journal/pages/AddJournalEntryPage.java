package com.pearson.eselenium.ls.coursetools.journal.pages;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddJournalEntryPage extends BasePageObject {

	/* UI Elements Declaration */
	private UIElement txtTitle = createElement(UIType.Xpath, "//*[@id='Title']");
	private UIElement btnclickaddentry = createElement(UIType.Css,
			"input[value='Add Entry']");
	private UIElement btnclickCancel = createElement(UIType.Css,
			"input[value='Cancel']");
	private UIElement txtgetheader = createElement(UIType.Xpath,
			"//div[@class='tablehead']");
	private UIElement radEditorDisplayed = createElement(UIType.Xpath,
			"//html//body");
	private UIElement radValue = createElement(UIType.Xpath,
			"//input[contains(@title,'{1}')]");
	private String strJournalRadFrameId = "RadeEntryText_contentIframe";
	private String strJournalRadToolId = "RadeEntryText";
	private VisualEditor radEditor = new VisualEditor(uiDriver,
			strJournalRadToolId, strJournalRadFrameId, strJournalRadToolId);
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");

	/* Variables */
	private boolean flag = false;
	String strHeaderName = null;

	/* Constructor */
	public AddJournalEntryPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("## Journal Page ##");
	}

	public VisualEditor getAddJournalEntryVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return radEditor;
	}

	/**
	 * Method helps to enter title.
	 * 
	 * @param text
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public AddJournalEntryPage enterTitleText(String text) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE TITLE TEXT");
			frameSwitch.switchToFrameContent();
			txtTitle.isDisplayedAfterWaiting(waitTime);
			txtTitle.clearAndSendKeys(text);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'title'"
					+ "\nMETHOD:enterTitleText\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps click on add entry button
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public JournalHomePage clickAddEntryButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKS ON ADD ENTRY BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnclickaddentry, waitTime);
			btnclickaddentry.clickAndWait(waitTime);
			UIElement msgerror = createElement(UIType.Xpath,
					"//td[contains(text(),'Please enter the following to continue:  Title.')]");
			if (msgerror.isDisplayedAfterWaiting(waitTime))
				flag = true;
		} catch (Exception e) {
			logInstruction("ISSUE IN CLICKING IN 'add entry' BUTTON"
					+ "\nMETHOD:clickAddEntryButton\n"
					+ e.getLocalizedMessage());
		}
		return new JournalHomePage(uiDriver);
	}

	/**
	 * Method helps click on cancel button
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public JournalHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKS ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnclickCancel, waitTime);
			btnclickCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'cancel' BUTTON"
					+ "\nMETHOD:clickCancelButton\n" + e.getLocalizedMessage());
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

		try {
			logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtgetheader, waitTime);
			strHeaderName = txtgetheader.getText().trim();

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE 'header' TITLE"
					+ "\nMETHOD:getHeaderTitle\n" + e.getLocalizedMessage());
		}

		return strHeaderName;
	}

	/**
	 * Method helps to verify rad editor.
	 * 
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public boolean isRadEditorDisplayed() throws Exception {
		flag = false;
		logInstruction("LOG INSTRUCTION:VERIFIYING RAD EDITOR");
		try {
			frameSwitch.switchToAddLinkFrame();
			uiDriver.waitToBeDisplayed(radEditorDisplayed, waitTime);
			flag = radEditorDisplayed.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'rad' EDITOR"
					+ "\nMETHOD:isRadEditorDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to select sharing radio button
	 * 
	 * @param sharing
	 * @return
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public AddJournalEntryPage selectSharingRadioButton(String sharing)
			throws Exception {

		logInstruction("LOG INSTRUCTION: SELECTING A RADIO BUTTON");
		try {
			frameSwitch.switchToAddLinkFrame();
			radValue.replaceValues(sharing);
			radValue.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING 'radio' BUTTON"
					+ "\nMETHOD:selectSharingRadioButton\n"
					+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This MEthod will check whether inliner error message is coming or not
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isInlinErrorMSGDisplayed() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : VERIFYING ERROR MESSAGE");
			if (flag)
				return true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE MESSAGE \n METHOD :isInlinErrorMSGDisplayed ");
		}
		return false;
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
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to add Journal Entry
	 * 
	 * @category Milestone2 Service Method
	 * @author amit.deshmukh
	 * @param title
	 * @param content
	 * @param radiobutton
	 * @return {@link JournalHomePage}
	 * @throws Exception
	 */

	public JournalHomePage addJouranlEntry(String title, String content,
			boolean Share, boolean Private) throws Exception {

		logInstruction("LOG INSTRUCTION : ADDING JOURNAL ENTRY");
		try {
			if (StringUtils.isNotBlank(title)
					&& StringUtils.isNotBlank(content)
					&& (Share == true && Private == true)) {
				logInstruction("LOG INSTRUCTION: ENTERING THE TITLE TEXT");
				frameSwitch.switchToFrameContent();

				txtTitle.isDisplayedAfterWaiting(waitTime);
				txtTitle.sendKeys(title);
				logInstruction("LOG INSTRUCTION: ENTERING THE CONTENT TEXT");
				getAddJournalEntryVisualEditor().enterText(content);

				if (Share == true) {

					radValue.replaceValues("Share");
					radValue.clickNoWait();
				}

				if (Private == true) {

					radValue.replaceValues("Private");
					radValue.clickNoWait();
				}

				logInstruction("LOG INSTRUCTION : CLICKING ON ADD ENTRY BUTTON");
				uiDriver.waitToBeDisplayed(btnclickaddentry, waitTime);
				btnclickaddentry.clickNoWait();

			}

		} catch (Exception e) {

			throw new Exception("UNABLE TO ADD 'journal' "
					+ "\n METHOD:addJouranlEntry \n" + e.getLocalizedMessage());

		}

		return new JournalHomePage(uiDriver);

	}

}
