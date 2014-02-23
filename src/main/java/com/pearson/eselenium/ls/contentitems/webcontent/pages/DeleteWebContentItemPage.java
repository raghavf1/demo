package com.pearson.eselenium.ls.contentitems.webcontent.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.eselenium.ls.course.pages.NextAuthorHomePage;
import com.pearson.eselenium.ls.course.pages.NextCourseHomePage;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the DeleteWebContentItem Page
 * 
 * @author Chaitali
 * @Team Beta
 * @Navigation From click on web content item on navigation tree then on ToolBox button then on
 *             delete button
 * 
 */
public class DeleteWebContentItemPage extends BasePageObject {

    /* UIElements of the page */
    private UIElement btnDeleteButton = createElement(UIType.Css, ".buttontd[value='Delete']");
    private UIElement txtTitle = createElement(UIType.Css, ".tablehead");
    private UIElement txtPageTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement chkCancel = createElement(UIType.Css, "#chkDeleteAgree");
    private UIElement btnDeleteContent = createElement(UIType.Css, "input[name='bttnSubmit']");

    String title;

    String strTableTitle = null;

    /* Constructor */
    public DeleteWebContentItemPage(UIDriver driver) {
        super(driver);
        pageTitle = "DeleteWebContentItemPage";
        logInstruction("LOG INSTRUCTION: ## DELETE TEXT MULTIMEDIA ITEM PAGE ##");
    }

    /**
     * This Method will delete item On the Confirmation Page
     * 
     * @return:NextAuthorHomePage
     * @throws Exception
     * @author Chaitali
     */
    public NextAuthorHomePage clickDeleteButton() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: CLICK DELETE UNIT BUTTON");
            frameSwitch.switchToFrameContent();
            if (!btnDeleteButton.isDisplayedAfterWaiting(waitTime)) {
                throw new Exception("DELETE  BUTTON DOES NOT EXISTS!!! EXITING THE METHOD");
            }
            btnDeleteButton.clickNoWait();
            logInstruction("LOG INSTRUCTION: SUCCESSFULLY CLICK ON DELETE");
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION:UNABLE TO CLICK delete  BUTTON" + "\n METHOD:clickDeleteButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextAuthorHomePage(uiDriver);
    }

    /**
     * Methods helps to get Screen title i.e Delete Item:
     * 
     * @category Milestone2
     * @author amit.deshmukh
     * @return String
     * @throws Exception
     */

    public String getScreenTitle() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION : GET PAGE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(txtTitle, waitTime);
            strTableTitle = txtTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE" + "\nMETHOD:getScreenTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * Methods helps to get page title
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
            uiDriver.waitToBeDisplayed(txtPageTitle, waitTime);
            strTableTitle = txtPageTitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE" + "\nMETHOD: getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTableTitle;
    }

    /**
     * This method is used to click the checkbox
     * 
     * @category Milestone2
     * @return:DeleteWebContentItemPage
     * @author amit.deshmukh
     * @throws Exception
     */
    public DeleteWebContentItemPage clickCheckBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE CHECKBOX" + "\n METHOD:clickCheckBox \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * this method clicks the delete unit button
     * 
     * @category Milestone2
     * @return:NextCourseHomePage
     * @throws Exception
     * @author amit.deshmukh
     */
    public NextCourseHomePage clickDeleteUnitButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKS THE DELETE BUTTON");
            frameSwitch.switchToFrameContent();
            btnDeleteContent.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK THE DELETE BUTTON" + "\n METHOD: clickDeleteUnitButton \n" + e
                            .getLocalizedMessage());
        }
        return new NextCourseHomePage(uiDriver);
    }

}
