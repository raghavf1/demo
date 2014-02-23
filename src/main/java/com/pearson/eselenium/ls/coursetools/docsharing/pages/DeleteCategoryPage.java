package com.pearson.eselenium.ls.coursetools.docsharing.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class DeleteCategoryPage extends BasePageObject {

    /**
     * Class has the methods to handle the page objects of Delete Category Page Follow
     * 
     * @category MileStone 2
     * @author Raghav S
     * 
     */

    /* UIElements */

    private UIElement chkiagree = createElement(UIType.ID, "isConfirmed");
    private UIElement btndeletecategory = createElement(UIType.ID, "deleteCategoryAndFilesButton");
    private UIElement btncancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement txttitle = createElement(UIType.Css, ".tablehead");
    private UIElement btndeletewothoutuploading = createElement(UIType.ID, "deleteCategoryButton");
    private UIElement lblheadertitle = createElement(UIType.Css, ".tablehead");
    private UIElement txtinstructional = createElement(UIType.Css, ".innercontenttable");

    private UIElement btndelete = createElement(UIType.Css, "#deleteCategoryButton");
    
    /*Variables*/
    
    private  String strHeaderName = null;
    
    /* Constructor */
    public DeleteCategoryPage(UIDriver uiDriver) {
        super(uiDriver);

    }

    /**
     * This method helps to click on iagree checkbox
     * 
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */

    public DeleteCategoryPage clickiAgree() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION: CLICK ON I AGREE BUTTON");
            uiDriver.waitToBeDisplayed(chkiagree, waitTime);
            chkiagree.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING 'iagree' BUTTON" + "\n METHOD:clickiAgree\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on Delete Category Button
     * 
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */

    public DocSharingPage clickOnDeleteCategoryButton() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION:CLICKING ON DELETE CATEGORY BUTTON");
            uiDriver.waitToBeDisplayed(btndeletecategory, waitTime);
            btndeletecategory.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' CATEGORY BUTTON" + "\nMETHOD:clickOnDeleteCategoryBtn\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method helps to click on Delete Category Button
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return DocSharingPage
     * @throws Exception
     * 
     */

    public DocSharingPage clickOnDeleteButton() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION:CLICKING ON DELETE  BUTTON");
            uiDriver.waitToBeDisplayed(btndelete, waitTime);
            btndelete.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete'  BUTTON" + "\nMETHOD:clickOnDeleteButton\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method helps to click on Cancel Button
     * 
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */

    public DocSharingPage clickOnCancel() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION: CLICK ON CANCEL BUTTON");
            uiDriver.waitToBeDisplayed(btncancel, waitTime);
            btncancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'cancel' BUTTON" + "\nMETHOD:clickOnCancel\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * This method helps to get the title of DeleteCategoryPage
     * 
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */
    public String getHeaderTitle() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:GETTING THE HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txttitle, waitTime);
            strHeaderName = txttitle.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN GETTING THE 'header' MESSAGE" + "\n METHOD:getHeaderTitle\n");
        }
        return strHeaderName;
    }

    /**
     * This method helps to click on Delete Button when there are no uploaded Files
     * 
     * @author Raghav S
     * @return
     * @throws Exception
     * 
     */

    public DocSharingPage clickonDeleteButtonWithoutUploading() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION: CLICK ON DELETE BUTTON");
            uiDriver.waitToBeDisplayed(btndeletewothoutuploading, waitTime);
            btndeletewothoutuploading.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING 'delete' BUTTON" + "\n METHOD:clickonDeleteButtonWithoutUploading\n" + e
                            .getLocalizedMessage());
        }
        return new DocSharingPage(uiDriver);
    }

    /**
     * Methhods determine whether table header is present or not
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     * 
     */

    public boolean isHeaderTitlePresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : VERIFYING HEADER TITLE");
            frameSwitch.switchToFrameContent();
            return lblheadertitle.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING 'Title'" + "\nMETHOD:isHeaderTitlePresent \n" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify on iagree checkbox
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     */
    public boolean isClickiAgreeCheckBoxPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY CHECKBOX");
            frameSwitch.switchToFrameContent();
            return chkiagree.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'checkbox'" + "\nMETHOD:isclickiAgreeCheckBoxPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify Instructional Text
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @throws Exception
     */
    public boolean isInstructionalTextPresent() throws Exception {

        try {
            logInstruction("LOGINSTRUCTION: VERIFY INSTRUCTIONAL TEXT");
            frameSwitch.switchToFrameContent();
            return txtinstructional.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'text'" + "\nMETHOD:isInstructionalTextPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method helps to verify on Delete Category Button
     * 
     * @author amit.deshmukh
     * @return boolean
     * @category Milestone2
     * @throws Exception
     * 
     */

    public boolean isDeleteCategoryButtonPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DELETE CATEGORY BUTTON");
            frameSwitch.switchToFrameContent();
            return btndeletecategory.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'delete' BUTTON" + "\nMETHOD:isDeleteCategoryBtnPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify on Delete Category Button
     * 
     * @author amit.deshmukh
     * @return boolean
     * @category Milestone2
     * @throws Exception
     * 
     */

    public boolean isDeleteButtonPresent() throws Exception {
        try {
            logInstruction("LOGINSTRUCTION: VERIFY DELETE  BUTTON");
            frameSwitch.switchToFrameContent();
            return btndelete.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'delete' BUTTON" + "\nMETHOD: isDeleteButtonPresent\n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method helps to verify on Cancel Button
     * 
     * @author Raghav S
     * @category Milestone2
     * @return
     * @throws Exception
     * 
     */

    public boolean isCancelButtonPresent() throws Exception {
        try {

            frameSwitch.switchToFrameContent();
            logInstruction("LOGINSTRUCTION: VERIFYING CANCEL BUTTON");
            return btncancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'cancel' BUTTON" + "\nMETHOD:isCancelBtnPresent\n" + e
                            .getLocalizedMessage());
        }
    }
}
