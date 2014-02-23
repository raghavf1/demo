package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class AjaxSpellCheckElement extends BasicPieceObject {

    public AjaxSpellCheckElement(UIElement element) {
        super(element);
    }

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    /**
     * Method helps to click Move Focus To Text Editor
     * 
     * @author soundarya
     * @return void
     * @throws Exception
     */
    public void clickAjaxSpellCheckButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK MOVE FOCUS TO TEXT EDITOR");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK MOVE FOCUS TO TEXT EDITOR \n METHOD :clickAjaxSpellCheckButton" + e
                    .getLocalizedMessage());
        }
    }
}
