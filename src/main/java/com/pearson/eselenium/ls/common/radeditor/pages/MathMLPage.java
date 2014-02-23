package com.pearson.eselenium.ls.common.radeditor.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

public class MathMLPage extends BasePageObject {

    /* Elements */
    private UIElement editor = createElement(UIType.Xpath, "id=TextEditor");

    /* Constructor */
    public MathMLPage(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION : ## MathMLPage ##");
    }

    /**
     * This method helps to check whether the show math ml editor is displayed or not
     * 
     * @author ashish.juyal
     * @return boolean
     * @throws Exception
     */
    public boolean isEditorDisplayed() throws Exception {
        boolean flag = false;
        try {
            logInstruction("LOG INSTRUCTION: CHECKING FOR THE EDITOR");
            frameSwitch.switchToPopUpContent();
            uiDriver.waitToBeDisplayed(editor, waitTime);
            flag = editor.isDisplayed();
        } catch (Exception e) {
            throw new Exception("UNABLE TO FIND THE EDITOR \n" + e.getLocalizedMessage());
        }
        return flag;
    }

}
