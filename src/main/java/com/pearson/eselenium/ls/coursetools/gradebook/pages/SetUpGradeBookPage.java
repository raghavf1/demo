package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This page contains all the methods for the SetUpGradeBookPage
 * 
 * @author praveen.maled
 */
public class SetUpGradeBookPage extends BasePageObject {

    /* UIElements for the SetUpGradeBookPage */
    private UIElement lnkaddNewItemsLink = createElement(UIType.LinkText, "Add New Items");
    private UIElement btnaddNewItemsToGradeBook = createElement(UIType.ID, "next1");;
    private UIElement lnkselectGradableItemsLink = createElement(
            UIType.LinkText,
            "Select Gradable Items");
    private UIElement lnkassignPointsLink = createElement(UIType.LinkText, "Assign Points/Weights");
    private UIElement lnkpreferencesLink = createElement(UIType.LinkText, "Preferences");

    /* Constructor */
    public SetUpGradeBookPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Setup Gradebook Page ##");
    }

    /**
     * method to click on AddNewItemsToGradeBook button
     * 
     * @author praveen.maled
     * @return
     * @throws Exception
     */
    public AddNewItemsPage clickAddNewItemsToGradeBookButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicked on the addnewitems");
            uiDriver.waitToBeDisplayed(btnaddNewItemsToGradeBook, waitTime);
            frameSwitch.switchToFrameContent();
            btnaddNewItemsToGradeBook.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE ADD NEW ITEMS" + "\n METHOD:clickAddNewItemsToGradeBookButton" + e
                            .getLocalizedMessage());
        }
        return new AddNewItemsPage(uiDriver);
    }

    /**
     * method to click on SelectGradableItems link
     * 
     * @author praveen.maled
     * @return
     * @throws Exception
     */
    public SelectGradableItemsPage clickSelectGradableItems() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on gradableitems");
            uiDriver.waitToBeDisplayed(lnkselectGradableItemsLink, waitTime);
            frameSwitch.switchToFrameContent();
            lnkselectGradableItemsLink.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Gradable' Items" + "\n METHOD:clickSelectGradableItemsLink" + e
                            .getLocalizedMessage());
        }
        return new SelectGradableItemsPage(uiDriver);
    }

    /**
     * method to click on AddNewItems link
     * 
     * @author praveen.maled
     * @return
     * @throws Exception
     */
    public AddNewItemsPage clickAddNewItemsLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on additems");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkaddNewItemsLink, waitTime);

            lnkaddNewItemsLink.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE ADD NEW ITEMS" + "\n METHOD:clickAddNewItemsLink" + e
                            .getLocalizedMessage());
        }
        return new AddNewItemsPage(uiDriver);

    }

    /**
     * method to click on AssignPoints link
     * 
     * @author praveen.maled
     * @return
     * @throws Exception
     */
    public AssignPointsPage clickAssignPoints() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: click on AssignPoints(");
            uiDriver.waitToBeDisplayed(lnkassignPointsLink, waitTime);
            frameSwitch.switchToFrameContent();
            lnkassignPointsLink.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Assign Points'" + "\n METHOD:clickAssignPoints\n" + e
                            .getLocalizedMessage());
        }
        return new AssignPointsPage(uiDriver);
    }

    /**
     * method to click on Preferences link
     * 
     * @author praveen.maled
     * @throws Exception
     * 
     */
    public void clickPreferencesLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicked on preference link");
            uiDriver.waitToBeDisplayed(lnkpreferencesLink, waitTime);
            frameSwitch.switchToFrameContent();
            lnkpreferencesLink.click();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Preferences'" + "\n METHOD:clickPreferencesLink\n" + e
                            .getLocalizedMessage());
        }
    }
}
