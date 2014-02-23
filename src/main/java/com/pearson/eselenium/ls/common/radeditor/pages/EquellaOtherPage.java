package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class EquellaOtherPage extends BasePageObject {

    /* Constructor */
    public EquellaOtherPage(UIDriver uiDriver) {
        super(uiDriver);

        logInstruction("LOG INSTRUCTION: ## View Unit Pages ##");
    }

    /* elements */
    private UIElement btnSelect = createElement(UIType.Css, ".button.itemresult-action.add");
    private UIElement txtHeadder = createElement(
            UIType.Xpath,
            "//div[@class='area browse-topics']/h2[contains(.,'Other')]");

    /* UIElements for the EquellaOtherPage */

    /**
     * Method helps to click get Header Title
     * 
     * @author soundarya
     * @return String
     */
    public String getHeaderTitle() throws Exception {
        logInstruction("LOG INSTRUCTION: GET HEADER TITLE");
        String headder;
        try {
            uiDriver.waitToBeDisplayed(txtHeadder, waitTime);
            headder = txtHeadder.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET HEADER TITLe \n METHOD :getHeaderTitle" + e
                    .getLocalizedMessage());
        }
        return headder;
    }

    /**
     * Method helps to click Select button
     * 
     * 
     * @author soundarya
     * @return MySelectionPage
     */
    public MySelectionPage clickSelect() throws Exception {
        logInstruction("LOG INSTRUCTION:CLICK SELECT BUTON");
        try {
            uiDriver.switchTo().frame("popupcontent");
            uiDriver.waitToBeDisplayed(btnSelect, waitTime);
            btnSelect.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK SELECT BUTTON \n METHOD :clickSelect" + e
                    .getLocalizedMessage());
        }
        return new MySelectionPage(uiDriver);
    }
}