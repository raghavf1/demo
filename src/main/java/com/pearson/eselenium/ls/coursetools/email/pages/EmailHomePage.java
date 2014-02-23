package com.pearson.eselenium.ls.coursetools.email.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import com.pearson.eselenium.ls.common.pages.AddRemoveAttachmentsPage;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

public class EmailHomePage extends BasePageObject {

	/**
	 * This page contains AddOrRemoveAttachment,getAttachedFileList the methods
	 * for the EmailHomePage
	 * 
	 * @author soundarya
	 */

	List<UIElement> lstAttach = new ArrayList<UIElement>();;
	private List<String> lstAttachedFiles = new ArrayList<String>();
	private boolean flag = false;
	private String strEmailHomeRadEditorToolId = "MailBody";
	private String strEmailHomeRadEditorFrameId = "MailBody_contentIframe";

	/* UIElements of the EmailHomePage */
	private UIElement lnkAddOrRemoveAttachment = createElement(UIType.Css,
			"a[title='Attachment']");
	private UIElements lstAttachfile = createElements(UIType.Css,
			".tableitem a");
	private UIElement btnAddRecipients = createElement(UIType.Css,
			"input[name='add recipients']");
	private UIElement btnRemoveRecipients = createElement(UIType.Css,
			"input[name='remove recipients']");
	private UIElement btnOK = createElement(UIType.Css, "#Confirmation input");
	private UIElement lstSelectRecipientToAdd = createElement(UIType.ID,
			"courseMembers");
	private UIElement lstAddedSelectRecipientToARemove = createElement(
			UIType.ID, "selectedMembers");
	private UIElement lnkAttachedFile = createElement(UIType.Xpath,
			"//tbody/tr/td/a[contains(text(),'{1}')]");
	private UIElement txtSubject = createElement(UIType.ID, "subject");
	private UIElement txtCCUser = createElement(UIType.ID, "ccUsers");
	private UIElement btnSendMessage = createElement(UIType.Css,
			"input[value='Send Message']");
	private UIElement imgAttachedFileIcon = createElement(UIType.Xpath,
			"//tbody/tr/td//a[contains(text(),'{1}')]/img");
	private UIElement lblPageHeader = createElement(UIType.Css, ".pageTitle ");
	private VisualEditor emailHomeRadEditor = new VisualEditor(uiDriver,
			strEmailHomeRadEditorToolId, strEmailHomeRadEditorFrameId,
			strEmailHomeRadEditorToolId);

	private UIElement lblSendMessageTitle = createElement(UIType.Css,
			".tablehead");
	private UIElement txtRemoveRecepient = createElement(UIType.Css,
			"input[name='remove recipients']");
	private UIElement opnSelectRecepient = createElement(UIType.ID,
			"courseMembers");
	private UIElements drpselectrecepient = createElements(UIType.ID,
			"courseMembers");
	private UIElement drpselect = createElement(UIType.ID, "courseMembers");
	private UIElement divmsgSent = createElement(UIType.Xpath,
			"//div[contains(text(),'Message Sent Successfully')]");
	private UIElement msgError = createElement(UIType.Xpath,
			"//td[contains(text(),'Please enter the following to continue: Recipient.')]");
	private static final String FILEATTACHEDTOP = "('a')[1].getBoundingClientRect().top";
	private static final String FILEICON = "('img')[1].getBoundingClientRect().top";
	private static final String ADDREMOVELINKBOTTOM = "('a')[0].getBoundingClientRect().bottom ";

	private UIElement chkCheckBox = createElement(UIType.ID, "isBCC");
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");

	String strHeader = "";
	JavascriptExecutor javascriptExecutor;
	Object location1;
	Object location2;
	double bottom;
	double top;
	String title = null;
	List<String> dropdownlist = new ArrayList<String>();
	List<UIElement> elements;

