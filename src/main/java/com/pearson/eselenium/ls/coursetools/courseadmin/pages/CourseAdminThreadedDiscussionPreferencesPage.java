/**
 * 
 */
package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminThreadedDiscussionPreferencesPage
 * 
 * @author Raghav
 * @param uiDriver
 * 
 */

public class CourseAdminThreadedDiscussionPreferencesPage extends BasePageObject {

    /* UI element declarations for CourseAdminThreadedDiscussionPreferencesPage */
    private UIElement chkthreadpreview = createElement(UIType.Css, "#isThreadTextPreviewEnabled");
    private UIElement chkstudenteditable = createElement(
            UIType.ID,
            "isUserEditableResponsesEnabled");
    private UIElement chkreadonly = createElement(UIType.ID, "isReadOnlyAfterScheduledDates");
    private UIElement chksubjectline = createElement(UIType.ID, "areSubjectLinesEditable");
    private UIElement btnsavechanges = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save Changes')]");
    private UIElement txtgettitle = createElement(UIType.Css, ".tablehead");
    private UIElement lblsettopic = createElement(
            UIType.Css,
            "label[for='isReadOnlyAfterScheduledDates']");
    private UIElement lblallowstudents = createElement(
            UIType.Css,
            "label[for='isUserEditableResponsesEnabled']");
    private UIElement lbldisplaypreview = createElement(
            UIType.Css,
            "label[for='isThreadTextPreviewEnabled']");
    private UIElement lblsubject = createElement(UIType.Css, "label[for='areSubjectLinesEditable']");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    /*variables*/
    private String strPagetitle = null;
    private String strTopicLblTxt = null;
    private String strLabelText = null;
    private boolean flag = false;
    private boolean flagOne=false;
    private boolean flagTwo=false;
    private boolean flagThree=false;
    /* constructor */
    public CourseAdminThreadedDiscussionPreferencesPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION:## CourseAdminThreadedDiscussionsPage ##");

    }

    /**
     * This method clicks on threadpreview checkbox
     * 
     * @author Raghav S
     * @return CourseAdminThreadedDiscussionPreferencesPage
     * @throws Exception
     */

    public CourseAdminThreadedDiscussionPreferencesPage selectThreadPreview() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON THREAD PREVIEW CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkthreadpreview, waitTime);
            if (chkstudenteditable.isSelected() == false) {
                chkstudenteditable.clickAndWait(waitTime);
            } else {
                logInstruction("LOG INSTRUCTION:ALREADY CHECKED");

            }

            logInstruction("LOG INSTRUCTION:THREAD PREVIEW CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'Thread Preview CheckBox'" + "\n METHOD:selectThreadPreview \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks on Allows students to edit the thread checkbox
     * 
     * @author Raghav S
     * @return CourseAdminThreadedDiscussionPreferencesPage
     * @throws Exception
     */

    public CourseAdminThreadedDiscussionPreferencesPage selectStudentEditable() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON USER EDITABLE CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkstudenteditable, waitTime);
            if (chkstudenteditable.isSelected() == true) {
                logInstruction("LOG INSTRUCTION:ITS ALREADY CHECKED");
            } else {
                chkstudenteditable.clickAndWait(waitTime);

            }

            logInstruction("LOG INSTRUCTION:USER EDITABLE CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'editable CheckBox'" + "\n METHOD:selectStudentEditable \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks on readonly checkbox
     * 
     * @author Raghav S
     * @return CourseAdminThreadedDiscussionPreferencesPage
     * @throws Exception
     */

    public CourseAdminThreadedDiscussionPreferencesPage selectReadOnly() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON READONLY CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkreadonly, waitTime);
            if (chkreadonly.isSelected() == true) {
                logInstruction("LOG INSTRUCTION:ALREADY SELECTED");
            } else {
                chkreadonly.clickAndWait(waitTime);
            }
            logInstruction("LOG INSTRUCTION:READONLY CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'selectreadonly checkbox'" + "\n METHOD:selectReadOnly \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks on readonly checkbox
     * 
     * @author Raghav S
     * @return CourseAdminThreadedDiscussionPreferencesPage
     * @throws Exception
     */

    public CourseAdminThreadedDiscussionPreferencesPage selectSubjectLine() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON SUBJECTLINE CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chksubjectline, waitTime);
            if (chksubjectline.isSelected() == true) {
                logInstruction("LOG INSTRUCTION:ALREADY SELECTED");

            } else {
                chksubjectline.clickAndWait(waitTime);
            }
            logInstruction("LOG INSTRUCTION:SUBJECTLINE CHECKBOX IS SELECTED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'subjectline checkbox'" + "\n METHOD:selectSubjectLine \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method clicks on save button
     * 
     * @author Raghav S
     * @return CourseAdminPage
     * @throws Exception
     */

    public CourseAdminPage clickSave() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON SAVE BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
            btnsavechanges.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION:SAVEBUTTON IS CLICKED");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'savebutton'" + "\n METHOD:clickSave \n" + e
                            .getLocalizedMessage());
        }

        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method helps to get the title of CourseAdminGroupManagementNewGroupPage
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getTitle() throws Exception {
       
        try {
            frameSwitch.switchToFrameContent();
            logInstruction("LOG INSTRUCTION:VERIFY THREADED DISCUSSION PAGE TITLE");
            uiDriver.waitToBeDisplayed(txtgettitle, waitTime);
            strPagetitle = txtgettitle.getText().trim();

        } catch (Exception e) {

            throw new Exception(
                    "ISSUE IN GETTING THE 'Threaded Discussion page Title'" + "\n METHOD:getTitle \n" + e
                            .getLocalizedMessage());
        }
        return strPagetitle;
    }

    /**
     * This Method is used Get the is settopic Label Text
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getTopiclabelTxt() throws Exception {
         strTopicLblTxt = null;
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TEXT OF  SET TOPIC  TEXT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblsettopic, waitTime);
            strTopicLblTxt = lblsettopic.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE ' Set Topic Text'" + "\n METHOD:getTopiclblTxt \n" + e
                            .getLocalizedMessage());
        }
        return strTopicLblTxt;
    }

    /**
     * This Method is used get Allow Students Editable Label Text
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getallowStudentsEditablelabelTxt() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TEXT OF ALLOW STUDENTS EDITABLE ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblallowstudents, waitTime);
            strTopicLblTxt = lblallowstudents.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  'Students Editable Text'" + "\n METHOD:getallowStudentsEditablelblTxt \n" + e
                            .getLocalizedMessage());
        }
        return strTopicLblTxt;
    }

    /**
     * This Method is used to get thread Preview label Text
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getDisplayThreadPreviewlabelTxt() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TEXT OF THREAD PREVIEW LABEL TEXT ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lbldisplaypreview, waitTime);
            strLabelText = lbldisplaypreview.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'Thread Preview Label Text'" + "\n METHOD:getDisplayThreadPreviewlblTxt \n" + e
                            .getLocalizedMessage());
        }
        return strLabelText;
    }

    /**
     * This Method is used get the subject line label text
     * 
     * @category Milestone 2
     * @author Raghav
     * @return String
     * @throws Exception
     */

    public String getSubjectLine() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE TEXT OF SUBJECTLINE LABEL TEXT ");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblsubject, waitTime);
            strLabelText = lblsubject.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'SubjectLine Label Text'" + "\n METHOD:getSubjectLine \n" + e
                            .getLocalizedMessage());
        }
        return strLabelText;
    }

    /**
     * This method clicks on Cancel button
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return CourseAdminPage
     * @throws Exception
     */
    public CourseAdminPage clickCancel() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION:Cancel Btn is clicked");
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'Cancel Button'" + "\n METHOD:clickCancel \n" + e
                            .getLocalizedMessage());
        }

        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method Verifies Save Button is Present
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */
    public boolean isSaveButtonDisplayed() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES SAVE BUTTON IS PRESENT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
            if (btnsavechanges.isDisplayedAfterWaiting(waitTime))
            	flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE'Save Button'" + "\n METHOD:isSavebtnDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method Verifies Save Button is Present
     * 
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES CANCEL BUTTON IS PRESENT");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            if (btncancel.isDisplayedAfterWaiting(waitTime))
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Cancel Button'" + "\n METHOD:isCancelbtnDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }
    
    /**
     * This method To Check the Check Boxes in Thread Discussion Page adn Click On Save Changes
     * @ServiceLevelMethods
     * @category Milestone 2
     * @author Raghav S
     * @return boolean
     * @throws Exception
     */
    public CourseAdminPage selectThreaddiscussionPreferencesandClickSaveChanges(boolean settopics,boolean allowstudents,boolean displaythreaded,boolean subjectline) throws Exception {
       
       
        try {
            logInstruction("LOG INSTRUCTION:METHOD HELPS TO VERIFY TO CLICK ON CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkreadonly, waitTime);
            flag=chkreadonly.isSelected();
            uiDriver.waitToBeDisplayed(chkstudenteditable, waitTime);
            flagOne=chkstudenteditable.isSelected();
            uiDriver.waitToBeDisplayed(chkthreadpreview, waitTime);
            flagTwo=chkthreadpreview.isSelected();
            uiDriver.waitToBeDisplayed(chksubjectline, waitTime);
            flagThree=chksubjectline.isSelected();
            if(settopics && !flag)
            {
            	uiDriver.waitToBeDisplayed(lblsettopic, waitTime);
            	lblsettopic.clickAndWait(waitTime);
            }else{
            	logInstruction("LOG INSTRUCTION:ALREADY CHECKBOX IS SELECTED");
            }
            if(allowstudents && !flagOne)
            {
            	uiDriver.waitToBeDisplayed(lblallowstudents, waitTime);
            	lblallowstudents.clickAndWait(waitTime);
            }else{
            	logInstruction("LOG INSTRUCTION:ALREADY CHECKBOX IS SELECTED");
            }
            if(displaythreaded && !flagTwo)
            {
            	uiDriver.waitToBeDisplayed(lbldisplaypreview, waitTime);
            	lbldisplaypreview.clickAndWait(waitTime);
            }else{
            	logInstruction("LOG INSTRUCTION:ALREADY CHECKBOX IS SELECTED");
            }
            if(subjectline && !flagThree)
            {
            	uiDriver.waitToBeDisplayed(lblsubject, waitTime);
            	lblsubject.clickAndWait(waitTime);
            }else{
                    	logInstruction("LOG INSTRUCTION:ALREADY CHECKBOX IS SELECTED");
                 }
            uiDriver.waitToBeDisplayed(btnsavechanges, waitTime);
            btnsavechanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Cancel Button'" + "\n METHOD:isCancelbtnDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return new CourseAdminPage(uiDriver);
    }

}
