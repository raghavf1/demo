package com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pearson.eselenium.ls.common.pages.AddRemoveAttachmentsPage;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all the methods related to thread respond page
 * 
 * @author ganapati.bhat
 * 
 */
public class ThreadRespondPage extends BasePageObject {

	/* Elements */
	private UIElement lnkEditorSwitch = createElement(UIType.Css, "#telerikRAD");
	private UIElement txtRespondTitle = createElement(UIType.ID,
			"responseTitle");
	private UIElement btnPostResponse = createElement(UIType.ID,
			"btnPostResponse1");
	private UIElements listResponses = createElements(UIType.Css, ".tablehead");
	private UIElement txtRadEditor = createElement(UIType.Css, "html>body");
	private UIElement lnkAddOrRemove = createElement(UIType.Css,
			".innercontenttable>table>tbody>tr>td>a");
	private UIElement btnCancel = createElement(UIType.Xpath,
			"//table[4]//table[1]//tr/td/input[@value='Cancel']");
	private UIElement btnPreview = createElement(UIType.Xpath,
			"//table[4]//table[1]//tr/td/input[@value='Preview']");
	private UIElement txtSubject = createElement(UIType.Css, "#responseTitle");
	private UIElement txtTitle = createElement(UIType.Xpath,
			"//table[3]//tr/td/h3/div");
	private UIElement lblTableHeader = createElement(UIType.Css,
			"div.tablehead");
	private UIElement lnkAttachedFile = createElement(UIType.Xpath,
			"//a[@name='downloadAttachment'][contains(text(),'{1}')]");
	private UIElement lnkAddRemoveAttachments = createElement(UIType.Xpath,
			"//a[contains(.,'Add/Remove')]");
	private String threadRespondRadEditorToolId = "RadeEntryText";
	private String threadRespondRadEditorFrameId = "RadeEntryText_contentIframe";
	private UIElement msgError = createElement(UIType.Xpath,
			"//td[contains(text(),' You must first enter text in the Subject field')]");

	/* Variables */
	boolean flag = false;
	private String strResult = null;
	private VisualEditor threadRespondRadEditor = new VisualEditor(uiDriver,
			threadRespondRadEditorToolId, threadRespondRadEditorFrameId,
			threadRespondRadEditorToolId);

