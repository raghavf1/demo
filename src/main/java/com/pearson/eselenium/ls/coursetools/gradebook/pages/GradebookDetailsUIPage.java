package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.eselenium.ls.contentitems.threadeddiscussion.pages.ThreadHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the GradebookDetailsUIPage
 * 
 * @author ganapati.bhat
 * @param uiDriver
 */
public class GradebookDetailsUIPage extends BasePageObject {

	/* Elements */
	private UIElement lblheader = createElement(UIType.Css, ".tablehead");
	private UIElement topicNames = createElement(UIType.Xpath,
			"//a[contains(.,'{1}')]");
	private UIElements lbltablehead = createElements(UIType.Css, ".tablehead");;
	private UIElement txteditor = createElement(UIType.Xpath, "//html/body");
	private UIElement btnSave = createElement(
			UIType.Css,
			"table.outercontenttable>tbody>tr>td>table>tbody>tr:nth-of-type(2)>td>input:nth-of-type(1)");
	private UIElement btnSaveAndClose = createElement(UIType.Xpath,
			"//form[@id='gradebookView']//input[@id='button9']']");
	private UIElement divheading = createElement(UIType.Css, ".tablehead");
	public static String name = null;
	private String toolID = "RadeEntryText";
	private String frameID = "RadeEntryText_contentIframe";
	private boolean flag = false;
	private VisualEditor visualEditor = new VisualEditor(uiDriver, toolID,
			frameID, toolID);
	private UIElement btnCancel = createElement(UIType.Css, "#button9");
	private UIElement lnkEditorSwitch = createElement(UIType.Css, "#telerikRAD");

