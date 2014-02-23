package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MathEquationPage extends BasePageObject {

    /* Elements */
    private UIElement createnewButton = createElement(UIType.Css, ".buttontd");
    private UIElement header = createElement(UIType.Xpath, "//tr/td[@class=\"tablehead\"]");;
    private UIElement expandall = createElement(UIType.Xpath, "//a[@id=\"row0\"]");;

    /* Constructor */
    public MathEquationPage(UIDriver uidriver) {
        super(uidriver);
        logInstruction("LOG INSTRUCTION: ## MathEquationPage ##");
    }

    /**
     * This method helps to click the create new button
     * 
     * @author ashish.juyal
     * @return CreateEquationPage
     * @throws Exception
     */
    public CreateEquationPage clickCreateNewEquationButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING THE CREATE NEW EQUATION BUTTON");
            uiDriver.waitToBeDisplayed(createnewButton, waitTime);
            createnewButton.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK THE CREATE NEW BUTTON" + e.getLocalizedMessage());
        }
        return new CreateEquationPage(uiDriver);
    }

    /**
     * This method helps to get the header
     * 
     * @author ashish.juyal
     * @return String
     * @throws Exception
     */
    public String getHeader() throws Exception {
        String headertext = null;
        try {
            frameSwitch.switchToPopUpContent();
            uiDriver.waitToBeDisplayed(header, waitTime);
            headertext = header.getText();
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + e.getLocalizedMessage());
        }
        return headertext;
    }

    /**
     * This method checks whether the Math Equation Page is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isMathEquationPageDisplayed() throws Exception {
        boolean flag = false;
        String headertext = null;
        try {
            frameSwitch.switchToPopUpContent();
            uiDriver.waitToBeDisplayed(header, waitTime);
            headertext = header.getText();
            if (headertext.contains("Math Equations")) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO GET THE HEADER" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks whether the createnew button is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isCreateNewButtonDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE CREATE NEW BUTTON");
            frameSwitch.switchToPopUpContent();
            uiDriver.waitToBeDisplayed(createnewButton, waitTime);
            flag = createnewButton.isDisplayed();
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND THE CREATE NEW BUTTON" + e.getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method checks for the Expand All link is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */

    public boolean isExpandAllDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE EXPAND ALL ICON");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(expandall, waitTime);
            flag = expandall.isDisplayed();
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND THE EXPAND ALL" + e.getLocalizedMessage());
        }
        return flag;
    }
}
