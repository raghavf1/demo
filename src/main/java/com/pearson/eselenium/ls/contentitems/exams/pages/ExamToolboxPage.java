package com.pearson.eselenium.ls.contentitems.exams.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * @author Kiran.Kumar2
 * @date Nov 4, 2013
 */

public class ExamToolboxPage extends BasePageObject {

    /* Elements */
    private UIElement lnkdeleteExam = createElement(UIType.Xpath, "//a[contains(.,'Delete')]");
    private UIElement chkExamGaurd = createElement(UIType.Css, "#UseExamGuard");
    private UIElement lblpagetitle = createElement(UIType.Css, ".pageTitle");
    private UIElement lnkmoveexam = createElement(UIType.Xpath, "//a[contains(.,'Move')]");
    private UIElement btncancel = createElement(
            UIType.Xpath,
            "//table/tbody/tr[4]/td/input[2][@value='Cancel']");

    private UIElement lnkEditSchedule = createElement(
            UIType.Xpath,
            "//a[contains(.,'Edit Schedule')]");
    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//td[@width='35%']/following-sibling::td");

    private UIElement btnSaveChanges = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save Changes')]");

    /**
     * @param driver
     */
    /* Constructor */
    public ExamToolboxPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## ExamToolboxPage ##");
    }

    /**
     * This Method will delete the exam
     * 
     * @return {@link NextCourseHomePage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public NextCourseHomePage clickdeleteExam() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lnkdeleteExam, waitTime);
            lnkdeleteExam.clickNoWait();
            uiDriver.getUIAlert().acceptAlertIfPresent();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Delete' BUTTON" + "\n METHOD : clickdeleteExam \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

    /**
     * This Method will Check on The Exam Gaurd CheckBox
     * 
     * @return {@link ExamToolboxPage}
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public ExamToolboxPage checkExamGaurd() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON EXAM GAURD");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkExamGaurd, waitTime);
            chkExamGaurd.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON EXAM GAURD." + "\n METHOD : checkExamGaurd \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to click MoveExam
     * 
     * @author amit.deshmukh Category Milestone 2
     * @return ExamToolboxPage
     * @throws Exception
     */
    public ExamToolboxPage clickMoveExam() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON MOVEEXAM");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(lnkmoveexam, waitTime);
            lnkmoveexam.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON MOVEEXAM." + "\n METHOD : clickMoveExam \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to get header title
     * 
     * @author amit.deshmukh Category Milestone 2
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {
        String title = null;
        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblpagetitle, waitTime);
            title = lblpagetitle.getText().trim();
            return title;
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING TITLE." + "\n METHOD : getPageTitle \n" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to click Cancel
     * 
     * @author amit.deshmukh Category Milestone 2
     * @return ExamToolboxPage
     * @throws Exception
     */
    public ExamToolboxPage clickCancel() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(btncancel, waitTime);
            btncancel.clickNoWait();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING ON 'Cancel'." + "\n METHOD : clickCancel \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method is used to click on Edit Schedule link
     * 
     * @category Milestone 2
     * @author Pratush.Manglik
     * @return EditSchedulePage
     * @throws Exception
     */
    public ExamEditSchedulePage clickEditScheduleLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON 'Edit Schedule' LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule, waitTime);
            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Edit Schedule' LINK" + "\n METHOD:clickEditScheduleLink \n" + e
                            .getLocalizedMessage());
        }
        return new ExamEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to get message adjacent to Edit Schedule Link
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getMessageDisplayedNextToEditSchedule() throws Exception {
        String msgg;
        try {
            logInstruction("LOG INSTRUCTION : GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            msgg = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
            	"UNABLE TO GET MESSAGE ADJACENT TO EDIR SCHEDULE LINK." + "\n METHOD : getMessageDisplayedNextToEditSchedule \n" + e
                    .getLocalizedMessage());
        }
        return msgg;
    }

    /**
     * @category Milestone 2 Method is used to click on Save Changes button
     * @author Pratush.Manglik
     * @return ExamHomePage
     * @throws Exception
     */
    public ExamHomePage clickSaveChanges() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK ON SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.click();
            uiDriver.getUIAlert().acceptAlertIfPresent(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON SAVE CHANGES BUTTON." + "\n METHOD : clickSaveChanges \n" + e
                    .getLocalizedMessage());
        }
        return new ExamHomePage(uiDriver);
    }
}
