/**
 *  Copyright 2014-16 by Riccardo Massera (TheCoder4.Eu) and Stephan Rauh (http://www.beyondjava.net).
 *  
 *  This file is part of BootsFaces.
 *  
 *  BootsFaces is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  BootsFaces is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with BootsFaces. If not, see <http://www.gnu.org/licenses/>.
 */

package net.bootsfaces.component.messages;

import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;

import net.bootsfaces.component.AttributeMapWrapper;

/**
 * 
 * <p>
 * By default, the <code>rendererType</code> property must be set to
 * "<code>javax.faces.Messages</code>". This value can be changed by calling the
 * <code>setRendererType()</code> method.
 * </p>
 */
@ResourceDependencies({ @ResourceDependency(library = "bsf", name = "css/core.css", target = "head"),
		@ResourceDependency(library = "bsf", name = "css/alerts.css", target = "head"),
		@ResourceDependency(library = "bsf", name = "js/alert.js", target = "body"),
		@ResourceDependency(library = "bsf", name = "css/tooltip.css", target = "head") })
@FacesComponent("net.bootsfaces.component.Messages")
public class Messages extends javax.faces.component.UIMessages {

	private Map<String, Object> attributes;

	public Messages() {
		super();
		setRendererType("net.bootsfaces.component.MessagesRenderer");
	}

	@Override
	public Map<String, Object> getAttributes() {
		if (attributes == null)
			attributes = new AttributeMapWrapper(this, super.getAttributes());
		return attributes;
	}

	protected enum PropertyKeys {
		dir, errorClass, errorStyle, escape, fatalClass, fatalStyle, globalOnly, infoClass, infoStyle, showDetail, showSummary, style, styleClass, tooltip, tooltipContainer, tooltipDelay, tooltipDelayHide, tooltipDelayShow, tooltipPosition, warnClass, warnStyle;

		String toString;

		PropertyKeys(String toString) {
			this.toString = toString;
		}

		PropertyKeys() {
		}

		public String toString() {
			return ((this.toString != null) ? this.toString : super.toString());
		}
	}

