package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.sincon.sanita.services.model.CategoriaStruttura;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CategoriaStruttura in entity cache.
 *
 * @author Sincon
 * @see CategoriaStruttura
 * @generated
 */
public class CategoriaStrutturaCacheModel implements CacheModel<CategoriaStruttura>,
    Externalizable {
    public String idTipoStruttura;
    public String denominazione;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{idTipoStruttura=");
        sb.append(idTipoStruttura);
        sb.append(", denominazione=");
        sb.append(denominazione);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public CategoriaStruttura toEntityModel() {
        CategoriaStrutturaImpl categoriaStrutturaImpl = new CategoriaStrutturaImpl();

        if (idTipoStruttura == null) {
            categoriaStrutturaImpl.setIdTipoStruttura(StringPool.BLANK);
        } else {
            categoriaStrutturaImpl.setIdTipoStruttura(idTipoStruttura);
        }

        if (denominazione == null) {
            categoriaStrutturaImpl.setDenominazione(StringPool.BLANK);
        } else {
            categoriaStrutturaImpl.setDenominazione(denominazione);
        }

        categoriaStrutturaImpl.resetOriginalValues();

        return categoriaStrutturaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        idTipoStruttura = objectInput.readUTF();
        denominazione = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (idTipoStruttura == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(idTipoStruttura);
        }

        if (denominazione == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(denominazione);
        }
    }
}
