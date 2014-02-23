package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EditPageNPage extends BasePageObject {

	/* Elements */
	private UIElement btnCancel = createElement(UIType.Xpath,
			"//input[@value='Cancel']");
	private UIElement btnUpdate = createElement(UIType.Xpath,
			"//input[@value='Update Page']");
	private UIElement txtPageTitle = createElement(UIType.Xpath,
			"//input[@id='RADTitle']");
	private UIElement lblTitle = createElement(UIType.Xpath,
			"//td[@class='tablehead']//strong");
	private UIElement txtTitle = createElement(UIType.Xpath,
			"//input[@id='RADTitle']");
	private UIElement txtradEditorBody = createElement(UIType.Xpath,
			"//html/body");
	private String pageInstructionRadToolId = "RADDescription";
	private String pageInstructionRadFrameId = "RADDescription_contentIframe";
	private String pageInstructionRadFooterId = "RADDescription_ModesWrapper";
	private VisualEditor pageInstruction = new VisualEditor(uiDriver,
			pageInstructionRadToolId, pageInstructionRadFrameId,pageInstructionRadFooterId);


	/* Constructor */
	public EditPageNPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## EditPageNPage ##");
	}

	public VisualEditor getpageInstructionRadEditor() throws Exception {
		 frameSwitch.switchToFrameContent();
		return pageInstruction;
	}

	/**
	 * Method helps to click on cancel button.
	 * 
	 * @return {@link ExamHomePage}
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamHomePage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnCancel, waitTime);
			btnCancel.clickNoWait();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Cancel' BUTTON"
					+ "\n METHOD : clickCancelButton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * Method helps to click on Update page button.
	 * 
	 * @return {@link ExamHomePage}
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public ExamHomePage clickUpdatePageButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING ON UPDATE PAGE BUTTON");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUpdate, waitTime);
			btnUpdate.clickAndWait(waitTime);
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Update Page' BUTTON"
					+ "\n METHOD : clickUpdatePageButton \n"
					+ e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

	/**
	 * Method helps to enter title
	 * 
	 * @param title
	 * @return EditPageNPage
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public EditPageNPage enterPageTitle(String title) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: ENTERING THE PAGE TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
			txtPageTitle.clearAndSendKeys(title);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE PAGE TITLE"
					+ "\n METHOD : enterPageTitle \n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to get header title.
	 * 
	 * @return String
	 * @throws Exception
	 * @author saurabh.jain1
	 */
	public String getHeaderTitle() throws Exception {
		String title = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE HEADER TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(lblTitle, waitTime);
			title = lblTitle.getText();
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE HEADER TITLE."
					+ "\n METHOD : getHeaderTitle \n" + e.getLocalizedMessage());
		}
		return title;
	}

	/**
	 * Method helps to get page title.
	 * 
	 * @return String
	 * @throws Exception
	 * @author saurabh.jain1
	 * 
	 */
	public String getPageTitle() throws Exception {
		String pagetitle = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE PAGE TITLE.");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtTitle, waitTime);
			pagetitle = txtTitle.getAttribute("value");
		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE PAGE TITLE."
					+ "\n METHOD : getPageTitle \n" + e.getLocalizedMessage());
		}
		return pagetitle;
	}
	
	/**
	 * Method helps to get page instruction.
	 * 
	 * @return String
	 * @throws Exception
	 * @author saurabh.jain1
	 * 
	 */
	public String getPageInstruction() throws Exception {
		String text = null;
		try {
			logInstruction("LOG INSTRUCTION: GETTING THE PAGE INSTRUCTION.");
			String browser = System.getProperty("browser.NAME");
			logInstruction("get the page instruction");
			if (!browser.equalsIgnoreCase("INTERNETEXPLORER")) {
				frameSwitch.switchToFrameContent();
				frameSwitch.switchToRadeEntryTextcontentIframe();
				text = txtradEditorBody.getText();

			} else {
				logInstruction("LOG INSTRUCTION: SKIPPING TEXT FETCH FOR IE");
			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN GETTING THE PAGE INSTRUCTION."
					+ "\n METHOD : getPageInstruction \n"
					+ e.getLocalizedMessage());
		}
		return text;
	}
	
	/**
	 * This is Service level method to Edit 'n' Exam Page
	 * 
	 * @author Kapil
	 * @param pageTitle
	 * @param pageInstructions
	 * @return ExamHomePage
	 */
	public ExamHomePage editPageInformation(String pageTitle, String pageInstructions)
			throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
			txtPageTitle.sendKeys(pageTitle);
			logInstruction("LOG INSTRUCTION: ENTERED PAGE TITLE");
			getpageInstructionRadEditor().enterText(pageInstructions);
			logInstruction("LOG INSTRUCTION: ENTERED PAGE INSTRUCTIONS");
			frameSwitch.switchToFrameContent();
			uiDriver.waitToBeDisplayed(btnUpdate, waitTime);
			btnUpdate.clickAndWait(waitTime);
			logInstruction("LOG INSTRUCTION: CLICKED ON UPDATE BUTTON");
			uiDriver.getUIAlert().acceptAlertIfPresent();
			logInstruction("LOG INSTRUCTION: ACCEPTED ALERT");
		} catch (Exception e) {
			throw new Exception("ISSUE IN EDIT 'n' EXAM PAGE"
					+ "\n METHOD : editPageInformation \n" + e.getLocalizedMessage());
		}
		return new ExamHomePage(uiDriver);
	}

}
