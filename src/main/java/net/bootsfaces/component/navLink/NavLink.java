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

package net.bootsfaces.component.navLink;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.html.HtmlOutcomeTargetLink;

import net.bootsfaces.C;
import net.bootsfaces.component.AttributeMapWrapper;
import net.bootsfaces.component.ajax.IAJAXComponent;
import net.bootsfaces.listeners.AddResourcesListener;
import net.bootsfaces.render.Tooltip;

/** This class holds the attributes of &lt;b:navLink /&gt;. */
@ResourceDependencies({ @ResourceDependency(library = "bsf", name = "css/core.css", target = "head"),
		@ResourceDependency(library = "javax.faces", name = "jsf.js", target = "head"),
		@ResourceDependency(library = "bsf", name = "js/bsf.js", target = "head"),
		@ResourceDependency(library = "bsf", name = "css/tooltip.css", target = "head") })
@FacesComponent("net.bootsfaces.component.navLink.NavLink")
public class NavLink extends HtmlOutcomeTargetLink implements ClientBehaviorHolder, net.bootsfaces.render.IHasTooltip, IAJAXComponent, AbstractNavLink {

	public static final String COMPONENT_TYPE = "net.bootsfaces.component.navLink.NavLink";

	public static final String COMPONENT_FAMILY = "net.bootsfaces.component";

	public static final String DEFAULT_RENDERER = "net.bootsfaces.component.navLink.NavLink";

	private AttributeMapWrapper attributes;

	public NavLink() {
		Tooltip.addResourceFile();
		AddResourcesListener.addResourceToHeadButAfterJQuery(C.BSF_LIBRARY, "jq/jquery.js");
		setRendererType(DEFAULT_RENDERER);
	}

