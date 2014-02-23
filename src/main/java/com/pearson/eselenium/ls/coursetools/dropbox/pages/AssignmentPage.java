package com.pearson.eselenium.ls.coursetools.dropbox.pages;

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
 * Class has the methods of Assignment Page. Navigation --> 1) Login as Student
 * 2) Select Course 3) Click 'Dropbox' 4) Click 'Submit Assignment' link
 * 
 * @author soundarya
 * @modifiedBy Vivek.Singh -- as per code review comments by Lanka Pearson
 * **/
public class AssignmentPage extends BasePageObject {

	private static final String SUBMIT_ASSIGNMENT = "Submit Assignment";
	/* Elements */
	private UIElement txtContent = createElement(UIType.Css, "html>body");
	private UIElement txtHeadder = createElement(UIType.Css, ".tablehead");
	private UIElement btnSubmitAssignment = createElement(UIType.Css,
			"#btnSubmitAssignmentTop");
	private UIElement drpBasket = createElement(UIType.Xpath, "id('Basket')");
	private UIElement lnkAddOrRemoveAttachment = createElement(UIType.Xpath,
			"//a[contains(.,'Add/Remove')]");
	private String strToolid = "vizEditor";
	private String strFrameid = "vizEditor_contentIframe";
	private UIElements isFileAttached = createElements(UIType.Xpath,
			"//a[@href[contains(.,'DownloadAttachment')]]");

	private VisualEditor visualEditor = new VisualEditor(uiDriver, strToolid,
			strFrameid, strToolid);
	private UIElement msgInlinError = createElement(UIType.Xpath,
			"//td[contains(text(),'select a basket')]");

	private String strMessage = null;
	private boolean flag = false;
	private List<UIElement> list = null;
	private int intTotlaList = 0;

	/* Constructor */
	public AssignmentPage(UIDriver uiDriver) {
		super(uiDriver);
		pageTitle = "Submit Assignment";
		logInstruction("LOG INSTRUCTION: ## AssignmentPage ##");
	}

