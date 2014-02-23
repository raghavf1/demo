package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditExamPage extends BasePageObject {

	/* Elements */
	private UIElement txtExamTitle = createElement(UIType.Xpath,
			"//*[@id='RADTitle']");
	private UIElement btnSaveChanges = createElement(UIType.Xpath,
			"//table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/input[1]");
	private String introductoryTextRadToolId = "RADdescription";
	private String introductoryTextRadFrameId = "RADdescription_contentIframe";
	private String introductoryTextRadFooterId = "RADdescription_ModesWrapper";
	private VisualEditor introductoryText = new VisualEditor(uiDriver,
			introductoryTextRadToolId, introductoryTextRadFrameId,introductoryTextRadFooterId);
	private UIElement txtTitle = createElement(UIType.Xpath,
			"//input[contains(@name,'RADTitle')]");

	/* Constructor */
	public EditExamPage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## EditExamPage ##");
	}

	public VisualEditor getintroductoryTextRadEditor() throws Exception {
		 frameSwitch.switchToFrameContent();
		return introductoryText;
	}

	/**
	 * Method helps to enter the Exam title
	 * 
	 * @param title
	 * @return {@link EditExamPage }
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public EditExamPage enterExamTitle(String title) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE EXAM TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtExamTitle, waitTime);
			txtExamTitle.sendKeys(title);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE EXAM TITLE"
					+ "\n METHOD : enterExamTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on Save Changes page button.
	 * 
	 * @return ExamHomePage
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public ExamHomePage clickSaveChangesButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON SAVE CHANGES BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.clickAndWait(waitTime);
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Save Changes' BUTTON"
					+ "\n METHOD : clickSaveChangesButton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * Method helps to get Exam title.
	 * 
	 * @return String
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public String getExamTitle() throws Exception {
		String ExamTitle = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE EXAM TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtExamTitle, waitTime);
			ExamTitle = txtExamTitle.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE EXAM TITLE"
					+ "\n METHOD : getExamTitle \n" + e.getLocalizedMessage());
		}
		return ExamTitle;
	}

	/**
	 * @category Milestone 2
	 * Method is used to enter text in title field
	 * 
	 * @author Pratush.Manglik 
	 * @param title
	 * @return EditExamPage
	 * @throws Exception
	 */
	public EditExamPage setTitle(String title) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTER TEXT IN TITLE FIELD");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			txtTitle.sendKeys(title);
		} catch (Exception e) {
			throw new Exception("UNABLE TO ENTER TEXT IN TITLE FIELD"
					+ "\n METHOD : setTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * @category Milestone 2 
	 * Method is used to Click on save changes
	 * 
	 * @author Pratush.Manglik
	 * @return ExamHomePage
	 * @throws Exception
	 */
	public ExamHomePage clickSaveChanges() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICK ON SAVE CHANGES");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.click();
			uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
		} catch (Exception e) {
			throw new Exception("UNABLE TO CLICK ON SAVE CHANGES"
					+ "\n METHOD : clickSaveChanges \n" + e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * This is Service level method to Edit Exam Page
	 * 
	 * @author Kapil
	 * @param examTitle
	 * @param introductoryText
	 * @return ExamHomePage
	 */
	public ExamHomePage editExamIntroText(String examTitle,
			String introductoryText) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtExamTitle, waitTime);
			txtExamTitle.sendKeys(examTitle);
			logInstruction("LOG INSTRUCTION: ENTERED EXAM TITLE");
			getintroductoryTextRadEditor().enterText(introductoryText);
			logInstruction("LOG INSTRUCTION: ENTERED EXAM INTRODUCTORY TEXT");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
			btnSaveChanges.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception("ISSUE IN EDIT EXAM PAGE"
					+ "\n METHOD : editExamIntroText \n" + e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}
	/**
	 * This method will check Whether  Rad editor is displayed or not
	 * @return
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isRADEditorDisplayed() throws Exception{
		try {
			if(introductoryText!=null)
				return true;
		} catch (Exception e) {
			logInstruction("LOG INSTRUCTION: RAD EDITOR IS NOT DISPLAYED \n METHOD: isRADEditorDisplayed");
		}
		return false;
	}
}
