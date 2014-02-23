package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.PlainTextEditor;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

public class DropboxEmailPage extends BasePageObject {

	/* UIElements */
	private UIElement lblHeaderTitle = createElement(UIType.Css,
			"div.pageTitle");
	private UIElement btnRemove = createElement(UIType.Xpath,
			"//input[@value='Remove']");
	private UIElement btnAdd = createElement(UIType.Xpath,
			"//input[@value='Add']");
	private UIElement radEditor = createElement(UIType.ID,
			"MailBody_contentIframe");
	private UIElement txtSubject = createElement(UIType.ID, "subject");
	private UIElement btnOK = createElement(UIType.Xpath,
			"//form[@id='Confirmation']/input");
	private UIElement txtRadContent = createElement(UIType.Xpath, "//html/body");
	private UIElement msgError = createElement(UIType.Xpath,
			"//table[@class='outercontenttable']//tbody//td[@class='inlineerror']");
	private UIElement lstRecipients = createElement(
			UIType.Xpath,
			"//table[@role='presentation']//select[@ id='courseMembers']/option[contains(.,'{1}')]");

	private static final String CONTENTRADEDITORTABLEID = "MailBodyCenter";
	private static final String DROPBOXEMAILTOOLID = "MailBody_contentIframe";
	VisualEditor visualEditor = new VisualEditor(uiDriver,
			CONTENTRADEDITORTABLEID, DROPBOXEMAILTOOLID,
			CONTENTRADEDITORTABLEID);
	PlainTextEditor plainEditor = new PlainTextEditor(uiDriver);
	private String strValue = null;
	private String strMessage = null;
	private boolean flag = false;

