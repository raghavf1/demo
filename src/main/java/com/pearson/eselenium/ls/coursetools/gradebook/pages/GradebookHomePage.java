package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.elements.DefaultUIActions;
import com.pearson.test.eselenium.framework.elements.UIActions;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the GradebookHomePage
 * 
 * @author praveen.maled
 */
public class GradebookHomePage extends BasePageObject {

    /* UIElements for the GradebookHomePage */
    private UIElement lnksetupgradebookTab = createElement(UIType.Link, "Setup Gradebook");
    private UIElement lnkselectstudent = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");
    private UIElement selectGradebookDrpDwn = createElement(UIType.ID, "gradebookViewDropDownList2");
    private UIElement btnclickSelextGradeGoBtn = createElement(UIType.ID, "goButton2");
    private UIElement btnClickgradebookandRubrics = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Setup Gradebook & Rubrics')]");
    private UIElement GradebookPresentForStudent = createElement(
            UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[1]");
    private UIElement clickonStudentforgrade = createElement(
            UIType.Xpath,
            "//a[contains(text(),'{1}')]");
    private UIElement lnkplaintexteditor = createElement(
            UIType.Link,
            "//a[@id='RadCourseText_simpleEditor']");
    private UIElement selectRubric = createElement(
            UIType.Xpath,
            "//a[contains(text(),'Setup Gradebook & Rubrics')]");
    private UIElement lnkCoursePointtodate = createElement(
            UIType.Xpath,
            "//td[a[contains(text(),'{1}')]]/following-sibling::td[1]//a");
    private UIElement lnkclickStudentPoint = createElement(
            UIType.Xpath,
            "//th[contains(text(),'{1}')]/following-sibling::td[1]/a");
    private UIElement txtPageHeader = createElement(UIType.Css, ".pageTitle");
    private UIElement btnclickchat = createElement(
            UIType.Xpath,
            "//td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]/following::th[contains(text(),'{2}')]/following::td[2]//a[contains(text(),'Chat')]/following::tr[1]/td[2]/a");
    private UIElement btnclickdocsharing = createElement(
            UIType.Xpath,
            "//td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]/following::th[contains(text(),'{2}')]/following::td[3]//a[contains(text(),'Doc Sharing')]/following::tr[1]/td[3]/a");
    private UIElement btnclickjournal = createElement(
            UIType.Xpath,
            "//td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]/following::th[contains(text(),'{2}')]/following::td[4]//a[contains(text(),'Journal')]/following::tr[1]/td[4]/a");
    private UIElement btnclickwebliography = createElement(
            UIType.Xpath,
            "//td[table[tbody[tr[td[a[contains(text(),'{1}')]]]]]]/following::th[contains(text(),'{2}')]/following::td[5]//a[contains(text(),'Webliography')]/following::tr[1]/td[5]/a");
    private UIElement lblgrade = createElement(UIType.Xpath, "//a[contains(text(),'{1}')]");

    /* Constructor */
    public GradebookHomePage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Gradebook Home Page ##");
    }

