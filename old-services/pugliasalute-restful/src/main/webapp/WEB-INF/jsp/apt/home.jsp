<%@include file="../init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %> 

<style>
.annullato{
	background-color: #FFD6D6 !important;
}
</style>

<liferay-ui:search-container searchContainer="${ aptSearchContainer }" >

	<liferay-ui:search-container-results
		results="${ aptSearchContainer.results }"
		total="${ aptSearchContainer.total }" >
		

		<liferay-ui:search-container-row
			className="it.sincon.sanita.services.beans.atp.DatiAttoJAXB"
			keyProperty="numeroRepertorio"
			modelVar="atto">
			
			<%
			SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
			Date dataPubbl = sdfInput.parse(atto.dataPubblicazione);
			Date dataAnnul = null;
			SimpleDateFormat sdfOutput = new SimpleDateFormat("dd/MM/yyyy");
			
			String classeCss = "";
			if (atto.stato.equals("annul") ) { 
				classeCss = "annullato";
				dataAnnul = sdfInput.parse(atto.dataAnnullamento);
			}
			
			%>
			
			<liferay-ui:search-container-column-text name="numero" property="numero" orderable="true" cssClass="<%= classeCss %>"/>
			<liferay-ui:search-container-column-text name="proponente" property="proponente" orderable="true" cssClass="<%= classeCss %>"/>
			<liferay-ui:search-container-column-text name="tipoItem" property="tipoItem" orderable="true" cssClass="<%= classeCss %>"/>
			<liferay-ui:search-container-column-text name="oggetto" property="oggetto" cssClass="<%= classeCss %>"/>
			<liferay-ui:search-container-column-text name="dataPubblicazione" orderableProperty="dataPubblicazione" orderable="true" cssClass="<%= classeCss %>">
				<%-- <c:out value="<%= atto.dataPubblicazione%>"/>
				<c:if test="<%= classeCss.equals("annullato")%>">
					<div style="color: red;">
					  <b><br/>ANNULLATO IL <%= atto.dataAnnullamento%></b>
					</DIV>
				</c:if> --%>
				<c:out value="<%= sdfOutput.format(dataPubbl) %>"/>
				<c:if test="<%= classeCss.equals("annullato")%>">
					<div style="color: red;">
					  <b><br/>ANNULLATO IL <%= sdfOutput.format(dataAnnul) %></b>
					</DIV>
				</c:if>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="linkDettaglio" href="<%= atto.linkDettaglio %>" value="Dettaglio" cssClass="<%= classeCss %>">
				<img src="<%=request.getContextPath() %>/images/dettaglio.png">
			</liferay-ui:search-container-column-text>
			
		</liferay-ui:search-container-row>

	</liferay-ui:search-container-results>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

