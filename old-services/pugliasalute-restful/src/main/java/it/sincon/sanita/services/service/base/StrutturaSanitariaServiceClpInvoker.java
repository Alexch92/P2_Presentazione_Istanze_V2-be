package it.sincon.sanita.services.service.base;

import it.sincon.sanita.services.service.StrutturaSanitariaServiceUtil;

import java.util.Arrays;

/**
 * @author Sincon
 * @generated
 */
public class StrutturaSanitariaServiceClpInvoker {
    private String _methodName44;
    private String[] _methodParameterTypes44;
    private String _methodName45;
    private String[] _methodParameterTypes45;

    public StrutturaSanitariaServiceClpInvoker() {
        _methodName44 = "getBeanIdentifier";

        _methodParameterTypes44 = new String[] {  };

        _methodName45 = "setBeanIdentifier";

        _methodParameterTypes45 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName44.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
            return StrutturaSanitariaServiceUtil.getBeanIdentifier();
        }

        if (_methodName45.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
            StrutturaSanitariaServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
