package com.pearson.eselenium.ls.coursetools.dropbox.pages;

import org.apache.commons.lang3.StringUtils;
import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.drivers.FrameLocator.FrameLocatorType;
import com.pearson.test.eselenium.framework.util.UIType;

public class SubmissionPage extends BasePageObject {

    /* elements */
    private UIElement txtHeadder = createElement(UIType.Css, ".tablehead");
    private UIElement lnkRespondoSubmitanAdditionalAssignment = createElement(
            UIType.Xpath,
            "//table[2]/tbody/tr/td/table//tr/td[2]/a[@class='subnavoff']");
    private UIElement txtAssignment = createElement(
            UIType.Xpath,
            "//table[3]//tr//td[contains(.,'{1}')]");
    private UIElement btnClose = createElement(
            UIType.Xpath,
            "//table[1]//tr/td/table//tr/td/table[4]//tr/td[2]/input[@value='Close']");
    private UIElement txtNumericGrade = createElement(
            UIType.Xpath,
            "//table[2]//tr/td/table//tr/td/table//tr[1]/td[2]");

    private String strResult = null;
    boolean flag = false;
    /* Constructor */
    public SubmissionPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Syllabus Home Page ##");
    }

    /**
     * This method will get headder for Submission Page
     * 
     * @author soundarya
     * @return String
     * @throws Exception
     * **/
    public String getHeader() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET HEADER FOR SUBMISSIONS PAGE");
            uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
            uiDriver.waitToBeDisplayed(txtHeadder, waitTime);
            strResult = txtHeadder.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER FOR SUBMISSION PAGE \n METHOD: getHeader" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }

    /**
     * This method will check is Submission Page Displayed or not
     * 
     * @author Soundarya
     * @return boolean
     * @throws Exception
     * **/
    public boolean isSubmissionPageDisplayed() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK IS SUBMISSION PAGE DISPLAYED");
            uiDriver.getUIFrameLocator().selectFrame("generalTopFrame");
            flag = txtHeadder.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CHECK SUBMISSION PAGE DISPLAYED \n METHOD: isSubmissionPageDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will click Respondo Submitan Additional Assignment
     * 
     * @author soundarya
     * @return AssigmentPage
     * @throws Exception
     * **/
    public AssignmentPage clickRespondoSubmitanAdditionalAssignment() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK RESPOND SUBMIT ADDITIONAL ASSIGNMENT");
            uiDriver.getUIFrameLocator().waitForAndSwitchToNestedFrame(
                    "generalBottomFrame",
                    FrameLocatorType.NAME);
            lnkRespondoSubmitanAdditionalAssignment.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK RESPONDO SUBMITAN ADDITIONAL ASSIGNMENT \n METHOD: clickRespondoSubmitanAdditionalAssignment" + e
                            .getLocalizedMessage());
        }
        return new AssignmentPage(uiDriver);
    }

    /**
     * This method will check assignment is displayed or not
     * 
     * @author soundarya
     * @param String
     *            - strAssginment
     * @return boolean
     * @throws Exception
     * **/
    public boolean isAssignementDisplayed(String strAssginment) throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECK ASSIGNMET IS DISPLAYED");
            if(StringUtils.isNotBlank(strAssginment)){
            uiDriver.getUIFrameLocator().waitForAndSwitchToNestedFrame(
                    "generalBottomFrame",
                    FrameLocatorType.NAME);
            txtAssignment.replaceValues(strAssginment);
                flag = txtAssignment.isDisplayedAfterWaiting(waitTime);
            }else
	            throw new Exception("ASSIGNMENT VALUE IS BLANK \n METHOD: isAssignementDisplayed");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  CHECK  ASSIGNMENT IS DISPLAYED \n METHOD: isAssignementDisplayed" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method will click on close button
     * 
     * @author soundarya
     * @return DropboxPage
     * @throws Exception
     * **/
    public DropboxPage clickCloseButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK CLOSE BUTTON");
            uiDriver.getUIFrameLocator().waitForAndSwitchToNestedFrame(
                    "generalBottomFrame",
                    FrameLocatorType.NAME);
            if (btnClose.isDisplayedAfterWaiting(waitTime))
                btnClose.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("UNABLE TO  CLICK CLOSE BUTTON \n METHOD: clickCloseButton" + e
                    .getLocalizedMessage());
        }
        return new DropboxPage(uiDriver);
    }

    /**
     * This method will get Numeric Grade
     * 
     * @author soundarya
     * @return String
     * @throws Exception
     * **/
    public String getNumericGrade() throws Exception {
        strResult = null;
        try {
            logInstruction("LOG INSTRUCTION: GET NUMERIC GRADE");
            uiDriver.getUIFrameLocator().waitForAndSwitchToNestedFrame(
                    "generalTopFrame",
                    FrameLocatorType.NAME);
            if (txtNumericGrade.isDisplayedAfterWaiting(waitTime))
                strResult = txtNumericGrade.getText();
            else
                throw new Exception("NUMERIC GRADE IS NULL \n METHOD: getNumericGrade");
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET NUMERIC GRADE \n METHOD: getNumericGrade" + e
                    .getLocalizedMessage());
        }
        return strResult;
    }
}
