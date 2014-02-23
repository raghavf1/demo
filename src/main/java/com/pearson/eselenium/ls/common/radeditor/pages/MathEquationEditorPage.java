package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MathEquationEditorPage extends BasePageObject {

    public MathEquationEditorPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## MathEquationEditor Page ##");
    }

    private UIElement lbTitle = createElement(UIType.Css, "tr>td.tablehead:first-child");

    /**
     * This Method will switch to Math Equation Editor .
     * 
     * @return MathEquationEditorPage
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public MathEquationEditorPage switchToMathEquationEditor() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:SWITCHING TO POP UP WINDOW ");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO SWITCH TO POP UP WINDOW \n METHOD : switchToMathEquationEditor ");
        }
        return this;
    }

    /**
     * This Method will check whether we are at Math Equation Editor Page .
     * 
     * @return boolean
     * @throws Exception
     * @author Shishir.Dwivedi
     */
    public boolean isMathEquationEditorPage() throws Exception {
        String pagetitle = null;
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: VERIFYING MATH EQUATION PAGE ");
            uiDriver.getUIWindowLocator().switchToNewWindow();
            frameSwitch.switchToAddLinkFrame();
            uiDriver.waitToBeDisplayed(lbTitle, waitTime);
            pagetitle = lbTitle.getText().trim();
            if (pagetitle.equals("Math Equations"))
                flag = true;
            uiDriver.close();
            uiDriver.getUIWindowLocator().switchToFirstWindow();

        } catch (Exception e) {
            throw new Exception(
                    " UNABLE TO GET THE MATH EQUATION EDITOR \n METHOD : isMathEquationEditorPage");
        }
        return flag;
    }
}