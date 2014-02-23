package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class RedoElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));
    
	/*Constructor*/
	public RedoElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Redo Button
     * 
     * @author soundarya
     * @return RedoElement
     * @throws Exception
     */
    public RedoElement clickRedoButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: click Redo Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Redo Button \n METHOD: clickRedoButton" + e.getLocalizedMessage());
        }
        return this;
    }
}
