package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.sincon.sanita.services.service.CategoriaStrutturaLocalServiceUtil;
import it.sincon.sanita.services.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class CategoriaStrutturaClp extends BaseModelImpl<CategoriaStruttura>
    implements CategoriaStruttura {
    private String _idTipoStruttura;
    private String _denominazione;
    private BaseModel<?> _categoriaStrutturaRemoteModel;

    public CategoriaStrutturaClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return CategoriaStruttura.class;
    }

    @Override
    public String getModelClassName() {
        return CategoriaStruttura.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _idTipoStruttura;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setIdTipoStruttura(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _idTipoStruttura;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("idTipoStruttura", getIdTipoStruttura());
        attributes.put("denominazione", getDenominazione());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String idTipoStruttura = (String) attributes.get("idTipoStruttura");

        if (idTipoStruttura != null) {
            setIdTipoStruttura(idTipoStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }
    }

    @Override
    public String getIdTipoStruttura() {
        return _idTipoStruttura;
    }

    @Override
    public void setIdTipoStruttura(String idTipoStruttura) {
        _idTipoStruttura = idTipoStruttura;

        if (_categoriaStrutturaRemoteModel != null) {
            try {
                Class<?> clazz = _categoriaStrutturaRemoteModel.getClass();

                Method method = clazz.getMethod("setIdTipoStruttura",
                        String.class);

                method.invoke(_categoriaStrutturaRemoteModel, idTipoStruttura);
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

        if (_categoriaStrutturaRemoteModel != null) {
            try {
                Class<?> clazz = _categoriaStrutturaRemoteModel.getClass();

                Method method = clazz.getMethod("setDenominazione", String.class);

                method.invoke(_categoriaStrutturaRemoteModel, denominazione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portal.service.ServiceContext.class
                };

            Object[] parameterValues = new Object[] { serviceContext };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portlet.expando.model.ExpandoBridge.class
                };

            Object[] parameterValues = new Object[] { expandoBridge };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        try {
            String methodName = "setExpandoBridgeAttributes";

            Class<?>[] parameterTypes = new Class<?>[] {
                    com.liferay.portal.model.BaseModel.class
                };

            Object[] parameterValues = new Object[] { baseModel };

            invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getCategoriaStrutturaRemoteModel() {
        return _categoriaStrutturaRemoteModel;
    }

    public void setCategoriaStrutturaRemoteModel(
        BaseModel<?> categoriaStrutturaRemoteModel) {
        _categoriaStrutturaRemoteModel = categoriaStrutturaRemoteModel;
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

        Class<?> remoteModelClass = _categoriaStrutturaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_categoriaStrutturaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CategoriaStrutturaLocalServiceUtil.addCategoriaStruttura(this);
        } else {
            CategoriaStrutturaLocalServiceUtil.updateCategoriaStruttura(this);
        }
    }

    @Override
    public CategoriaStruttura toEscapedModel() {
        return (CategoriaStruttura) ProxyUtil.newProxyInstance(CategoriaStruttura.class.getClassLoader(),
            new Class[] { CategoriaStruttura.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CategoriaStrutturaClp clone = new CategoriaStrutturaClp();

        clone.setIdTipoStruttura(getIdTipoStruttura());
        clone.setDenominazione(getDenominazione());

        return clone;
    }

    @Override
    public int compareTo(CategoriaStruttura categoriaStruttura) {
        String primaryKey = categoriaStruttura.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CategoriaStrutturaClp)) {
            return false;
        }

        CategoriaStrutturaClp categoriaStruttura = (CategoriaStrutturaClp) obj;

        String primaryKey = categoriaStruttura.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{idTipoStruttura=");
        sb.append(getIdTipoStruttura());
        sb.append(", denominazione=");
        sb.append(getDenominazione());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("it.sincon.sanita.services.model.CategoriaStruttura");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>idTipoStruttura</column-name><column-value><![CDATA[");
        sb.append(getIdTipoStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>denominazione</column-name><column-value><![CDATA[");
        sb.append(getDenominazione());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
