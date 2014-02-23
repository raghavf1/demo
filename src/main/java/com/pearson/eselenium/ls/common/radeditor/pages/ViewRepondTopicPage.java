package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class ViewRepondTopicPage extends BasePageObject {

    /* Constructor */
    public ViewRepondTopicPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## View Respond Topic Page ##");
    }

    /* UIElement declarations for the View Respond Topic page */

    private UIElement lnkAddRemove = createElement(UIType.Xpath, "//a[@title='Add/Remove']");
    private UIElement frmradEditor;

    /**
     * Method helps to check RadEditorDisplayed For View Respond Topic Page
     * 
     * @return boolean
     * @author usha.reddy
     * @throws Exception
     */

    public boolean isRadEditorDisplayedForViewRespondTopicPage() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECK IF THE RAD EDITOR IS DISPLAYED FOR VIEWRESPONDTOPIC PAGE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(frmradEditor, waitTime);
            if (frmradEditor.isDisplayed())
                flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "RAD EDITOR IS NOT DISPLAYED FOR VIEWRESPONDTOPIC PAGE \n METHOD : isRadEditorDisplayedForViewRespondTopicPage" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Method helps to check for AddRemove Link
     * 
     * @author Usha
     * @return boolean
     * @throws Exception
     */
    public boolean isAddRemoveLinkDisplayed() throws Exception {
        boolean isAddRemoveLinkDisplayed = false;
        try {
            logInstruction("Check for AddRemove Link");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkAddRemove, waitTime);
            if (lnkAddRemove.isDisplayed()) {
                isAddRemoveLinkDisplayed = true;
            }

        } catch (Exception e) {

            throw new Exception("Unable to find the AddRemove Link" + e.getLocalizedMessage());
        }
        return isAddRemoveLinkDisplayed;
    }

}
