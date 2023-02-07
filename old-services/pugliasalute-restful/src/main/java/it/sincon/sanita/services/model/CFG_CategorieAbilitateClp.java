package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.sincon.sanita.services.service.CFG_CategorieAbilitateLocalServiceUtil;
import it.sincon.sanita.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class CFG_CategorieAbilitateClp extends BaseModelImpl<CFG_CategorieAbilitate>
    implements CFG_CategorieAbilitate {
    private String _titoloStruttura;
    private String _denominazione;
    private int _ordine;
    private String _className;
    private boolean _defaultRicerca;
    private BaseModel<?> _cfg_CategorieAbilitateRemoteModel;

    public CFG_CategorieAbilitateClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return CFG_CategorieAbilitate.class;
    }

    @Override
    public String getModelClassName() {
        return CFG_CategorieAbilitate.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _titoloStruttura;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setTitoloStruttura(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _titoloStruttura;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("titoloStruttura", getTitoloStruttura());
        attributes.put("denominazione", getDenominazione());
        attributes.put("ordine", getOrdine());
        attributes.put("className", getClassName());
        attributes.put("defaultRicerca", getDefaultRicerca());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String titoloStruttura = (String) attributes.get("titoloStruttura");

        if (titoloStruttura != null) {
            setTitoloStruttura(titoloStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }

        Integer ordine = (Integer) attributes.get("ordine");

        if (ordine != null) {
            setOrdine(ordine);
        }

        String className = (String) attributes.get("className");

        if (className != null) {
            setClassName(className);
        }

        Boolean defaultRicerca = (Boolean) attributes.get("defaultRicerca");

        if (defaultRicerca != null) {
            setDefaultRicerca(defaultRicerca);
        }
    }

    @Override
    public String getTitoloStruttura() {
        return _titoloStruttura;
    }

    @Override
    public void setTitoloStruttura(String titoloStruttura) {
        _titoloStruttura = titoloStruttura;

        if (_cfg_CategorieAbilitateRemoteModel != null) {
            try {
                Class<?> clazz = _cfg_CategorieAbilitateRemoteModel.getClass();

                Method method = clazz.getMethod("setTitoloStruttura",
                        String.class);

                method.invoke(_cfg_CategorieAbilitateRemoteModel,
                    titoloStruttura);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDenominazione() {
        return _denominazione;
    }

    @Override
    public void setDenominazione(String denominazione) {
        _denominazione = denominazione;

        if (_cfg_CategorieAbilitateRemoteModel != null) {
            try {
                Class<?> clazz = _cfg_CategorieAbilitateRemoteModel.getClass();

                Method method = clazz.getMethod("setDenominazione", String.class);

                method.invoke(_cfg_CategorieAbilitateRemoteModel, denominazione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getOrdine() {
        return _ordine;
    }

    @Override
    public void setOrdine(int ordine) {
        _ordine = ordine;

        if (_cfg_CategorieAbilitateRemoteModel != null) {
            try {
                Class<?> clazz = _cfg_CategorieAbilitateRemoteModel.getClass();

                Method method = clazz.getMethod("setOrdine", int.class);

                method.invoke(_cfg_CategorieAbilitateRemoteModel, ordine);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClassName() {
        return _className;
    }

    @Override
    public void setClassName(String className) {
        _className = className;

        if (_cfg_CategorieAbilitateRemoteModel != null) {
            try {
                Class<?> clazz = _cfg_CategorieAbilitateRemoteModel.getClass();

                Method method = clazz.getMethod("setClassName", String.class);

                method.invoke(_cfg_CategorieAbilitateRemoteModel, className);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getDefaultRicerca() {
        return _defaultRicerca;
    }

    @Override
    public boolean isDefaultRicerca() {
        return _defaultRicerca;
    }

    @Override
    public void setDefaultRicerca(boolean defaultRicerca) {
        _defaultRicerca = defaultRicerca;

        if (_cfg_CategorieAbilitateRemoteModel != null) {
            try {
                Class<?> clazz = _cfg_CategorieAbilitateRemoteModel.getClass();

                Method method = clazz.getMethod("setDefaultRicerca",
                        boolean.class);

                method.invoke(_cfg_CategorieAbilitateRemoteModel, defaultRicerca);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCFG_CategorieAbilitateRemoteModel() {
        return _cfg_CategorieAbilitateRemoteModel;
    }

    public void setCFG_CategorieAbilitateRemoteModel(
        BaseModel<?> cfg_CategorieAbilitateRemoteModel) {
        _cfg_CategorieAbilitateRemoteModel = cfg_CategorieAbilitateRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _cfg_CategorieAbilitateRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_cfg_CategorieAbilitateRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CFG_CategorieAbilitateLocalServiceUtil.addCFG_CategorieAbilitate(this);
        } else {
            CFG_CategorieAbilitateLocalServiceUtil.updateCFG_CategorieAbilitate(this);
        }
    }

    @Override
    public CFG_CategorieAbilitate toEscapedModel() {
        return (CFG_CategorieAbilitate) ProxyUtil.newProxyInstance(CFG_CategorieAbilitate.class.getClassLoader(),
            new Class[] { CFG_CategorieAbilitate.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CFG_CategorieAbilitateClp clone = new CFG_CategorieAbilitateClp();

        clone.setTitoloStruttura(getTitoloStruttura());
        clone.setDenominazione(getDenominazione());
        clone.setOrdine(getOrdine());
        clone.setClassName(getClassName());
        clone.setDefaultRicerca(getDefaultRicerca());

        return clone;
    }

    @Override
    public int compareTo(CFG_CategorieAbilitate cfg_CategorieAbilitate) {
        int value = 0;

        if (getOrdine() < cfg_CategorieAbilitate.getOrdine()) {
            value = -1;
        } else if (getOrdine() > cfg_CategorieAbilitate.getOrdine()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CFG_CategorieAbilitateClp)) {
            return false;
        }

        CFG_CategorieAbilitateClp cfg_CategorieAbilitate = (CFG_CategorieAbilitateClp) obj;

        String primaryKey = cfg_CategorieAbilitate.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{titoloStruttura=");
        sb.append(getTitoloStruttura());
        sb.append(", denominazione=");
        sb.append(getDenominazione());
        sb.append(", ordine=");
        sb.append(getOrdine());
        sb.append(", className=");
        sb.append(getClassName());
        sb.append(", defaultRicerca=");
        sb.append(getDefaultRicerca());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("it.sincon.sanita.services.model.CFG_CategorieAbilitate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>titoloStruttura</column-name><column-value><![CDATA[");
        sb.append(getTitoloStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>denominazione</column-name><column-value><![CDATA[");
        sb.append(getDenominazione());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ordine</column-name><column-value><![CDATA[");
        sb.append(getOrdine());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>className</column-name><column-value><![CDATA[");
        sb.append(getClassName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>defaultRicerca</column-name><column-value><![CDATA[");
        sb.append(getDefaultRicerca());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
