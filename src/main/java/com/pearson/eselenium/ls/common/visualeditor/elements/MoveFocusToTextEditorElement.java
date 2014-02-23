package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class MoveFocusToTextEditorElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));

	/*Constructor*/
	public MoveFocusToTextEditorElement(UIElement element) {
        super(element);
    }

    /**
     * Method helps to click Move Focus To Text Editor Button
     * 
     * @author soundarya
     * @return MoveFocusToTextEditorElement
     * @throws Exception
     */
    public MoveFocusToTextEditorElement clickMoveFocusToTextEditorButton() throws Exception {
        try {
            //switchToFrame.switchToFrameContent();
            logInstruction("LOG INSTRUCTION: CLICK ON Move Focus To Text Editor Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Move Focus To Text Editor Button \n METHOD: clickMoveFocusToTextEditorButton" + e
                    .getLocalizedMessage());
        }
        return this;
    }
}