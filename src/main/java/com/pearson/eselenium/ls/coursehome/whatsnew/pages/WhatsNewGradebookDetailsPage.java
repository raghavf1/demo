package com.pearson.eselenium.ls.coursehome.whatsnew.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class has the methods to handle the page objects of
 * WhatsNewGradebookDetailsPage Follow the below steps to navigate the page:
 * Login as prof Click on the Course click expand all in whats new section click
 * gradebook icon
 * 
 * @author Chaitali
 */
public class WhatsNewGradebookDetailsPage extends BasePageObject {

	private UIElement btnCancel = createElement(UIType.Css,
			"input[value='Cancel']");
	private UIElement btnDeleteDropboxItem = createElement(UIType.Css,
			"#commentRow0>td>a>img[title='Delete']");
	private UIElement lnkRespondOrSubmitAssignment = createElement(UIType.Css,
			"a[title='Respond or Submit an Additional Assignment']");
	private UIElement btnClose = createElement(UIType.Css,
			"input[value='Close']");
	private UIElements btnExpandIcon = createElements(
			UIType.Xpath,
			"//form[@id='DetailView']//table[@summary='The details of the Dropbox item submitted.']//tbody//tr[td[text()='{1}']]//th[contains(text(),'{2}')]//../following::tr[1]//a[contains(@title,'Expand')]");
	private UIElements btnCollapseIcon = createElements(
			UIType.Xpath,
			"//form[@id='DetailView']//table[@summary='The details of the Dropbox item submitted.']//tbody//tr[td[text()='{1}']]//th[contains(text(),'{2}')]//../following::tr[1]//a[contains(@title,'Collapse')]");
	private UIElements lblComments = createElements(
			UIType.Xpath,
			"//form[@id='DetailView']//table[@summary='The details of the Dropbox item submitted.']//tbody//tr[td[text()='{1}']]//th[contains(text(),'{2}')]//../following::tr[1]");
	private UIElements lblDropboxItem = createElements(
			UIType.Xpath,
			"//form[@id='DetailView']//table[@summary='The details of the Dropbox item submitted.']//tbody//tr[td[text()='{1}']]//th[contains(text(),'{2}')]");

	private String whatsnewgradableRadFrameId = "RadeEntryText_contentIframe";
	private String whatsnewgradableRadToolId = "RadeEntryText";

	private VisualEditor gradeablerad = new VisualEditor(uiDriver,
			whatsnewgradableRadToolId, whatsnewgradableRadFrameId,
			whatsnewgradableRadToolId);

	private UIElement txtNumericGrade; // Locator Missing
	private UIElement txtLetterGrade; // Locator Missing
	private UIElement chkReturnToStudentUponClosing;// Locator Missing
	private UIElement txtComments; // Locator Missing
	private UIElement lnkAddRemove; // Locator Missing
	private UIElement btnSave; // Locator Missing
	private UIElement btnSaveAndClose; // Locator Missing
	private UIElement lblNote = createElement(UIType.Css, ".dkgraytext");
	private UIElement btnsaveandclose = createElement(UIType.ID, "SaveAndClose");
	private UIElement txtnumericvalue = createElement(UIType.Xpath,
			"//input[@title='Number grade']");
	private UIElement txtgrade = createElement(UIType.Css,
			"ItemGrade.LetterGrade");
	private UIElement radEditor = createElement(UIType.Xpath, "html");

	/* Variables */
	List<UIElement> elements;
	String[] strNoteOne;
	private String numericGrade;
	private String strNot;
	private String strCommentArray[];
	private int total;
	private int commentSize;
	private Integer numericGradeValue;
	Set<String> windows;
	Iterator<String> iterator;
	String parentWindows;
	String ChildWindows;

	/* Constructor */