	@Override
	public Map<String, Object> getAttributes() {
		if (attributes == null)
			attributes = new AttributeMapWrapper(this, super.getAttributes());
		return attributes;
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	@Override
	public boolean getRendersChildren() {
		return true;
	}

	protected enum PropertyKeys {
		active, ajax, binding, contentClass, contentStyle, disabled, fragment, header, href, icon, iconAlign, iconAwesome, immediate, includeViewParams, onblur, onchange, onclick, oncomplete, ondblclick, onfocus, onkeydown, onkeypress, onkeyup, onmousedown, onmousemove, onmouseout, onmouseover, onmouseup, onselect, outcome, process, style, styleClass, tooltip, tooltipContainer, tooltipDelay, tooltipDelayHide, tooltipDelayShow, tooltipPosition, update;

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

	private static final Collection<String> EVENT_NAMES = Collections
			.unmodifiableCollection(Arrays.asList("blur", "change", "click", "dblclick", "focus", "keydown", "keypress",
					"keyup", "mousedown", "mousemove", "mouseout", "mouseover", "mouseup", "select"));

	/**
	 * returns the subset of AJAX requests that are implemented by jQuery
	 * callback or other non-standard means (such as the onclick event of
	 * b:tabView, which has to be implemented manually).
	 * 
	 * @return
	 */
	@Override
	public Map<String, String> getJQueryEvents() {
		return null;
	}

	@Override
	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	@Override
	public String getDefaultEventName() {
		return "click";
	}

	/**
	 * Adds the active state to the link.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public boolean isActive() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.active, false);
		return (boolean) value;
	}

	/**
	 * Adds the active state to the link.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setActive(boolean _active) {
		getStateHelper().put(PropertyKeys.active, _active);
	}

	/**
	 * Whether the Button submits the form with AJAX.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public boolean isAjax() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.ajax, false);
		return (boolean) value;
	}

	/**
	 * Whether the Button submits the form with AJAX.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setAjax(boolean _ajax) {
		getStateHelper().put(PropertyKeys.ajax, _ajax);
	}

	/**
	 * An el expression referring to a server side UIComponent instance in a
	 * backing bean.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public javax.faces.component.UIComponent getBinding() {
		javax.faces.component.UIComponent value = (javax.faces.component.UIComponent) getStateHelper()
				.eval(PropertyKeys.binding);
		return value;
	}

	/**
	 * An el expression referring to a server side UIComponent instance in a
	 * backing bean.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setBinding(javax.faces.component.UIComponent _binding) {
		getStateHelper().put(PropertyKeys.binding, _binding);
	}

	/**
	 * contentClass is optional: if specified, the content (i.e. the anchor tag)
	 * will be displayed with this specific class
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getContentClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.contentClass);
		return value;
	}

	/**
	 * contentClass is optional: if specified, the content (i.e. the anchor tag)
	 * will be displayed with this specific class
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setContentClass(String _contentClass) {
		getStateHelper().put(PropertyKeys.contentClass, _contentClass);
	}

	/**
	 * Inline style of the content area (i.e the anchor tag).
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getContentStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.contentStyle);
		return value;
	}

	/**
	 * Inline style of the content area (i.e the anchor tag).
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setContentStyle(String _contentStyle) {
		getStateHelper().put(PropertyKeys.contentStyle, _contentStyle);
	}

	/**
	 * The fragment that is to be appended to the target URL. The # separator is
	 * applied automatically and needs not be included.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getFragment() {
		String value = (String) getStateHelper().eval(PropertyKeys.fragment);
		return value;
	}

	/**
	 * The fragment that is to be appended to the target URL. The # separator is
	 * applied automatically and needs not be included.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setFragment(String _fragment) {
		getStateHelper().put(PropertyKeys.fragment, _fragment);
	}

	/**
	 * If present, this element is rendered as Header in a menu with the text
	 * specifide by this attribute value: all other attributes will be ignored.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getHeader() {
		String value = (String) getStateHelper().eval(PropertyKeys.header);
		return value;
	}

	/**
	 * If present, this element is rendered as Header in a menu with the text
	 * specifide by this attribute value: all other attributes will be ignored.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setHeader(String _header) {
		getStateHelper().put(PropertyKeys.header, _header);
	}

	/**
	 * URL to link directly to implement anchor behavior.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getHref() {
		String value = (String) getStateHelper().eval(PropertyKeys.href);
		return value;
	}

	/**
	 * URL to link directly to implement anchor behavior.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setHref(String _href) {
		getStateHelper().put(PropertyKeys.href, _href);
	}

	/**
	 * Navigation Link Icon, can be one of the Bootstrap's Glyphicons icon
	 * names. Alignment can be specified with the iconAlign attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getIcon() {
		String value = (String) getStateHelper().eval(PropertyKeys.icon);
		return value;
	}

	/**
	 * Navigation Link Icon, can be one of the Bootstrap's Glyphicons icon
	 * names. Alignment can be specified with the iconAlign attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setIcon(String _icon) {
		getStateHelper().put(PropertyKeys.icon, _icon);
	}

	/**
	 * Alignment can right or left.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getIconAlign() {
		String value = (String) getStateHelper().eval(PropertyKeys.iconAlign);
		return value;
	}

	/**
	 * Alignment can right or left.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setIconAlign(String _iconAlign) {
		getStateHelper().put(PropertyKeys.iconAlign, _iconAlign);
	}

	/**
	 * Navigation Link Font Awesome Icon, can be one of the Font Awesome icon
	 * names. Alignment can be specified with the iconAlign attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getIconAwesome() {
		String value = (String) getStateHelper().eval(PropertyKeys.iconAwesome);
		return value;
	}

	/**
	 * Navigation Link Font Awesome Icon, can be one of the Font Awesome icon
	 * names. Alignment can be specified with the iconAlign attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setIconAwesome(String _iconAwesome) {
		getStateHelper().put(PropertyKeys.iconAwesome, _iconAwesome);
	}

	/**
	 * Flag indicating that, if this component is activated by the user,
	 * notifications should be delivered to interested listeners and actions
	 * immediately (that is, during Apply Request Values phase) rather than
	 * waiting until Invoke Application phase. Default is false.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public boolean isImmediate() {
		Boolean value = (Boolean) getStateHelper().eval(PropertyKeys.immediate, false);
		return (boolean) value;
	}

	/**
	 * Flag indicating that, if this component is activated by the user,
	 * notifications should be delivered to interested listeners and actions
	 * immediately (that is, during Apply Request Values phase) rather than
	 * waiting until Invoke Application phase. Default is false.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setImmediate(boolean _immediate) {
		getStateHelper().put(PropertyKeys.immediate, _immediate);
	}

    /**
     * <p class="changed_added_2_0">Return whether or not the view
     * parameters should be encoded into the target url.</p>
     *
     * @since 2.0
     */
    @Override
	public boolean isIncludeViewParams() {

        return (Boolean) getStateHelper().eval(PropertyKeys.includeViewParams, false);

    }

    /**
     * <p class="changed_added_2_0">Set whether or not the page
     * parameters should be encoded into the target url.</p>
     *
     * @param includeViewParams The state of the switch for encoding
     * page parameters
     *
     * @since 2.0
     */
    @Override
	public void setIncludeViewParams(boolean includeViewParams) {

        getStateHelper().put(PropertyKeys.includeViewParams, includeViewParams);

    }
    
 	/**
	 * Client side callback to execute when input element loses focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnblur() {
		String value = (String) getStateHelper().eval(PropertyKeys.onblur);
		return value;
	}

	/**
	 * Client side callback to execute when input element loses focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnblur(String _onblur) {
		getStateHelper().put(PropertyKeys.onblur, _onblur);
	}

	/**
	 * Client side callback to execute when input element loses focus and its
	 * value has been modified since gaining focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnchange() {
		String value = (String) getStateHelper().eval(PropertyKeys.onchange);
		return value;
	}

	/**
	 * Client side callback to execute when input element loses focus and its
	 * value has been modified since gaining focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnchange(String _onchange) {
		getStateHelper().put(PropertyKeys.onchange, _onchange);
	}

	/**
	 * The onclick attribute.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnclick() {
		String value = (String) getStateHelper().eval(PropertyKeys.onclick);
		return value;
	}

	/**
	 * The onclick attribute.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnclick(String _onclick) {
		getStateHelper().put(PropertyKeys.onclick, _onclick);
	}

	/**
	 * Javascript to be executed when ajax completes with success.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOncomplete() {
		String value = (String) getStateHelper().eval(PropertyKeys.oncomplete);
		return value;
	}

	/**
	 * Javascript to be executed when ajax completes with success.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOncomplete(String _oncomplete) {
		getStateHelper().put(PropertyKeys.oncomplete, _oncomplete);
	}

	/**
	 * Client side callback to execute when input element is double clicked.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOndblclick() {
		String value = (String) getStateHelper().eval(PropertyKeys.ondblclick);
		return value;
	}

	/**
	 * Client side callback to execute when input element is double clicked.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOndblclick(String _ondblclick) {
		getStateHelper().put(PropertyKeys.ondblclick, _ondblclick);
	}

	/**
	 * Client side callback to execute when input element receives focus.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnfocus() {
		String value = (String) getStateHelper().eval(PropertyKeys.onfocus);
		return value;
	}

	/**
	 * Client side callback to execute when input element receives focus.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnfocus(String _onfocus) {
		getStateHelper().put(PropertyKeys.onfocus, _onfocus);
	}

	/**
	 * Client side callback to execute when a key is pressed down over input
	 * element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnkeydown() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeydown);
		return value;
	}

	/**
	 * Client side callback to execute when a key is pressed down over input
	 * element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnkeydown(String _onkeydown) {
		getStateHelper().put(PropertyKeys.onkeydown, _onkeydown);
	}

	/**
	 * Client side callback to execute when a key is pressed and released over
	 * input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnkeypress() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeypress);
		return value;
	}

	/**
	 * Client side callback to execute when a key is pressed and released over
	 * input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnkeypress(String _onkeypress) {
		getStateHelper().put(PropertyKeys.onkeypress, _onkeypress);
	}

	/**
	 * Client side callback to execute when a key is released over input
	 * element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnkeyup() {
		String value = (String) getStateHelper().eval(PropertyKeys.onkeyup);
		return value;
	}

	/**
	 * Client side callback to execute when a key is released over input
	 * element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnkeyup(String _onkeyup) {
		getStateHelper().put(PropertyKeys.onkeyup, _onkeyup);
	}

	/**
	 * Client side callback to execute when a pointer input element is pressed
	 * down over input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnmousedown() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmousedown);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is pressed
	 * down over input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnmousedown(String _onmousedown) {
		getStateHelper().put(PropertyKeys.onmousedown, _onmousedown);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * within input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnmousemove() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmousemove);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * within input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnmousemove(String _onmousemove) {
		getStateHelper().put(PropertyKeys.onmousemove, _onmousemove);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * away from input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnmouseout() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseout);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * away from input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnmouseout(String _onmouseout) {
		getStateHelper().put(PropertyKeys.onmouseout, _onmouseout);
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * onto input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnmouseover() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseover);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is moved
	 * onto input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnmouseover(String _onmouseover) {
		getStateHelper().put(PropertyKeys.onmouseover, _onmouseover);
	}

	/**
	 * Client side callback to execute when a pointer input element is released
	 * over input element.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnmouseup() {
		String value = (String) getStateHelper().eval(PropertyKeys.onmouseup);
		return value;
	}

	/**
	 * Client side callback to execute when a pointer input element is released
	 * over input element.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnmouseup(String _onmouseup) {
		getStateHelper().put(PropertyKeys.onmouseup, _onmouseup);
	}

	/**
	 * Client side callback to execute when text within input element is
	 * selected by user.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOnselect() {
		String value = (String) getStateHelper().eval(PropertyKeys.onselect);
		return value;
	}

	/**
	 * Client side callback to execute when text within input element is
	 * selected by user.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOnselect(String _onselect) {
		getStateHelper().put(PropertyKeys.onselect, _onselect);
	}

	/**
	 * The outcome to navigate to.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getOutcome() {
		String value = (String) getStateHelper().eval(PropertyKeys.outcome);
		return value;
	}

	/**
	 * The outcome to navigate to.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setOutcome(String _outcome) {
		getStateHelper().put(PropertyKeys.outcome, _outcome);
	}

	/**
	 * Comma or space separated list of ids or search expressions denoting which
	 * values are to be sent to the server.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getProcess() {
		String value = (String) getStateHelper().eval(PropertyKeys.process);
		return value;
	}

	/**
	 * Comma or space separated list of ids or search expressions denoting which
	 * values are to be sent to the server.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setProcess(String _process) {
		getStateHelper().put(PropertyKeys.process, _process);
	}

	/**
	 * Inline style
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getStyle() {
		String value = (String) getStateHelper().eval(PropertyKeys.style);
		return value;
	}

	/**
	 * Inline style
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setStyle(String _style) {
		getStateHelper().put(PropertyKeys.style, _style);
	}

	/**
	 * CSS style class
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getStyleClass() {
		String value = (String) getStateHelper().eval(PropertyKeys.styleClass);
		return value;
	}

	/**
	 * CSS style class
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setStyleClass(String _styleClass) {
		getStateHelper().put(PropertyKeys.styleClass, _styleClass);
	}

	/**
	 * The text of the tooltip.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getTooltip() {
		String value = (String) getStateHelper().eval(PropertyKeys.tooltip);
		return value;
	}

	/**
	 * The text of the tooltip.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
	public void setTooltipPosition(String _tooltipPosition) {
		getStateHelper().put(PropertyKeys.tooltipPosition, _tooltipPosition);
	}

	/**
	 * Component(s) to be updated with ajax.
	 * <P>
	 * 
	 * @return Returns the value of the attribute, or null, if it hasn't been
	 *         set by the JSF file.
	 */
	@Override
	public String getUpdate() {
		String value = (String) getStateHelper().eval(PropertyKeys.update);
		return value;
	}

	/**
	 * Component(s) to be updated with ajax.
	 * <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setUpdate(String _update) {
		getStateHelper().put(PropertyKeys.update, _update);
	}

	/**
	 * Boolean value to specify if the button is disabled. <P>
	 * @return Returns the value of the attribute, or null, if it hasn't been set by the JSF file.
	 */
	@Override
	public boolean isDisabled() {
		Boolean value = (Boolean)getStateHelper().eval(PropertyKeys.disabled, false);
		return (boolean) value;
	}
	
	/**
	 * Boolean value to specify if the button is disabled. <P>
	 * Usually this method is called internally by the JSF engine.
	 */
	@Override
	public void setDisabled(boolean _disabled) {
	    getStateHelper().put(PropertyKeys.disabled, _disabled);
    }

}
