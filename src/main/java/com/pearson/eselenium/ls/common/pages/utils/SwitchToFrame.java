package com.pearson.eselenium.ls.common.pages.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;

import com.pearson.test.eselenium.framework.BasicPageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;

/**
 * @author Sumanth SV For switching between different frames
 */
public class SwitchToFrame extends BasicPageObject {
	
	private JavascriptExecutor jsx= null;
	private Set<String> windows = null;

    /* Constructor */
    public SwitchToFrame(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## SwitchToFrame ##");
    }

    /**
     * Method helps to Switch to tree pane
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToTreePane() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN FRAME");
            uiDriver.switchTo().frame("Main");
            logInstruction("LOG INSTRUCTION: SWITCH TO TREE FRAME");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Tree")));
        } catch (NoSuchFrameException ne) {
            try {
                logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
                uiDriver.switchTo().defaultContent();
                logInstruction("LOG INSTRUCTION: SWITCH TO TREE FRAME");
                uiDriver.switchTo().frame(uiDriver.findElement(By.id("Tree")));
            } catch (Exception e) {
                throw new Exception(
                        "UNABLE TO SWITCH TO TREE PANE INSIDE CATCH BLOCK \n METHOD :switchToTreePane" + e
                                .getLocalizedMessage());
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO TREE PANE \n METHOD :switchToTreePane" + e
                    .getLocalizedMessage());
        }

    }

    /**
     * Mehtod helps to Switch to content frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToFrameContent() throws Exception {
        try {

            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN FRAME");
            uiDriver.switchTo().frame("Main");
            logInstruction("LOG INSTRUCTION: SWITCH TO CONTENT FRAME");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
        } catch (NoSuchFrameException NF) {
            try {
                logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
                uiDriver.switchTo().defaultContent();
                logInstruction("LOG INSTRUCTION: SWITCH TO CONTENT FRAME");
                uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            } catch (Exception e) {
                throw new Exception(
                        "UNABLE TO SWITCH TO CONTENT FRAME INSIDE CATCH \n METHOD :switchToFrameContent" + e
                                .getLocalizedMessage());
            }
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO CONTENT FRAME\n METHOD :switchToFrameContent" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to Switch to topic content frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void selectTopicContentFrame() throws Exception {
        try {

            JavascriptExecutor jsx = (JavascriptExecutor) uiDriver.getWebDriver();
            jsx.executeScript("window.scrollBy(0,450)", "");
            logInstruction("LOG INSTRUCTION: SWITCH TO  IFRAME");
            uiDriver.switchTo().frame("RadeEntryText_contentIframe");

        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO TOPIC CONTENT FRAME\n METYHOD:selectTopicContentFrame" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * method helps to switch to top frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void selectTopFrame() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN FRAME");
            uiDriver.switchTo().frame("Main");
            logInstruction("LOG INSTRUCTION: SWITCH TO TOP TREE FRAME");
            uiDriver.switchTo().frame("Top");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO TOP FRAME \n METHOD :selectTopFrame" + e
                    .getLocalizedMessage());
        }
    }

    /**
     * Method helps to switch to new popwindow bottom frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToNewWindowBottomFrame() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO BOTTOM FRAME");
            uiDriver.switchTo().frame("generalBottomFrame");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO NEW WINDOW POPUP BOTTOM FRAME\n METHOD :switchToNewWindowBottomFrame" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to switch to new window top frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToNewWindowTopFrame() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: Switch to top Frame");
            uiDriver.switchTo().frame("generalTopFrame");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO NEW WINDOW TOP FRAME \n METHOD :switchToNewWindowTopFrame" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to switch to rad editor entry frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToRadeEntryTextcontentIframe() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            uiDriver.switchTo().frame("RadeEntryText_contentIframe");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO RADEDITOR ENTRY FRAME \n METHOD :switchToRadeEntryTextcontentIframe" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to switch to general frame
     * 
     * @author Ashish
     * @return void
     * @throws Exception
     */
    public void switchToRadeEntryTextcontentIframethroughtopGeneralFrame() throws Exception {
        try {
            uiDriver.switchTo().defaultContent();
            uiDriver.switchTo().frame("generalTopFrame");
            uiDriver.switchTo().frame("RadeEntryText_contentIframe");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO RADEDITOR IFRAME \n METHOD :switchToRadeEntryTextcontentIframethroughtopGeneralFrame" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to switch to general frame
     * 
     * @author Ashish
     * @return void
     * @throws Exception
     */
    public void switchtopGeneralFrame() throws Exception {
        try {
            uiDriver.switchTo().defaultContent();
            uiDriver.switchTo().frame("generalTopFrame");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO GENERAL FRAME \n METHOD :switchtopGeneralFrame" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Method helps to switch to popupcontent frame
     * 
     * @author Monica
     * @return void
     * @throws Exception
     */
    public void switchToAddLinkFrame() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: Switch to top Frame");
            uiDriver.switchTo().frame("popupcontent");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO ADD LINK FRAME \n METHOD :switchToAddLinkFrame" + e
                            .getLocalizedMessage());
        }

    }

    /***
     * Method helps to Switch to DatePickerPage
     * 
     * @author Chaitali
     * @return void
     * @throws Exception
     */
    public void switchToDatePickerPage() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DATEPICKER PAGe");
            List<String> windows = new ArrayList<String>();
            windows.addAll(uiDriver.getWindowHandles());
            uiDriver.switchTo().window(windows.get(1));
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWTICH TO DATE PICKER PAGE \n METHOD :switchToDatePickerPage" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Method helps to switch to iframe to enter the content for Add Announcement page
     * 
     * @author amit.deshmukh
     * @return void
     * @throws Exception
     */
    public void selectTopicContentFrameAddAnnouncment() throws Exception {
        try {
            jsx = (JavascriptExecutor) uiDriver.getWebDriver();
            jsx.executeScript("window.scrollBy(0,450)", "");
            logInstruction("LOG INSTRUCTION: Switch to  iFrame");
            switchToFrameContent();
            uiDriver.switchTo().frame("RadText_contentIframe");
        } catch (Exception e) {
            throw new Exception(
                    "UNABLE TO SWITCH TO RADEDITOR CONTENT IN ADD ANNOUNCEMENT PAGE \n METHOD :selectTopicContentFrameAddAnnouncment" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Switch between different windows.
     * 
     * @author Vivek.Singh
     * @return void
     * @throws Exception
     * @param pageTitle
     *            to be switch to
     **/
    public void handleMultipleWindows(String pageTitle) throws Exception {
        try {
            windows = uiDriver.getWindowHandles();
            for (String window : windows) {
                uiDriver.switchTo().window(window);
                if (uiDriver.getTitle().trim().equals(pageTitle)) {
                    uiDriver.switchTo().window(window);
                }
            }
        } catch (Exception e) {
            throw new Exception("UNABLE TO HADLE MULTIPLE WINDOW \n METHOD :handleMultipleWindows" + e
            		.getLocalizedMessage());
        }
    }

    /***
     * Method helps to Switch to New Window
     * 
     * @author Chaitali
     * @return void
     * @throws Exception
     */

    public void switchToNewWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Switch to New Window Page");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO EW WINDOW \n METHOD :switchToNewWindow" + e
            		.getLocalizedMessage());
        }
    }

    /**
     * MEthod helps to switch to rad Editor subject frame
     * 
     * @author ganapati.bhat
     * @return void
     * @throws Exception
     */
    public void switchToRadEditorSubjectFrame() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Swtich to RadEditor Subject frame");
            uiDriver.switchTo().defaultContent();
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            logInstruction("LOG INSTRUCTION: Switch to  iFrame");
            uiDriver.switchTo().frame("SubLineRadText_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE SUBJECT IFRAME \n METHOD :switchToRadEditorSubjectFrame" + e
            		.getLocalizedMessage());
        }
    }

    /**
     * Method helps to navigate to RADQuestionTextContentIframe
     * 
     * @author monica.anand
     * @return void
     * @throws Exception
     */
    public void switchToRADQuestionTextContentIframe() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Switch to Default Content");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: Switch to Main");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADQuestionText_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO ENTER THE CONTENT IFRAME \n METHOD :switchToRADQuestionTextContentIframe" + e
                    .getLocalizedMessage());
        }
    }

    /***
     * Method helps to Switch to PArent Window
     * 
     * @author Chaitali
     * @return void
     * @throws Exception
     */
    public void switchToParentWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Switch to Parent Window Page");
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("ISSUE WHILE SWITCHING TO PARENT WINDOW" + e.getLocalizedMessage());
        }
    }

    /**
     * This method will switch inside the frame of new POPUP frame
     * 
     * @author Shishir.Dwivedi
     * @return void
     * @throws Exception
     */
    public void switchToPopUpContent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: Switching to Pop content ");
            uiDriver.switchTo().frame("popupcontent");
        } catch (Exception e) {
        	throw new Exception("ISSUE IN SWITCHING TO POP UP CONTENT" + e.getLocalizedMessage());
        }
    }

    /**
     * This method will switch inside the frame of rad course
     * 
     * @author Shishir.Dwivedi
     * @return void
     * @throws Exception
     */
    public void switchToRadeCourseTextcontentIframe() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            uiDriver.switchTo().frame("RadCourseText_contentIframe");
        } catch (Exception e) {
            throw new Exception("ISSUE IN SWITCHING TO RAD COURSE TEXT CONTENT IFRAME" + e.getLocalizedMessage());
        }
    }

    /**
     * Method helps to navigate to RADTrueTextContentIframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToTrueTextContentIframe() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO  DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADTrueExplanation_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO TRUE CONTENT IFRAME \n METHOD :switchToTrueTextContentIframe" + e.getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to RADTrueTextContentIframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToFalseTextContentIframe() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADFalseExplanation_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO FALSE CONTENT IFRAME \n METHOD :switchToFalseTextContentIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to First Response Iframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToFirstResponseIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADresponse1_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO RESPONSE 1 CONTENT IFRAME \n METHOD :switchToFirstResponseIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to Second Response Iframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToSecondResponseIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADresponse2_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO RESPONSE 2 CONTENT IFRAME \n METHOD :switchToSecondResponseIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to Third Response Iframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToThirdResponseIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADresponse3_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO RESPONSE 3 CONTENT IFRAME \n METHOD :switchToThirdResponseIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to Fourth Response Iframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToFourthResponseIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADresponse4_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO RESPONSE 4 CONTENT IFRAME \n METHOD :switchToFourthResponseIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to Fifth Response Iframe
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToFifthResponseIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADresponse5_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO RESPONSE 5 CONTENT IFRAME \n METHOD :switchToFifthResponseIframe" + e
                    .getLocalizedMessage());

        }

    }

    /**
     * Method helps to navigate to General Explanation Frame
     * 
     * @return void
     * @author monica.anand
     * @throws Exception
     */
    public void switchToGeneralResponse() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame("Content");
            uiDriver.switchTo().frame("RADGeneralExplanation_contentIframe");
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO GENERAL RESPONSE \n METHOD :switchToGeneralResponse" + e
            		.getLocalizedMessage());

        }
    }

    /**
     * This method will switch inside the frame of rad in dropbox Email page
     * 
     * @return void
     * @throws Exception
     * @author Usha
     */
    public void switchToRadEmailcontentIframe() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            uiDriver.switchTo().frame("MailBody_contentIframe");
        } catch (Exception e) {
        	throw new Exception("NOT ABLE TO SWITCH \n METHOD :switchToRadEmailcontentIframe" + e
            		.getLocalizedMessage());
        }
    }

    /**
     * This method will switch to courseSchedular bottom frame
     * 
     * @return void
     * @throws Exception
     * @author kiran.kumar
     */
    public void switchToCourseSchedularBottomFrame() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            logInstruction("Switch to course schedular Frame");
            uiDriver.switchTo().frame("CourseScheduler_Bottom");
        } catch (Exception e) {
        	throw new Exception("ISSUE IN SWITCHING TO COURSE SCHEDULAR BOTTOM FRAME" + e.getLocalizedMessage());
        }
    }

    /**
     * This method will switch to courseSchedular top frame
     * 
     * @return void
     * @throws Exception
     * @author kiran.kumar
     */
    public void switchToCourseSchedularTopFrame() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO MAIN");
            uiDriver.switchTo().frame("Main");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
            logInstruction("LOG INSTRUCTION: SWITCH TO COURSE SCHEDULAR FRAME");
            uiDriver.switchTo().frame("CourseScheduler_Top");
        } catch (Exception e) {
        	throw new Exception("ISSUE IN SWITCHING TO COURSE SCHEDULAR TOP FRAME" + e.getLocalizedMessage());
        }
    }

    /**
     * Method helps to switch to popupcontent frame
     * 
     * @return void
     * @author Monica
     * @throws Exception
     */
    public void switchToPopUpContentFrame() throws Exception {
        try {
        	logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO TOP FRAME");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("popupcontent")));
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO ADD LINK FRAME \n METHOD :switchToPopUpContentFrame" + e
            		.getLocalizedMessage());
        }

    }

    /***
     * Method helps to Switch to New Window and Returns String Handler ID of Parent
     * 
     * @author Raghav
     * @return void
     * @throws Exception
     */

    public void SwitchToNewWindowID() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO NEW WINDOW PAGE");
            uiDriver.getUIWindowLocator().switchToNewWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO NEW WINDOW \n METHOD :SwitchToNewWindowID" + e
            		.getLocalizedMessage());
        }

    }

    /***
     * Method helps to Switch to Parent Window from Child Window
     * SwitchToNewWindowandReturnWindowID() Should be called Before Calling this Method
     * 
     * @param String
     *            WindowID
     * @author Raghav
     * @return void
     * @throws Exception
     */

    public void SwitchToParentWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCHING TO PARENT WINDOW");
            uiDriver.getUIWindowLocator().switchToFirstWindow();
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO PARENT WINDOW \n METHOD :SwitchToParentWindow" + e
            		.getLocalizedMessage());
        }

    }

    /***
     * Method helps to Close the Current Browser window
     * 
     * @author Raghav
     * @return void
     * @throws Exception
     */
    public void ClosePresentWindow() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLOSING THE CURRENT WINDOW");
            uiDriver.close();
        } catch (Exception e) {
            throw new Exception("UNABLE TO CLOSE THE CURRENT WINDOW \n METHOD :ClosePresentWindow" + e
            		.getLocalizedMessage());
        }

    }

    /**
     * @category Milestone2 METHOD IS USED TO SWITCH TO CONTENT FRAME WITHOUT SWITCHING TO MAIN
     *           CONTENT
     * @author Pratush.Manglik
     * @return void
     * @throws Exception
     */
    public void switchToContentFrameWithoutMain() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SWITCH TO DEFAULT CONTENT");
            uiDriver.switchTo().defaultContent();
            logInstruction("LOG INSTRUCTION: SWITCH TO CONTENT FRAME");
            uiDriver.switchTo().frame(uiDriver.findElement(By.id("Content")));
        } catch (Exception e) {
            throw new Exception("UNABLE TO SWITCH TO DEFAULT CONTENT \n METHOD :switchToContentFrameWithoutMain" + e
            		.getLocalizedMessage());
        }
    }

}
