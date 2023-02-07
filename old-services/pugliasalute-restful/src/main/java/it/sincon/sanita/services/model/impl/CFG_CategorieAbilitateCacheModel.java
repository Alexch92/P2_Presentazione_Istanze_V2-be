package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.sincon.sanita.services.model.CFG_CategorieAbilitate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CFG_CategorieAbilitate in entity cache.
 *
 * @author Sincon
 * @see CFG_CategorieAbilitate
 * @generated
 */
public class CFG_CategorieAbilitateCacheModel implements CacheModel<CFG_CategorieAbilitate>,
    Externalizable {
    public String titoloStruttura;
    public String denominazione;
    public int ordine;
    public String className;
    public boolean defaultRicerca;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{titoloStruttura=");
        sb.append(titoloStruttura);
        sb.append(", denominazione=");
        sb.append(denominazione);
        sb.append(", ordine=");
        sb.append(ordine);
        sb.append(", className=");
        sb.append(className);
        sb.append(", defaultRicerca=");
        sb.append(defaultRicerca);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public CFG_CategorieAbilitate toEntityModel() {
        CFG_CategorieAbilitateImpl cfg_CategorieAbilitateImpl = new CFG_CategorieAbilitateImpl();

        if (titoloStruttura == null) {
            cfg_CategorieAbilitateImpl.setTitoloStruttura(StringPool.BLANK);
        } else {
            cfg_CategorieAbilitateImpl.setTitoloStruttura(titoloStruttura);
        }

        if (denominazione == null) {
            cfg_CategorieAbilitateImpl.setDenominazione(StringPool.BLANK);
        } else {
            cfg_CategorieAbilitateImpl.setDenominazione(denominazione);
        }

        cfg_CategorieAbilitateImpl.setOrdine(ordine);

        if (className == null) {
            cfg_CategorieAbilitateImpl.setClassName(StringPool.BLANK);
        } else {
            cfg_CategorieAbilitateImpl.setClassName(className);
        }

        cfg_CategorieAbilitateImpl.setDefaultRicerca(defaultRicerca);

        cfg_CategorieAbilitateImpl.resetOriginalValues();

        return cfg_CategorieAbilitateImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        titoloStruttura = objectInput.readUTF();
        denominazione = objectInput.readUTF();
        ordine = objectInput.readInt();
        className = objectInput.readUTF();
        defaultRicerca = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (titoloStruttura == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(titoloStruttura);
        }

        if (denominazione == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(denominazione);
        }

        objectOutput.writeInt(ordine);

        if (className == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(className);
        }

        objectOutput.writeBoolean(defaultRicerca);
    }
}
