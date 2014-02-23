package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EquellaLinkWizardInsertPage extends BasePageObject {

    public EquellaLinkWizardInsertPage(UIDriver driver) {
        super(driver);
    }
    
    private boolean flag = false;

    private UIElement isEquella = createElement(UIType.Css, ".tablehead");

    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public boolean isEquellContentPage() throws Exception {
        flag = false;
        try {
            logInstruction("LOG INSTRUCTION : CHECKING FOR EQUELLA CONTENT PAGE ");
            uiDriver.getUIWindowLocator().switchToNewWindow();
            uiDriver.getUIFrameLocator().selectFrame("popupcontent");
            uiDriver.waitToBeDisplayed(isEquella, waitTime);
            String data = isEquella.getText().trim();
            if (data.contains("Add Content from Equella"))
                flag = true;
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE TEXT OF HEADER \n METHOD :isEquellContentPage");
        }
        return flag;
    }

}