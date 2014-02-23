package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import java.util.Iterator;
import java.util.Set;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the MyGradeBookPage
 * 
 * @param uiDriver
 */

public class MyGradeBookPage extends BasePageObject {

	/* UIElements for the MyGradeBookPage */
	private UIElement lnkStudentPoint = createElement(UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[1]//a");
	private UIElement txtaddNumericgrade = createElement(UIType.ID,
			"ItemGrade.PointsAchieved");
	private UIElement txtaddLetterGrade = createElement(UIType.ID,
			"ItemGrade.LetterGrade");
	private UIElement btnsaveAndclose = createElement(UIType.ID, "SaveAndClose");
	private UIElement lnkgrade = createElement(UIType.Xpath,
			"//tr[th[contains(text(),'{1}')]]/td[1]/a");
	private UIElement lnkSelectGrade = createElement(UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[1]//a");
	private UIElement lnkEditorSwitch= createElement(UIType.Css, "#telerikRAD");
	
	/*  Variables */
	private static String parentWindow = "";
	private static final String WEB = "webliography";
	private static final String JOURNAL = "journal";
	private static final String CHAT = "chat";
	private boolean flag = false;
	
	/* Constructor */
	public MyGradeBookPage(UIDriver uiDriver) {
		super(uiDriver);
		logInstruction("LOG INSTRUCTION: ## My Gradebook Page ##");
	}

	/**
	 * @author krishna.kulkarni Method helps to clickStudentPoint
	 * @return MyGradeBookPage
	 * @throws Exception
	 */
	public MyGradeBookPage clickStudentPoint(String assignmeNtname,
			String numericgrade, String letterGrade) throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: clicked on studentpoint");
			lnkStudentPoint.replaceValues(assignmeNtname);
			uiDriver.waitToBeDisplayed(lnkStudentPoint, waitTime);
			lnkStudentPoint.click();
			Set<String> windows = uiDriver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			String parent = itr.next();
			String Child = itr.next();
			uiDriver.switchTo().window(Child);
			frameSwitch.switchtopGeneralFrame();
			txtaddNumericgrade.clearAndSendKeys(numericgrade);
			txtaddLetterGrade.clearAndSendKeys(letterGrade);

			frameSwitch.switchToNewWindowBottomFrame();
			btnsaveAndclose.click();
			uiDriver.switchTo().window(parent);

		} catch (Exception e) {
			throw new Exception("ISSUES IN CLICKING THE 'STUDENT POINT' LINK"
					+ "\n METHOD:clickStudentPoint:\n"
					+ e.getLocalizedMessage());
		}
		return new MyGradeBookPage(uiDriver);
	}

	// /**
	// * @author krishna.kulkarni Method helps to validate MyGradeBookDetail new
	// window
	// * @return MyGradeBookPage
	// * @throws Exception
	// */
	// public boolean validateMyGradeBookDetail(String stdName) throws Exception
	// {
	// try {
	// logInstruction("LOG INSTRUCTION: validating gradebookdetails");
	// parentWindow = uiDriver.getWindowHandle();
	// Set<String> handles = uiDriver.getWindowHandles();
	// for (String windowHandle : handles) {
	// if (!windowHandle.equals(parentWindow)) {
	// uiDriver.switchTo().window(windowHandle);
	// }
	// }
	// frameSwitch.switchToNewWindowTopFrame();
	// String studentName = StudentMyGradeBookDetail.getText();
	//
	// if (studentName.contains(stdName)) {
	// logInstruction("LOG INSTRUCTION: Student MyGarde Book Verified Successfully");
	// return true;
	// }
	// } catch (Exception e) {
	// throw new Exception("unable to validate gradebookdetails");
	// }
	// return false;
	//
	// }

	/**
	 * @author krishna.kulkarni Method helps to close MyGradeBookDetail new
	 *         window get back control
	 * @return MyGradeBookPage
	 * @throws Exception
	 */

	public MyGradeBookPage closeStudentPointMyGradeBookDetailNewWindow() {

		logInstruction("LOG INSTRUCTION: Closing GradeBook Detail New Window");
		uiDriver.close();
		uiDriver.switchTo().window(parentWindow);
		return new MyGradeBookPage(uiDriver);
	}

	/**
	 * This method helps to click the student points
	 * 
	 * @author ashish.juyal
	 * @throws Exception
	 */
	public Object clickGradeLink(String AssignmentName) throws Exception {
		try {
			logInstruction("selecting the assignmnet");
			frameSwitch.switchToFrameContent();
			lnkgrade.replaceValues(AssignmentName);
			uiDriver.waitToBeDisplayed(lnkgrade, waitTime);
			String itemType = lnkgrade.getAttribute("Id").split("\\_")[2];
			lnkgrade.click();
			if (itemType.equals(WEB)) {
				return new GradebookPointsWebliography(uiDriver);
			}
			if (itemType.equals(JOURNAL)) {
				return new GradebookPointsJournalPage(uiDriver);
			}
			if (itemType.equals(CHAT)) {
				return new GradebookPointsChatPage(uiDriver);
			}
		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING THE 'Grade' LINK"
					+ "\n METHOD:clickGrade" + e.getLocalizedMessage());
		}
		return null;

	}

	/**
	 * Method helps to clickOnStudentPoint
	 * 
	 * @author suchi.singh
	 * @return CourseGradeDetailViewPage
	 * @param assignment
	 *            Name
	 * @throws Exception
	 */
	public CourseGradeDetailViewPage clickOnStudentPoint(String assignmeNtname)
			throws Exception {
		try {
			logInstruction("LOG INSTRUCTION: CLICKING  ON STUDENT POINT.");
            frameSwitch.switchToFrameContent();
			lnkStudentPoint.replaceValues(assignmeNtname);
          	lnkStudentPoint.click();
			uiDriver.getUIWindowLocator().switchToNewWindow();

		} catch (Exception e) {
			throw new Exception("ISSUE IN CLICKING  ON STUDENT POINT."
					+ "\n METHOD: clickOnStudentPoint"
					+ e.getLocalizedMessage());
		}
		return new CourseGradeDetailViewPage(uiDriver);
	}

	/**
	 * This Method will Select Grade * in front of Item type
	 * 
	 * @param ItemType
	 * @return
	 * @throws Exception
	 * @author Shishir.Dwivedi
	 */
	public GradebookDetailsUIPage selectGrade(String ItemType) throws Exception {
		try {
			frameSwitch.switchToFrameContent();
			lnkSelectGrade.replaceValues(ItemType);
			uiDriver.waitToBeDisplayed(lnkSelectGrade, waitTime);
			lnkSelectGrade.click();
			uiDriver.getUIWindowLocator().switchToNewWindow();

		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO GET THE GRADE \n METHOD : selectGrade");
		}
		return new GradebookDetailsUIPage(uiDriver);
	}

	/**
	 * method is to click on the * link for an assignment
	 * 
	 * @author kirankumar
	 * @category milestone 2
	 * @return GradeableItemDocSharingPage
	 * @throws Exception
	 */
	public GradeableItemDocSharingPage clickGradeLinkStar(String assignmentname)
			throws Exception {
		try {
			logInstruction("LOGINSTRUCTION:CLICKING ON GRADE LINK");
			frameSwitch.switchToFrameContent();
			lnkStudentPoint.replaceValues(assignmentname);
			lnkStudentPoint.click();
			frameSwitch.switchToNewWindow();

		} catch (Exception e) {
			throw new Exception("issue in clicking on 'gradelink'"
					+ "\n method:clickGradelink \n" + e.getLocalizedMessage());
		}
		return new GradeableItemDocSharingPage(uiDriver);
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

}
