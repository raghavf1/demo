package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class UndoElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    
	/*Constructor*/
	public UndoElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click Undo Button
     * 
     * @author soundarya
     * @return UndoElement
     * @throws Exception
     */
    public UndoElement clickUndoButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: click Undo Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Undo Button \n METHOD: clickUndoButton" + e.getLocalizedMessage());
        }
        return this;
    }
}