package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

public class ToggleScreenModeElement extends BasicPieceObject {

	private long waitTime=Long.parseLong(config.getValue("waitTime"));
    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
   
	/*Constructor*/
	public ToggleScreenModeElement(UIElement element) {
		super(element);
	}
	
	
    /**
     * Method helps to click ZoomButton on RadEditor
     * 
     * @author monica.anand
     * @return ToggleScreenModeElement
     * @throws Exception
     */
    public ToggleScreenModeElement clickToggleScreenMode() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ON TOGGLESCREENMODE");
            uiDriver.waitToBeDisplayed(root, waitTime);
            root.clickNoWait();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK ON TOGGLESCREENMODE" + e.getLocalizedMessage());
        }
        return this;

    }
}
