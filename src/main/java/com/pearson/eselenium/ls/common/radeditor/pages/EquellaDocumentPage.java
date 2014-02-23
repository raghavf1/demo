package com.pearson.eselenium.ls.common.radeditor.pages;

import java.util.ArrayList;
import java.util.List;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains methods related to EquellaDocumentPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class EquellaDocumentPage extends BasePageObject {

    /* Constructor */
    public EquellaDocumentPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION : ### EquellaDocumentPage ###");
    }

    /* UIElement declarations for EquellaDocumentPage */
    private UIElement btnSelect = createElement(
            UIType.Xpath,
            "//div[@class='itemlist']//div[//div[h3//a[@title='{1}']]]//div[//div[input]]");

    /**
     * Method helps to switch the window
     * 
     * @author Pratush.Manglik
     * @throws Exception
     */
    public void switchToWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : SWITCHING THE WINDOW TO LINKCOURSE TOOL PAGE");
            List<String> windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            uiDriver.switchTo().window(windows.get(1));
        } catch (Exception e) {
            throw new Exception("Unable to switch the window \n METHOD :switchToWindow" + e.getLocalizedMessage());
        }

    }

    /**
     * This method is used to click on Select button
     * 
     * @author Pratush.Manglik
     * @param docName
     * @return EquellaSelectionPage
     * @throws Exception
     */
    public EquellaSelectionPage clickSelectButton(String docName) throws Exception {
        logInstruction("LOG INSTRUCTION :  CLICK ON SELECT BUTTON");
        try {
            frameSwitch.switchToAddLinkFrame();
            btnSelect.replaceValues(docName); // EQUELLA 5 Documentation
            uiDriver.waitToBeDisplayed(btnSelect, waitTime);
            btnSelect.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO CLICK ON SELECT BUTTON \n METHOD :clickSelectButton" + e
                            .getLocalizedMessage());
        }
        return new EquellaSelectionPage(uiDriver);
    }

}
