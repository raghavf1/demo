package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class RADContentPage extends BasePageObject {

    /* Constructor */
    public RADContentPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## RADContentPage ##");
    }

    /* Elements */
    private UIElement areaenterContent = createElement(UIType.Xpath, "//html/body");

    /**
     * This method is used to enter content in RAD Editor
     * 
     * @author Suchi.Singh
     * @param String
     *            Content
     * @return RADContentPage
     * @throws Exception
     * 
     */
    public RADContentPage enterContentIntoRADEditor(String Content) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : ENTERING CONTENT IN RAD EDITOR ");
            frameSwitch.switchToRadeCourseTextcontentIframe();
            uiDriver.waitToBeDisplayed(areaenterContent, waitTime);
            areaenterContent.clearAndSendKeys(Content);
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  ENTER CONTENT IN RAD EDITOR \n METHOD : enterContentIntoRADEditor" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to get content of RAD Editor
     * 
     * @author Suchi.Singh
     * 
     * @return String
     * @throws Exception
     * 
     */
    public String getContentOfRADEditor() throws Exception {
        String Content = null;
        try {
            logInstruction("LOG INSTRUCTION : ENTERING CONTENT IN RAD EDITOR ");
            frameSwitch.switchToRadeCourseTextcontentIframe();
            uiDriver.waitToBeDisplayed(areaenterContent, waitTime);
            Content = areaenterContent.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO  ENTER CONTENT IN RAD EDITOR \n METHOD :getContentOfRADEditor " + e
                            .getLocalizedMessage());
        }
        return Content;
    }

}
