package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.common.pages.VisualEditor;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains the method related to Gradeable item Chat page which opens as
 * a new window.
 * 
 * @author Raghav
 * 
 */

public class GradeableItemChatPage extends BasePageObject {

	/* UIElement declarations for the GradeableItemChatPage */
	private UIElement txtnumericgrade = createElement(UIType.ID,
			"ItemGrade.PointsAchieved");
	private UIElement txtlettergrade = createElement(UIType.ID,
			"ItemGrade.LetterGrade");
	private UIElement btnsaveandclose = createElement(UIType.Css,
			"input[name='SaveAndClose']");
	private UIElement chkshareGradewithstudent = createElement(UIType.ID,
			"shareGradeCheckBox");
	private String frameid = "RadeEntryText_contentIframe";
	private String gradableRadToolId = "RadeEntryText";

	public GradeableItemChatPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("############GradeableItemChatPage######");
	}

	private VisualEditor gradeablerad = new VisualEditor(uiDriver,
			gradableRadToolId, frameid, gradableRadToolId);

	public VisualEditor getGradableRadEditor() throws Exception {
		frameSwitch.switchToFrameContent();
		return gradeablerad;
	}

	/**
	 * Method will helps to enter the Numeric Grade
	 * 
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradeableItemChatPage enterNumericGrade(String entergrade)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE NUMERIC GRADE");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(txtnumericgrade, waitTime);
			txtnumericgrade.clearAndSendKeys(entergrade);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE'numeric' GRADE"
					+ "\n METHOD:enterNumericGrade\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method will helps to enter the Letter Grade
	 * 
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradeableItemChatPage enterLetterGrade(String lettergrade)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:ENTERING THE NUMERIC GRADE");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(txtlettergrade, waitTime);
			txtlettergrade.clearAndSendKeys(lettergrade);
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING THE'letter' GRADE"
					+ "\n METHOD:enterLetterGrade\n" + e.getLocalizedMessage());
		}
		return this;
	}

	/**
	 * Method Helps to click and Save
	 * 
	 * @author Raghav S
	 * @throws Exception
	 */
	public GradebookHomePage clickSaveandClose() throws Exception {
		try {
			logInstruction("LOG INSTRUCTION:CLICK ON SAVE CHANGES");
			frameSwitch.switchtopGeneralFrame();
			uiDriver.waitToBeDisplayed(btnsaveandclose, waitTime);
			btnsaveandclose.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICK'save' CHANGES"
					+ "\n METHOD:clickSaveandClose\n" + e.getLocalizedMessage());
		}
		return new GradebookHomePage(uiDriver);
	}

	/**
	 * Method to enter the grade of item type=chat
	 * 
	 * @category service level method
	 * @author kiran.kumar
	 * @throws Exception
	 */

	public GradebookHomePage enterGradePoints(String lettergrade,
			int numericgrade, boolean selectcheckbox, String radtext)
			throws Exception {
		try {
			logInstruction("ENTERING GRADE FOR CHAT ITEM");
			frameSwitch.switchtopGeneralFrame();
			txtlettergrade.clearAndSendKeys(lettergrade);
			String numericgrade1 = Integer.toString(numericgrade);
			txtnumericgrade.clearAndSendKeys(numericgrade1);
			if (selectcheckbox == true
					&& !chkshareGradewithstudent.isSelected()) {
				chkshareGradewithstudent.clickNoWait();

			} else {
				logInstruction("LOGINSTRUCTION:ALREADY CHECKED");
				;
			}
			getGradableRadEditor().enterText(radtext);

			frameSwitch.switchtopGeneralFrame();
			btnsaveandclose.clickAndWait(waitTime);
			uiDriver.getUIWindowLocator().switchToFirstWindow();
		} catch (Exception e) {
			throw new Exception("ISSUE IN ENTERING GRADE"
					+ "\n Method:enterGradePoints \n" + e.getLocalizedMessage());
		}

		return new GradebookHomePage(uiDriver);

	}
}
