package com.pearson.eselenium.ls.common.pages;

import com.pearson.eselenium.ls.common.pages.utils.CleanUpUtil;
import com.pearson.eselenium.ls.common.pages.utils.SwitchToFrame;
import com.pearson.eselenium.utils.StringUtils;
import com.pearson.test.eselenium.framework.BasicPageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.Browser;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * This is base class where common methods and variables are initialized which are used across the
 * application. This class is extended in each of the page classes.
 * 
 * @author Kapil.Aare
 */
public abstract class BasePageObject extends BasicPageObject {

	/* Elements */
	private UIElement navigationPane = createElement(UIType.ID, "Form1");
    private UIElement toolBar = createElement(UIType.ID, "Form1");
    
    /* Variables */
	protected CourseLeftNavigationPane navigationTool = null;
    protected CourseToolNavigationBar toolBarObject = null;
    protected SwitchToFrame frameSwitch = new SwitchToFrame(uiDriver);
    protected int waitTime = Integer.parseInt(config.getValue("waitTime"));
    protected String pageTitle;
    protected CleanUpUtil cleanup=new CleanUpUtil();
    protected StringUtils stringUtils = new StringUtils();
    private static Browser browser;
    

    /**
     * Creating a Constructor for the Login operation
     * 
     * @author Kapil.Aare
     * @param UIDriver driver
     */
    public BasePageObject(UIDriver driver) {
        super(driver);
        logInstruction("LOG INSTRUCTION: ## Base Page ##");
        setBrowser();
    }

    /**
     * This method can be called from any page class to get the current executed Browser
     * 
     * @author Kapil.Aare
     * @return current selected browser
     */
    protected static Browser getBrowser() {
        return browser;
    }

    /**
     * This method is used to set browser ENUM value from the browser.NAME system property
     * 
     * @author Kapil.Aare
     * @return void
     */
    private static void setBrowser() {
    	String browserName = System.getProperty("browser.NAME");
        if(browserName.equalsIgnoreCase("FIREFOX")) {
        	BasePageObject.browser = Browser.FIREFOX;
        }
        else if(browserName.equalsIgnoreCase("CHROME")) {
        	BasePageObject.browser = Browser.CHROME;
        }
        else if(browserName.equalsIgnoreCase("INTERNETEXPLORER")) {
        	BasePageObject.browser = Browser.INTERNETEXPLORER;
        }
        else {
        	// Falling back to default browser, for any other browser
        	BasePageObject.browser = Browser.FIREFOX;
        }
    }
    
    /**
     * This method can be called from any page class to navigate on the common items visible across
     * application
     * 
     * @author Kapil.Aare
     * @return instance of CourseLeftNavigationPane
     */
    public CourseLeftNavigationPane getNavigationPane() {
        if (navigationTool == null) {
            navigationTool = new CourseLeftNavigationPane(navigationPane);
        }
        return navigationTool;
    }

    /**
     * This method can be called from any page class to navigate on the common tools visible across
     * application
     * 
     * @author Hemant.Kumar
     * @return instance of CourseToolNavigationBar
     */
    public CourseToolNavigationBar getToolBar() {
        if (toolBarObject == null) {
            toolBarObject = new CourseToolNavigationBar(toolBar);
        }
        return toolBarObject;
    }

}