	/* Constructor */
	public GradebookDetailsUIPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## Gradebook Details UI Page ##");
	}

	public VisualEditor getVisualEditor() {

		uiDriver.switchTo().defaultContent();
		uiDriver.getUIFrameLocator().selectFrame("generalBottomFrame");
		return visualEditor;
	}

	public VisualEditor getVisualEditorForThreadItem() throws Exception {
		uiDriver.switchTo().defaultContent();
		uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
		return visualEditor;
	}

	public VisualEditor getVisualEditorForExamItem() throws Exception {
		uiDriver.switchTo().defaultContent();
		uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
		return visualEditor;
	}

	public VisualEditor getVisualEditorForWebContent() throws Exception {
		uiDriver.switchTo().defaultContent();
		return visualEditor;
	}

	public VisualEditor getVisualEditorForTextMultimedia() throws Exception {
		uiDriver.switchTo().defaultContent();
		return visualEditor;
	}

	public VisualEditor getVisualEditorForMSDOC() throws Exception {
		uiDriver.switchTo().defaultContent();
		return visualEditor;
	}

	public VisualEditor getVisualEditorForChat() throws Exception {
		uiDriver.switchTo().defaultContent();
		uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
		return visualEditor;
	}

	/**
	 * Method helps to switch to the GradebookDetailsUIPage
	 * 
	 * @author ganapati.bhat
	 * @return
	 * @throws Exception
	 */

	public GradebookDetailsUIPage switchToGradebookDetailsUIPage()
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Switching the window to GradebookDetailsUI page");
			uiDriver.getUIWindowLocator().switchToNewWindow();
		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN SWITCHING TO THE 'GradebookDetailsUIPage'"
							+ "\n METHOD:switchToGradebookDetailsUIPage\n"
							+ e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method helps to select the topic required
	 * 
	 * @author ganapati.bhat
	 * @throws Exception
	 * @return:GradebookDetailsUIPage
	 */
	public GradebookDetailsUIPage verifyTheTopicSelected(String topicName)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Topic is selected");
			frameSwitch.switchToNewWindowBottomFrame();
			topicNames.replaceValues(topicName);
			uiDriver.waitToBeDisplayed(topicNames, waitTime);

			if (topicNames.isDisplayed()) {
				topicNames.click();

			} else {
				List<UIElement> elements = lbltablehead.getUIElementsList();
				int totalHeader = elements.size();
				for (int i = 0; i < totalHeader; i++) {
					if (elements.get(i).getText().trim().equals(topicName)) {

						break;
					}
				}

			}

		} catch (Exception e) {
			throw new Exception("ISSUE IN SELECTING THE TOPIC"
					+ "\n METHOD:verifyTheTopicSelected\n"
					+ e.getLocalizedMessage());
		}
		return this;

	}

	/**
	 * Method helps to click on the close popup window and switch to main window
	 * 
	 * @author ganapati.bhat
	 * @return:ThreadHomePage
	 * @throws Exception
	 */
	public ThreadHomePage closePopUpWindowAndSwitchToMainWindow()
			throws Exception {

		try {
			logInstruction("LOG INSTRUCTION: switch to main window");
			List<String> windows = new ArrayList<String>();
			windows.addAll(uiDriver.getWindowHandles());
			uiDriver.close();
			uiDriver.switchTo().window(windows.get(0));
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLOSING THE POP UP WINDOW"
					+ "\n METHOD:closePopUpWindowAndSwitchToMainWindow\n"
					+ e.getLocalizedMessage());
		}
		return new ThreadHomePage(uiDriver);
	}

	/**
	 * Method to verify the gradebookDetailsUIPage
	 * 
	 * @param studentName
	 * @return
	 * @throws Exception
	 */
	public boolean VerifyGradebookDetailsUIPage(String studentName)
			throws Exception {
		boolean value = false;
		try {
			logInstruction("LOG INSTRUCTION: Verify the UIPage");
			uiDriver.waitToBeDisplayed(lblheader, waitTime);
			frameSwitch.switchToNewWindowTopFrame();
			String studentNameValue = lblheader.getText().trim();
			if (studentNameValue.contains(studentName)) {
				value = true;
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN VERIFYING THE PAGE"
					+ "\n METHOD:isGradebookDetailsUiPageDisplayed\n"
					+ e.getLocalizedMessage());
		}
		return value;
	}

	/**
	 * This method helps sending character in editor author:ashish.juyal
	 * 
	 * @return:GradebookDetailsUIPage
	 */
	public GradebookDetailsUIPage writeTextInEditor(String val)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: Enter text in editor");
			frameSwitch
					.switchToRadeEntryTextcontentIframethroughtopGeneralFrame();
			txteditor.sendKeys(Keys.CONTROL + "a");
			txteditor.sendKeys(Keys.DELETE);
			txteditor.sendKeys(val);
		} catch (Exception e) {
			throw new Exception("ISSUE IN WRITING THE TEXT IN EDITOR"
					+ "\n METHOD:writeTextInEditor\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/*
	 * Clicking save button after entering the text in editor
	 * author:ashish.juyal
	 */
	public GradebookDetailsUIPage clickSaveButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: click on save button");
			frameSwitch.switchtopGeneralFrame();
			btnSave.click();
			uiDriver.switchTo().alert().accept();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE SAVE BUTTON"
					+ "\n METHOD:clickSaveButton\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/*
	 * Clicking save button after entering the text in editor author:soundarya
	 */
	public MyGradeBookPage clickSaveAndCloseButton() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: click on save and close button button");
			uiDriver.switchTo().defaultContent();
			uiDriver.switchTo().frame("generalBottomFrame");
			btnSaveAndClose.click();
			uiDriver.getUIAlert().acceptAlertIfPresent();
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE SAVE AND CLOSE BUTTON"
					+ "\n METHOD: clickSaveAndCloseButton\n"
					+ e.getLocalizedMessage());
		}
		return new MyGradeBookPage(uiDriver);
	}

	/**
	 * This method will click on cancel button
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public MyGradeBookPage clickCancelButton() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : CLICKING ON CANCEL BUTTON");
			btnCancel.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK ON CANCEL BUTTON \n METHOD : clickCancelButton");
		}
		return new MyGradeBookPage(uiDriver);
	}

	/**
	 * This method will switch between the window
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void switchToPOPWindow() throws Exception {
		try {
			logInstruction("LOG INSTRUICTION : SWITCHING TO POP UP WINDOW ");
			uiDriver.getUIWindowLocator().switchToNewWindow();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO SWITCH TO NEW WINDOW \n METHOD: switchToPOPWindow");
		}

	}

	/**
	 * This method will get page name
	 * 
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public void getPageName() throws Exception {
		try {
			logInstruction("LOG INSTRCUTION : GETTING PAGE NAME ");
			uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
			uiDriver.waitToBeDisplayed(divheading, waitTime);
			if (divheading.getText().trim().contains("INBOX")) {
				name = "INBOX";
			} else {
				name = divheading.getText().trim();
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE PAGE NAME \n METHOD : getPageName");
		}
	}

	/**
	 * Method helps to verify Alternative Editor Present or not..
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
	 * This Method will check whether Rad Editor is displayed or not.
	 * 
	 * @return {@link Boolean}
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public boolean isRadEditorDisplayed() throws Exception {
		try {
			if (visualEditor != null)
				return true;

		} catch (Exception e) {
			throw new Exception(
					"ISSUE IN VERIFYING ALTERNATIVE EDITOR SWITCH OPTION."
							+ "\n METHOD : isEditorSwitchDisplayed \n"
							+ e.getLocalizedMessage());
		}
		return false;
	}
}
