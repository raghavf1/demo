package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import java.util.List;

import org.openqa.selenium.Alert;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the SelectGradableItemsPage
 * 
 * @author praveen.maled
 */
public class SelectGradableItemsPage extends BasePageObject {

    /* UIElements for the SelectGradableItemsPage */
    private UIElement btnsavechanges = createElement(UIType.Css, "#save1");
    private UIElement btnnext = createElement(UIType.Css, "#next1");
    private UIElements lstcheckboxlist = createElements(UIType.Css, "input[title*='{1}']");
    private UIElement chkgradeableitems = createElement(
            UIType.Xpath,
            "//tr[td[h3[contains(text(),'{1}')]]]/following-sibling::tr[2]/td/div/input");

    /* Constructor */
    public SelectGradableItemsPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Select Gradable Items Page ##");
    }

    /**
     * If check box is not checked for the thread, we are clicking on the check box
     * 
     * @author praveen.maled
     * @param threadName
     * @return
     * @throws Exception
     */
    public SelectGradableItemsPage checkThread(String threadName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: unable to select the gradableItems");
            uiDriver.waitToBeDisplayed(btnnext, waitTime);
            frameSwitch.switchToFrameContent();
            frameSwitch.switchToFrameContent();
            lstcheckboxlist.replaceValues(threadName);
            List<UIElement> threadCheckBox = lstcheckboxlist.getUIElementsList();
            for (UIElement checkbox : threadCheckBox) {
                String ischecked = checkbox.getAttribute("checked");
                if (ischecked == null) {
                    checkbox.click();

                }

            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE CHECK THREAD" + "\n METHOD:checkThread:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will verify the check box is clicked or not
     * 
     * @author praveen.maled
     * @param threadName
     * @return
     * @throws Exception
     */
    public boolean verifyCheckbox(String threadName) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: unable to select the gradableItems");
            uiDriver.waitToBeDisplayed(btnnext, waitTime);
            frameSwitch.switchToFrameContent();

            frameSwitch.switchToFrameContent();
            lstcheckboxlist.replaceValues(threadName);
            List<UIElement> threadCheckBox = lstcheckboxlist.getUIElementsList();
            for (UIElement checkbox : threadCheckBox) {
                String ischecked = checkbox.getAttribute("checked");
                return ischecked != null ? true : false;
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CHECKING THE CHECKBOX" + "\n METHOD:verifyCheckbox :\n" + e
                            .getLocalizedMessage());
        }
        return false;
    }

    /**
     * Method helps to uncheck the thread selected
     * 
     * @param threadName
     * @return
     * @throws Exception
     */
    public SelectGradableItemsPage uncheckThread(String threadName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Uncheck the thread");
            uiDriver.waitToBeDisplayed(btnnext, waitTime);
            frameSwitch.switchToFrameContent();
            lstcheckboxlist.replaceValues(threadName);
            List<UIElement> threadCheckBox = lstcheckboxlist.getUIElementsList();
            for (UIElement checkbox : threadCheckBox) {
                String ischecked = checkbox.getAttribute("checked");
                if (ischecked != null) {
                    checkbox.click();

                }

            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN UNCHECKING THE CHECKBOX" + "\n METHOD:uncheckThread:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * method will click on the save changes button and accept the alert
     * 
     * @author Praveen.Maled
     * @throws Exception
     */
    public SelectGradableItemsPage clickSaveChanges() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON SAVE CHANGES BUTTON");
            frameSwitch.switchToFrameContent();
            btnsavechanges.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE SAVE BUTTON" + "\n METHOD:clickSaveChangesButton\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click on the next button
     * 
     * @author Praveen.Maled
     * @return:AssignPointsPage
     * @throws Exception
     */
    public AssignPointsPage clickNextButton() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: click on nextButton");
            frameSwitch.switchToFrameContent();
            btnnext.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE NEXT BUTTON" + "\n METHOD:clickNextButton\n" + e
                            .getLocalizedMessage());
        }
        return new AssignPointsPage(uiDriver);
    }

    /**
     * This method helps to clicks on the thread Category Milestone 2
     * 
     * @author Raghav
     * @param threadName
     * @return
     * @throws Exception
     */
    public SelectGradableItemsPage checkGradeableCheckBox(String gradeableitemname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THE GRADEABLE CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkgradeableitems.replaceValues(gradeableitemname);
            uiDriver.waitToBeDisplayed(chkgradeableitems, waitTime);
            boolean status = chkgradeableitems.isSelected();
            if (status == true) {
                logInstruction("LOG INSTRUCTION:CHECKBOX IS ALREADY CHECKED");
            } else {
                chkgradeableitems.click();
            }

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE CHECK THREAD" + "\n METHOD:checkGradeableCheckBox:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

}
