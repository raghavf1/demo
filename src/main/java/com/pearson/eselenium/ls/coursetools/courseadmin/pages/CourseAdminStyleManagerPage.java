package com.pearson.eselenium.ls.coursetools.courseadmin.pages;

import com.pearson.eselenium.ls.common.pages.BasePageObject;
import com.pearson.test.eselenium.framework.core.UIDriver;
import com.pearson.test.eselenium.framework.core.UIElement;
import com.pearson.test.eselenium.framework.util.UIType;

/**
 * Class contains all methods related to CourseAdminStyleManagerPage
 * 
 * @author Pratush.Manglik
 * @param uiDriver
 */
public class CourseAdminStyleManagerPage extends BasePageObject {

    /* UI element declarations for CourseAdminStyleManagerPage */
    private UIElement radDefaultStyle = createElement(UIType.ID, "Aradio");
    private UIElement radCustomStyle = createElement(UIType.ID, "Bradio");
    private UIElement lblColorThemes = createElement(UIType.LinkText, "Color Themes");
    private UIElement btnSaveChanges = createElement(
            UIType.Xpath,
            "//input[contains(@value,'Save')]");
    private UIElement btnCancel = createElement(UIType.Xpath, "//input[contains(@value,'Cancel')]");
    private UIElement radValue = createElement(
            UIType.Xpath,
            "//td[span[label[contains(.,'{2}')]]]//input[contains(@aria-label,'{1}')]");
    private UIElement lnkdesigntheme = createElement(UIType.LinkText, "Design Themes");
    private UIElement lnkfont = createElement(UIType.LinkText, "Fonts");
    private UIElement selectTheme = createElement(
            UIType.Xpath,
            "//span[label[contains(text(),'{1}')]]/preceding-sibling::input");
    private UIElement selectFontface = createElement(
            UIType.Xpath,
            "//label[label[span[contains(text(),'{1}')]]]/preceding-sibling::input");
    private UIElement gettitle = createElement(UIType.Css, "div[class='tablehead']");
    private UIElement lnkcolortheme = createElement(UIType.LinkText, "Color Themes");
    private UIElement lblcolor = createElement(UIType.Xpath, "//div[text()='{1}:']");
    private UIElement lbldesign = createElement(UIType.Xpath, "//label[contains(text(),'{1}')]");
    private UIElement lbllinkstyle = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table:nth-of-type(3)>tbody>tr:nth-of-type(2)>td>table>tbody>tr>td:nth-of-type(1)>h3");
    private UIElement lbllinkcolor = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table:nth-of-type(3)>tbody>tr:nth-of-type(3)>td>table>tbody>tr>td:nth-of-type(1)>h3");
    private UIElement lblfontsize = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table:nth-of-type(3)>tbody>tr:nth-of-type(4)>td>table>tbody>tr>td:nth-of-type(1)>h3");
    private UIElement lblfontface = createElement(
            UIType.Css,
            ".outercontenttable>tbody>tr>td>table:nth-of-type(3)>tbody>tr:nth-of-type(1)>td>table>tbody>tr>td:nth-of-type(1)>h3");
    private UIElement chknobackground = createElement(
            UIType.Xpath,
            "//td[span[label[contains(.,'No Background')]]]//input[contains(@aria-label,'{1}')]");
    private UIElement chkstripespresent = createElement(
            UIType.Xpath,
            "//td[span[label[contains(.,'Stripes')]]]//input[contains(@aria-label,'{1}')]");
    private UIElement chkwirlpresent = createElement(
            UIType.Xpath,
            "//td[span[label[contains(.,'Swirl')]]]//input[contains(@aria-label,'{1}')]");
    private UIElement chkbrushpresent = createElement(
            UIType.Xpath,
            "//td[span[label[contains(.,'Brush')]]]//input[contains(@aria-label,'{1}')]");
    private UIElement chkfontfacepresent = createElement(
            UIType.Xpath,
            "//td[label[label[span[contains(text(),'{1}')]]]]//input");
    private UIElement chkalwaysunderlinedpresent = createElement(
            UIType.Xpath,
            "//td[label[a[label[contains(text(),'Always Underlined')]]]]//input");
    private UIElement chkhoverunderlinepresent = createElement(
            UIType.Xpath,
            "//td[label[label[a[contains(text(),'Hover Underlined')]]]]//input");
    private UIElement chklinkcolorpresent = createElement(
            UIType.Xpath,
            "//td[label[label[a[contains(text(),'{1}')]]]]//input");
    private UIElement chkfontsizepresent = createElement(
            UIType.Xpath,
            "//td[label[label[span[contains(text(),'{1}')]]]]//input");
    private UIElement raddesign = createElement(
            UIType.Xpath,
            "//td[span[label[contains(text(),'{1}')]]]/input");
    /*Variables*/
    private boolean flag = false; 
    private String strTitle =null;
    /* Constructor */
    public CourseAdminStyleManagerPage(UIDriver uiDriver) {
        super(uiDriver);
        logInstruction("LOG INSTRUCTION: ## CourseAdminStyleManagerPage ##");

    }

