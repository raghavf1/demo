package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class PasteElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));

	/*Constructor*/
	public PasteElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Paste Element Button
     * 
     * @author soundarya
     * @return PasteElement
     * @throws Exception
     */
    public PasteElement clickPasteElementButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK Paste Element Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Paste Element Button \n METHOD: clickPasteElementButton" + e
            		.getLocalizedMessage());
        }
        return this;
    }
}
