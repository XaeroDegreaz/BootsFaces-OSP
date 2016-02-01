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

package net.bootsfaces.component.dropButton;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import net.bootsfaces.render.CoreRenderer;
import net.bootsfaces.render.Tooltip;

/** This class generates the HTML code of &lt;b:dropButton /&gt;. */
@FacesRenderer(componentFamily = "net.bootsfaces.component", rendererType = "net.bootsfaces.component.dropButton.DropButton")
public class DropButtonRenderer extends CoreRenderer {

	/**
	 * This methods generates the HTML code of the current b:dropButton.
	 * <code>encodeBegin</code> generates the start of the component. After the,
	 * the JSF framework calls <code>encodeChildren()</code> to generate the
	 * HTML code between the beginning and the end of the component. For
	 * instance, in the case of a panel component the content of the panel is
	 * generated by <code>encodeChildren()</code>. After that,
	 * <code>encodeEnd()</code> is called to generate the rest of the HTML code.
	 * 
	 * @param context
	 *            the FacesContext.
	 * @param component
	 *            the current b:dropButton.
	 * @throws IOException
	 *             thrown if something goes wrong when writing the HTML code.
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if (!component.isRendered()) {
			return;
		}
		DropButton dropButton = (DropButton) component;
		ResponseWriter rw = context.getResponseWriter();

		rw.startElement("div", dropButton);
		String clientId = dropButton.getClientId(context);
		rw.writeAttribute("id", clientId, "id");
		rw.writeAttribute("name", clientId, "name");
		String styleClass = getStyleclass(dropButton);
		rw.writeAttribute("class", styleClass, "class");
		writeAttribute(rw, "style", dropButton.getStyle(), "style");
		Tooltip.generateTooltip(context, dropButton, rw);

		String ts = "btn btn-";
		String look = dropButton.getLook();
		if (look != null) {
			ts += look + " ";
		} else {
			ts += "default ";
		}
		String size = dropButton.getSize();
		if (size != null) {
			ts += "btn-" + size + " ";
		}
		String value = (String) dropButton.getAttributes().get("value");

		{
			rw.startElement("button", dropButton);
			rw.writeAttribute("id", "dtL" + clientId, "id");
			rw.writeAttribute("class", ts + "dropdown-toggle", "class");
			if ("button".equals("button")) {
				rw.writeAttribute("type", "button", null);
			} else {
				rw.writeAttribute("href", "#", null);
			}
			rw.writeAttribute("role", "button", null);
			rw.writeAttribute("data-toggle", "dropdown", null);

			// Encode value
			rw.writeText(value, null);
			// Encode Caret
			{
				rw.startElement("b", dropButton);
				rw.writeAttribute("class", "caret", "class");
				rw.endElement("b");
			}
			rw.endElement("button");
		}
		{
			rw.startElement("ul", dropButton);
			rw.writeAttribute("class", "dropdown-menu", "class");
			rw.writeAttribute("role", "menu", null);
			rw.writeAttribute("aria-labelledby", "dtL" + clientId, null);
		}
	}

	private String getStyleclass(DropButton dropButton) {
		String direction = getDirection(dropButton);
		String styleClass = "btn-group";
		if (direction.equals("up")) {
			styleClass += " drop" + direction;
		}
		if (dropButton.getStyleClass() != null) {
			styleClass += " " + dropButton.getStyleClass();
		}
		return styleClass;
	}

	private String getDirection(DropButton dropButton) {
		String direction = dropButton.getDrop();
		if (direction == null) {
			direction = "down";
		}
		if (!direction.equals("up") && !direction.equals("down")) {
			direction = "down";
		}
		return direction;
	}

	/**
	 * This methods generates the HTML code of the current b:dropButton.
	 * <code>encodeBegin</code> generates the start of the component. After the,
	 * the JSF framework calls <code>encodeChildren()</code> to generate the
	 * HTML code between the beginning and the end of the component. For
	 * instance, in the case of a panel component the content of the panel is
	 * generated by <code>encodeChildren()</code>. After that,
	 * <code>encodeEnd()</code> is called to generate the rest of the HTML code.
	 * 
	 * @param context
	 *            the FacesContext.
	 * @param component
	 *            the current b:dropButton.
	 * @throws IOException
	 *             thrown if something goes wrong when writing the HTML code.
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		if (!component.isRendered()) {
			return;
		}
		DropButton dropButton = (DropButton) component;
		ResponseWriter rw = context.getResponseWriter();
		rw.endElement("ul");
		rw.endElement("li");

		rw.endElement("div"); // btn-group
		Tooltip.activateTooltips(context, dropButton);
	}

}
