package it.sincon.sanita.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;
import it.sincon.sanita.services.service.CategoriaStrutturaLocalServiceUtil;
import it.sincon.sanita.services.service.CategoriaStrutturaServiceUtil;
import it.sincon.sanita.services.service.ClpSerializer;
import it.sincon.sanita.services.service.NewsLocalServiceUtil;
import it.sincon.sanita.services.service.NewsServiceUtil;
import it.sincon.sanita.services.service.StrutturaSanitariaFigliaLocalServiceUtil;
import it.sincon.sanita.services.service.StrutturaSanitariaFigliaServiceUtil;
import it.sincon.sanita.services.service.StrutturaSanitariaLocalServiceUtil;
import it.sincon.sanita.services.service.StrutturaSanitariaServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            CategoriaStrutturaLocalServiceUtil.clearService();

            CategoriaStrutturaServiceUtil.clearService();
            CFG_CategorieAbilitateLocalServiceUtil.clearService();

            NewsLocalServiceUtil.clearService();

            NewsServiceUtil.clearService();
            StrutturaSanitariaLocalServiceUtil.clearService();

            StrutturaSanitariaServiceUtil.clearService();
            StrutturaSanitariaFigliaLocalServiceUtil.clearService();

            StrutturaSanitariaFigliaServiceUtil.clearService();
        }
    }
}