	public VisualEditor getAssignmentVisualEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return visualEditor;
	}

	/**
	 * methods helps to select 'Drop box' Basket from Drop down.
	 * 
	 * @author amit.deshmukh
	 * @param {{@link String} --strBasket --
	 * @return {@link AssignmentPage}
	 * @throws Exception
	 */

	public AssignmentPage selectFromBasket(String strBasket) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: SELECT FROM BASKET: " + strBasket);
			if (StringUtils.isNotBlank(strBasket)) {
				frameSwitch.switchToFrameContent();
				uiDriver.waitToBeDisplayed(drpBasket, waitTime);
				drpBasket.selectByVisibleText(strBasket);
			} else
				throw new Exception(
						"PARAMETER IS NULL. \nMETHOD: selectFromBasket.\n");
		} catch (Exception e) {
			throw new Exception("UNABLE TO SELECT: " + strBasket
					+ ". \nMETHOD: selectFromBasket.\n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method is used to get header title of Assignment Page
	 * 
	 * @author soundarya
	 * @return String
	 * @throws Exception
	 * **/
	public String getHeader() throws Exception {
		strMessage = null;
		try {
			logInstruction("LOG INSTRUCTION: GET HEADER TITLE OF ASSIGNMENT PAGE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtHeadder, waitTime);
			strMessage = txtHeadder.getText();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET HEADER TITLE OF ASSIGNMENT PAGE. \nMETHOD: getHeader.\n"
							+ e.getLocalizedMessage());
		}
		return strMessage;
	}

	/**
	 * This method will enter Content In Editor
	 * 
	 * @author soundarya
	 * @return SubmissionPage
	 * @throws Exception
	 * **/
	public AssignmentPage enterContentInEditor(String strContent)
			throws Exception {

		try {
			if (StringUtils.isNotBlank(strContent)) {
				logInstruction("LOG INSTRUCTION: ENTER CONTENT IN 'Rad Editor'.");
				frameSwitch.switchToFrameContent();
				uiDriver.waitToBeDisplayed(txtContent, waitTime);
				txtContent.clearAndSendKeys(strContent);

			} else
				throw new Exception(
						"PARAMETER IS NULL. \nMETHOD: enterContentInEditor.\n");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO ENTER CONTENT IN 'Rad Editor'. \nMETHOD: enterContentInEditor.\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method will click 'Submit Assignment' Button. Navigates to
	 * {@link DropboxPage}
	 * 
	 * @author soundarya
	 * @return DropboxPage
	 * @throws Exception
	 * **/
	public Object clickSubmitAssignmentButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK 'Submit Assignment' BUTTON.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSubmitAssignment, waitTime);
			btnSubmitAssignment.clickAndWait(waitTime);
			if ((msgInlinError.isDisplayedAfterWaiting(waitTime))) {
				return new AssignmentPage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK 'Submit Assignment' BUTTON. \nMETHOD: clickSubmitAssignmentButton.\n"
							+ e.getLocalizedMessage());
		}
		return new DropboxPage(uiDriver);
	}

	/**
	 * This method clicks on the 'Add/Remove' link. Navigates to
	 * {@link AddRemoveAttachmentsPage} i.e. opens a pop-up window of
	 * Add/Remove.
	 * 
	 * @return {@link AddRemoveAttachmentsPage}
	 * @author Chaitali
	 * @throws Exception
	 * @movedBy Vivek.Singh
	 * @reason not required on DropboxPage
	 */
	public AddRemoveAttachmentsPage clickAddOrRemoveAttachment()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON THE 'Add/Remove' LINK");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lnkAddOrRemoveAttachment, waitTime);
			if(getBrowser().equals(Browser.INTERNETEXPLORER))
				lnkAddOrRemoveAttachment.clickByJavascript();
			else
			lnkAddOrRemoveAttachment.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON THE 'Add/Remove' LINK. \nMETHOD: clickAddOrRemoveAttachment.\n"
							+ e.getLocalizedMessage());
		}
		return new AddRemoveAttachmentsPage(uiDriver, this);
	}

	/**
	 * Method check Submit assignment table is displayed or not
	 * 
	 * @author Praveen.Maled
	 * @return boolean
	 * @throws Exception
	 * @category Milestone 2
	 */
	public boolean isSubmitAssignmentPageDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION:CHECKING FOR 'Submit Assignment' DISPLAYED OR NOT");
			frameSwitch.switchToFrameContent();
			flag = SUBMIT_ASSIGNMENT.equalsIgnoreCase(txtHeadder.getText());
		} catch (Exception e) {
			throw new Exception(
					"NOT ABLE TO VERIFY 'Submit Assignment' PAGE. \nMETHOD: isSubmitAssignmentPageDisplayed.\n"
							+ e.getLocalizedMessage());
		}
		return flag;
	}

	/**
	 * This Method will check whether Error Messgae is displayed when assignment
	 * is submitted with selecting basket
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isInlinErrorMSGDisplayed() throws Exception {
		flag = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR INLINE ERROR MESSAGE");
			frameSwitch.switchToFrameContent();
			if ((msgInlinError.isDisplayedAfterWaiting(waitTime)))
				flag = true;
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE INLINE MSG \n METHOD : isInlinErrorMSGDisplayed.\n");
		}
		return flag;
	}

	/**
	 * This method checks if file is attached or not
	 * 
	 * @Category Milestone2
	 * @return boolean
	 * @author Raghav
	 * @throws Exception
	 */
	public boolean isFileAttachedDisplayed(String strNameOfFile)
			throws Exception {
		flag = false;
		try {

			logInstruction("LOG INSTRUCTION: CHECKING SELECTED FILE ATTACHED OR NOT");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strNameOfFile)) {
				list = isFileAttached.getUIElementsList();
				intTotlaList = list.size();
				for (int i = 0; i < intTotlaList; i++) {
					if (list.get(i).getText().equals(strNameOfFile)) {
						flag = true;

					}
				}
			} else {
				logInstruction("LOG INSTRUCTION: FILE NAME BLANK");
				flag = false;
			}
		} catch (Exception e) {
			logInstruction(e.getMessage());
			throw new Exception(
					"NOT ABLE TO FIND ATTACHED FILE \n METHOD:isFileAttachedDisplayed.\n");
		}
		return flag;
	}

	/**
	 * Method is a service method to submit assignment.
	 * 
	 * @author Vivek.Singh
	 * @param String
	 *            {strBasket - Basket name, strContent - Content to put in Rad
	 *            Editor.}
	 * @return DropboxPage
	 * @throws Exception
	 * **/
	public DropboxPage submitAssignment(String strBasket, String strContent)
			throws Exception {
		logInstruction("LOG INSTRUCTION: SUBMITTING ASSIGNMENT.");
		try {
			if (StringUtils.isNotBlank(strBasket)
					&& StringUtils.isNotBlank(strContent)) {
				logInstruction("LOG INSTRUCTION: SELECT FROM BASKET: "
						+ strBasket);
				frameSwitch.switchToFrameContent();
				uiDriver.waitToBeDisplayed(drpBasket, waitTime);
				drpBasket.selectByVisibleText(strBasket);

				getAssignmentVisualEditor().enterText(strContent);
				frameSwitch.switchToFrameContent();
				logInstruction("LOG INSTRUCTION: CLICK 'Submit Assignment' BUTTON.");
				uiDriver.waitToBeDisplayed(btnSubmitAssignment, waitTime);
				btnSubmitAssignment.clickAndWait(waitTime);

				return new DropboxPage(uiDriver);
			} else
				throw new Exception(
						"PARAMETERS ARE BLANK. \nMETHOD: submitAssignment \n");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SUBMIT 'Assignment'.\nMETHOD: submitAssignment \n"
							+ e.getLocalizedMessage());
		}
	}
	
	/**
     * This Method will check is DropBox RAD Editor Displayed
     * 
     * @return {@link boolean}
     * @throws Exception
     * @author Suchi.Singh
     */
    public boolean isDropBoxRADEditorDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING WHETHER EMAIL RESPONSE RAD EDITOR IS BEING DISPLAYED");
            if (visualEditor != null) {
                flag = true;
            } else {
                flag = false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING WHETHER  EMAIL RESPONSE RAD EDITOR IS DISPLAYED OR NOT" + "\n METHOD : isEmailResponseRADEditorDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}