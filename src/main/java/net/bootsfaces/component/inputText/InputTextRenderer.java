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

package net.bootsfaces.component.inputText;

import java.io.IOException;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;

import net.bootsfaces.C;
import net.bootsfaces.component.ajax.AJAXRenderer;
import net.bootsfaces.component.icon.Icon;
import net.bootsfaces.component.inputSecret.InputSecret;
import net.bootsfaces.render.CoreRenderer;
import net.bootsfaces.render.H;
import net.bootsfaces.render.R;
import net.bootsfaces.render.Tooltip;

@FacesRenderer(componentFamily = C.BSFCOMPONENT, rendererType = "net.bootsfaces.component.InputTextRenderer")
public class InputTextRenderer extends CoreRenderer {

	@Override
	public void decode(FacesContext context, UIComponent component) {
		InputText inputText = (InputText) component;

		if (inputText.isDisabled() || inputText.isReadonly()) {
			return;
		}

		decodeBehaviors(context, inputText);

		String clientId = inputText.getClientId(context);
		String name = clientId;
		String submittedValue = (String) context.getExternalContext().getRequestParameterMap().get(name);

		if (submittedValue != null) {
			inputText.setSubmittedValue(submittedValue);
		}
		new AJAXRenderer().decode(context, component, name);
	}

	/**
	 * This method is called by the JSF framework to get the type-safe value of
	 * the attribute. Do not delete this method.
	 */
	@Override
	public Object getConvertedValue(FacesContext fc, UIComponent c, Object sval) throws ConverterException {
		Converter cnv = resolveConverter(fc, c);

		if (cnv != null) {
			return cnv.getAsObject(fc, c, (String) sval);
		} else {
			return sval;
		}
	}

	protected Converter resolveConverter(FacesContext context, UIComponent c) {
		if (!(c instanceof ValueHolder)) {
			return null;
		}

		Converter cnv = ((ValueHolder) c).getConverter();

		if (cnv != null) {
			return cnv;
		} else {
			ValueExpression ve = c.getValueExpression("value");

			if (ve != null) {
				Class<?> valType = ve.getType(context.getELContext());

				if (valType != null) {
					return context.getApplication().createConverter(valType);
				}
			}

			return null;
		}
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if (!component.isRendered()) {
			return;
		}
		InputText inputText = (InputText) component;

		ResponseWriter rw = context.getResponseWriter();
		String clientId = inputText.getClientId();

		int span = inputText.getSpan();
		if (span > 0) {
			rw.startElement("div", component);
			rw.writeAttribute("class", "col-md-" + span, "class");
		}

		// "Prepend" facet
		UIComponent prep = inputText.getFacet("prepend");
		// "Append" facet
		UIComponent app = inputText.getFacet("append");
		boolean prepend = (prep != null);
		boolean append = (app != null);

		String label = inputText.getLabel();
		{
			if (!inputText.isRenderLabel()) {
				label = null;
			}
		}

		// Define TYPE ( if null set default = text )
		// support for b:inputSecret
		String t;
		if (component instanceof InputSecret) {
			t = "password";
		} else { // ordinary input fields
			t = inputText.getType();
			if (t == null)
				t = "text";
		}

		rw.startElement("div", component);
		if (null != inputText.getDir()) {
			rw.writeAttribute("dir", inputText.getDir(), "dir");
		}

		Tooltip.generateTooltip(context, inputText, rw);
		rw.writeAttribute("id", clientId, "id");
		if (inputText.isInline()) {
			rw.writeAttribute("class", "form-inline", "class");

		} else {
			rw.writeAttribute("class", "form-group", "class");
		}

		if (label != null) {
			rw.startElement("label", component);
			rw.writeAttribute("for", "input_" + clientId, "for");
			generateErrorAndRequiredClass(inputText, rw, clientId);

			rw.writeText(label, null);
			rw.endElement("label");
		}

		if (append || prepend) {
			rw.startElement("div", component);
			rw.writeAttribute("class", "input-group", "class");
		}

		if (prepend) {
			if (prep.getClass().getName().endsWith("Button") || (prep.getChildCount() > 0
					&& prep.getChildren().get(0).getClass().getName().endsWith("Button"))) {
				rw.startElement("div", inputText);
				rw.writeAttribute("class", "input-group-btn", "class");
				prep.encodeAll(context);
				rw.endElement("div");
			} else {
				if (prep instanceof Icon)
					((Icon) prep).setAddon(true); // modifies the id of the icon
				rw.startElement("span", inputText);
				rw.writeAttribute("class", "input-group-addon", "class");
				prep.encodeAll(context);
				rw.endElement("span");
			}
		}

		// Input
		rw.startElement("input", inputText);
		rw.writeAttribute("id", "input_" + clientId, null);
		rw.writeAttribute("name", clientId, null);
		rw.writeAttribute("type", t, null);

		generateStyleClass(inputText, rw);

		String ph = inputText.getPlaceholder();
		if (ph != null) {
			rw.writeAttribute("placeholder", ph, null);
		}

		if (inputText.isDisabled()) {
			rw.writeAttribute("disabled", "disabled", null);
		}
		if (inputText.isReadonly()) {
			rw.writeAttribute("readonly", "readonly", null);
		}

		// Encode attributes (HTML 4 pass-through + DHTML)
		renderPassThruAttributes(context, component, H.INPUT_TEXT);

		String autocomplete = inputText.getAutocomplete();
		if ((autocomplete != null) && (autocomplete.equals("off"))) {
			rw.writeAttribute("autocomplete", "off", null);
		}

		String v = getValue2Render(context, component);
		rw.writeAttribute("value", v, null);

		// Render Ajax Capabilities
		AJAXRenderer.generateBootsFacesAJAXAndJavaScript(FacesContext.getCurrentInstance(), inputText, rw);

		rw.endElement("input");
		if (append) {
			if (app.getClass().getName().endsWith("Button")
					|| (app.getChildCount() > 0 && app.getChildren().get(0).getClass().getName().endsWith("Button"))) {
				rw.startElement("div", inputText);
				rw.writeAttribute("class", "input-group-btn", "class");
				app.encodeAll(context);
				rw.endElement("div");
			} else {
				if (app instanceof Icon)
					((Icon) app).setAddon(true);
				rw.startElement("span", inputText);
				rw.writeAttribute("class", "input-group-addon", "class");
				app.encodeAll(context);
				rw.endElement("span");
			}
		}

		if (append || prepend) {
			rw.endElement("div");
		} // input-group
		rw.endElement("div"); // form-group
		if (span > 0) {
			rw.endElement("div"); // span
		}

		Tooltip.activateTooltips(context, inputText);
	}

	private void generateStyleClass(InputText inputText, ResponseWriter rw) throws IOException {
		StringBuilder sb;
		String s;
		sb = new StringBuilder(20); // optimize int
		sb.append("form-control");

		String fsize = inputText.getFieldSize();

		if (fsize != null) {
			sb.append(" input-").append(fsize);
		}

		// styleClass and class support
		String sclass = inputText.getStyleClass();
		if (sclass != null) {
			sb.append(" ").append(sclass);
		}

		sb.append(" ").append(getErrorAndRequiredClass(inputText, inputText.getClientId()));
		s = sb.toString().trim();
		if (s != null && s.length() > 0) {
			rw.writeAttribute("class", s, "class");
		}
	}
}
