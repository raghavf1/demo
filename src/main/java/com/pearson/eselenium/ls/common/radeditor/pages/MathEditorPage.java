package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MathEditorPage extends BasePageObject {

    /* Elements */
    private UIElement btnclickCreateNewEquation = createElement(UIType.Css, ".buttontd");
    private UIElement tblExpandAllOrCollapseAll = createElement(UIType.Css, "#row1");
    private UIElement tblgetHeader = createElement(
            UIType.Xpath,
            "//*[@id='Form1']/table[1]/tbody/tr/td[1]");

    /* Constructor */
    public MathEditorPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## MathEditorPage ##");
    }

    /**
     * Method will click On CreateNewEquation Button
     * 
     * @author Suchi.Singh
     * @return MathEditorPage
     * @throws Exception
     */
    public MathEditorPage clickOnCreateNewEquationButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON CREATENEWEQUATION BUTTON");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(btnclickCreateNewEquation, waitTime);
            btnclickCreateNewEquation.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON CREATENEWEQUATION BUTTON \n METHOD :clickOnCreateNewEquationButton " + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will click On ExpandAllOrCollapseAll Link
     * 
     * @author Suchi.Singh
     * @return MathEditorPage
     * @throws Exception
     */
    public MathEditorPage clickOnExpandAllOrCollapseAllLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON EXPANDALLORCOLLAPSEALL LINK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(tblExpandAllOrCollapseAll, waitTime);
            tblExpandAllOrCollapseAll.clickNoWait();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON EXPANDALLORCOLLAPSEALL LINK \n METHOD : clickOnExpandAllOrCollapseAllLink" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Method will get Header Text *
     * 
     * @author Suchi.Singh
     * @return String
     * @throws Exception
     */
    public String getHeaderText() throws Exception {
        String headerText = null;
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON EXPANDALLORCOLLAPSEALL LINK");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(tblgetHeader, waitTime);
            headerText = tblgetHeader.getText();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO CLICK ON EXPANDALLORCOLLAPSEALL LINK \n METHOD :getHeaderText " + e
                            .getLocalizedMessage());
        }
        return headerText;
    }

    /**
     * Method will check is ExpandAllOrCollapseAll Link displayed or not
     * 
     * @author Suchi.Singh
     * @return boolean
     * @throws Exception
     */
    public boolean isExpandAllOrCollapseAllLinkDisplayed() throws Exception {
        boolean link = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING IS EXPANDALLORCOLLAPSEALL LINK PRESENT");
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(tblExpandAllOrCollapseAll, waitTime);
            if (tblExpandAllOrCollapseAll.isDisplayed()) {
                link = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "EXPANDALLORCOLLAPSEALL LINK IS NOT PRESENT. \n METHOD : isExpandAllOrCollapseAllLinkDisplayed" + e
                            .getLocalizedMessage());
        }
        return link;
    }

    /**
     * This method is used to Switch to Math Equation Page
     * 
     * @author Suchi.Singh
     * @return MathEditorPage
     * @throws Exception
     */
    public MathEditorPage switchToMathEquationPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SWITCHING TO MATH EQAUTION PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO MATH EQUATION PAGE  \n METHOD : switchToMathEquationPage");
        }
        return this;
    }

    /**
     * This Method will check whether we are at math equation [page or not .
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isMathEquationPage() throws Exception {
        String data = null;
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: verifying Math Eqaution Page ");
            uiDriver.switchTo().frame("popupcontent");
            UIElement element = uiDriver.findUIElement(UIType.Xpath, "//td[@class='tablehead'][1]");
            data = element.getText().trim();
            if (data.contains("Math Equations"))
                flag = true;
            uiDriver.getUIWindowLocator().switchToMainWindow();
        } catch (Exception e) {
            throw new Exception(
                    " UANBLE TO VERIFY MATH EQAUTION PAGE \n METHOD : isMathEquationPage ");
        }
        return flag;
    }

    /**
     * This Method will check whether we are at math equation [page or not .
     * 
     * 
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public void switchToMainWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SWITCHING BACK TO MAIN WINDOW");
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToMainWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO MAIN WINDOW \n METHOD : switchToMainWindow");
        }
    }
}