	/**
	 * HTML: The direction of text display, either 'ltr' (left-to-right) or
	 * 'rtl' (right-to-left).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getDir() {
		String value = (String) getStateHelper().eval(PropertyKeys.dir);
		return value;
	}

	/**
	 * HTML: The direction of text display, either 'ltr' (left-to-right) or
	 * 'rtl' (right-to-left).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setDir(String _dir) {
		getStateHelper().put(PropertyKeys.dir, _dir);
	}

	/**
	 * CSS class to be used for messages with severity "ERROR".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getErrorClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.errorClass);
		return value;
	}

	/**
	 * CSS class to be used for messages with severity "ERROR".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setErrorClass(String _errorClass) {
		getStateHelper().put(PropertyKeys.errorClass, _errorClass);
	}

	/**
	 * CSS style to be used for messages with severity "ERROR".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getErrorStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.errorStyle);
		return value;
	}

	/**
	 * CSS style to be used for messages with severity "ERROR".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setErrorStyle(String _errorStyle) {
		getStateHelper().put(PropertyKeys.errorStyle, _errorStyle);
	}

	/**
	 * By default, error messages encode HTML and JavaScript code. Instead of
	 * being executed, the source code is displayed. This protects you against
	 * hacker attacks. By setting escape=false, you deactivate the protection,
	 * and allow HTML and JavaScript code to be rendered.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isEscape() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.escape, true);
		return (boolean) value;
	}

	/**
	 * By default, error messages encode HTML and JavaScript code. Instead of
	 * being execute, the source code is displayed. This protects you against
	 * hacker attacks. By setting escape=false, you deactivate the protection,
	 * and allow HTML and JavaScript code to be rendered.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setEscape(boolean _escape) {
		getStateHelper().put(PropertyKeys.escape, _escape);
	}

	/**
	 * CSS class to be used for messages with severity "FATAL".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getFatalClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.fatalClass);
		return value;
	}

	/**
	 * CSS class to be used for messages with severity "FATAL".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setFatalClass(String _fatalClass) {
		getStateHelper().put(PropertyKeys.fatalClass, _fatalClass);
	}

	/**
	 * CSS style to be used for messages with severity "FATAL".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getFatalStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.fatalStyle);
		return value;
	}

	/**
	 * CSS style to be used for messages with severity "FATAL".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setFatalStyle(String _fatalStyle) {
		getStateHelper().put(PropertyKeys.fatalStyle, _fatalStyle);
	}

	/**
	 * Specifies whether only messages (FacesMessage objects) not associated
	 * with a specific component should be displayed, ie whether messages should
	 * be ignored if they are attached to a particular component. Defaults to
	 * false.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isGlobalOnly() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.globalOnly, false);
		return (boolean) value;
	}

	/**
	 * Specifies whether only messages (FacesMessage objects) not associated
	 * with a specific component should be displayed, ie whether messages should
	 * be ignored if they are attached to a particular component. Defaults to
	 * false.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setGlobalOnly(boolean _globalOnly) {
		getStateHelper().put(PropertyKeys.globalOnly, _globalOnly);
	}

	/**
	 * CSS class to be used for messages with severity "INFO".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getInfoClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.infoClass);
		return value;
	}

	/**
	 * CSS class to be used for messages with severity "INFO".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setInfoClass(String _infoClass) {
		getStateHelper().put(PropertyKeys.infoClass, _infoClass);
	}

	/**
	 * CSS style to be used for messages with severity "INFO".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getInfoStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.infoStyle);
		return value;
	}

	/**
	 * CSS style to be used for messages with severity "INFO".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setInfoStyle(String _infoStyle) {
		getStateHelper().put(PropertyKeys.infoStyle, _infoStyle);
	}

	/**
	 * Specifies whether the detailed information from the message should be
	 * shown. Default to false.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isShowDetail() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.showDetail, true);
		return (boolean) value;
	}

	/**
	 * Specifies whether the detailed information from the message should be
	 * shown. Default to false.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setShowDetail(boolean _showDetail) {
		getStateHelper().put(PropertyKeys.showDetail, _showDetail);
	}

	/**
	 * Specifies whether the summary information from the message should be
	 * shown. Defaults to true.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public boolean isShowSummary() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.showSummary, true);
		return (boolean) value;
	}

	/**
	 * Specifies whether the summary information from the message should be
	 * shown. Defaults to true.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setShowSummary(boolean _showSummary) {
		getStateHelper().put(PropertyKeys.showSummary, _showSummary);
	}

	/**
	 * HTML: CSS styling instructions.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.style);
		return value;
	}

	/**
	 * HTML: CSS styling instructions.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setStyle(String _style) {
		getStateHelper().put(PropertyKeys.style, _style);
	}

	/**
	 * The CSS class for this element. Corresponds to the HTML 'class'
	 * attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getStyleClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.styleClass);
		return value;
	}

	/**
	 * The CSS class for this element. Corresponds to the HTML 'class'
	 * attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setStyleClass(String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	/**
	 * If true, the message summary will be rendered as a tooltip (i.e. HTML
	 * title attribute).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTooltip() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltip);
		return value;
	}

	/**
	 * If true, the message summary will be rendered as a tooltip (i.e. HTML
	 * title attribute).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltip(String _tooltip) {
		getStateHelper().put(PropertyKeys.tooltip, _tooltip);
	}

	/**
	 * Where is the tooltip div generated? That's primarily a technical value
	 * that can be used to fix rendering error in special cases. Also see
	 * data-container in the documentation of Bootstrap. The default value is
	 * body.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTooltipContainer() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltipContainer, "body");
		return value;
	}

	/**
	 * Where is the tooltip div generated? That's primarily a technical value
	 * that can be used to fix rendering error in special cases. Also see
	 * data-container in the documentation of Bootstrap. The default value is
	 * body.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipContainer(String _tooltipContainer) {
		getStateHelper().put(PropertyKeys.tooltipContainer, _tooltipContainer);
	}

	/**
	 * The tooltip is shown and hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelay() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelay, 0);
		return (int) value;
	}

	/**
	 * The tooltip is shown and hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelay(int _tooltipDelay) {
		getStateHelper().put(PropertyKeys.tooltipDelay, _tooltipDelay);
	}

	/**
	 * The tooltip is hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelayHide() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelayHide, 0);
		return (int) value;
	}

	/**
	 * The tooltip is hidden with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelayHide(int _tooltipDelayHide) {
		getStateHelper().put(PropertyKeys.tooltipDelayHide, _tooltipDelayHide);
	}

	/**
	 * The tooltip is shown with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public int getTooltipDelayShow() {
		Integer value = (Integer) getStateHelper().eval(PropertyKeys.tooltipDelayShow, 0);
		return (int) value;
	}

	/**
	 * The tooltip is shown with a delay. This value is the delay in
	 * milliseconds. Defaults to 0 (no delay).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipDelayShow(int _tooltipDelayShow) {
		getStateHelper().put(PropertyKeys.tooltipDelayShow, _tooltipDelayShow);
	}

	/**
	 * Where is the tooltip to be displayed? Possible values: "top", "bottom",
	 * "right", "left", "auto", "auto top", "auto bottom", "auto right" and
	 * "auto left". Default to "bottom".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getTooltipPosition() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltipPosition);
		return value;
	}

	/**
	 * Where is the tooltip to be displayed? Possible values: "top", "bottom",
	 * "right", "left", "auto", "auto top", "auto bottom", "auto right" and
	 * "auto left". Default to "bottom".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setTooltipPosition(String _tooltipPosition) {
		getStateHelper().put(PropertyKeys.tooltipPosition, _tooltipPosition);
	}

	/**
	 * CSS class to be used for messages with severity "WARN".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getWarnClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.warnClass);
		return value;
	}

	/**
	 * CSS class to be used for messages with severity "WARN".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setWarnClass(String _warnClass) {
		getStateHelper().put(PropertyKeys.warnClass, _warnClass);
	}

	/**
	 * CSS style to be used for messages with severity "WARN".
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	public String getWarnStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.warnStyle);
		return value;
	}

	/**
	 * CSS style to be used for messages with severity "WARN".
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	public void setWarnStyle(String _warnStyle) {
		getStateHelper().put(PropertyKeys.warnStyle, _warnStyle);
	}

}