    /**
     * This method is used to select the type of styles
     * 
     * @author Pratush.Manglik
     * @param style
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage selectDefaultOrCustomStyle(String style) throws Exception {
        logInstruction("LOG INSTRUCTION:  SELECT TYPE OF STYLE ");
        try {
            frameSwitch.switchToFrameContent();
            if (style.contains("default")) {
                logInstruction("LOG INSTRUCTION: USE THE DEFAULT COURSE STYLE");
                uiDriver.waitToBeDisplayed(radDefaultStyle, waitTime);
                radDefaultStyle.clickAndWait(waitTime);
            } else
                if (style.contains("custom")) {
                    logInstruction("LOG INSTRUCTION: USE THE CUSTOM COURSE STYLE");
                    uiDriver.waitToBeDisplayed(radCustomStyle, waitTime);
                    radCustomStyle.clickAndWait(waitTime);
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'radio button' " + "\n METHOD:selectDefaultOrCustomStyle \n" + e
                            .getLocalizedMessage());
        }

        return this;
    }

    /**
     * This method is used to Verify Whether Default and Custom Style Radio Buttons are Displayed
     * 
     * @category Milestone 2
     * @author Raghav
     * @param style
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public boolean isSelectDefaultOrCustomStyleDisplayed(String style) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT TYPE OF STYLE ");
       
        try {
            frameSwitch.switchToFrameContent();
            if (style.equalsIgnoreCase("default")) {
                logInstruction("LOG INSTRUCTION:USE THE DEFAULT COURSE STYLE");
                uiDriver.waitToBeDisplayed(radDefaultStyle, waitTime);
                if (radDefaultStyle.isDisplayedAfterWaiting(waitTime)) {
                    flag = true;
                }
            } else
                if (style.equalsIgnoreCase("custom")) {
                    logInstruction("LOG INSTRUCTION:USE THE CUSTOM COURSE STYLE");
                    uiDriver.waitToBeDisplayed(radCustomStyle, waitTime);
                    if (radCustomStyle.isDisplayedAfterWaiting(waitTime)) {
                    	flag = true;
                    }
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'radio buttons' " + "\n METHOD:isselectDefaultOrCustomStyleDisplayed \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method is used to Verify Whether Default and Custom Style Radio Button are Selected or
     * not
     * 
     * @category Milestone 2
     * @author Raghav
     * @param style
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public boolean isSelectDefaultOrCustomStyleSelected(String style) throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT TYPE OF STYLE ");
        
        try {
            frameSwitch.switchToFrameContent();
            if (style.equalsIgnoreCase("default")) {
                logInstruction("LOG INSTRUCTION:USE THE DEFAULT COURSE STYLE");
                uiDriver.waitToBeDisplayed(radDefaultStyle, waitTime);
                if (radDefaultStyle.isSelected()) {
                	flag = true;
                }
            } else
                if (style.equalsIgnoreCase("custom")) {
                    logInstruction("LOG INSTRUCTION:USE THE CUSTOM COURSE STYLE");
                    uiDriver.waitToBeDisplayed(radCustomStyle, waitTime);
                    if (radCustomStyle.isSelected()) {
                    	flag = true;
                    }
                }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'radio buttons' " + "\n METHOD:isselectDefaultOrCustomStyleSelected \n" + e
                            .getLocalizedMessage());
        }

        return flag;
    }

    /**
     * This method is used to click on the Color theme tab
     * 
     * @author Pratush.Manglik
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage selectColorThemesTab() throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT COLOR THEME");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lblColorThemes, waitTime);
            lblColorThemes.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'color theme tab'" + "\n METHOD:selectColorThemesTab \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to click on save changes button
     * 
     * @author Pratush.Manglik
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminPage clickSaveChanges() throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT SAVE CHANGES");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON  'save changes button'" + "\n METHOD:clickSaveChanges \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method is used to click on save changes button after selecting Custom course style
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminPage clickSaveChangesSelectingCustomCourse() throws Exception {
        logInstruction("LOG INSTRUCTION:SELECT SAVE CHANGES");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnSaveChanges, waitTime);
            btnSaveChanges.clickAndWait(waitTime);
            uiDriver.getUIAlert().acceptAlertIfPresent();
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE ON CLICKING'save changes button'" + "\n METHOD:clickSaveChangesSelectingCustomCourse \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method is used to Verify save changes button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public boolean isSaveChangesbtnDisplayed() throws Exception {
        logInstruction("LOG INSTRUCTION:VERIFY SAVE CHANGES");

        try {
            frameSwitch.switchToFrameContent();
            return btnSaveChanges.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'save changes button'" + "\n METHOD:isSaveChangesbtnDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to click on cancel button
     * 
     * @author Pratush.Manglik
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminPage clickCancel() throws Exception {
        logInstruction("LOG INSTRUCTION: SELECT CANCEL BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(btnCancel, waitTime);
            btnCancel.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE  'cancel button'" + "\n METHOD:clickCancel \n" + e
                            .getLocalizedMessage());
        }
        return new CourseAdminPage(uiDriver);
    }

    /**
     * This method is used to click on save changes button
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public boolean isCancelButtonDisplayed() throws Exception {
        logInstruction("LOG INSTRUCTION:VERIFY CANCEL BUTTON");
        try {
            frameSwitch.switchToFrameContent();
            return btnCancel.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'cancel button'" + "\n METHOD:isCancelbtnDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method is used to select any style and color
     * 
     * @author Pratush.Manglik
     * @param color
     *            Enter name of the color Example: Green,Purple,Gold
     * @param style
     *            enter the name of style Ex: Stripes, Swirl,No Backgraound
     * @returnCourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage selectColorTheme(String color, String style)
            throws Exception {
        logInstruction("LOG INSTRUCTION: THIS SELECTS THE COLOR AND STYLES");
        try {
            frameSwitch.switchToFrameContent();
            radValue.replaceValues(color, style);
            uiDriver.waitToBeDisplayed(radValue, waitTime);
            radValue.clickAndWait(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'theme' " + "\n METHOD:selectColorTheme \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to select DesignThemes
     * 
     * @author kiran.kumar
     * 
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage clickDesignTheme() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON DESIGN THEMES");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkdesigntheme, waitTime);
            lnkdesigntheme.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' delign link'" + "\n METHOD:clickDesignTheme \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to select Fonts
     * 
     * @author kiran.kumar
     * 
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage clicklinkfont() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: CLICKING ON FONT LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkfont, waitTime);
            lnkfont.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON 'font link'" + "\n METHOD:clicklnkfont \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to select theme
     * 
     * @param theme
     *            name
     * @author kiran.kumar
     * 
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage selectTheme(String themeName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING THEME");
            frameSwitch.switchToFrameContent();
            selectTheme.replaceValues(themeName);
            uiDriver.waitToBeDisplayed(selectTheme, waitTime);
            selectTheme.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception("ISSUE IN SELECTING THE  'theme'" + "\n METHOD:selectTheme \n" + e
                    .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method is used to select font face
     * 
     * @param fontname
     * @author kiran.kumar
     * 
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage selectFontFace(String fontName) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION: SELECTING FONT FACE");
            frameSwitch.switchToFrameContent();
            selectFontface.replaceValues(fontName);
            uiDriver.waitToBeDisplayed(selectFontface, waitTime);
            selectFontface.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE'fontface'" + "\n METHOD:selectFontFace \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * This method Verifies whether color tab is displayed or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */

