package com.pearson.eselenium.ls.coursetools.gradebook.pages;

import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.core.UIElements;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This class contains all the method for AssignPoints Page
 * 
 * @author Hemant.Kumar
 */
public class AssignPointsPage extends BasePageObject {

    /* UIElements of the AssignPointsPage */
    private UIElement btnclickSaveChanges = createElement(UIType.Css, "#Submit1");;
    private UIElements txtelementsthread = createElements(UIType.Xpath, "/input[@title='{1}']");
    private UIElement txtenterpoints = createElement(UIType.ID, "ids");
    private UIElement txtenterpointtoitem = createElement(
            UIType.Xpath,
            "//tr[td[h3[contains(text(),'{1}')]]]/following::tr[2]/td[1]/descendant::td[1]//input");
    private UIElement btnNextButton = createElement(UIType.Xpath, "//input[@id='next1']");

    /* Constructor */
    public AssignPointsPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## Assign Points Page ##");
    }

    /**
     * Method helps to enter the points to the student
     * 
     * @author Hemant.Kumar
     * @param threadname
     * @param percentage
     * @param point
     * @return:AssignPointsPage
     * @throws Exception
     */
    public AssignPointsPage enterPointsInTextbox(String threadname, String percentage, String point)
            throws Exception {

        try {
            uiDriver.waitToBeDisplayed(btnclickSaveChanges, waitTime);
            frameSwitch.switchToFrameContent();
            txtelementsthread.replaceValues(threadname);

            if (btnclickSaveChanges.isDisplayed()) {
                List<UIElement> elements = txtelementsthread.getUIElementsList();
                for (int i = 0; i < elements.size(); i++) {
                    String ids = elements.get(i).getAttribute("id");
                    if (ids.startsWith("wp")) {
                        txtenterpoints.clearAndSendKeys(percentage);
                    } else
                        if (ids.startsWith("ci")) {
                            txtenterpoints.clearAndSendKeys(point);
                        }
                }
            }

        } catch (Exception e) {
            throw new Exception("ISSUE IN 'Entering Points'" + "\n METHOD:enterPoints:\n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to click on the save changes button
     * 
     * @author Hemant.Kumar
     * @return:AssignPointsPage
     * @throws Exception
     */
    public AssignPointsPage clickSaveChangesButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: clicks on the save button");
            uiDriver.waitToBeDisplayed(btnclickSaveChanges, waitTime);
            btnclickSaveChanges.click();
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE 'Save Changes' BUTTON" + "\n METHOD:clickSaveChanges:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method helps to enter point
     * 
     * @author kiran kumar
     * @return:AssignPointsPage
     * @throws Exception
     */
    public AssignPointsPage enterPointToItemInTextbox(String itemName, String pointsToEnter)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: entering point");
            frameSwitch.switchToFrameContent();
            txtenterpointtoitem.replaceValues(itemName);
            uiDriver.waitToBePresent(txtenterpointtoitem, waitTime);
            txtenterpointtoitem.clearAndSendKeys(pointsToEnter);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN 'Enter Point To Item'" + "\n METHOD:enterPointtoItem:\n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method helps to click the next button
     * 
     * @author ashish.juyal
     * @return:SelectGradableItemsPage
     * @throws Exception
     */
    public SelectGradableItemsPage clickNextButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:clicking the next button");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnNextButton, waitTime);
            btnNextButton.click();
        } catch (Exception e) {
            throw new Exception("ISSUE IN CLICKING THE 'Next' BUTTON" + "clickNextButton" + e
                    .getLocalizedMessage());
        }
        return new SelectGradableItemsPage(uiDriver);
    }
    /**
     * This method help to assifgn points
     * @category Service level method
     * @author kiran.kumar
     * @return:SelectGradableItemsPage
     * @throws Exception
     */
    public AssignPointsPage assignPoint(String itemName,int points) throws Exception{
    	try {
    		logInstruction("LOGINSTRUCTION:ASSIGNING POINTS FOR ITEM");
			frameSwitch.switchToFrameContent();
			txtenterpointtoitem.replaceValues(itemName);
			String points1=Integer.toString(points);
			txtenterpointtoitem.clearAndSendKeys(points1);
			btnclickSaveChanges.clickNoWait();
			uiDriver.getUIAlert().acceptAlertIfPresent();
			
		} catch (Exception e) {
			throw new Exception("ISSUE IN ASSIGNING THE POINTS"+"\n Method:assignPoint \n"+e.getLocalizedMessage());
		}
    	return this;
    }
    
    
    
}