	/* Constructor */
	public EmailHomePage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "EmailHomePage";
		logInstruction("LOG INSTRUCTION: ## Email Home Page ##");
	}

	/**
	 * Method helps to get email RadEditor
	 * 
	 * @author Kapil
	 * @return
	 * @throws Exception 
	 */
	public VisualEditor getEmailHomeRadEditor() throws Exception {
		try{
 		frameSwitch.switchToFrameContent();
		
		}catch (Exception e) {
			logInstruction("LOG INSTRUCTION: NOT ABLE TO SWITCH: \n METHOD: getEmailHomeRadEditor");
		}
		return emailHomeRadEditor;
	}

	/**
	 * This method clicks on the add or remove attachment
	 * 
	 * @return:EmailHomePage
	 * @author soundarya
	 * @throws Exception
	 */
	public AddRemoveAttachmentsPage clickAddOrRemoveAttachment()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE ADD OR REMOVE ATTACHMENT LINK");
			frameSwitch.switchToFrameContent();
			lnkAddOrRemoveAttachment.isDisplayedAfterWaiting(waitTime);

			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				lnkAddOrRemoveAttachment.clickByJavascript();
			} else
				lnkAddOrRemoveAttachment.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToNewWindow();
			logInstruction("LOG INSTRUCTION: CLICKED ON ADD/REMOVE LINK");
		} catch (Exception e) {
			throw new Exception(" UNABLE TO 'Click Add Or Remove Attachment'"
					+ "\n METHOD:clickAddOrRemoveAttachment \n"
					+ e.getLocalizedMessage());
		}
		return new AddRemoveAttachmentsPage(uiDriver, this);
	}

	/**
	 * 
	 * This method get the all attached file list
	 * 
	 * @return List<String>
	 * @author soundarya
	 * @throws Exception
	 */
	public List<String> getAttachedFileList() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GET ATTACHED FILE LIST");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddOrRemoveAttachment, waitTime);
			List<UIElement> attach = lstAttachfile.getUIElementsList();
			for (UIElement uiElement : attach) {
				lstAttachedFiles.add(uiElement.getText());
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Get Attached File List'"
					+ "\n METHOD:getAttachedFileList \n"
					+ e.getLocalizedMessage());
		}
		return lstAttachedFiles;
	}

	/**
	 * This method checks whether the Attached file is listed or not
	 * 
	 * @author Chaitali
	 * @param String
	 *            fileName
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 * 
	 * **/
	public boolean isAttachedFileListed(String strFileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR NEWLY ATTACHED FILE.");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strFileName)
					&& lstAttachfile.areAllPresent()) {
				java.util.List<UIElement> listOfElementsInTable = lstAttachfile
						.getUIElementsList();
				for (UIElement element : listOfElementsInTable) {
					if (element.getText().equals(strFileName)) {
						flag = true;
						logInstruction("LOG INSTRUCTION: " + strFileName
								+ "ATTCHMENT FOUND");
						break;
					}
				}
			} else {
				logInstruction("LOG INSTRUCTION:FILE NAME BLANK OR FILE REMOVED.");
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception("File " + strFileName + "not attached"
					+ "\n METHOD:isAttachedFileListed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method will click on add button
	 * 
	 * @author praveen.maled
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickAddButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE ADD BUTTON");
			frameSwitch.switchToFrameContent();
			btnAddRecipients.isDisplayedAfterWaiting(waitTime);
			btnAddRecipients.clickAndWait(waitTime);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO 'Click Add Button'"
					+ "\n METHOD:clickAddButton \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will click on Remove button
	 * 
	 * @author praveen.maled
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickRemoveButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE REMOVE BUTTON");
			frameSwitch.switchToFrameContent();
			btnRemoveRecipients.isDisplayedAfterWaiting(waitTime);
			btnRemoveRecipients.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(" UNABLE TO 'Click Remove Button'"
					+ "\n METHOD:clickRemoveButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will click on the Send Message button
	 * 
	 * @author praveen.maled
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickSendMessageButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE SEND MESSAGE BUTTON");
			frameSwitch.switchToFrameContent();
			btnSendMessage.isDisplayedAfterWaiting(waitTime);
			btnSendMessage.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Click Send Message Button'"
					+ "\n METHOD:clickSendMessageButton \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will return the page header
	 * 
	 * @author praveen.maled
	 * @return String
	 * @throws Exception
	 * @category Milestone 2
	 */
	public String getPageHeader() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: GETTING PAGE HEADER");
			frameSwitch.switchToFrameContent();
			lblPageHeader.isDisplayedAfterWaiting(waitTime);
			strHeader = lblPageHeader.getText();
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Get Page Header'"
					+ "\n METHOD:getPageHeader \n" + e.getLocalizedMessage());
		}
		return strHeader;
	}

	/**
	 * Method will click on the specified attached file name
	 * 
	 * @author praveen.maled
	 * @param strFileName
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickOnAttachedFile(String strFileName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE ATTACHED FILE");
			if (StringUtils.isBlank(strFileName)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED FILENAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			lnkAttachedFile.replaceValues(strFileName);
			lnkAttachedFile.isDisplayedAfterWaiting(waitTime);
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				lnkAttachedFile.clickByJavascript();
				uiDriver.sleep(waitTime);
			} else {
				lnkAttachedFile.clickAndWait(waitTime);
			}
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Click Attached File'"
					+ "\n METHOD:clickOnAttachedFile \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will check whether attached file is a link or not.
	 * 
	 * @author Vivek.Singh
	 * @param strFileName
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isAttachedFileALink(String strFileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CHECKING ATTACHED FILE LINK.");
			if (StringUtils.isBlank(strFileName)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED FILENAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			lnkAttachedFile.replaceValues(strFileName);
			uiDriver.waitToBeDisplayed(lnkAttachedFile, waitTime);
			return lnkAttachedFile.getAttribute("href") != null;
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Check Attached File link'"
					+ "\n METHOD: isAttachedFileALink \n"
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * This method will return the complete name of the file attached.
	 * 
	 * @author Vivek.Singh
	 * @param {@link String}
	 * @return {@link String}
	 * @throws Exception
	 * **/
	public String getAttachedFileFormat(String fileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: GETTING COMPLETE NAME OF ATTACHED FILE.");
			lnkAttachedFile.replaceValues(fileName);
			lnkAttachedFile.isDisplayedAfterWaiting(waitTime);
			return lnkAttachedFile.getText();
		} catch (Exception e) {
			throw new Exception(
					"CANNOT LOCATE ATTACHED FILE. \nMETHOD: getAttachedFileFormat(). "
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method will select the recipient which has to be added
	 * 
	 * @author praveen.maled
	 * @param strRecipient
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage selectRecipientsToAdd(String strRecipient)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING RECIPIENT TO ADD");
			if (StringUtils.isBlank(strRecipient)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED FILENAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			lstSelectRecipientToAdd.isDisplayedAfterWaiting(waitTime);
			Select dropList = new Select(lstSelectRecipientToAdd);
			dropList.selectByVisibleText(strRecipient);
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Select Recipents To Add'"
					+ "\n METHOD:selectRecipientsToAdd \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will select the selected recipient which has to be removed
	 * 
	 * @author praveen.maled
	 * @param strSelectedRecipient
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage selectAddedRecipientsToRemove(
			String strSelectedRecipient) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECTING  RECIPIENT TO REMOVE");
			if (StringUtils.isBlank(strSelectedRecipient)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED RECIPIENT NAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			lstAddedSelectRecipientToARemove.isDisplayedAfterWaiting(waitTime);
			Select dropList = new Select(lstAddedSelectRecipientToARemove);
			dropList.selectByVisibleText(strSelectedRecipient);
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Select Added Recipents To Remove '"
					+ "\n METHOD:selectAddedRecipientsToRemove \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will enter the subject
	 * 
	 * @author praveen.maled
	 * @param strSubject
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage enterSubject(String strSubject) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER SUBJECT");
			if (StringUtils.isBlank(strSubject)) {
				throw new Exception("LOG INSTRUCTION: PROVIDED SUBJECT IS NULL");
			}
			txtSubject.isDisplayedAfterWaiting(waitTime);
			txtSubject.clearAndSendKeys(strSubject);
		} catch (Exception e) {
			throw new Exception(" UNABLE TO 'Enter Subject '"
					+ "\n METHOD:enterSubject \n" + e.getLocalizedMessage());

		}
		return this;
	}

	/**
	 * Method will add the specified mail id in to CC
	 * 
	 * @author praveen.maled
	 * @param strMailID
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage enterCC(String strMailID) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER MAIL ID TO BE ADDED IN CC");
			if (StringUtils.isBlank(strMailID)) {
				throw new Exception("LOG INSTRUCTION: PROVIDED MAIL ID IS NULL");
			}
			txtCCUser.isDisplayedAfterWaiting(waitTime);
			txtCCUser.sendKeys(strMailID);
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Enter CC '"
					+ "\n METHOD:enterCC \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will add the mail body provided by the user
	 * 
	 * @author praveen.maled
	 * @param mailBody
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage enterTextInRadEditor(String mailBody) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING MAIL BODY");
			if (StringUtils.isBlank(mailBody)) {
				throw new Exception(
						"LOG INSTRUCTION:PROVIDED MAIL BODY IS NULL");
			}
			frameSwitch.switchToFrameContent();
			uiDriver.sendKeysToBrowser(mailBody);

		} catch (Exception e) {
			throw new Exception(" UNABLE TO 'Enter Text In Rad Editor '"
					+ "\n METHOD:enterTextInRadEditor \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will click on OK button on confirmation page
	 * 
	 * @author praveen.maled
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickOnOKButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE OK BUTTON");
			frameSwitch.switchToFrameContent();
			btnOK.isDisplayedAfterWaiting(waitTime);
			btnOK.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO 'Click On Ok Button'"
					+ "\n METHOD:clickOnOKButton \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will click on the image icon of the mentioned attached file
	 * 
	 * @author praveen.maled
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public EmailHomePage clickAttachedFileDocumentIcon(String strFileName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE ATTACHED FILE DOCUMENT ICON");
			if (StringUtils.isBlank(strFileName)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED FILE NAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			imgAttachedFileIcon.replaceValues(strFileName);
			imgAttachedFileIcon.isDisplayedAfterWaiting(waitTime);
			if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
				imgAttachedFileIcon.clickByJavascript();
				uiDriver.sleep(waitTime);
			} else
				imgAttachedFileIcon.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO 'Click On Attached  File  Document Icon '"
							+ "\n METHOD:clickAttachedFileDocumentIcon \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will check whether the image icon of the mentioned attached file
	 * is displayed or not?
	 * 
	 * @author Vivek.Singh
	 * @return EmailHomePage
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isDocumentIconPresent(String strFileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE ATTACHED FILE DOCUMENT ICON");
			if (StringUtils.isBlank(strFileName)) {
				throw new Exception(
						"LOG INSTRUCTION: PROVIDED FILE NAME IS NULL");
			}
			frameSwitch.switchToFrameContent();
			imgAttachedFileIcon.replaceValues(strFileName);
			return imgAttachedFileIcon.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception(
					" UNABLE TO 'Click On Attached  File  Document Icon '"
							+ "\n METHOD: isDocumentIconPresent \n"
							+ e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to check whether the attached file is below the Add/Remove
	 * link
	 * 
	 * @author Chaitali.Barhate
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isFileBelowAttachLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CHECKING FOR IS FILE BELOW ADD REMOVE ATTACHED LINK");
			frameSwitch.switchToFrameContent();
			javascriptExecutor = (JavascriptExecutor) uiDriver;
			location1 = javascriptExecutor
					.executeScript("return document.getElementsByTagName"
							+ FILEATTACHEDTOP);
			location2 = javascriptExecutor
					.executeScript("return document.getElementsByTagName"
							+ ADDREMOVELINKBOTTOM);
			bottom = Math.ceil(Double.parseDouble(location1.toString()));
			top = Math.ceil(Double.parseDouble(location2.toString()));
			if (bottom < top)
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY IF 'File Is Below Attach Link'"
							+ "\n METHOD:isFileBelowAttachLink \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to check whether the attached file icon is below the
	 * Add/Remove link
	 * 
	 * @author Vivek.Singh
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isDocumentIconBelowAttachLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CHECKING FOR IS FILE BELOW ADD REMOVE ATTACHED LINK");
			frameSwitch.switchToFrameContent();
			javascriptExecutor = (JavascriptExecutor) uiDriver;
			location1 = javascriptExecutor
					.executeScript("return document.getElementsByTagName"
							+ FILEICON);
			location2 = javascriptExecutor
					.executeScript("return document.getElementsByTagName"
							+ ADDREMOVELINKBOTTOM);
			bottom = Math.ceil(Double.parseDouble(location1.toString()));
			top = Math.ceil(Double.parseDouble(location2.toString()));
			if (bottom > top)
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY IF 'File Is Below Attach Link'"
							+ "\n METHOD:isDocumentIconBelowAttachLink \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * 
	 * This method checks whether file attached or not
	 * 
	 * @category Milestone2
	 * @return boolean true if file present false if file not present
	 * @author Chaitali
	 * @throws Exception
	 */
	public boolean isFileAttchmentPresent() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Checking for attchment present or not");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddOrRemoveAttachment, waitTime);

			flag = lstAttachfile.areAllPresent();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO VERIFY IF 'Attached File Is Present '"
							+ "\n METHOD:isFileAttchmentPresent \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method gets the title of Send Message
	 * 
	 * @category Milestone 2
	 * @return EmailHomePage
	 * @author Raghav
	 * @throws Exception
	 */
	public String getSendMessageTitle() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION : GET SEND MESSAGE TITLE");
			frameSwitch.switchToFrameContent();
			title = lblSendMessageTitle.getText().trim();
		} catch (Exception e) {
			throw new Exception("UNABLE TO GET 'Send Message Title '"
					+ "\n METHOD:getSendMessageTitle \n"
					+ e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * This method clicks on Remove Recipient
	 * 
	 * @category Milestone 2
	 * @return:EmailHomePage
	 * @author Raghav
	 * @throws Exception
	 */
	public EmailHomePage clickonRemoveRecipient() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON REMOVE RECIPIENT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtRemoveRecepient, waitTime);
			txtRemoveRecepient.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK 'Remove Reciepient '"
					+ "\n METHOD:clickonRemoveRecipient \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * 
	 * This method verifies the recipients is present or not
	 * 
	 * @category Milestone 2
	 * @return EmailHomePage
	 * @author Raghav
	 * @throws Exception
	 */

	public boolean isSelectRecipentPresent(String recepientname)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION : VERIFIES RECEIPENT IS PRESENT");
			frameSwitch.switchToFrameContent();
			opnSelectRecepient.selectByVisibleText(recepientname);
			flag = true;

		} catch (Exception e) {
			throw new Exception("UNABLE TO VERIFY 'Select Reciepient '"
					+ "\n METHOD:isSelectRecipentPresent \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * 
	 * This method verifies the recipient is present or not
	 * 
	 * @category Milestone 2
	 * @return EmailHomePage
	 * @author Raghav
	 * @throws Exception
	 */

	public boolean isSelectGroupMembersValuePresent(String value)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:CAPTURING SELECT GROUP MEMEBERS VALUES");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(drpselect, waitTime);

			elements = drpselectrecepient.getUIElementsList();

			for (int i = 0; i < elements.size(); i++) {
				dropdownlist.add(elements.get(i).getText().trim());

			}
			logInstruction("LOG INSTRUCTION:GROUP MEMBERS DROP DOWN VALUES ARE CAPTURED");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CAPTURE  'Select Group Members Values '"
							+ "\n METHOD:isSelectGroupMembersValuePresent \n"
							+ e.getLocalizedMessage());
		}

		for (int i = 0; i < dropdownlist.size(); i++) {
			if (dropdownlist.contains(value)) {
				flag = true;
			} else {
				flag = false;
			}
		}

		return flag;

	}

	/**
	 * This Method will check whether message has been sent or not
	 * 
	 * @return
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isMessageSent() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : CHECKING MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(divmsgSent, waitTime);
			if (divmsgSent.isDisplayedAfterWaiting(waitTime))
				return true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE MESSAGE \n METHOD: isMessageSent");
		}
		return false;
	}

	/**
	 * This method will check whether inline error message displayed
	 * 
	 * @return
	 * @throws Exception
	 */

	public boolean isInLineErroMSGDisplayed() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : CHECKING EROR MESSAGE");
			if (flag)
				return true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE ERROR MESSAGE \n METHOD :isInLineErroMSGDisplayed ");
		}
		return false;
	}

	/**
	 * Method helps to verify rad editor.
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isRadEditorDisplayed() throws Exception {

		logInstruction("LOG INSTRUCTION: VERIFYING RAD EDITOR IS DISPLAYED OR NOT.");
		try {
			if (emailHomeRadEditor != null) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER RAD EDITOR IS DISPLAYED OR NOT."
							+ "\n METHOD : isRadEditorDisplayed \n"
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
		flag=false;
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
	 * Method used to send email message
	 * 
	 * @category milestone2
	 * @author amit.deshmukh @ Category Service Level Method
	 * @param selectreceipent
	 * @param cc
	 * @param Subject
	 * @param entercontent
	 * @return EmailHomepage
	 * @throws Exception
	 */

	public EmailHomePage sendEmailMessage(String selectreceipent,
			boolean checkbox, String cc, String subject, String entercontent)
			throws Exception {
		logInstruction("LOG INSTRUCTION : SENDING EMAIL MESSAGE");

		try {

			if (StringUtils.isNotBlank(subject)
					&& StringUtils.isNotBlank(entercontent)) {

				frameSwitch.switchToFrameContent();
				if (StringUtils.isBlank(selectreceipent)) {
					logInstruction("LOG INSTRUCTION : RECEIPENT NOT SELECTED");

				} else {
					lstSelectRecipientToAdd.isDisplayedAfterWaiting(waitTime);
					Select dropList = new Select(lstSelectRecipientToAdd);
					dropList.selectByVisibleText(selectreceipent);
				}

				if (checkbox == true) {
					logInstruction("LOG INSTRUCTION : CLICKONG CHECKBOX");
					chkCheckBox.isDisplayedAfterWaiting(waitTime);
					chkCheckBox.clickNoWait();

				}

				btnAddRecipients.isDisplayedAfterWaiting(waitTime);
				btnAddRecipients.clickAndWait(waitTime);

				logInstruction("LOG INSTRUCTION: ENTER MAIL ID TO BE ADDED IN CC");
				if (StringUtils.isBlank(cc)) {
					logInstruction("LOG INSTRUCTION : CC IS NOT ENTERED");
				} else {

					txtCCUser.isDisplayedAfterWaiting(waitTime);
					txtCCUser.sendKeys(cc);

				}

				txtSubject.isDisplayedAfterWaiting(waitTime);
				txtSubject.clearAndSendKeys(subject);

				logInstruction("LOG INSTRUCTION : ENTERING CONTENT");
				getEmailHomeRadEditor().enterText(entercontent);

				logInstruction("LOG INSTRUCTION: CLICKING ON THE SEND MESSAGE BUTTON");
				btnSendMessage.isDisplayedAfterWaiting(waitTime);
				btnSendMessage.clickAndWait(waitTime);

				logInstruction("LOG INSTRUCTION: CLICKING ON THE OK BUTTON");
				frameSwitch.switchToFrameContent();
				btnOK.isDisplayedAfterWaiting(waitTime);
				btnOK.clickAndWait(waitTime);

			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN SENDING 'email' MESSAGE"
					+ "\n METHODsendEmailMessage \n" + e.getLocalizedMessage());
		}

		return this;
	}

}
