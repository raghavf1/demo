package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.PasteFromWordPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class PasteFromWordElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));

	/*Constructor*/
	public PasteFromWordElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Past eFrom Word Button
     * 
     * @author soundarya
     * @return PasteFromWordPage
     * @throws Exception
     */
    public PasteFromWordPage clickPasteFromWordButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK Past eFrom Word Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Past eFrom Word Button \n METHOD: clickPasteFromWordButton" + e
                    .getLocalizedMessage());
        }
        return new PasteFromWordPage(uiDriver);
    }
}