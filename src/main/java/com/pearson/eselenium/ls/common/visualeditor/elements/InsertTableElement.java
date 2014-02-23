package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.InsertTablePage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class InsertTableElement extends BasicPieceObject {

	SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructor*/
	public InsertTableElement(UIElement element) {
        super(element);
    }

    
    /**
     * Method helps to click Insert Table Button
     * 
     * @author soundarya
     * @return InsertTablePage
     * @throws Exception
     */
    public InsertTablePage clickInsertTableButton() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ONInsert Table Button");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Insert Table Button \n METHOD: clickInsertTableButton" + e
            		.getLocalizedMessage());
        }
        return new InsertTablePage(uiDriver);
    }
}
