package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class AddNewExamPage extends BasePageObject {

	/* Elements */
	private UIElement txtPageTitle = createElement(UIType.Xpath,
			"//*[@id='RADTitle']");
	private UIElement btnAddPage = createElement(UIType.Xpath,
			"//*[@id='button3']");
	private UIElement lblHeaderTitle = createElement(UIType.Xpath,
			"//td[@class='tablehead']//strong");
	private UIElement rad = createElement(UIType.Xpath,
			"//div[@id='RADDescription']");
	private UIElement btnCancel = createElement(UIType.ID, "button4");

	/* Variables */
	private String pageInstructionRadToolId = "RADDescription";
	private String pageInstructionRadFrameId = "RADDescription_contentIframe";
	private String pageInstructionRadFooterId = "RADDescription_ModesWrapper";
	private VisualEditor pageInstruction = new VisualEditor(uiDriver,
			pageInstructionRadToolId, pageInstructionRadFrameId,
			pageInstructionRadFooterId);
	String text;
	String ExamTitle;
	boolean status;

	/* Constructor */
	public AddNewExamPage(UIDriver driver) {
		super(driver);
		logInstruction("LOG INSTRUCTION: ## AddNewExamPage ##");
	}

	/**
	 * This method will return Page Instruction Visual Editor
	 * 
	 * @return Visual Editor
	 * @throws Exception
	 */
	public VisualEditor getpageInstructionRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return pageInstruction;
	}

	/**
	 * Method helps to enter the Page title
	 * 
	 * @param title
	 * @return AddNewExamPage
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public AddNewExamPage enterPageTitle(String title) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE PAGE TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
			txtPageTitle.sendKeys(title);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE 'Page Title'"
					+ "\n METHOD : enterPageTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to click on Add page button.
	 * 
	 * @return ExamHomePage
	 * @throws Exception
	 * @author Suchi.Singh
	 */
	public ExamHomePage clickOnAaddPageButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING THE ADD PAGE BUTTON. ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAddPage, waitTime);
			btnAddPage.clickAndWait(waitTime);
			uiDriver.getUIAlert().acceptAlertIfPresent();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Add Page Button'"
					+ "\n METHOD : clickOnAaddPageButton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * Method helps to get page title.
	 * 
	 * @return String
	 * @throws Exception
	 * @author Suchi.Singh
	 * 
	 */
	public String getExamTitle() throws Exception {
		ExamTitle = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE EXAM TITLE. ");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
			ExamTitle = txtPageTitle.getText();

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE EXAM TITLE."
					+ "\n METHOD : getExamTitle \n" + e.getLocalizedMessage());
		}
		return ExamTitle;
	}

	/**
	 * This method helps to get the page header title
	 * 
	 * @author ashish.juyal
	 * @return:String
	 * @throws Exception
	 */
	public String getHeader() throws Exception {
		text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE HEADER OF THE PAGE");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblHeaderTitle, waitTime);
			text = lblHeaderTitle.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE HEADER OF THE PAGE."
					+ "\n METHOD : getHeader \n" + e.getLocalizedMessage());
		}
		return text;

	}

	/**
	 * This method helps to check whether the rad editor is displayed or not
	 * 
	 * @author ashish.juyal
	 * @return:boolean
	 * @throws Exception
	 * 
	 */

	public boolean isRadDisplayed() throws Exception {
		status = false;
		try {
			logInstruction("LOG INSTRUCTION: CHECKING FOR THE RAD EDITOR");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(rad, waitTime);
			status = rad.isDisplayed();

		} catch (Exception e) {
			throw new Exception("UNABLE TO FIND THE RAD EDITOR."
					+ "\n METHOD : isRadDisplayed \n" + e.getLocalizedMessage());
		}
		return status;
	}

	/**
	 * This is Service level method to Add New Exam Page
	 * 
	 * @author Kapil
	 * @param pageTitle
	 * @param pageInstructions
	 * @return ExamHomePage
	 */
	public ExamHomePage addNewExam(String pageTitle, String pageInstructions)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
			txtPageTitle.sendKeys(pageTitle);
			logInstruction("LOG INSTRUCTION: ENTERED PAGE TITLE");
			getpageInstructionRadEditor().enterText(pageInstructions);
			logInstruction("LOG INSTRUCTION: ENTERED PAGE INSTRUCTIONS");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnAddPage, waitTime);
			btnAddPage.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON ADD BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception("ISSUE IN ADDING NEW EXAM PAGE"
					+ "\n METHOD : addNewExam \n" + e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * This method is used to click on Cancel Button
	 * 
	 * @author Ashish
	 * @return ExamHomePage
	 */
	public ExamHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("checking for the cancel button");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("unable to click the cancel button"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

}
