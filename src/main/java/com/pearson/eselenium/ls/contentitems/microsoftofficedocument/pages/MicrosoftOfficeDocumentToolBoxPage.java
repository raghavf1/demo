package com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MicrosoftOfficeDocumentToolBoxPage extends BasePageObject {

    public MicrosoftOfficeDocumentToolBoxPage(UIDriver driver) {
        super(driver);
        pageTitle = "MicrosoftOfficeDocumentToolBoxPage";
        logInstruction("LOG INSTRUCTION: ## MicrosoftOfficeDocToolboxPage ##");
    }

    private UIElement lblEditSchedule = createElement(
            UIType.Xpath,
            "//td[@width='35%']/following-sibling::td");
    private UIElement lnkEditSchedule = createElement(
            UIType.Xpath,
            "//a[contains(.,'Edit Schedule')]");
    private UIElement lnkDelete = createElement(UIType.Xpath, "//a[contains(.,'Delete')]");
    private UIElement txtTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement imgMoveContent = createElement(UIType.Css, ".toolboxitem>a>img[src*='move']");
    private UIElement btnCancel = createElement(
            UIType.Xpath,
            "//form/table[1]//tbody/tr[4]/td/input[2]");
    private UIElement txtHeaderTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement btnDeleteDoc = createElement(UIType.Xpath, "//a[contains(.,'Delete')]");
    private UIElement btnDeleteButton = createElement(UIType.Css, ".buttontd[value='Delete']");
    private UIElement chkCancel = createElement(
            UIType.Xpath,
            "//form/table[1]//tbody/tr[4]/td/input[2]");
    private UIElement btnDeletContent;
    String pageTitle = null;
    String strErrorMessage = null;

    /**
     * @category Milestone 2 Method is used to click on Edit Schedule link
     * @author Pratush.Manglik
     * @return MicrosoftOfficeDocEditSchedulePage
     * @throws Exception
     */
    public MicrosoftOfficeDocEditSchedulePage clickEditScheduleLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :CLICK EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkEditSchedule, waitTime);
            lnkEditSchedule.clickAndWait(waitTime);
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK EDIT SCHEDULE LINK" + "\n METHOD:clickEditScheduleLink \n" + e
                            .getLocalizedMessage());

        }
        return new MicrosoftOfficeDocEditSchedulePage(uiDriver);
    }

    /**
     * @category Milestone 2 Method is used to get message adjacent to Edit Schedule Link
     * @author Pratush.Manglik
     * @return String
     * @throws Exception
     */
    public String getMessageDisplayedNextToEditSchedule() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblEditSchedule, waitTime);
            strErrorMessage = lblEditSchedule.getText().trim();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO GET MESSAGE ADJACENT TO EDIT SCHEDULE LINK" + "\n METHOD:getMessageDisplayedNextToEditSchedule \n" + e
                            .getLocalizedMessage());

        }
        return strErrorMessage;
    }

    /**
     * @category Milestone 2 Method is used to click on delete link
     * @author Pratush.Manglik
     * @return MicrosoftOfficeDocDeletePage
     * @throws Exception
     */
    public MicrosoftOfficeDocDeletePage clickDeleteLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :CLICK DELETE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkDelete, waitTime);
            lnkDelete.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON DELETE LINK" + "\n METHOD:clickDeleteLink \n" + e
                            .getLocalizedMessage());

        }
        return new MicrosoftOfficeDocDeletePage(uiDriver);
    }

    /**
     * Methods helps to get header title
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getPageTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            pageTitle = txtTitle.getText().trim();
            return pageTitle;
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE" + "\n METHOD:getPageTitle \n" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * method will click on move link image
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     */
    public MicrosoftOfficeDocumentToolBoxPage clickOnMove() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON MOVE LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(imgMoveContent);
            imgMoveContent.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON  MOVE LINK" + "\n METHOD:clickOnMove \n" + e
                    .getLocalizedMessage());

        }
        return this;
    }

    /**
     * Methods Helps To Click On Cancel
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     */

    public MicrosoftOfficeDocumentToolBoxPage clickCancel() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON CANCEL");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(btnCancel, waitTime);
            btnCancel.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON  CANCEL" + "\n METHOD:clickCancel \n" + e
                    .getLocalizedMessage());

        }
        return this;
    }

    /**
     * Methods helps to get header title
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getHeaderTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET HEADER TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtHeaderTitle, waitTime);
            pageTitle = txtHeaderTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLE" + "\n METHOD:getHeaderTitle \n" + e
                    .getLocalizedMessage());

        }
        return pageTitle;
    }

    /**
     * Methods Helps To Click On Delete Doc Link
     * 
     * @author amit.deshmukh
     * @category Milestone2
     * @return MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     */

    public MicrosoftOfficeDocumentToolBoxPage clickDeleteDocument() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : CLICK DELETE DOC LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBePresent(btnDeleteDoc, waitTime);
            btnDeleteDoc.clickNoWait();
            uiDriver.getUIAlert().acceptAlertIfPresent();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK DELETE DOC LINK" + "\n METHOD: clickDeleteDocument \n" + e
                            .getLocalizedMessage());

        }
        return this;
    }

    /**
     * This Method will delete item On the Confirmation Page
     * 
     * @category Milestone2
     * @return:NextAuthorHomePage
     * @throws Exception
     * @author amit.deshmukh
     */
    public NextAuthorHomePage clickDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK DELETE  BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDeleteButton.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("DELETE  BUTTON DOES NOT EXISTS!!! EXITING THE METHOD");
            }
            btnDeleteButton.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK DELETE  BUTTON" + "\n METHOD:clickDeleteButton \n" + e
                            .getLocalizedMessage());

        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * This method is used to click the check box
     * 
     * @category Milestone2
     * @return:MicrosoftOfficeDocumentToolBoxPage
     * @author amit.deshmukh
     * @throws Exception
     */
    public MicrosoftOfficeDocumentToolBoxPage clickCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkCancel.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK CHECKBOX" + "\n METHOD:clickCheckBox \n" + e
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
            logInstruction("LOG INSTRUCTION: CLICKS THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDeletContent.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK DELETE UNIT BUTTON" + "\n METHOD:clickDeleteUnitButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

}
