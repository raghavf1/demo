package com.pearson.eselenium.ls.common.visualeditor.elements;

import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.ls.common.radeditor.pages.InsertSymbolPage;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This class identifies the Element and Actions / Methods for that Element.
 * 
 * @author Kapil.Aare
 */
public class InsertSymbolElement extends BasicPieceObject {

    SwitchToFrame switchToFrame = new SwitchToFrame(uiDriver);
    private long waitTime=Long.parseLong(config.getValue("waitTime"));    

	/*Constructors*/
	public InsertSymbolElement(UIElement element) {
        super(element);
    }


    /**
     * Method helps to click Insert Symbol
     * 
     * @author soundarya
     * @return InsertSymbolPage
     * @throws Exception
     */
    public InsertSymbolPage clickInsertSymbol() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICK ONInsert Symbol");
            root.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLICK Insert Symbol \n METHOD: clickInsertSymbol" + e
            		.getLocalizedMessage());
        }
        return new InsertSymbolPage(uiDriver);
    }
}