    public boolean isColorThemesTabDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES COLOR THEMES TAB");
            frameSwitch.switchToFrameContent();
            return lnkcolortheme.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'color theme tab'" + "\n METHOD:iscolorThemesTabDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method Verifies whether design tab is displayed or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */

    public boolean isDesignThemesTabDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES DESIGN THEMES TAB");
            frameSwitch.switchToFrameContent();
            return lnkdesigntheme.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'design theme tab'" + "\n METHOD:isdesignThemesTabDisplayed \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method Verifies whether Font tab is displayed or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */

    public boolean isFontTabDisplayed() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES DESIGN THEMES TAB");
            frameSwitch.switchToFrameContent();
            return lnkfont.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'Font tab'" + "\n METHOD:isFontTabDisplayed \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * This method Verifies whether color label is present in color theme tab
     * 
     * @category Milestone 2
     * @param colorname
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */

    public boolean isDifferentColorlblPresent(String color) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES DIFFERENT COLOR LABEL IN COLOR THEMES TAB");
            frameSwitch.switchToFrameContent();
            lblcolor.replaceValues(color);
            return lblcolor.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'Color label'" + "\n METHOD:isdifferentColorlblPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * This method Verifies whether Design theme is present in design theme tab
     * 
     * @category Milestone 2
     * @param designname
     * @author Raghav
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */

