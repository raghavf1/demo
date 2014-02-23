package com.pearson.eselenium.ls.contentitems.microsoftofficedocument.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MicrosoftOfficeDocumentHomePage extends BasePageObject {

    /**
     * UIElements Declaration
     */

    private UIElement txtTitle = createElement(UIType.Css, ".pageTitle");
    private UIElement mnuToolBox = createElement(UIType.LinkText, "Toolbox");
    String pageTitle = null;
    boolean flag = false;

    /* Constructor */
    public MicrosoftOfficeDocumentHomePage(UIDriver uiDriver) {
        super(uiDriver);
        pageTitle = "MicrosoftOfficeDocumentHomePage";
        logInstruction("LOG INSTRUCTION: ## Microsoft Office Doc HomePage ##");
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

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET PAGE TITLE" + "\n METHOD:getPageTitle \n" + e
                    .getLocalizedMessage());
        }
        return pageTitle;

    }

    /**
     * @author Method helps to click on the ToolBox tab
     * @category Milestone2
     * @author amit.deshmukh
     * @return MicrosoftOfficeDocumentToolBoxPage
     * @throws Exception
     */
    public MicrosoftOfficeDocumentToolBoxPage selectToolBox() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SELECTING TOOLBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(mnuToolBox, waitTime);
            mnuToolBox.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO SELECT TOOLBOX" + "\n METHOD:selectToolBox \n" + e
                    .getLocalizedMessage());
        }

        return new MicrosoftOfficeDocumentToolBoxPage(uiDriver);
    }

    /**
     * @author Method helps to determine whether ToolBox tab is present
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isToolBoxPresent() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION:VERIFYING TOOLBOX ");
            frameSwitch.switchToFrameContent();
            flag = mnuToolBox.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO VERIFY TOOLBOX" + "\n METHOD:isToolBoxPresent \n" + e
                    .getLocalizedMessage());
        }
        return flag;
    }

}
