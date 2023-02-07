package it.sincon.gepred.web.portlet.varie;


import javax.portlet.PortletSession;


import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.TableDecorator;
import org.displaytag.model.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortletSessionDecorator extends TableDecorator {
	private static Logger log = LoggerFactory.getLogger( PortletSessionDecorator.class );

//	@Override
	public void init(PageContext pageContext, Object decorated,
			TableModel tableModel) {

		log.debug(String.format("Table id:%s Table rows :%s",
				tableModel.getId(), tableModel.getRowListFull().size()));

		PortletSession pSession = (PortletSession) pageContext.getAttribute(
				"portletSession", PageContext.PAGE_SCOPE);
		pSession.setAttribute(tableModel.getId(), tableModel,
				PortletSession.APPLICATION_SCOPE);

		// ---------------- End portlet logic
		// -----------------------------------

		super.init(pageContext, decorated, tableModel);
	}


	
}
