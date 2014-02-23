package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class CutTextElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public CutTextElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click Cut Button
     * 
     * @author soundarya
     * @return CutTextElement
     * @throws Exception
     */
    public CutTextElement clickCutButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON Cut Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Cut Button \n METHOD: clickCutButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}