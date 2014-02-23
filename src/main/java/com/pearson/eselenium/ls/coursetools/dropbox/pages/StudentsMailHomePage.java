package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class StudentsMailHomePage extends BasePageObject {

    private UIElement txtNumericGrade = createElement(
            UIType.Xpath,
            "//tr[td[a[contains(.,'{1}')]]]//td[6]/input");
    private UIElement txtLetterGrade = createElement(
            UIType.Xpath,
            "//tr[td[a[contains(.,'{1}')]]]//td[7]/input");
    private UIElement btnSaveChanges = createElement(UIType.Css, "#save");
    private UIElement chkReturn = createElement(
            UIType.Xpath,
            "//tr[td[a[contains(.,'{1}')]]]//td[8]/input");
    private UIElement txtAssignment = createElement(UIType.Xpath, "//a[contains(.,'{1}')]");
    private UIElement lnkOutbox = createElement(UIType.Xpath, "//form//a[contains(.,'Outbox')]");

    private boolean flag = false;
    public StudentsMailHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## StudentsMailHomePage ##");
    }

    /**
     * This method will click student outbox link
     * 
     * @author soundarya
     * @return StudentOutBoxPage
     * @throws Exception
     * **/
    public StudentsOutBoxPage clickOutboxLink() throws Exception {
        try {
			logInstruction("LOG INSTRUCTION: CLICK STUDENT OUTBOX LINK");
			frameSwitch.switchToFrameContent();
			if (lnkOutbox.isDisplayedAfterWaiting(waitTime)) {
				lnkOutbox.clickAndWait(waitTime);
			} else {
				throw new Exception(
						"ERROR WHILE CLICKING STUDENT OUTBOX LINK \n METHOD: clickOutboxLink");
			}
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO CLICK STUDENT OUTBOX LINK \n METHOD :clickOutboxLink" + e
                            .getLocalizedMessage());
        }
        return new StudentsOutBoxPage(uiDriver);
    }

    /**
     * This method will enter student numeric grade
     * 
     * @author Soundarya
     * @param strAssginment
     * @param intGrade
     * @return
     * @throws Exception
     */
    public StudentsMailHomePage enterNumericGrade(String strAssginment, int intGrade)
            throws Exception {
        try {
			logInstruction("LOG INSTRUCTION : ENTER STUDENT NUMERIC GRADE");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssginment)) {
				txtNumericGrade.replaceValues(strAssginment);
				if (txtNumericGrade.isDisplayedAfterWaiting(waitTime))
                    txtNumericGrade.clearAndSendKeys(Integer.toString(intGrade));

			} else
                throw new Exception("ASSIGNMENT VALUE IS BLANK \n METHOD :enterNumericGrade");
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO ENTER STUDENT NUMERIC GRADE \n METHOD :enterNumericGrade" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will enter student Letter grade
     * 
     * @author soundarya
     * @return StudentMailHomePage
     * @throws Exception
     * **/
    public StudentsMailHomePage enterLetterGrade(String strAssginment, String strLetterGrade)
            throws Exception {
        try {
			logInstruction("LOG INSTRUCTION :ENTER STUDENT LETTER GRADE");
			frameSwitch.switchToFrameContent();
            if (StringUtils.isNotBlank(strAssginment) && StringUtils.isNotBlank(strLetterGrade)) {
				txtLetterGrade.replaceValues(strAssginment);
				if (txtLetterGrade.isDisplayedAfterWaiting(waitTime))
					txtLetterGrade.clearAndSendKeys(strLetterGrade);
			} else
				throw new Exception(
						"ASSIGNMENT VALUE OR LETTER GRADE VALUE IS EMPTY \n METHOD :enterLetterGrade");
		} catch (Exception e) {
			throw new Exception(
					"UNABLE TO ENTER STUDENT LETTER GRADE \n METHOD :enterLetterGrade" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will select the check box select return check box
     * 
     * @author soundarya
     * @param String
     *            assginment
     * @return StudentMailHomePage
     * @throws Exception
     * **/
    public StudentsMailHomePage selectReturnCheckbox(String strAssginment) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING RETURN CHECKBOX OF STUDENT " + strAssginment);
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssginment)) {
				chkReturn.replaceValues(strAssginment);
				if (chkReturn.isDisplayedAfterWaiting(waitTime))
					chkReturn.clickAndWait(waitTime);
			} else
                throw new Exception("ASSIGNMENT VALUE IS BLANK \n METHOD :selectReturnCheckbox");
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO SELECT RETURN CHECKBOX OF STUDENT \n METHOD :selectReturnCheckbox" + strAssginment + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method will click Save Changes Button on Dropbax Page.
     * 
     * @author soundarya
     * @return DropboxPage
     * @throws Exception
     * **/
    public DropboxPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING SAVE CHANGES BUTTON.");
			frameSwitch.switchToFrameContent();
			if (btnSaveChanges.isDisplayedAfterWaiting(waitTime)) {
				btnSaveChanges.clickAndWait(waitTime);

			} else {
				throw new Exception(
						"ERROR WHILE CLICKING SAVE CHANGES BUTTON \n METHOD: clickSaveChangesButton");
			}

		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO CLICK SAVE CHANGES BUTTON. \n METHOD :clickSaveChangesButton" + e
                            .getLocalizedMessage());
		}
        return new DropboxPage(uiDriver);
	}

    /**
     * This method will click Student assignment in inbox
     * 
     * @author soundarya
     * @param String
     *            - assginment
     * @return DropboxPage
     * @throws Exception
     * **/
    public DropBoxDetailViewPage clickAssignmentInInbox(String strAssginment) throws Exception {
        try {
			logInstruction("LOG INSTRUCTION: CLICK STUDENT ASSIGNMENT IN INBOX");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssginment)) {
				txtAssignment.replaceValues(strAssginment);
				if (txtAssignment.isDisplayedAfterWaiting(waitTime)) {
					txtAssignment.clickAndWait(waitTime);
				} else {
					throw new Exception(
							"ERROR WHILE CLICKING ASSINGMENT IN INBOX \n METHOD: clickAssignmentInInbox");
				}
			} else
                throw new Exception("ASSIGNMENT VALUE IS BLANK \n METHOD :clickAssignmentInInbox");
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO CLICK STUDENT ASSIGNMENT IN INBOX \n METHOD :clickAssignmentInInbox" + e
                            .getLocalizedMessage());
		}
        return new DropBoxDetailViewPage(uiDriver);
	}

    /**
     * This method will check Student assignment is displayed in inbox
     * 
     * @author soundarya
     * @param String
     *            - assginment
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAssignementDisplayedInInbox(String strAssginment) throws Exception {
        flag = false;
        try {
			logInstruction("LOG INSTRUCTION: CHECK STUDENT ASSIGNMENT IS DISPLAYED IN INBOX");
			frameSwitch.switchToFrameContent();
			if (StringUtils.isNotBlank(strAssginment)) {
				txtAssignment.replaceValues(strAssginment);
                flag = txtAssignment.isDisplayedAfterWaiting(waitTime);
			} else
				throw new Exception(
						"ASSIGNMENT VALUE IS BLANK \n METHOD :isAssignementDisplayedInInbox");
		} catch (Exception e) {
			throw new Exception(
                    "UNABLE TO CHECK STUDENT ASSIGNMENT IS DISPLAYED IN INBOX \n METHOD :isAssignementDisplayedInInbox" + e
                            .getLocalizedMessage());
		}
        return flag;
	}
}