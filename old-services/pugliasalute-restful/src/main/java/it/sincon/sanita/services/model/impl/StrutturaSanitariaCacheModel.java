package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.sincon.sanita.services.model.StrutturaSanitaria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StrutturaSanitaria in entity cache.
 *
 * @author Sincon
 * @see StrutturaSanitaria
 * @generated
 */
public class StrutturaSanitariaCacheModel implements CacheModel<StrutturaSanitaria>,
    Externalizable {
    public long pk;
    public long idStruttura;
    public long groupId;
    public String idTipoStruttura;
    public String tipoStruttura;
    public String tipologia;
    public String denominazione;
    public String immagine;
    public String descrizione;
    public String indirizzo;
    public double lat;
    public double lng;
    public double distanza;
    public String telefono;
    public String email;
    public String fax;
    public String orari;
    public String locale;
    public int stato;
    public String childrenEdottoOspedaleCollegato;
    public String childrenEdottoAmbulatorio;
    public String childrenEdottoUnitaOperativa;
    public String childrenEdottoUnitaps;
    public String relazioneAmbulatorio;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(49);

        sb.append("{pk=");
        sb.append(pk);
        sb.append(", idStruttura=");
        sb.append(idStruttura);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", idTipoStruttura=");
        sb.append(idTipoStruttura);
        sb.append(", tipoStruttura=");
        sb.append(tipoStruttura);
        sb.append(", tipologia=");
        sb.append(tipologia);
        sb.append(", denominazione=");
        sb.append(denominazione);
        sb.append(", immagine=");
        sb.append(immagine);
        sb.append(", descrizione=");
        sb.append(descrizione);
        sb.append(", indirizzo=");
        sb.append(indirizzo);
        sb.append(", lat=");
        sb.append(lat);
        sb.append(", lng=");
        sb.append(lng);
        sb.append(", distanza=");
        sb.append(distanza);
        sb.append(", telefono=");
        sb.append(telefono);
        sb.append(", email=");
        sb.append(email);
        sb.append(", fax=");
        sb.append(fax);
        sb.append(", orari=");
        sb.append(orari);
        sb.append(", locale=");
        sb.append(locale);
        sb.append(", stato=");
        sb.append(stato);
        sb.append(", childrenEdottoOspedaleCollegato=");
        sb.append(childrenEdottoOspedaleCollegato);
        sb.append(", childrenEdottoAmbulatorio=");
        sb.append(childrenEdottoAmbulatorio);
        sb.append(", childrenEdottoUnitaOperativa=");
        sb.append(childrenEdottoUnitaOperativa);
        sb.append(", childrenEdottoUnitaps=");
        sb.append(childrenEdottoUnitaps);
        sb.append(", relazioneAmbulatorio=");
        sb.append(relazioneAmbulatorio);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public StrutturaSanitaria toEntityModel() {
        StrutturaSanitariaImpl strutturaSanitariaImpl = new StrutturaSanitariaImpl();

        strutturaSanitariaImpl.setPk(pk);
        strutturaSanitariaImpl.setIdStruttura(idStruttura);
        strutturaSanitariaImpl.setGroupId(groupId);

        if (idTipoStruttura == null) {
            strutturaSanitariaImpl.setIdTipoStruttura(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setIdTipoStruttura(idTipoStruttura);
        }

        if (tipoStruttura == null) {
            strutturaSanitariaImpl.setTipoStruttura(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setTipoStruttura(tipoStruttura);
        }

        if (tipologia == null) {
            strutturaSanitariaImpl.setTipologia(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setTipologia(tipologia);
        }

        if (denominazione == null) {
            strutturaSanitariaImpl.setDenominazione(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setDenominazione(denominazione);
        }

        if (immagine == null) {
            strutturaSanitariaImpl.setImmagine(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setImmagine(immagine);
        }

        if (descrizione == null) {
            strutturaSanitariaImpl.setDescrizione(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setDescrizione(descrizione);
        }

        if (indirizzo == null) {
            strutturaSanitariaImpl.setIndirizzo(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setIndirizzo(indirizzo);
        }

        strutturaSanitariaImpl.setLat(lat);
        strutturaSanitariaImpl.setLng(lng);
        strutturaSanitariaImpl.setDistanza(distanza);

        if (telefono == null) {
            strutturaSanitariaImpl.setTelefono(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setTelefono(telefono);
        }

        if (email == null) {
            strutturaSanitariaImpl.setEmail(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setEmail(email);
        }

        if (fax == null) {
            strutturaSanitariaImpl.setFax(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setFax(fax);
        }

        if (orari == null) {
            strutturaSanitariaImpl.setOrari(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setOrari(orari);
        }

        if (locale == null) {
            strutturaSanitariaImpl.setLocale(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setLocale(locale);
        }

        strutturaSanitariaImpl.setStato(stato);

        if (childrenEdottoOspedaleCollegato == null) {
            strutturaSanitariaImpl.setChildrenEdottoOspedaleCollegato(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setChildrenEdottoOspedaleCollegato(childrenEdottoOspedaleCollegato);
        }

        if (childrenEdottoAmbulatorio == null) {
            strutturaSanitariaImpl.setChildrenEdottoAmbulatorio(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setChildrenEdottoAmbulatorio(childrenEdottoAmbulatorio);
        }

        if (childrenEdottoUnitaOperativa == null) {
            strutturaSanitariaImpl.setChildrenEdottoUnitaOperativa(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setChildrenEdottoUnitaOperativa(childrenEdottoUnitaOperativa);
        }

        if (childrenEdottoUnitaps == null) {
            strutturaSanitariaImpl.setChildrenEdottoUnitaps(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setChildrenEdottoUnitaps(childrenEdottoUnitaps);
        }

        if (relazioneAmbulatorio == null) {
            strutturaSanitariaImpl.setRelazioneAmbulatorio(StringPool.BLANK);
        } else {
            strutturaSanitariaImpl.setRelazioneAmbulatorio(relazioneAmbulatorio);
        }

        strutturaSanitariaImpl.resetOriginalValues();

        return strutturaSanitariaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        pk = objectInput.readLong();
        idStruttura = objectInput.readLong();
        groupId = objectInput.readLong();
        idTipoStruttura = objectInput.readUTF();
        tipoStruttura = objectInput.readUTF();
        tipologia = objectInput.readUTF();
        denominazione = objectInput.readUTF();
        immagine = objectInput.readUTF();
        descrizione = objectInput.readUTF();
        indirizzo = objectInput.readUTF();
        lat = objectInput.readDouble();
        lng = objectInput.readDouble();
        distanza = objectInput.readDouble();
        telefono = objectInput.readUTF();
        email = objectInput.readUTF();
        fax = objectInput.readUTF();
        orari = objectInput.readUTF();
        locale = objectInput.readUTF();
        stato = objectInput.readInt();
        childrenEdottoOspedaleCollegato = objectInput.readUTF();
        childrenEdottoAmbulatorio = objectInput.readUTF();
        childrenEdottoUnitaOperativa = objectInput.readUTF();
        childrenEdottoUnitaps = objectInput.readUTF();
        relazioneAmbulatorio = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(pk);
        objectOutput.writeLong(idStruttura);
        objectOutput.writeLong(groupId);

        if (idTipoStruttura == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(idTipoStruttura);
        }

        if (tipoStruttura == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tipoStruttura);
        }

        if (tipologia == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tipologia);
        }

        if (denominazione == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(denominazione);
        }

        if (immagine == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(immagine);
        }

        if (descrizione == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(descrizione);
        }

        if (indirizzo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(indirizzo);
        }

        objectOutput.writeDouble(lat);
        objectOutput.writeDouble(lng);
        objectOutput.writeDouble(distanza);

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

        if (fax == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fax);
        }

        if (orari == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(orari);
        }

        if (locale == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(locale);
        }

        objectOutput.writeInt(stato);

        if (childrenEdottoOspedaleCollegato == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(childrenEdottoOspedaleCollegato);
        }

        if (childrenEdottoAmbulatorio == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(childrenEdottoAmbulatorio);
        }

        if (childrenEdottoUnitaOperativa == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(childrenEdottoUnitaOperativa);
        }

        if (childrenEdottoUnitaps == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(childrenEdottoUnitaps);
        }

        if (relazioneAmbulatorio == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(relazioneAmbulatorio);
        }
    }
}
