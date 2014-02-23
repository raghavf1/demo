package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class InsertTimeElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public InsertTimeElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Insert Time Element
     * 
     * @author soundarya
     * @return InsertTimeElement
     * @throws Exception
     */
    public InsertTimeElement clickInsertTimeButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON Insert Time Element");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Insert Time Element \n METHOD: clickInsertTimeButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}