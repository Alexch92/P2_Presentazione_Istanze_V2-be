<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%  
String idAzienda_cfg = portletPreferences.getValue("idAzienda", StringPool.BLANK);
String trasparenza_cfg = portletPreferences.getValue("trasparenza", StringPool.BLANK);
String tipoAtto_cfg = portletPreferences.getValue("tipoAtto", StringPool.BLANK);
String numRisultati_cfg = portletPreferences.getValue("numRisultati", "25");
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

    <!-- Preference control goes here -->
    <aui:select name="preferences--idAzienda--">
    	<aui:option label="Nessuna Selezione" value="" />
    	<aui:option label="ASL BARI" value="aslbari" selected="<%=idAzienda_cfg.equals("aslbari") %>" />
	    <aui:option label="ASL BAT" value="aslbat" selected="<%=idAzienda_cfg.equals("aslbat") %>" />
	    <aui:option label="ASL BRINDISI" value="aslbrindisi" selected="<%=idAzienda_cfg.equals("aslbrindisi") %>" />
	    <aui:option label="ASL FOGGIA" value="aslfoggia" selected="<%=idAzienda_cfg.equals("aslfoggia") %>" />
	    <aui:option label="ASL LECCE" value="asllecce" selected="<%=idAzienda_cfg.equals("asllecce") %>" />
	    <aui:option label="ASL TARANTO" value="asltaranto" selected="<%=idAzienda_cfg.equals("asltaranto") %>" />
	    <aui:option label="AOU Consorziale Policlinico" value="policlinicobari" selected="<%=idAzienda_cfg.equals("policlinicobari") %>" />
	    <aui:option label="AOU Ospedali Riuniti" value="ospedaliriuniti" selected="<%=idAzienda_cfg.equals("ospedaliriuniti") %>" />
	    <aui:option label="IRCCS S. De Bellis" value="sdebellis" selected="<%=idAzienda_cfg.equals("sdebellis") %>" />
	    <aui:option label="ARES" value="ares" selected="<%=idAzienda_cfg.equals("ares") %>" />
	    <aui:option label="Istituto Tumori \"Giovanni Paolo II\" I.R.C.C.S. Bari" value="giovannipaolo" selected="<%=idAzienda_cfg.equals("giovannipaolo") %>" />
	    <aui:option label="Sanitaservice ASL BR" value="saslbr" selected="<%=idAzienda_cfg.equals("saslbr") %>" />
	    
	    
	</aui:select>
	
    <aui:select name="preferences--trasparenza--">
    	<aui:option label="Nessuna Selezione" value="" />
    	<aui:option label="Bandi" value="Bandi" selected="<%=trasparenza_cfg.equals("Bandi") %>" />
	    <aui:option label="Concorsi" value="Concorsi" selected="<%=trasparenza_cfg.equals("Concorsi") %>" />
	    <aui:option label="Consulenti e Collaboratori" value="ConsulentiCollaboratori" selected="<%=trasparenza_cfg.equals("ConsulentiCollaboratori") %>" />
	    <aui:option label="Provvedimenti organi indirizzo politico" value="ProvvedimentiOrganiIndirizzoPolitico" selected="<%=trasparenza_cfg.equals("ProvvedimentiOrganiIndirizzoPolitico") %>" />
	    <aui:option label="Provvedimenti dirigenti amministrativi" value="ProvvedimentiDirigentiAmministrativi" selected="<%=trasparenza_cfg.equals("ProvvedimentiDirigentiAmministrativi") %>" />
	</aui:select>
	
	<aui:select name="preferences--tipoAtto--">
    	<aui:option label="Nessuna Selezione" value="" />
	    <aui:option label="Bando" value="bando" selected="<%=tipoAtto_cfg.equals("bando") %>" />
	    <aui:option label="Concorso" value="concorso" selected="<%=tipoAtto_cfg.equals("concorso") %>" />
	    <aui:option label="Delibera" value="delibera" selected="<%=tipoAtto_cfg.equals("delibera") %>" />
	    <aui:option label="Determina" value="determina" selected="<%=tipoAtto_cfg.equals("determina") %>" />
	    <aui:option label="Altra Documentazione" value="documentazione" selected="<%=tipoAtto_cfg.equals("documentazione") %>" />
	</aui:select> 
	
	<aui:select name="preferences--numRisultati--">
		<aui:option label="10" value="10" selected="<%=numRisultati_cfg.equals("10") %>" />
	    <aui:option label="25" value="25" selected="<%=numRisultati_cfg.equals("25") %>" />
	    <aui:option label="50" value="50" selected="<%=numRisultati_cfg.equals("50") %>" />
	    <aui:option label="75" value="75" selected="<%=numRisultati_cfg.equals("75") %>" />
	    <aui:option label="100" value="100" selected="<%=numRisultati_cfg.equals("100") %>" />
	</aui:select> 
	
    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>