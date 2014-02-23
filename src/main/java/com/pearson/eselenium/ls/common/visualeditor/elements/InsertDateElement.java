package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class InsertDateElement extends BasicPieceObject {

    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);

	/*Consructors*/
    public InsertDateElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click Insert Date button
     * 
     * @author soundarya
     * @return InsertDateElement
     * @throws Exception
     */
    public InsertDateElement clickInsertDateButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON Insert Date button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Insert Date button \n METHOD: clickInsertDateButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}