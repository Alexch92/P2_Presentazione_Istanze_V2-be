package it.sincon.sanita.services.service.base;

import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Sincon
 * @generated
 */
public class CFG_CategorieAbilitateLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;

    public CFG_CategorieAbilitateLocalServiceClpInvoker() {
        _methodName0 = "addCFG_CategorieAbilitate";

        _methodParameterTypes0 = new String[] {
                "it.sincon.sanita.services.model.CFG_CategorieAbilitate"
            };

        _methodName1 = "createCFG_CategorieAbilitate";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName2 = "deleteCFG_CategorieAbilitate";

        _methodParameterTypes2 = new String[] { "java.lang.String" };

        _methodName3 = "deleteCFG_CategorieAbilitate";

        _methodParameterTypes3 = new String[] {
                "it.sincon.sanita.services.model.CFG_CategorieAbilitate"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchCFG_CategorieAbilitate";

        _methodParameterTypes10 = new String[] { "java.lang.String" };

        _methodName11 = "getCFG_CategorieAbilitate";

        _methodParameterTypes11 = new String[] { "java.lang.String" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getCFG_CategorieAbilitates";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getCFG_CategorieAbilitatesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateCFG_CategorieAbilitate";

        _methodParameterTypes15 = new String[] {
                "it.sincon.sanita.services.model.CFG_CategorieAbilitate"
            };

        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName66 = "getAllCFG_CategorieAbilitate";

        _methodParameterTypes66 = new String[] {  };

        _methodName67 = "getCFG_CategorieAbilitateByClassName";

        _methodParameterTypes67 = new String[] { "java.lang.String" };

        _methodName68 = "getCFG_CategorieAbilitateByClassNameAndDefaultRicerca";

        _methodParameterTypes68 = new String[] { "java.lang.String", "boolean" };

        _methodName69 = "getSelectedByClassName";

        _methodParameterTypes69 = new String[] {
                "java.lang.String", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.addCFG_CategorieAbilitate((it.sincon.sanita.services.model.CFG_CategorieAbilitate) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.createCFG_CategorieAbilitate((java.lang.String) arguments[0]);
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.deleteCFG_CategorieAbilitate((java.lang.String) arguments[0]);
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.deleteCFG_CategorieAbilitate((it.sincon.sanita.services.model.CFG_CategorieAbilitate) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.fetchCFG_CategorieAbilitate((java.lang.String) arguments[0]);
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitate((java.lang.String) arguments[0]);
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitates(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitatesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.updateCFG_CategorieAbilitate((it.sincon.sanita.services.model.CFG_CategorieAbilitate) arguments[0]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            CFG_CategorieAbilitateLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getAllCFG_CategorieAbilitate();
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassName((java.lang.String) arguments[0]);
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getCFG_CategorieAbilitateByClassNameAndDefaultRicerca((java.lang.String) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return CFG_CategorieAbilitateLocalServiceUtil.getSelectedByClassName((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
