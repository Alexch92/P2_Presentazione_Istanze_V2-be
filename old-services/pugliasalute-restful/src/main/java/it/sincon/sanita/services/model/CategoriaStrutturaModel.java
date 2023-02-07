package it.sincon.sanita.services.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CategoriaStruttura service. Represents a row in the &quot;SANITAREST_CategoriaStruttura&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.sincon.sanita.services.model.impl.CategoriaStrutturaImpl}.
 * </p>
 *
 * @author Sincon
 * @see CategoriaStruttura
 * @see it.sincon.sanita.services.model.impl.CategoriaStrutturaImpl
 * @see it.sincon.sanita.services.model.impl.CategoriaStrutturaModelImpl
 * @generated
 */
public interface CategoriaStrutturaModel extends BaseModel<CategoriaStruttura> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a categoria struttura model instance should use the {@link CategoriaStruttura} interface instead.
     */

    /**
     * Returns the primary key of this categoria struttura.
     *
     * @return the primary key of this categoria struttura
     */
    public String getPrimaryKey();

    /**
     * Sets the primary key of this categoria struttura.
     *
     * @param primaryKey the primary key of this categoria struttura
     */
    public void setPrimaryKey(String primaryKey);

    /**
     * Returns the id tipo struttura of this categoria struttura.
     *
     * @return the id tipo struttura of this categoria struttura
     */
    @AutoEscape
    public String getIdTipoStruttura();

    /**
     * Sets the id tipo struttura of this categoria struttura.
     *
     * @param idTipoStruttura the id tipo struttura of this categoria struttura
     */
    public void setIdTipoStruttura(String idTipoStruttura);

    /**
     * Returns the denominazione of this categoria struttura.
     *
     * @return the denominazione of this categoria struttura
     */
    @AutoEscape
    public String getDenominazione();

    /**
     * Sets the denominazione of this categoria struttura.
     *
     * @param denominazione the denominazione of this categoria struttura
     */
    public void setDenominazione(String denominazione);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(CategoriaStruttura categoriaStruttura);

    @Override
    public int hashCode();

    @Override
    public CacheModel<CategoriaStruttura> toCacheModel();

    @Override
    public CategoriaStruttura toEscapedModel();

    @Override
    public CategoriaStruttura toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}