	public WhatsNewGradebookDetailsPage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## WhatsNew GradebookDetails Page##");
	}

	public VisualEditor getGradableRadEditor() {
		return gradeablerad;
	}

	/**
	 * Method helps to click Cancel button
	 * 
	 * @author Chaitali
	 * @return
	 * @throws Exception
	 */
	public void clickCancelButton() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:CLICK ON CANCEL BUTTON");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'cancel' BUTTON "
					+ "\n\n METHOD :clickCancelButton \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to click on delete icon
	 * 
	 * @author Chaitali
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage clickDeleteIcon() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: CLICK ON DELETE BUTTON");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnDeleteDropboxItem, waitTime);
			btnDeleteDropboxItem.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'delete' ICON "
					+ "\n METHOD: clickDeleteIcon \n" + e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to expand dropbox item
	 * 
	 * @author Chaitali
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage expandDropboxItem(String name,
			String date) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:EXPAND DROPBOX ITEM");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			btnExpandIcon.replaceValues(date, name);
			List<UIElement> elements = btnExpandIcon.getUIElementsList();
			int total = elements.size();
			for (int i = 0; i < total; i++) {
				elements.get(i).click();
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN EXPANDING ' dropbox' ITEM "
					+ "\n METHOD:expandDropboxItem \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to collapse dropbox item
	 * 
	 * @author Chaitali
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage collapseDropboxItem(String name,
			String date) throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: COLLAPSE DROPBOX ITEM");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			btnCollapseIcon.replaceValues(date, name);
			elements = btnCollapseIcon.getUIElementsList();
			total = elements.size();
			for (int i = 0; i < total; i++) {
				elements.get(i).clickAndWait(waitTime);
			}
		}

		catch (Exception e) {
			throw new Exception("ISSUE IN COLLAPSING 'dropbox' ITEM"
					+ "\n METHOD:collapseDropboxItem \n "
					+ e.getLocalizedMessage());

		}
		return this;
	}

	/**
	 * Method helps to get dropbox item comments
	 * 
	 * @param - String name, date
	 * @author Chaitali
	 * @return String[] comments
	 * @throws Exception
	 */
	public String[] getDropboxItemComments(String name, String date)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: GET DROPBOX ITEM COMMENTS");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			lblComments.replaceValues(date, name);
			elements = lblComments.getUIElementsList();
			commentSize = elements.size();
			strCommentArray = new String[commentSize];

			for (int i = 0; i < commentSize; i++) {
				strCommentArray[i] = elements.get(i).getText();
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'dropbox' ITEM COMMENTS"
					+ "\n Method:getDropboxItemComments \n"
					+ e.getLocalizedMessage());
		}
		return strCommentArray;

	}

	/**
	 * Method helps to click RespondOrSubmitAssignmentLink
	 * 
	 * @author Chaitali
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 *             Follow the below steps to navigate the page: Login as Student
	 *             Click On Dropbox on toolbar Click on dropbox item
	 * 
	 */
	public WhatsNewGradebookDetailsPage clickRespondOrSubmitAssignmentLink()
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: ClICK ON RESPOND OR SUBMIT ASSIGNMENT LINK");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(lnkRespondOrSubmitAssignment, waitTime);
			lnkRespondOrSubmitAssignment.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSSUE IN CLICKING 'respondorsubmit' ASSIGNMENT LINK"
							+ "\n METHOD clickRespondOrSubmitAssignmentLink: \n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click Close Button
	 * 
	 * @author Chaitali
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 *             Follow the below steps to navigate the page: Login as Student
	 *             Click On Dropbox on toolbar Click on dropbox item
	 */
	public WhatsNewGradebookDetailsPage clickCloseButton() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: ClICK ON CLOSE BUTTON");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnClose, waitTime);
			btnClose.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'close' BUTTON "
					+ " \n METHOD :clickCloseButton \n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to check dropbox item exists
	 * 
	 * @author Chaitali
	 * @return boolean true if item exists false if item not found
	 * @throws Exception
	 */

	public boolean isDropboxItemExists(String name, String date)
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: IS DROPBOX ITEM EXISTS");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			lblDropboxItem.replaceValues(date, name);
			if (lblDropboxItem.areAllDisplayed()) {
				logInstruction("LOG INSTRUCTION: GRADEBOOK ITEM EXISTS");
				return true;
			} else {
				logInstruction("LOG INSTRUCTION: GRADEBOOK ITEM NOT EXISTS");
				return false;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN EXISTING 'dropBox' ITEMS"
					+ "\n METHOD:isDropboxItemExists \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * Method helps to check dropbox item exists
	 * 
	 * @author Hemant.Kumar
	 * @return String
	 * @throws Exception
	 */
	public String getNote() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION:GET THE NOTE ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblNote, waitTime);
			strNot = lblNote.getText();

			strNoteOne = strNot.split("Formatting Tips");

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING 'note'"
					+ "\nMETHOD:getNote \n" + e.getLocalizedMessage());
		}
		return strNoteOne[0];
	}

	/**
	 * This method enter Numeric Grade
	 * 
	 * @param value
	 * @author soundarya
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage enterNumericGrade(int value)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTER NUMERIC GRADE");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
			numericGradeValue = value;
			numericGrade = numericGradeValue.toString();

			txtNumericGrade.clearAndSendKeys(numericGrade);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'numeric' GRADE"
					+ "\nMETHOD:enterNumericGrade \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method enter Letter Grade
	 * 
	 * @param String
	 * 
	 * @author soundarya
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage enterLetterGrade(String gradevalue)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTER LETTER GRADE");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
			txtLetterGrade.clearAndSendKeys(gradevalue);

		} catch (Exception e) {

			throw new Exception("ISSUE IN ENTERING 'letter' GRADE"
					+ "\n METHOD:enterLetterGrade\n" + e.getLocalizedMessage());

		}

		return this;
	}

	/**
	 * This method select Return To Student Upon Clocsing CheckBox
	 * 
	 * 
	 * @author soundarya
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage selectReturnToStudentUponClosingCheckBox()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:SELECT STUDENT UPON CLOSING CHECKBOX");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			uiDriver.waitToBeDisplayed(chkReturnToStudentUponClosing, waitTime);
			chkReturnToStudentUponClosing.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SELECTING 'student' UPON CLOSING CHECKBOX"
							+ "\n METHOD:selectReturnToStudentUponClosingCheckBox\n"
							+ e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method enter Comments
	 * 
	 * @param String
	 *            - comments
	 * @author soundarya
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage enterComments(String comments)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER COMMENTS");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			uiDriver.waitToBeDisplayed(txtComments, waitTime);
			txtComments.clearAndSendKeys(comments);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'comments'"
					+ "\nMETHOD:enterComments \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method click Add Remove Link
	 * 
	 * @author soundarya
	 * @return void
	 * @throws Exception
	 */
	public void addRemoveLink() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK ADD REMOVE LINK");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(lnkAddRemove, waitTime);
			lnkAddRemove.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ADDING/REMOVING 'link'"
					+ "\n METHOD:addRemoveLink \n" + e.getLocalizedMessage());
		}

		return;
	}

	/**
	 * This method click Save Button
	 * 
	 * @author soundarya
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */
	public WhatsNewGradebookDetailsPage clickSaveButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK SAVE BUTTON");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnSave, waitTime);
			btnSave.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'save' BUTTON"
					+ "\nMETHOD:clickSaveButton \n" + e.getLocalizedMessage());
		}

		return this;
	}

	/**
	 * This method click Save And Close Button
	 * 
	 * @author soundarya
	 * @return void
	 * @throws Exception
	 */
	public void clickSaveAndCloseButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK SAVE AND CLOSE BUTTON");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
			btnSaveAndClose.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'saveandclose' BUTTON "
					+ "\n METHOD:clickSaveAndCloseButton \n"
					+ e.getLocalizedMessage());
		}

		return;
	}

	/**
	 * This method check Numeric Grade is enabled
	 * 
	 * @author Raghavendra
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEnterNumericGradeEnabled() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: VERIFYING ENTERIC NUMERIC GRADE IS ENABLED OR NOT");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			return txtNumericGrade.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING 'numeric' GRADE ENABLED"
					+ "\nMETHOD:isEnterNumericGradeEnabled\n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method to verify Letter Grade is enabled
	 * 
	 * @author Raghavendra
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isEnterLetterGradeEnabled() throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: VERIFYING LETTER GRADE IS ENABLED OR NOT");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowTopFrame();
			return txtLetterGrade.isDisplayedAfterWaiting(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENABLING 'enterlettergrade'"
					+ "\nMETHOD:isEnterLetterGradeEnabled \n"
					+ e.getLocalizedMessage());
		}

	}

	/**
	 * This method enters text in rad edit
	 * 
	 * @param String
	 *            text
	 * @author Raghavendra
	 * @return void
	 * @throws Exception
	 */
	public void enterTextInRadEditor(String text) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING TEXT IN RAD EDITOR");
			frameSwitch.switchToNewWindow();
			frameSwitch.switchToNewWindowBottomFrame();
			uiDriver.waitToBeDisplayed(radEditor, waitTime);
			radEditor.sendKeys(text);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING TEXT 'radeditor'"
					+ "\nMETHOD:enterTextInRadEditor \n"
					+ e.getLocalizedMessage());
		}

		return;
	}

	/**
	 * This method enters text in Whatsnew GradeBook
	 * 
	 * @param String
	 *            numericGrade, letterGrade
	 * @author Raghavendra
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */

	public WhatsNewGradebookDetailsPage clickStudentPoint(String numericgrade,
			String letterGrade) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION :CLICK STUDENT POINT");
			windows = uiDriver.getWindowHandles();
			iterator = windows.iterator();
			parentWindows = iterator.next();
			ChildWindows = iterator.next();
			uiDriver.switchTo().window(ChildWindows);
			uiDriver.switchTo().frame("generalTopFrame");
			uiDriver.waitToBeDisplayed(txtnumericvalue, waitTime);
			txtnumericvalue.clearAndSendKeys(numericgrade);
			uiDriver.waitToBeDisplayed(txtgrade, waitTime);
			txtgrade.clearAndSendKeys(letterGrade);
			uiDriver.switchTo().defaultContent();
			uiDriver.switchTo().frame("generalBottomFrame");
			uiDriver.waitToBeDisplayed(btnsaveandclose, waitTime);
			btnsaveandclose.clickAndWait(waitTime);
			uiDriver.switchTo().window(parentWindows);

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'studentpoint'"
					+ "\nMETHOD:clickStudentPoint \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * This method enters text in Whatsnew GradeBook @ Category Service Level
	 * Method
	 * 
	 * @param String
	 *            numericGrade, letterGrade
	 * @author Raghav
	 * @return WhatsNewGradebookDetailsPage
	 * @throws Exception
	 */

	public WhatsNewGradebookDetailsPage enterGradeWhatsnewDetailView(
			String numericgrade, String lettergrade, String content,
			boolean save, boolean saveandclose) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING GRADE AND ENTERING IN RAD EDITOR");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(txtNumericGrade, waitTime);
			txtNumericGrade.clearAndSendKeys(numericgrade);
			uiDriver.waitToBeDisplayed(txtLetterGrade, waitTime);
			txtLetterGrade.clearAndSendKeys(lettergrade);
			if (content != null) {
				getGradableRadEditor().enterText(content);
			}
			if (saveandclose) {
				uiDriver.waitToBeDisplayed(btnSaveAndClose, waitTime);
				btnSaveAndClose.clickAndWait(waitTime);
				uiDriver.getUIWindowLocator().switchToMainWindow();
				return this;
			} else if (save) {
				uiDriver.waitToBeDisplayed(btnSave, waitTime);
				btnSave.clickAndWait(waitTime);
				return this;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING 'studentpoint'"
					+ "\nMETHOD:enterGradeWhatsnewDetailView \n"
					+ e.getLocalizedMessage());
		}
		return this;
	}

}
