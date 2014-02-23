package com.pearson.eselenium.ls.common.pages;

import com.pearson.eselenium.ls.common.pages.utils.CleanUpUtil;
import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.test.eselenium.framework.BasicPieceObject;
import com.pearson.test.eselenium.framework.core.UIElement;

/**
 * This is base class for all element classes where common methods and variables are initialized which are used across the
 * application. This class is extended in each of the element classes.
 * 
 * @author Hemanth
 */
public class BasePieceObject extends BasicPieceObject {

    /* Variables */
    protected CourseLeftNavigationPane navigationTool = null;
    protected SwitchToFrame frameSwitch = new SwitchToFrame(uiDriver);
    protected int waitTime = Integer.parseInt(config.getValue("waitTime"));
    protected CleanUpUtil cleanup=new CleanUpUtil();

    /* Constructor */
    public BasePieceObject(UIElement element) {
        super(element);
        logInstruction("LOG INSTRUCTION: ## BASIC PIECE OBJECT ##");
    }
}