	/* Constructor */
	public ThreadRespondPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "ThreadRespondPage";
		logInstruction("LOG INSTRUCTION: ## Thread Respond Page ##");
	}

	/**
	 * Method returns Visual editor Object instance
	 * 
	 * @author Suchi
	 * @return VisualEditor
	 * @throws Exception
	 */
	public VisualEditor getThreadRespondRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return threadRespondRadEditor;
	}

	/**
	 * Method helps to enter the Response Subject
	 * 
	 * @author ganapati.bhat
	 * @param strSubject
	 * @return ThreadRespondPage
	 * @throws Exception
	 */
	public ThreadRespondPage enterResponseSubject(String strSubject)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE 'Response' SUBJECT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtRespondTitle, waitTime);
			txtRespondTitle.clearAndSendKeys(strSubject);
			logInstruction("LOG INSTRUCTION: 'Response' SUBJECT IS ENTERED");
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'Response' SUBJECT"
					+ "\nMETHOD:enterResponseSubject \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on the save response button
	 * 
	 * @author ganapati.bhat
	 * @return ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage clickPostResponseButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON THE 'Post Response' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnPostResponse, waitTime);
			btnPostResponse.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'Post Response' BUTTON "
					+ "\nMETHOD:clickPostResponseButton \n"
					+ e.getLocalizedMessage());
		}
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * Method helps to verify the specified text is present or not
	 * 
	 * @param strRespond
	 * @author ganapati.bhat
	 * @return boolean
	 * @throws Exception
	 */
	public boolean VerifyRespondTitle(String strRespond) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFY THE 'Respond' TITLE");
			frameSwitch.switchToFrameContent();
			List<UIElement> elements = listResponses.getUIElementsList();
			for (int i = 0; i < elements.size(); i++) {
				String respondValue = elements.get(i).getText().trim();
				if (respondValue.equals(strRespond)) {
					logInstruction("LOG INSTRUCTION: THE CONTROL IS IN 'Respond' PAGE");
					flag = true;
				}
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'Respond' TITLE"
					+ "\nMETHOD:VerifyRespondTitle \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify RadEditor page Displayed
	 * 
	 * @author soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isRadEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'RadEditor' DISPLAYED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtRadEditor, waitTime);
			flag = txtRadEditor.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING IS 'RadEditor' DISPLAYED"
					+ "\nMETHOD:isRadEditorDisplayed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify AddRemove Link Displayed
	 * 
	 * @author soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isAddRemoveLinkDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING IS 'AddRemove' LINK DISPLAYED");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddOrRemove, waitTime);
			flag = lnkAddOrRemove.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING IS 'AddRemove' LINK DISPLAYED"
							+ "\nMETHOD:isAddRemoveLinkDisplayed \n"
							+ e.getLocalizedMessage());

		}
		return flag;
	}

	/**
	 * Method helps to verify the cancel button
	 * 
	 * @author soundarya
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING 'Cancel' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			return btnCancel.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'Cancel' BUTTON"
					+ "\nMETHOD:clickCancelButton" + e.getLocalizedMessage());
		}
	}

	/**
	 * Method helps to get header title
	 * 
	 * @author soundarya
	 * @return String
	 * @throws Exception
	 */
	public String getHeaderTitle() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THREAD RESPOND PAGE 'Header Title'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			strResult = txtTitle.getText().trim();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN GETTING THREAD RESPOND PAGE 'Header Title'"
							+ "\nMETHOD:getHeaderTitle \n"
							+ e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * Method helps to click Preveiw Button
	 * 
	 * @author soundarya
	 * @return courseHomePreview
	 * @throws Exception
	 */
	public CourseHomePreview clickPreveiwButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON  'Preveiw' BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnPreview, waitTime);
			btnPreview.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON 'Preveiw' BUTTON"
					+ "\nMETHOD:clickPreveiwButton \n"
					+ e.getLocalizedMessage());
		}
		return new CourseHomePreview(uiDriver);
	}

	/**
	 * Method helps to get Response Subject
	 * 
	 * @author soundarya
	 * @return String
	 * @throws Exception
	 */
	public String getReponseSubject() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING 'Reponse Subject'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtSubject, waitTime);
			strResult = txtSubject.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'Reponse Subject'"
					+ "\nMETHOD:getReponseSubject \n" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * This methods gets the label heading
	 * 
	 * @author ashish.juyal
	 * @return String
	 * @throws Exception
	 */
	public String getLabelHeading() throws Exception {
		strResult = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING 'Label Heading'");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblTableHeader, waitTime);
			strResult = lblTableHeader.getText().trim();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'Label Heading'"
					+ "\nMETHOD:getLabelHeading \n" + e.getLocalizedMessage());
		}
		return strResult;
	}

	/**
	 * methods helps to click on attached file on ThreadRespond page
	 * 
	 * @author Chaitali.Barhate
	 * @return void
	 * @param strFileName
	 * @throws Exception
	 * @category Milestone 2
	 */
	public void clickAttachedFile(String strFileName) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION : CLICKING ON ATTACHED FILE '"
					+ strFileName + "'");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strFileName)) {
				lnkAttachedFile.replaceValues(strFileName);
				if (lnkAttachedFile.isDisplayedAfterWaiting(waitTime)) {
					if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
						lnkAttachedFile.clickByJavascript();
						Thread.sleep(waitTime); // Since clickAndWait() is
												// hanging, performing the
					} else {
						lnkAttachedFile.clickAndWait(waitTime);
					}
					logInstruction("LOG INSTRUCTION : SUCCESSFULLY CLICKED ON ATTACHED FILE '"
							+ strFileName + "'");
				} else
					throw new Exception(
							"Attached file '"
									+ strFileName
									+ "' not displayed... \nMETHOD:clickAttachedFile \n");
			} else {
				throw new Exception(
						"PROVIDED FILE NAME IS NULL \nMETHOD:clickAttachedFile \n");
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING ON ATTACHED FILE '"
					+ strFileName + "'" + "\nMETHOD:clickAttachedFile \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method clicks on the link AddOrRemoveAttachment
	 * 
	 * @return:AddRemoveAttachmentsPage
	 * @author Chaitali.Barhate
	 * @throws Exception
	 * @category Milestone 2
	 */
	public AddRemoveAttachmentsPage clickAddOrRemoveAttachmentsLink()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION :CLICKING ON THE 'AddOrRemoveAttachment' LINK");
			frameSwitch.switchToFrameContent();
			if (lnkAddRemoveAttachments.isDisplayedAfterWaiting(waitTime)) {
				if (getBrowser().equals(Browser.INTERNETEXPLORER)) {
					lnkAddRemoveAttachments.clickByJavascript();
					Thread.sleep(waitTime); // Since clickAndWait() is hanging,
											// performing the same
				} else {
					lnkAddRemoveAttachments.clickAndWait(waitTime);
				}
				logInstruction("LOG INSTRUCTION :SUCCESSFULLY CLICKED ON 'AddOrRemoveAttachment' LINK");
				uiDriver.getUIWindowLocator().switchToNewWindow();
			} else {
				throw new Exception(
						"'AddOrRemoveAttachment' LINK NOT DISPLAYED \nMETHOD:clickAddOrRemoveAttachmentsLink \n");
			}
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN CLICKING ON THE 'AddOrRemoveAttachment' LINK"
							+ "\nMETHOD:clickAddOrRemoveAttachmentsLink \n"
							+ e.getLocalizedMessage());
		}
		return new AddRemoveAttachmentsPage(uiDriver, this);
	}

	/**
	 * This method checks whether the Attached file is listed or not.
	 * 
	 * @author Sumanth SV
	 * @param String
	 *            strFileName
	 * @return boolean
	 * @throws Exception
	 * **/
	public boolean isAttachedFileListed(String strFileName) throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION : VERIFYING ATTACHED FILE '"
					+ strFileName + "' LISTED OR NOT");
			frameSwitch.switchToFrameContent();
			lnkAttachedFile.replaceValues(strFileName);
			flag = lnkAttachedFile.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING ATTACHED FILE '"
					+ strFileName + "' LISTED OR NOT"
					+ "\nMETHOD:isAttachedFileListed \n"
					+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * Method helps to verify the cancel button
	 * 
	 * @author Praveen.Maled
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCancelButtonDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING 'Cancel' BUTTON");
			frameSwitch.switchToFrameContent();
			flag = btnCancel.isDisplayedAfterWaiting();
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING 'Cancel' BUTTON"
					+ "\nMETHOD:clickCancelButton" + e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check is Thread Respond RAD Editor Displayed
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public boolean isThreadRespondRADEditorDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: VERIFYING WHETHER THREAD RESPOND RAD EDITOR IS BEING DISPLAYED");
			if (threadRespondRadEditor != null) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING WHETHER THREAD RESPOND RAD EDITOR IS DISPLAYED OR NOT"
							+ "\n METHOD : isThreadRespondRADEditorDisplayed \n"
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
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This method will check whether error message is shown when mail is sent
	 * without subject
	 * 
	 * @return boolean
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */

	public boolean IsInlinErrorMSGDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRCUTION : CHECKING FOR 'Error' MESSAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(msgError, waitTime);
			if (msgError.isDisplayedAfterWaiting())
				flag = true;

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE 'Error' MESSAGE \n METHOD : IsInlinErrorMSGDisplayed");
		}
		return flag;
	}
}
