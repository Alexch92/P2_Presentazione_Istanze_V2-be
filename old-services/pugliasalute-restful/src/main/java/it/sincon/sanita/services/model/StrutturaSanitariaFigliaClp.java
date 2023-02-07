package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.sincon.sanita.services.service.ClpSerializer;
import it.sincon.sanita.services.service.StrutturaSanitariaFigliaLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class StrutturaSanitariaFigliaClp extends BaseModelImpl<StrutturaSanitariaFiglia>
    implements StrutturaSanitariaFiglia {
    private long _idStrutturaFiglia;
    private String _tipoStruttura;
    private String _denominazione;
    private String _indirizzo;
    private String _direttore;
    private String _responsabileSanitario;
    private String _telefono;
    private String _email;
    private BaseModel<?> _strutturaSanitariaFigliaRemoteModel;

    public StrutturaSanitariaFigliaClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return StrutturaSanitariaFiglia.class;
    }

    @Override
    public String getModelClassName() {
        return StrutturaSanitariaFiglia.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _idStrutturaFiglia;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setIdStrutturaFiglia(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _idStrutturaFiglia;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("idStrutturaFiglia", getIdStrutturaFiglia());
        attributes.put("tipoStruttura", getTipoStruttura());
        attributes.put("denominazione", getDenominazione());
        attributes.put("indirizzo", getIndirizzo());
        attributes.put("direttore", getDirettore());
        attributes.put("responsabileSanitario", getResponsabileSanitario());
        attributes.put("telefono", getTelefono());
        attributes.put("email", getEmail());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long idStrutturaFiglia = (Long) attributes.get("idStrutturaFiglia");

        if (idStrutturaFiglia != null) {
            setIdStrutturaFiglia(idStrutturaFiglia);
        }

        String tipoStruttura = (String) attributes.get("tipoStruttura");

        if (tipoStruttura != null) {
            setTipoStruttura(tipoStruttura);
        }

        String denominazione = (String) attributes.get("denominazione");

        if (denominazione != null) {
            setDenominazione(denominazione);
        }

        String indirizzo = (String) attributes.get("indirizzo");

        if (indirizzo != null) {
            setIndirizzo(indirizzo);
        }

        String direttore = (String) attributes.get("direttore");

        if (direttore != null) {
            setDirettore(direttore);
        }

        String responsabileSanitario = (String) attributes.get(
                "responsabileSanitario");

        if (responsabileSanitario != null) {
            setResponsabileSanitario(responsabileSanitario);
        }

        String telefono = (String) attributes.get("telefono");

        if (telefono != null) {
            setTelefono(telefono);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }
    }

    @Override
    public long getIdStrutturaFiglia() {
        return _idStrutturaFiglia;
    }

    @Override
    public void setIdStrutturaFiglia(long idStrutturaFiglia) {
        _idStrutturaFiglia = idStrutturaFiglia;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setIdStrutturaFiglia",
                        long.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel,
                    idStrutturaFiglia);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTipoStruttura() {
        return _tipoStruttura;
    }

    @Override
    public void setTipoStruttura(String tipoStruttura) {
        _tipoStruttura = tipoStruttura;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setTipoStruttura", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel,
                    tipoStruttura);
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

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setDenominazione", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel,
                    denominazione);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIndirizzo() {
        return _indirizzo;
    }

    @Override
    public void setIndirizzo(String indirizzo) {
        _indirizzo = indirizzo;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setIndirizzo", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel, indirizzo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDirettore() {
        return _direttore;
    }

    @Override
    public void setDirettore(String direttore) {
        _direttore = direttore;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setDirettore", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel, direttore);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getResponsabileSanitario() {
        return _responsabileSanitario;
    }

    @Override
    public void setResponsabileSanitario(String responsabileSanitario) {
        _responsabileSanitario = responsabileSanitario;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setResponsabileSanitario",
                        String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel,
                    responsabileSanitario);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTelefono() {
        return _telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        _telefono = telefono;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setTelefono", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel, telefono);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_strutturaSanitariaFigliaRemoteModel != null) {
            try {
                Class<?> clazz = _strutturaSanitariaFigliaRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_strutturaSanitariaFigliaRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
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

    public BaseModel<?> getStrutturaSanitariaFigliaRemoteModel() {
        return _strutturaSanitariaFigliaRemoteModel;
    }

    public void setStrutturaSanitariaFigliaRemoteModel(
        BaseModel<?> strutturaSanitariaFigliaRemoteModel) {
        _strutturaSanitariaFigliaRemoteModel = strutturaSanitariaFigliaRemoteModel;
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

        Class<?> remoteModelClass = _strutturaSanitariaFigliaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_strutturaSanitariaFigliaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            StrutturaSanitariaFigliaLocalServiceUtil.addStrutturaSanitariaFiglia(this);
        } else {
            StrutturaSanitariaFigliaLocalServiceUtil.updateStrutturaSanitariaFiglia(this);
        }
    }

    @Override
    public StrutturaSanitariaFiglia toEscapedModel() {
        return (StrutturaSanitariaFiglia) ProxyUtil.newProxyInstance(StrutturaSanitariaFiglia.class.getClassLoader(),
            new Class[] { StrutturaSanitariaFiglia.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        StrutturaSanitariaFigliaClp clone = new StrutturaSanitariaFigliaClp();

        clone.setIdStrutturaFiglia(getIdStrutturaFiglia());
        clone.setTipoStruttura(getTipoStruttura());
        clone.setDenominazione(getDenominazione());
        clone.setIndirizzo(getIndirizzo());
        clone.setDirettore(getDirettore());
        clone.setResponsabileSanitario(getResponsabileSanitario());
        clone.setTelefono(getTelefono());
        clone.setEmail(getEmail());

        return clone;
    }

    @Override
    public int compareTo(StrutturaSanitariaFiglia strutturaSanitariaFiglia) {
        long primaryKey = strutturaSanitariaFiglia.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof StrutturaSanitariaFigliaClp)) {
            return false;
        }

        StrutturaSanitariaFigliaClp strutturaSanitariaFiglia = (StrutturaSanitariaFigliaClp) obj;

        long primaryKey = strutturaSanitariaFiglia.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{idStrutturaFiglia=");
        sb.append(getIdStrutturaFiglia());
        sb.append(", tipoStruttura=");
        sb.append(getTipoStruttura());
        sb.append(", denominazione=");
        sb.append(getDenominazione());
        sb.append(", indirizzo=");
        sb.append(getIndirizzo());
        sb.append(", direttore=");
        sb.append(getDirettore());
        sb.append(", responsabileSanitario=");
        sb.append(getResponsabileSanitario());
        sb.append(", telefono=");
        sb.append(getTelefono());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("it.sincon.sanita.services.model.StrutturaSanitariaFiglia");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>idStrutturaFiglia</column-name><column-value><![CDATA[");
        sb.append(getIdStrutturaFiglia());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tipoStruttura</column-name><column-value><![CDATA[");
        sb.append(getTipoStruttura());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>denominazione</column-name><column-value><![CDATA[");
        sb.append(getDenominazione());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>indirizzo</column-name><column-value><![CDATA[");
        sb.append(getIndirizzo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>direttore</column-name><column-value><![CDATA[");
        sb.append(getDirettore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>responsabileSanitario</column-name><column-value><![CDATA[");
        sb.append(getResponsabileSanitario());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>telefono</column-name><column-value><![CDATA[");
        sb.append(getTelefono());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
