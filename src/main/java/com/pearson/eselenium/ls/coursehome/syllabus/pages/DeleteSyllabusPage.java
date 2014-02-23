package com.pearson.eselenium.ls.coursehome.syllabus.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the methods of the Delete Syllabus Page.
 * 
 * @author Vivek.Singh
 * @navigation On Syllabus page (in author view), against desired syllabus item, click delete image
 *             to get this page.
 * **/
public class DeleteSyllabusPage extends BasePageObject {

    /* UIElements */
    
    private UIElement btnDelete = createElement(UIType.Css, "input[value='Delete']");
    private UIElement btnCancel = createElement(UIType.Css, "input[value='Cancel']");
    private UIElement lblHeader = createElement(UIType.Css, ".tablehead");
    private UIElement msgInfo = createElement(UIType.Css, ".innercontenttable td");
    private String message;
    private boolean flag = false;

    /* Constructor */
    public DeleteSyllabusPage(UIDriver uiDriver) {
        super(uiDriver);

        logInstruction("LOG INSTRUCTION: ## DeleteSyllabusPage ##");
    }

    /**
     * This method will click Delete button.
     * 
     * @author Vivek.Singh
     * @return SyllabusHomePage
     * @throws Exception
     * **/
    public SyllabusHomePage clickDeleteButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING DELETE BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            btnDelete.click();
            logInstruction("LOG INSTRUCTION: CLICKED DELETE BUTTON.");
            return new SyllabusHomePage(uiDriver);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CLICKING ON 'Delete Button'" + "\n METHOD: clickDeleteButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will click Cancel button.
     * 
     * @author Vivek.Singh
     * @return SyllabusHomePage
     * @throws Exception
     * **/
    public SyllabusHomePage clickCancelButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING CANCEL BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.click();
            logInstruction("LOG INSTRUCTION: CLICKED CANCEL BUTTON.");
            return new SyllabusHomePage(uiDriver);
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN CLICKING ON 'Cancel Button'" + "\n METHOD: clickCancelButton \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will return the header title of Delete syllabus page.
     * 
     * @author Vivek.Singh
     * @return String - Header title
     * @throws Exception
     * **/
    public String getHeaderTitle() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING HEADER TITLE.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblHeader, waitTime);
            message = lblHeader.getText();
            logInstruction("LOG INSTRUCTION: GOT HEADER TITLE.");
            return message;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING 'Header Title'" + "\n METHOD: getHeaderTitle \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method will return info of delete syllabus page.
     * 
     * @author Vivek.Singh
     * @return String - Info
     * @throws Exception
     * **/
    public String getInfo() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: GETTING INFO FROM DELETE SYLLABUS PAGE.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(msgInfo, waitTime);
            message = msgInfo.getText();
            logInstruction("LOG INSTRUCTION: GOT INFO FROM DELETE SYLLABUS PAGE.");
            return message;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING 'Info'" + "\n METHOD: getInfo \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This function will check wheather Delete button is available at Delete syllabus Confirmation
     * Page.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isDeleteDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING DELETE BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnDelete, waitTime);
            if (btnDelete.isDisplayed())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING 'Delete Button Displayed'" + "\n METHOD: isDeleteDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This function will check wheather Cancel button is available at Delete syllabus Confirmation
     * Page.
     * 
     * @return Boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CHECKING CANCEL BUTTON.");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            if (btnCancel.isDisplayed())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "LOG INSTRUCTION: ISSUE IN GETTING 'Cancel Button Displayed'" + "\n METHOD: isCancelButtonDisplayed \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }
}