    /**
     * method to select SetUpGradeBook tab
     * 
     * @author praveen.maled
     * @return
     * @throws Exception
     */
    public SetUpGradeBookPage selectSetUpGradeBook() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: select the gradebook");
            uiDriver.waitToBeDisplayed(lnksetupgradebookTab, waitTime);
            frameSwitch.switchToFrameContent();
            lnksetupgradebookTab.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'Setup Gradebook' TAB" + "\n METHOD:selectSetUpGradeBook\n" + e
                            .getLocalizedMessage());
        }
        return new SetUpGradeBookPage(uiDriver);
    }

    /**
     * clicking on student link
     * 
     * @author praveen.maled
     * @param stdname
     * @return
     * @throws Exception
     */
    public MyGradeBookPage selectStudent(String stdname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: select the student");
            frameSwitch.switchToFrameContent();
            lnkselectstudent.replaceValues(stdname);
            uiDriver.waitToBeDisplayed(lnkselectstudent, waitTime);
            lnkselectstudent.click();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'Student' LINK " + "\n METHOD:selectStudentLink \n" + e
                            .getLocalizedMessage());
        }
        return new MyGradeBookPage(uiDriver);
    }

    /**
     * method to select GradeBookDropDown value tab
     * 
     * @author kiran.kumar
     * @return
     * @throws Exception
     */
    public GradebookHomePage SelectGradeBookDrpDwn(String gradeBookView) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: selecting the " + gradeBookView + " as entered");
            frameSwitch.switchToFrameContent();
            selectGradebookDrpDwn.selectByVisibleText(gradeBookView);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'Gradebook View'" + "\n METHOD:SelectGradeBookDrpDwn\n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method to select clickSelectGradeOkBtn value tab
     * 
     * @author kiran.kumar
     * @return
     * @throws Exception
     **/
    public GradebookHomePage clickSelectGradeOkBtn() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clickong on go button");
            frameSwitch.switchToFrameContent();
            btnclickSelextGradeGoBtn.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'GRADE OK ' BUTTON" + "\n METHOD:clickSelectGradeOkBtn:\n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * method to select clickSelect setup and rubrics
     * 
     * @author kiran.kumar
     * @return
     * @throws Exception
     **/
    public SetUpGradeBookPage clickSelectsetupGradebookAndRubiric() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicking on gradebook and rubrics");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(btnClickgradebookandRubrics, waitTime);
            UIActions act = new DefaultUIActions(uiDriver, btnClickgradebookandRubrics);
            act.mouseMoveHere();
            btnClickgradebookandRubrics.click();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Setup Gradebook & Rubrics' BUTTON" + "\n METHOD:clickSelectsetupGradebookAndRubiric\n" + e
                            .getLocalizedMessage());
        }
        return new SetUpGradeBookPage(uiDriver);
    }

    /**
     * method to verify the grade displayed for a student in gradeview .
     * 
     * @author kiran.kumar
     * @return
     * @throws Exception
     **/
    public boolean isGradebookDisplayedForStudent(String itemName) throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: getting grade");
            frameSwitch.switchToFrameContent();
            GradebookPresentForStudent.replaceValues(itemName);
            GradebookPresentForStudent.isDisplayed();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN FINDING THE GRADEBOOK PAGE" + "\n METHOD:isGradebookDisplayedForStudent:\n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * method to click on a student to grade student in gradeview .
     * 
     * @author kiran.kumar
     * @return
     * @throws Exception
     **/
    public MyGradeBookPage clickonStudentTograde(String studName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: selecting a student for grading");
            clickonStudentforgrade.replaceValues(studName);
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(clickonStudentforgrade, waitTime);
            clickonStudentforgrade.click();

        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Student To grade' BUTTON" + e
                    .getLocalizedMessage());
        }
        return new MyGradeBookPage(uiDriver);
    }

    /**
     * Method will get the grade book home page header
     * 
     * @author Praveen.Maled
     * @return String
     * @throws Exception
     * @Category Milestone 2
     */
    public String getPageHeader() throws Exception {
        String strHeader = "";
        try {
            logInstruction("LOG INSTRUCTION: GETTING 'Page Header'");
            txtPageHeader.isDisplayedAfterWaiting(waitTime);
            strHeader = txtPageHeader.getText().trim();
        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'Page Header'" + "\nMETHOD:getPageHeader \n" + e
                    .getLocalizedMessage());
        }
        return strHeader;

    }

    /**
     * This method check whether the simple editor is diplayed or not
     * 
     * @author ashish.juyal
     * @return:boolean
     * 
     */
    public boolean isSimpleEditorDisplayed() throws Exception {
        boolean status = false;
        try {
            logInstruction("checking for the plain text editor");
            frameSwitch.switchToFrameContent();
            status = lnkplaintexteditor.isAbsent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN LOCATING THE 'Simple Editor'" + "\n METHOD:isSimpleEditorDisplayed\n" + e
                            .getLocalizedMessage());
        }
        return status;
    }

    public GradebookDetailsUIPage clickCoursePointToDate(String StudName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICKING ON STAR IN FRONT STUDENT NAME ");
            frameSwitch.switchToFrameContent();
            lnkCoursePointtodate.replaceValues(StudName);
            uiDriver.waitToBeDisplayed(lnkCoursePointtodate, waitTime);
            lnkCoursePointtodate.click();
            uiDriver.getUIWindowLocator().switchToNewWindow();

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET THE COURSE POINT TO DATE \n METHOD : clickCoursePointToDate");
        }
        return new GradebookDetailsUIPage(uiDriver);
    }

    /**
     * This method helps to click the SetUpRubric
     * 
     * @author ashish.juyal
     */
    public SetUpGradeBookPage clicksetUpGradebook() {
        try {
            logInstruction("Clicking the setupgradebook");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(selectRubric, waitTime);
            selectRubric.click();
        } catch (Exception e) {
            logInstruction("ISSUE IN CLICKING THE SETUP GRADEBOOK" + "METHOD:clicksetUpGradebook" + e
                    .getLocalizedMessage());
        }
        return new SetUpGradeBookPage(uiDriver);
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
    public CourseGradeDetailViewPage clickOnStudentPoint(String assignmeNtname) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING  ON STUDENT POINT.");
            lnkclickStudentPoint.replaceValues(assignmeNtname);
            uiDriver.waitToBeDisplayed(lnkclickStudentPoint, waitTime);
            // uiDriver.getUIWindowLocator().rememberMainWindow();

            lnkclickStudentPoint.click();
            uiDriver.getUIWindowLocator().switchToNewWindow();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING  ON STUDENT POINT." + "\n METHOD: clickOnStudentPoint" + e
                            .getLocalizedMessage());
        }
        return new CourseGradeDetailViewPage(uiDriver);
    }

    /**
     * Methods Help Click on Chat for Students Category Milestone 2
     * 
     * @author Raghav
     * @return
     * @throws Exception
     **/
    public GradeableItemChatPage clickonStudentTogradeForChat(String studName, String coursename)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CHAT WINDOW TO GRADE");
            frameSwitch.switchToFrameContent();
            btnclickchat.replaceValues(studName, coursename);
            uiDriver.waitToBeDisplayed(btnclickchat, waitTime);
            btnclickchat.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Student To grade' BUTTON" + e
                    .getLocalizedMessage());
        }
        return new GradeableItemChatPage(uiDriver);
    }

    /**
     * Methods Help Click on Doc Sharing for Students Category Milestone 2
     * 
     * @author Raghav
     * @return
     * @throws Exception
     **/
    public GradeableItemDocSharingPage clickonStudentTogradeForDocSharing(
            String studName,
            String coursename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DOC SHARING WINDOW TO GRADE");
            frameSwitch.switchToFrameContent();
            btnclickdocsharing.replaceValues(studName, coursename);
            uiDriver.waitToBeDisplayed(btnclickdocsharing, waitTime);
            btnclickdocsharing.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Student To grade' BUTTON" + e
                    .getLocalizedMessage());
        }
        return new GradeableItemDocSharingPage(uiDriver);
    }

    /**
     * Methods Help Click on Journal for Students Category Milestone 2
     * 
     * @author Raghav
     * @return
     * @throws Exception
     **/
    public GradeableItemJournalPage clickonStudentTogradeForJournal(
            String studName,
            String coursename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON JOURNAL WINDOW TO GRADE");
            frameSwitch.switchToFrameContent();
            btnclickjournal.replaceValues(studName, coursename);
            uiDriver.waitToBeDisplayed(btnclickjournal, waitTime);
            btnclickjournal.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Student To grade' BUTTON" + e
                    .getLocalizedMessage());
        }
        return new GradeableItemJournalPage(uiDriver);
    }

    /**
     * Methods Help Click onWebilography
     * 
     * @Category Milestone 2
     * @author Raghav
     * @return
     * @throws Exception
     **/
    public GradeableItemWebliographyPage clickonStudentTogradeForWebliography(
            String studName,
            String coursename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON WEBLIOGRAPHY WINDOW TO GRADE");
            frameSwitch.switchToFrameContent();
            btnclickwebliography.replaceValues(studName, coursename);
            uiDriver.waitToBeDisplayed(btnclickwebliography, waitTime);
            btnclickwebliography.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Student To grade' BUTTON" + e
                    .getLocalizedMessage());
        }
        return new GradeableItemWebliographyPage(uiDriver);
    }

    /**
     * Methods Help to Verify a grade is present
     * 
     * @Category Milestone 2
     * @author Raghav
     * @return
     * @throws Exception
     **/
    public boolean isGradeDisplayed(String gradename) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: VERFIYING THE GRADE");
            frameSwitch.switchToFrameContent();
            lblgrade.replaceValues(gradename);
            return lblgrade.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN VERFYING THE 'grade'" + "\nMETHOD:isGradeDisplayed\n" + e
                    .getLocalizedMessage());
        }

    }
}
