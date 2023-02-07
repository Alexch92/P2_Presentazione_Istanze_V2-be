package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.sincon.sanita.services.model.StrutturaSanitariaFiglia;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StrutturaSanitariaFiglia in entity cache.
 *
 * @author Sincon
 * @see StrutturaSanitariaFiglia
 * @generated
 */
public class StrutturaSanitariaFigliaCacheModel implements CacheModel<StrutturaSanitariaFiglia>,
    Externalizable {
    public long idStrutturaFiglia;
    public String tipoStruttura;
    public String denominazione;
    public String indirizzo;
    public String direttore;
    public String responsabileSanitario;
    public String telefono;
    public String email;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{idStrutturaFiglia=");
        sb.append(idStrutturaFiglia);
        sb.append(", tipoStruttura=");
        sb.append(tipoStruttura);
        sb.append(", denominazione=");
        sb.append(denominazione);
        sb.append(", indirizzo=");
        sb.append(indirizzo);
        sb.append(", direttore=");
        sb.append(direttore);
        sb.append(", responsabileSanitario=");
        sb.append(responsabileSanitario);
        sb.append(", telefono=");
        sb.append(telefono);
        sb.append(", email=");
        sb.append(email);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public StrutturaSanitariaFiglia toEntityModel() {
        StrutturaSanitariaFigliaImpl strutturaSanitariaFigliaImpl = new StrutturaSanitariaFigliaImpl();

        strutturaSanitariaFigliaImpl.setIdStrutturaFiglia(idStrutturaFiglia);

        if (tipoStruttura == null) {
            strutturaSanitariaFigliaImpl.setTipoStruttura(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setTipoStruttura(tipoStruttura);
        }

        if (denominazione == null) {
            strutturaSanitariaFigliaImpl.setDenominazione(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setDenominazione(denominazione);
        }

        if (indirizzo == null) {
            strutturaSanitariaFigliaImpl.setIndirizzo(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setIndirizzo(indirizzo);
        }

        if (direttore == null) {
            strutturaSanitariaFigliaImpl.setDirettore(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setDirettore(direttore);
        }

        if (responsabileSanitario == null) {
            strutturaSanitariaFigliaImpl.setResponsabileSanitario(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setResponsabileSanitario(responsabileSanitario);
        }

        if (telefono == null) {
            strutturaSanitariaFigliaImpl.setTelefono(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setTelefono(telefono);
        }

        if (email == null) {
            strutturaSanitariaFigliaImpl.setEmail(StringPool.BLANK);
        } else {
            strutturaSanitariaFigliaImpl.setEmail(email);
        }

        strutturaSanitariaFigliaImpl.resetOriginalValues();

        return strutturaSanitariaFigliaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        idStrutturaFiglia = objectInput.readLong();
        tipoStruttura = objectInput.readUTF();
        denominazione = objectInput.readUTF();
        indirizzo = objectInput.readUTF();
        direttore = objectInput.readUTF();
        responsabileSanitario = objectInput.readUTF();
        telefono = objectInput.readUTF();
        email = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(idStrutturaFiglia);

        if (tipoStruttura == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tipoStruttura);
        }

        if (denominazione == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(denominazione);
        }

        if (indirizzo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(indirizzo);
        }

        if (direttore == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(direttore);
        }

        if (responsabileSanitario == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(responsabileSanitario);
        }

        if (telefono == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(telefono);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }
    }
}