	/* Constructor */
	public DropboxEmailPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "Dropbox Email";
		logInstruction("## DropboxEmailPage ##");
	}

	/**
	 * Method helps to get DropboxEmail page 'Header' name
	 * 
	 * @author Usha
	 * @return String
	 * @throws Exception
	 */
	public String getHeaderName() throws Exception {
		strMessage = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY DROPBOXEMAIL PAGE TITLE");
			frameSwitch.switchToFrameContent();
			strMessage = lblHeaderTitle.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK FOR THE DROPBOXEMAIL PAGE TITLE. \nMETHOD: getHeaderName.\n"
							+ e.getLocalizedMessage());
		}
		return strMessage;
	}

	/**
	 * Method helps to check 'RadEditor' Displayed For 'DropboxEmailPage' or
	 * not.
	 * 
	 * @return boolean
	 * @author usha.reddy
	 * @throws Exception
	 */

	public boolean isRadEditorDisplayedForThreadEmailPage() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING 'RadEditor' DISPLAYED FOR 'DropboxEmailPage'");
			frameSwitch.switchToFrameContent();
			flag = radEditor.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"'RadEditor' IS NOT DISPLAYED FOR 'DropboxEmailPage'. \nMETHOD: isRadEditorDisplayedForThreadEmailPage.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to enter the subject text
	 * 
	 * @author Usha
	 * @param String
	 *            name: text
	 * @return DropboxEmailPage
	 * @throws Exception
	 */
	public DropboxEmailPage enterSubject(String strText) throws Exception {
		logInstruction("LOG INSTRUCTION: ENTER THE CONTENT FOR SUBJECT");
		try {
			if (StringUtils.isNotBlank(strText)) {
				frameSwitch.switchToFrameContent();
				uiDriver.waitToBeDisplayed(txtSubject, waitTime);
				txtSubject.sendKeysToFileInput(strText);
			} else
				throw new Exception(
						"PARAMETERS IS BLANK. \nMETHOD: enterSubject.\n");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO ENTER THE SUBJECT TEXT. \nMETHOD: enterSubject.\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to get content
	 * 
	 * @author Usha
	 * @return String
	 * @throws Exception
	 */

	public String getTextFromContentRadEditor() throws Exception {
		strMessage = null;
		try {
			logInstruction("LOG INSTRUCTION: GET THE CONTENT FROM 'RadEditor'.");
			if (!getBrowser().equals(Browser.INTERNETEXPLORER)) {
				frameSwitch.switchToFrameContent();
				frameSwitch.switchToRadEmailcontentIframe();
				strMessage = txtRadContent.getText();
			} else {
				logInstruction("LOG INSTRUCTION: SKIPPING TEXT FETCH FOR IE");
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE TEXT FROM 'RadEditor'. \nMETHOD: getTextFromContentRadEditor.\n"
							+ e.getLocalizedMessage());
		}
		return strMessage;
	}

	/**
	 * Method helps to click on the Add button
	 * 
	 * @author Usha
	 * @return DropboxEmailPage
	 * @throws Exception
	 */
	public DropboxEmailPage clickAddButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Add' BUTTON.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAdd, waitTime);
			btnAdd.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON 'Add' BUTTON. \nMETHOD: clickAddButton.\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on the Remove button
	 * 
	 * @author Usha
	 * @return DropboxEmailPage
	 * @throws Exception
	 */
	public DropboxEmailPage clickRemoveButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Remove' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnRemove, waitTime);
			btnRemove.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE 'Remove' BUTTON. \nMETHOD: clickRemoveButton.\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to check for Entered subject
	 * 
	 * @author Usha
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isSubjectEntered(String strText) throws Exception {
		flag = false;
		strValue = null;
		try {
			if (StringUtils.isNotBlank(strText)) {
				logInstruction("LOG INSTRUCTION: CHECK FOR ENTERED 'Subject'");
				frameSwitch.switchToFrameContent();
				uiDriver.waitToBeDisplayed(txtSubject, waitTime);
				strValue = txtSubject.getText();
				flag = strValue.contains(strText);
			} else
				throw new Exception(
						"PARAMETERS IS BLANK. \nMETHOD: isSubjectEntered.\n");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND THE ENTERED 'Subject'. \nMETHOD: isSubjectEntered.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to click on OK button. Navigates to {@link DropboxPage}.
	 * 
	 * @author Usha
	 * @return {@link DropboxPage}
	 * @throws Exception
	 */
	public DropboxPage clickOKButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Ok' BUTTON.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnOK, waitTime);
			btnOK.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON 'Ok' BUTTON. \nMETHOD: clickOKButton.\n"
							+ e.getLocalizedMessage());
		}
		return new DropboxPage(uiDriver);
	}

	/**
	 * Method helps to get confirmation message
	 * 
	 * @author Usha
	 * @return String - message
	 * @throws Exception
	 */
	public String getConfirmationMessage() throws Exception {
		strMessage = null;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY CONFIRMATION MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtSubject, waitTime);
			strMessage = txtSubject.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CHECK FOR CONFIRMATION MESSAGE. \nMETHOD: getConfirmationMessage.\n"
							+ e.getLocalizedMessage());
		}
		return strMessage;
	}

	/**
	 * Method helps to check for error message displayed without entering
	 * subject
	 * 
	 * @author Usha
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isErrorMessageDisplayedWithoutEntereingSubject()
			throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECK FOR 'error message' DISPLAYED WITHOUT ENTERING SUBJECT");
			frameSwitch.switchToFrameContent();
			flag = msgError.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO FIND 'error message'. \nMETHOD: isErrorMessageDisplayedWithoutEntereingSubject.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to selectOption from Recipents list.
	 * 
	 * @author Usha
	 * @return DropboxEmailPage
	 * @throws Exception
	 */
	public DropboxEmailPage selectOptionfromRecipentsDropdown(
			String strRecipients) throws Exception {
		try {
			if (StringUtils.isNotBlank(strRecipients)) {
				logInstruction("LOG INSTRUCTION: SELECTING 'Option' FROM 'RecipentsList'");
				frameSwitch.switchToFrameContent();
				lstRecipients.replaceValues(strRecipients);
				lstRecipients.selectByVisibleText(strRecipients);
			} else
				throw new Exception(
						"PARAMETERS IS BLANK. \nMETHOD: selectOptionfromRecipentsDropdown.\n");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SELECT 'Option' FROM 'RecipentsList'. \nMETHOD: selectOptionfromRecipentsDropdown.\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}
}