    public boolean isDifferentDesignlblPresent(String designtheme) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:VERIFIES DIFFERENT DESIGN LABEL IN DESIGN THEMES TAB");
            frameSwitch.switchToFrameContent();
            lbldesign.replaceValues(designtheme);
            return lbldesign.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' Design label'" + "\n METHOD:isdifferentDesignlblPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to find font face label is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isFontFacelblpresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR FONT FACE LABEL");
            frameSwitch.switchToFrameContent();
            return lblfontface.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'font face label'" + "\n METHOD:isFontFacelblpresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find Link Style label is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isLinkStylelblpresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR LINK STYLE LABEL");
            frameSwitch.switchToFrameContent();
            return lbllinkstyle.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'link style label'" + "\n METHOD:isLinkStylelblpresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find link color label is present
     * 
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isLinkColorlblPresent() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR LINK COLOR LABEL");
            frameSwitch.switchToFrameContent();
            return lbllinkcolor.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'link color label'" + "\n METHOD:isLinkColorlblPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find font size label is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */
    public boolean isFontSizelblPresent() throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR FONT SIZE LABEL");
            frameSwitch.switchToFrameContent();
            return lblfontsize.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' font size label'" + "\n METHOD:isFontSizelblPresent \n" + e
                            .getLocalizedMessage());
        }
       

    }

    /**
     * Methods helps to find NOBackGround Checkbox is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isNobackGroundCheckboxPresentinColorThemesTab(String color) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chknobackground.replaceValues(color);
            return chknobackground.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' checkbox'" + "\n METHOD:isNobackGroundCheckboxPresentinColorThemesTab \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find Stripes checkbox is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isStripesCheckboxPresentinColorThemesTab(String color) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkstripespresent.replaceValues(color);
            return chkstripespresent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'StripesCheckboxPresentinColorThemes'" + "\n METHOD:isStripesCheckboxPresentinColorThemesTab \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find swirl checkbox is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isSwirlCheckBoxPresntInColorThemesTab(String color) throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkwirlpresent.replaceValues(color);
            return chkwirlpresent.isDisplayedAfterWaiting(waitTime);
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING 'SwirlCheckBox'" + "\n METHOD:isSwirlCheckBoxPresntInColorThemesTab \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to find brush checkbox is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isBrushCheckBoxPresentIncolorThemesTab(String color) throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkbrushpresent.replaceValues(color);
            return chkbrushpresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'checkbox'" + "\n METHOD:isBrushCheckBoxPresentIncolorThemesTab \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to find whether Fontface checkbox are present( )
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isFontFaceCheckboxPresent(String checkboxname) throws Exception {
        ;
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkfontfacepresent.replaceValues(checkboxname);
            return chkfontfacepresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE 'checkbox'" + "\n METHOD:isFontFaceCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to find whether Fontface checkbox is Selected
     * 
     * @category Milestone 2
     * @author Raghav S
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isFontFaceCheckboxSelected(String checkboxname) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkfontfacepresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chkfontfacepresent, waitTime);
            if (chkfontfacepresent.isSelected()) {
                flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE ' checkbox'" + "\n METHOD:isFontFaceCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Methods helps to click on given checkbox of fontface style
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public CourseAdminStyleManagerPage clickOnFontFaceCheckbox(String checkboxname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION : WAIT FOR CHECKBOX TO CLICK");
            frameSwitch.switchToFrameContent();
            chkfontfacepresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chkfontfacepresent, waitTime);
            chkfontfacepresent.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'fontfacecheckbox'" + "\n METHOD:clickOnFontFaceCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Methods helps to find whether AlwaysUnderlined Checkbox is Present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isAlwaysUnderlinedCheckboxPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :VERIFYING  FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            return chkalwaysunderlinedpresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'checkbox'" + "\n METHOD:isAlwaysUnderlinedCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }
    }

    /**
     * Methods helps to find whether AlwaysUnderlined Checkbox is Checked or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return boolean
     * @throws Exception
     */

    public boolean isAlwaysUnderlinedCheckboxSelected() throws Exception {

       
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkalwaysunderlinedpresent, waitTime);
            if (chkalwaysunderlinedpresent.isSelected())
            	flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE  'checkbox'" + "\n METHOD:isAlwaysUnderlinedCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods helps to click on AlwaysUnderlined Checkbox
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public CourseAdminStyleManagerPage clickOnAlwaysUnderlinedCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX TO CLICK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkalwaysunderlinedpresent, waitTime);
            chkalwaysunderlinedpresent.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE  'alwaysundercheckbox'" + "\n METHOD:clickOnAlwaysUnderlinedCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to check whether HoverUnderlinedcheckbox is present
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return boolean
     * @throws Exception
     */

    public boolean isHoverUnderlinedCheckboxPresent() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            return chkhoverunderlinepresent.isDisplayedAfterWaiting(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ON THE  'alwaysundercheckbox'" + "\n METHOD:isHoverUnderlinedCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }

    }

    /**
     * Methods helps to check whether HoverUnderlinedcheckbox is Checked or not
     * 
     * @category Milestone 2
     * @author Raghav
     * @return boolean
     * @throws Exception
     */

    public boolean isHoverUnderLinedCheckboxSelected() throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkhoverunderlinepresent, waitTime);
            if (chkhoverunderlinepresent.isSelected()) {
            	flag = true;
            }
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING ON THE  'alwaysundercheckbox'" + "\n METHOD:isHoverUnderLinedCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * Methods helps to click on AlwaysUnderlined Checkbox
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */
    public CourseAdminStyleManagerPage clickOnHoverUnderLinedCheckbox() throws Exception {

        try {
            logInstruction("LOG INSTRUCTION :WAIT FOR CHECKBOX TO CLICK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(chkhoverunderlinepresent, waitTime);
            chkhoverunderlinepresent.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE  'checkbox'" + "\n METHOD:clickOnHoverUnderLinedCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

    /**
     * Methods helps to find whether Link Color checkbox are present( )
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isLinkColorCheckboxPresent(String checkboxname) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chklinkcolorpresent.replaceValues(checkboxname);
            chklinkcolorpresent.isDisplayedAfterWaiting(waitTime);
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  THE  'ColorCheckbox'" + "\n METHOD:isLinkColorCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Methods helps to find whether Link Color checkbox is selected( )
     * 
     * @category Milestone 2
     * @author Raghav
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isLinkColorCheckboxSelected(String checkboxname) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:wait for checkbox");
            frameSwitch.switchToFrameContent();
            chklinkcolorpresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chklinkcolorpresent, waitTime);
            chklinkcolorpresent.isSelected();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  THE  'ColorCheckbox'" + "\n METHOD:isLinkColorCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Methods helps to click on given checkbox of Link color style
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public CourseAdminStyleManagerPage clickOnLinkColorCheckbox(String checkboxname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR CHECKBOX TO CLICK");
            frameSwitch.switchToFrameContent();
            chklinkcolorpresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chklinkcolorpresent, waitTime);
            chklinkcolorpresent.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING THE ' checkbox'" + "\n METHOD:clickOnLinkColorCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Methods helps to find whether font size checkbox are present( )
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isFontSizeCheckboxPresent(String checkboxname) throws Exception {
        
        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkfontsizepresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chkfontsizepresent, waitTime);
            chkfontsizepresent.isDisplayedAfterWaiting(waitTime);
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  THE  'FontSizeCheckbox'" + "\n METHOD:isFontSizeCheckboxPresent \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Methods helps to find whether font size checkbox is Selected
     * 
     * @category Milestone 2
     * @author Raghav S
     * @param String
     * @return boolean
     * @throws Exception
     */

    public boolean isFontSizeCheckboxSelected(String checkboxname) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION:WAIT FOR CHECKBOX");
            frameSwitch.switchToFrameContent();
            chkfontsizepresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chkfontsizepresent, waitTime);
            chkfontsizepresent.isSelected();
            flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING  THE  'FontSizeCheckbox'" + "\n METHOD:isFontSizeCheckboxSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * Methods helps to click on given Checkbox of font Size style
     * 
     * @category Milestone 2
     * @author amit.deshmukh
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public CourseAdminStyleManagerPage clickOnFontSizeCheckbox(String checkboxname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :wait for checkbox to click");
            frameSwitch.switchToFrameContent();
            chkfontsizepresent.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(chkfontsizepresent, waitTime);
            chkfontsizepresent.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON THE 'checkbox'" + "\n METHOD:clickOnFontSizeCheckbox \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Methods helps to Get the Title
     * 
     * @category Milestone 2
     * @author Raghav
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public String getTitle() throws Exception {
         strTitle = null;
        try {
            logInstruction("LOG INSTRUCTION :GETTING THE TITLE");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(gettitle, waitTime);
            strTitle = gettitle.getText().trim();

        } catch (Exception e) {
            throw new Exception("ISSUE IN GETTING THE ' title'" + "\n METHOD:getTitle \n" + e
                    .getLocalizedMessage());
        }
        return strTitle;

    }

    /**
     * Methods helps to click on given Checkbox of in design theme
     * 
     * @category Milestone 2
     * @author Raghav
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public CourseAdminStyleManagerPage clickDesignThemeRadioButton(String checkboxname)
            throws Exception {
        try {
            logInstruction("LOG INSTRUCTION :SELECTING THE RADIO BUTTON");
            frameSwitch.switchToFrameContent();
            raddesign.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(raddesign, waitTime);
            raddesign.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE 'radiobtn'" + "\n METHOD:clickDesignThemeRadioButton \n" + e
                            .getLocalizedMessage());
        }
        return this;

    }

    /**
     * Methods helps to click on given Checkbox of in design theme
     * 
     * @category Milestone 2
     * @author Raghav
     * @param String
     * @return {@link CourseAdminStyleManagerPage}
     * @throws Exception
     */

    public boolean isDesignThemeRadioButtonSelected(String checkboxname) throws Exception {
       
        try {
            logInstruction("LOG INSTRUCTION :VERIFIES A RADIO IS SELECTED");
            frameSwitch.switchToFrameContent();
            raddesign.replaceValues(checkboxname);
            uiDriver.waitToBeDisplayed(raddesign, waitTime);
            if (raddesign.isSelected())
                flag = true;

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN VERIFYING THE RADIO BUTTON" + "\n METHOD:isDesignThemeRadioButtonSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;

    }

    /**
     * This method is used to select any style and color
     * 
     * @author Pratush.Manglik
     * @param color
     *            Enter name of the color Example: Green,Purple,Gold
     * @param style
     *            enter the name of style Ex: Stripes, Swirl,No Backgraound
     * @returnCourseAdminStyleManagerPage
     * @throws Exception
     */
    public boolean isSelectColorThemeSelected(String color, String style) throws Exception {
        
        logInstruction("LOG INSTRUCTION:THIS SELECTS THE COLOR AND STYLES");
        try {
            frameSwitch.switchToFrameContent();
            radValue.replaceValues(color, style);
            uiDriver.waitToBeDisplayed(radValue, waitTime);
            if (radValue.isSelected())
            	flag = true;
        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN SELECTING THE ' style'" + "\n METHOD:isSelectColorThemeSelected \n" + e
                            .getLocalizedMessage());
        }
        return flag;
    }

    /**
     * This method is used to select Fonts
     * 
     * @author kiran.kumar
     * @category Milestone 2
     * @return CourseAdminStyleManagerPage
     * @throws Exception
     */
    public CourseAdminStyleManagerPage clickFontLink() throws Exception {
        try {
            logInstruction("LOG INSTRUCTION:CLICKING ON FONT LINK");
            frameSwitch.switchToFrameContent();
            uiDriver.waitToBeDisplayed(lnkfont, waitTime);
            lnkfont.clickAndWait(waitTime);

        } catch (Exception e) {
            throw new Exception(
                    "ISSUE IN CLICKING ON ' Font Link'" + "\n METHOD:clickFontLink \n" + e
                            .getLocalizedMessage());
        }
        return this;
    }

}
