package it.sincon.sanita.services.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.sincon.sanita.services.model.News;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing News in entity cache.
 *
 * @author Sincon
 * @see News
 * @generated
 */
public class NewsCacheModel implements CacheModel<News>, Externalizable {
    public long pk;
    public long idNews;
    public String idAzienda;
    public String titolo;
    public String immagine;
    public String descrizione;
    public long dataPubblicazione;
    public String autore;
    public String locale;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{pk=");
        sb.append(pk);
        sb.append(", idNews=");
        sb.append(idNews);
        sb.append(", idAzienda=");
        sb.append(idAzienda);
        sb.append(", titolo=");
        sb.append(titolo);
        sb.append(", immagine=");
        sb.append(immagine);
        sb.append(", descrizione=");
        sb.append(descrizione);
        sb.append(", dataPubblicazione=");
        sb.append(dataPubblicazione);
        sb.append(", autore=");
        sb.append(autore);
        sb.append(", locale=");
        sb.append(locale);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public News toEntityModel() {
        NewsImpl newsImpl = new NewsImpl();

        newsImpl.setPk(pk);
        newsImpl.setIdNews(idNews);

        if (idAzienda == null) {
            newsImpl.setIdAzienda(StringPool.BLANK);
        } else {
            newsImpl.setIdAzienda(idAzienda);
        }

        if (titolo == null) {
            newsImpl.setTitolo(StringPool.BLANK);
        } else {
            newsImpl.setTitolo(titolo);
        }

        if (immagine == null) {
            newsImpl.setImmagine(StringPool.BLANK);
        } else {
            newsImpl.setImmagine(immagine);
        }

        if (descrizione == null) {
            newsImpl.setDescrizione(StringPool.BLANK);
        } else {
            newsImpl.setDescrizione(descrizione);
        }

        newsImpl.setDataPubblicazione(dataPubblicazione);

        if (autore == null) {
            newsImpl.setAutore(StringPool.BLANK);
        } else {
            newsImpl.setAutore(autore);
        }

        if (locale == null) {
            newsImpl.setLocale(StringPool.BLANK);
        } else {
            newsImpl.setLocale(locale);
        }

        newsImpl.resetOriginalValues();

        return newsImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        pk = objectInput.readLong();
        idNews = objectInput.readLong();
        idAzienda = objectInput.readUTF();
        titolo = objectInput.readUTF();
        immagine = objectInput.readUTF();
        descrizione = objectInput.readUTF();
        dataPubblicazione = objectInput.readLong();
        autore = objectInput.readUTF();
        locale = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(pk);
        objectOutput.writeLong(idNews);

        if (idAzienda == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(idAzienda);
        }

        if (titolo == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(titolo);
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

        objectOutput.writeLong(dataPubblicazione);

        if (autore == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(autore);
        }

        if (locale == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(locale);
        }
    }
}
