package com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MicrosoftOfficeDocDeletePage extends BasePageObject {

    // UIElement Declaration
    private UIElement btnCancel = createElement(UIType.Css, ".buttontd[value='Cancel']");
    private UIElement btnDelete = createElement(UIType.Css, ".buttontd[value='Delete']");
    private UIElement chkCheckBox = createElement(UIType.Css, "#chkDeleteAgree");
    private UIElement btnDeletContent = createElement(UIType.Css, "input[name='bttnSubmit']");

    /* Constructor */

    public MicrosoftOfficeDocDeletePage(UIDriver driver) {
        super(driver);
        pageTitle = "MicrosoftOfficeDocDeletePage";
        logInstruction("LOG INSTRUCTION: ## DELETE TEXTMULTIMEDIA ITEM PAGE ##");
    }

    /**
     * This Method will delete item On the Confirmation Page
     * 
     * @category milestone 2
     * @return:NextAuthorHomePage
     * @throws Exception
     * @author Chaitali
     */
    public NextAuthorHomePage clickDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION:CLICK DELETE UNIT BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDelete.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("DELETE  BUTTON DOES NOT EXISTS");
            }
            btnDelete.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION:SUCCESSFULLY CLICKED ON DELETE BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK Delete BUTTON" + "\n METHOD:clickDeleteButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method click Cancel Button
     * 
     * @category milestone 2
     * @return: MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     * @author Chaitali
     */
    public MicrosoftOfficeDocumentToolBoxPage clickCancelButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK CANCEL BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnCancel.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("CANCEL  BUTTON DOES NOT EXISTS");
            }
            btnCancel.clickAndWait(waitTime);
            logInstruction("LOG INSTRUCTION:SUCUSSFULLY CLICKED ON CANCEL BUTTON");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK Cancel BUTTON" + "\n METHOD:clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
        return new MicrosoftOfficeDocumentToolBoxPage(uiDriver);
    }

    /**
     * This method is used to click the check box
     * 
     * @category Milestone2
     * @return: MicrosoftOfficeDocumentToolBoxPage
     * @author amit.deshmukh
     * @throws Exception
     */
    public MicrosoftOfficeDocDeletePage clickCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkCheckBox.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK CHECKBOX" + "\n METHOD: clickCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method clicks the delete button
     * 
     * @return:NextCourseHomePage
     * @throws Exception
     * @author ashish.juyal
     */
    public NextCourseHomePage clickDeleteUnitButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK THE UNIT DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDeletContent.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK UNIT DELETE" + "\n METHOD: clickDeleteUnitButton \n" + e
                    .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

}
