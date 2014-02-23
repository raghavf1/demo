package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminDeleteaGroupPage
 * 
 * @category Milestone 2
 * @author kiran kumar
 * @param uiDriver
 * 
 */
public class CourseAdminDeleteGroupPage extends BasePageObject {

    /* UI element declarations for CourseAdminGeneralandInformationPage */

    private UIElement txtHeader = createElement(
            UIType.Xpath,
            "//div[contains(text(),'Delete Group')]");
    private UIElement txtareaDetails = createElement(UIType.Xpath, "//td[@valign='top']");
    private UIElement lblCheckkBox = createElement(UIType.Xpath, "//label[@for='chk']");
    private UIElement btnDeleteGroup = createElement(
            UIType.Css,
            "input[value='Delete Group & Group Content']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement radCheckBox = createElement(UIType.Css, "#chk");
    private UIElement txtBold = createElement(UIType.Css, "span[class='redtext']");
    
    
    /*Variables*/
    private boolean flag = false;
    
    /* constructor */
    public CourseAdminDeleteGroupPage(UIDriver driver) {
        super(driver);
        logInstruction("#########CourseAdminDeleteGroupPage########");

    }

    /**
     * This method helps to get the header title
     * 
     * @category Milestone 2
     * @author kiran.kumar
     * @return string
     * @throws Exception
     */

    public String getHeaderTitle() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GETTING THE HEADER OF THE PAGE");
            frameSwitch.switchToFrameContent();
            txtHeader.isDisplayedAfterWaiting(waitTime);
            return txtHeader.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE ON GETTING THE 'header'" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());

        }
    }

    /**
     * This method helps to get the details
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return string
     * @throws Exception
     */
    public String getInstructionalDetails() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GETTING INSTRUCTIONAL TXT DETAILS OF THE PAGE");
            frameSwitch.switchToFrameContent();
            txtareaDetails.isDisplayedAfterWaiting(waitTime);
            return txtareaDetails.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING 'instuctionaldetails'" + "\n METHOD:getInstructionalDetails \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to get the details
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return string
     * @throws Exception
     */
    public String getCheckBoxInstructionalText() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GETTING INSTRUCTIONAL TXT FOR CHKBOX");
            frameSwitch.switchToFrameContent();
            return lblCheckkBox.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE details" + "\n METHOD:getChkBoxInstructionalText \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify the delete button
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isDeleteGroupButtonPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            return btnDeleteGroup.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE deletebutton" + "\n METHOD:isDeleteGroupButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify the delete button
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isCancelButtonPresent() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION:VERIFYING THE CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            return btnCancel.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING cancelbutton" + "\n METHOD:isCancelButtonPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to click in i agree chk box
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return CourseAdminDeleteGroupPage
     * @throws Exception
     */
    public CourseAdminDeleteGroupPage clickCheckBox() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:CLICK ON I AGREE CHECKBOX");
            frameSwitch.switchToFrameContent();
            radCheckBox.isDisplayedAfterWaiting(waitTime);
            if (radCheckBox.isSelected()) {
                logInstruction("is selected ");
            } else {
            	radCheckBox.clickAndWait(waitTime);
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'i agree checkbox'" + "\n METHOD:clickCheckBox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to verify i agree chk box
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckBoxSelected() throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING IS CHK BOX SELECTED");
            frameSwitch.switchToFrameContent();
           return radCheckBox.isSelected();
           

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE chkbox " + "\n METHOD:isCheckBoxSelected \n" + e
                            .getLocalizedMessage());
        }
    
    }

    /**
     * This method helps to verify i agree chk box
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return boolean
     * @throws Exception
     */
    public boolean isCheckBoxPresent() throws Exception {
       
        try {
            logInstruction("LOGINSTRUCTION:VERIFYING THE CHK BOX");
            frameSwitch.switchToFrameContent();
            radCheckBox.isDisplayedAfterWaiting();
            if (radCheckBox.isEnabled()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE chkbox " + "\n METHOD:isCheckBoxPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method helps get the including student text for check box
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return string
     * @throws Exception
     */
    public String getIncludingStudentText() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION:GETTING THE BOLD TEXT FOR CHK BOX");
            frameSwitch.switchToFrameContent();
            txtBold.isDisplayedAfterWaiting(waitTime);
            return txtBold.getText().trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE bold text" + "\n METHOD:getIncludingStudentText \n" + e
                            .getLocalizedMessage());

        }
    }

    /**
     * This method helps get the color of including student text for check box
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return string
     * @throws Exception
     */
    public String getIncludingStudentTextColor() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION : GETTING COLOR OF THE BOLD TEXT FOR CHECK BOX");
            frameSwitch.switchToFrameContent();
            txtBold.isDisplayedAfterWaiting(waitTime);
            return txtBold.getAttribute("class").trim();

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE  color bold text" + "\n METHOD:getIncludingStudentTextColor \n" + e
                            .getLocalizedMessage());

        }
    }

    /**
     * This method helps to click on cancel btn
     * 
     * @category Milestone 2
     * @author kiran .kumar
     * @return CourseAdminGroupManagementPage
     * @throws Exception
     */
    public CourseAdminGroupManagementPage clickCancelButton() throws Exception {
        try {
            logInstruction("LOGISTRUCTION : CLICKING IN CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            btnCancel.isDisplayedAfterWaiting(waitTime);
            btnCancel.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON cancel btn" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminGroupManagementPage(uiDriver);
    }

}
