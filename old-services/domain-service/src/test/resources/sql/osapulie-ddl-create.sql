CREATE TABLE tb_area_aggregata (ID BIGINT NOT NULL, descrizione VARCHAR(256), nome VARCHAR(64) NOT NULL UNIQUE, PRIMARY KEY (ID));

CREATE TABLE tb_comune (ID BIGINT NOT NULL, cap VARCHAR(6) NOT NULL UNIQUE, codice_istat VARCHAR(8) NOT NULL UNIQUE, descrizione VARCHAR(512), nome VARCHAR(64) NOT NULL UNIQUE, uri_servizio_gw LONGTEXT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_profilo_utente_cittadino (ID VARCHAR(255) NOT NULL, codice_fiscale VARCHAR(16) NOT NULL UNIQUE, cognome VARCHAR(128) NOT NULL, nome VARCHAR(128) NOT NULL, pec VARCHAR(128) NOT NULL,ind_nr_civico VARCHAR(16), ind_via VARCHAR(256), fk_ind_comune BIGINT NOT NULL, fk_professionista VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE tb_profilo_utente_professionista (ID VARCHAR(255) NOT NULL, codice_fiscale VARCHAR(16) NOT NULL UNIQUE, cognome VARCHAR(128) NOT NULL, nome VARCHAR(128) NOT NULL, partita_iva VARCHAR(255) NOT NULL UNIQUE, ind_nr_civico VARCHAR(16), ind_via VARCHAR(256), fk_ind_comune BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_fascicolo_utente (ID BIGINT NOT NULL, fk_cittadino VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_richiesta_servizio (ID BIGINT NOT NULL, data_richiesta DATETIME, data_risposta DATETIME, nome_servizio VARCHAR(128) NOT NULL, fk_comune BIGINT, fk_fascicolo BIGINT, PRIMARY KEY (ID));
CREATE TABLE tb_servizio (ID BIGINT NOT NULL, descrizione VARCHAR(255) NOT NULL, nome_servizio VARCHAR(64) UNIQUE, PRIMARY KEY (ID));

CREATE TABLE tb_comune (ID BIGINT NOT NULL, cap VARCHAR(6) NOT NULL UNIQUE, codice_istat VARCHAR(8) NOT NULL UNIQUE, descrizione VARCHAR(512), nome VARCHAR(64) NOT NULL UNIQUE, uri_servizio_gw LONGVARCHAR NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_profilo_utente_cittadino (ID VARCHAR NOT NULL, codice_fiscale VARCHAR(16) NOT NULL UNIQUE, cognome VARCHAR(128) NOT NULL, nome VARCHAR(128) NOT NULL, pec VARCHAR(128) NOT NULL, ind_nr_civico VARCHAR(16), ind_via VARCHAR(256), fk_ind_comune BIGINT NOT NULL, fk_professionista VARCHAR, PRIMARY KEY (ID));
CREATE TABLE tb_profilo_utente_professionista (ID VARCHAR NOT NULL, codice_fiscale VARCHAR(16) NOT NULL UNIQUE, cognome VARCHAR(128) NOT NULL, nome VARCHAR(128) NOT NULL, partita_iva VARCHAR NOT NULL UNIQUE, pec VARCHAR(128) NOT NULL, ind_nr_civico VARCHAR(16), ind_via VARCHAR(256), fk_ind_comune BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_fascicolo_utente (ID BIGINT NOT NULL, fk_cittadino VARCHAR NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_richiesta_servizio (ID BIGINT NOT NULL, data_richiesta TIMESTAMP, data_risposta TIMESTAMP, nome_servizio VARCHAR(128) NOT NULL, fk_comune BIGINT, fk_fascicolo BIGINT, PRIMARY KEY (ID));
CREATE TABLE tb_servizio (ID BIGINT NOT NULL, descrizione VARCHAR NOT NULL, nome_servizio VARCHAR(64) UNIQUE, PRIMARY KEY (ID));

CREATE TABLE tb_servizio_erogato (ID BIGINT NOT NULL, uri VARCHAR(256) NOT NULL, fk_servizio BIGINT NOT NULL, PRIMARY KEY (ID));
CREATE TABLE tb_area_aggregata_comune (area_id BIGINT NOT NULL, comune_id BIGINT NOT NULL, PRIMARY KEY (area_id, comune_id));
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_professionista FOREIGN KEY (fk_professionista) REFERENCES tb_profilo_utente_professionista (ID);
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_ind_comune FOREIGN KEY (fk_ind_comune) REFERENCES tb_comune (ID);
ALTER TABLE tb_profilo_utente_professionista ADD CONSTRAINT FK_tb_profilo_utente_professionista_fk_ind_comune FOREIGN KEY (fk_ind_comune) REFERENCES tb_comune (ID);
ALTER TABLE tb_fascicolo_utente ADD CONSTRAINT FK_tb_fascicolo_utente_fk_cittadino FOREIGN KEY (fk_cittadino) REFERENCES tb_profilo_utente_cittadino (ID);
ALTER TABLE tb_richiesta_servizio ADD CONSTRAINT FK_tb_richiesta_servizio_fk_fascicolo FOREIGN KEY (fk_fascicolo) REFERENCES tb_fascicolo_utente (ID);
ALTER TABLE tb_richiesta_servizio ADD CONSTRAINT FK_tb_richiesta_servizio_fk_comune FOREIGN KEY (fk_comune) REFERENCES tb_comune (ID);
ALTER TABLE tb_servizio_erogato ADD CONSTRAINT FK_tb_servizio_erogato_fk_servizio FOREIGN KEY (fk_servizio) REFERENCES tb_servizio (ID);
ALTER TABLE tb_area_aggregata_comune ADD CONSTRAINT FK_tb_area_aggregata_comune_comune_id FOREIGN KEY (comune_id) REFERENCES tb_comune (ID);
ALTER TABLE tb_area_aggregata_comune ADD CONSTRAINT FK_tb_area_aggregata_comune_area_id FOREIGN KEY (area_id) REFERENCES tb_area_aggregata (ID);
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0);

alter table tb_comune add pec varchar(128);

alter table tb_profilo_utente_professionista add data_autenticazione_forte DATETIME;
alter table tb_profilo_utente_professionista add mail varchar(255);
alter table tb_profilo_utente_professionista add mail_pec varchar(255);

alter table tb_profilo_utente_cittadino add data_autenticazione_forte DATETIME;
alter table tb_profilo_utente_cittadino add mail varchar(255);
alter table tb_profilo_utente_cittadino add mail_pec varchar(255);

alter table tb_profilo_utente_cittadino add autenticazione_forte varchar(1);

alter table tb_profilo_utente_cittadino add fk_id VARCHAR(255);
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_id FOREIGN KEY (fk_id) REFERENCES tb_profilo_utente_cittadino (ID)

alter table tb_profilo_utente_professionista add fk_profiloutentecittadino VARCHAR(255);
alter table tb_profilo_utente_professionista ADD CONSTRAINT FK_tb_profilo_utente_professionista_fk_profiloutentecittadino FOREIGN KEY (fk_profiloutentecittadino) REFERENCES tb_profilo_utente_cittadino (ID);

ALTER TABLE tb_comune RENAME tb_comune_isa;
alter table tb_profilo_utente_cittadino add fk_comune_isa BIGINT NOT NULL;

/******NEW 27/01/2012****/
CREATE TABLE tb_area_aggregata (ID BIGINT NOT NULL, descrizione VARCHAR(256), nome VARCHAR(64) NOT NULL UNIQUE, PRIMARY KEY (ID))
CREATE TABLE tb_comune (ID BIGINT NOT NULL, altitudine VARCHAR(45), capoluogo TINYINT(1) default 0, codiceComune INTEGER, codiceIstat1 VARCHAR(45), codiceIstat103 VARCHAR(45), codiceIstatAN VARCHAR(45), codiceSistemaLocaleLavoro VARCHAR(45), codicestat107 VARCHAR(45), comuneLitoraneo TINYINT(1) default 0, comuneMontano VARCHAR(45), denominazione VARCHAR(100), denominazioneSistemaLocaleLavoro VARCHAR(100), popolazioneLegale VARCHAR(45), popolazioneResidente1 VARCHAR(45), popolazioneResidente2 VARCHAR(45), popolazioneResidente3 VARCHAR(45), superficie VARCHAR(45), zonaAltimetrica VARCHAR(45), idProvincia BIGINT, PRIMARY KEY (ID))
CREATE TABLE tb_provincia (ID BIGINT NOT NULL, codiceNUTS1 VARCHAR(45), codiceNUTS2 VARCHAR(45), codiceNUTS3 VARCHAR(45), codiceRegione INTEGER, codiceRipartizione INTEGER, denominazioneProvincia VARCHAR(75), denominazioneRegione VARCHAR(75), denominazioneRegioneM VARCHAR(45), ripartizioneGeografica VARCHAR(75), ripartizioneGeograficaM VARCHAR(45), sigla VARCHAR(2), PRIMARY KEY (ID))
CREATE TABLE tb_comune_isa (ID BIGINT NOT NULL, cap VARCHAR(6) NOT NULL UNIQUE, codice_istat VARCHAR(8) NOT NULL UNIQUE, descrizione VARCHAR(512), nome VARCHAR(64) NOT NULL UNIQUE, pec VARCHAR(128) NOT NULL, uri_servizio_gw LONGTEXT NOT NULL, PRIMARY KEY (ID))
CREATE TABLE tb_profilo_utente_cittadino (ID VARCHAR(255) NOT NULL, autenticazione_forte TINYINT(1) default 0, codice_fiscale VARCHAR(16) NOT NULL UNIQUE, cognome VARCHAR(128) NOT NULL, data_autenticazione_forte DATE, mail VARCHAR(128) NOT NULL, mail_pec VARCHAR(128), nome VARCHAR(128) NOT NULL, ind_nr_civico VARCHAR(16), ind_via VARCHAR(256), fk_ind_comune BIGINT NOT NULL, fk_comune_isa BIGINT NOT NULL, fk_id VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE tb_profilo_utente_professionista (ID BIGINT NOT NULL, partita_iva VARCHAR(255) NOT NULL UNIQUE, fk_profiloutentecittadino VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE tb_fascicolo_utente (ID BIGINT NOT NULL, fk_cittadino VARCHAR(255) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE tb_richiesta_servizio (ID BIGINT NOT NULL, data_richiesta DATETIME, data_risposta DATETIME, nome_servizio VARCHAR(128) NOT NULL, fk_comune BIGINT, fk_delegante VARCHAR(255), fk_fascicolo BIGINT, PRIMARY KEY (ID))
CREATE TABLE tb_servizio (ID BIGINT NOT NULL, codice_servizio VARCHAR(5) UNIQUE, descrizione VARCHAR(255) NOT NULL, nome_servizio VARCHAR(255) UNIQUE, uri VARCHAR(256) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE tb_servizio_erogato (ID BIGINT NOT NULL, uri VARCHAR(256) NOT NULL, fk_servizio BIGINT NOT NULL, PRIMARY KEY (ID))
CREATE TABLE tb_area_aggregata_comune (area_id BIGINT NOT NULL, comune_id BIGINT NOT NULL, PRIMARY KEY (area_id, comune_id))
ALTER TABLE tb_comune ADD CONSTRAINT FK_tb_comune_idProvincia FOREIGN KEY (idProvincia) REFERENCES tb_provincia (ID)
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_comune_isa FOREIGN KEY (fk_comune_isa) REFERENCES tb_comune_isa (ID)
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_id FOREIGN KEY (fk_id) REFERENCES tb_profilo_utente_cittadino (ID)
ALTER TABLE tb_profilo_utente_cittadino ADD CONSTRAINT FK_tb_profilo_utente_cittadino_fk_ind_comune FOREIGN KEY (fk_ind_comune) REFERENCES tb_comune (ID)
ALTER TABLE tb_profilo_utente_professionista ADD CONSTRAINT tbprfloutenteprofessionistafkprfiloutentecittadino FOREIGN KEY (fk_profiloutentecittadino) REFERENCES tb_profilo_utente_cittadino (ID)
ALTER TABLE tb_fascicolo_utente ADD CONSTRAINT FK_tb_fascicolo_utente_fk_cittadino FOREIGN KEY (fk_cittadino) REFERENCES tb_profilo_utente_cittadino (ID)
ALTER TABLE tb_richiesta_servizio ADD CONSTRAINT FK_tb_richiesta_servizio_fk_delegante FOREIGN KEY (fk_delegante) REFERENCES tb_profilo_utente_cittadino (ID)
ALTER TABLE tb_richiesta_servizio ADD CONSTRAINT FK_tb_richiesta_servizio_fk_fascicolo FOREIGN KEY (fk_fascicolo) REFERENCES tb_fascicolo_utente (ID)
ALTER TABLE tb_richiesta_servizio ADD CONSTRAINT FK_tb_richiesta_servizio_fk_comune FOREIGN KEY (fk_comune) REFERENCES tb_comune_isa (ID)
ALTER TABLE tb_servizio_erogato ADD CONSTRAINT FK_tb_servizio_erogato_fk_servizio FOREIGN KEY (fk_servizio) REFERENCES tb_servizio (ID)
ALTER TABLE tb_area_aggregata_comune ADD CONSTRAINT FK_tb_area_aggregata_comune_comune_id FOREIGN KEY (comune_id) REFERENCES tb_comune_isa (ID)
ALTER TABLE tb_area_aggregata_comune ADD CONSTRAINT FK_tb_area_aggregata_comune_area_id FOREIGN KEY (area_id) REFERENCES tb_area_aggregata (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
12:53:45,406  INFO main ddl.DDLGeneratorTool:113 - Done fixing osapulie-ddl-create.sql!
12:53:45,406  INFO main ddl.DDLGeneratorTool:92 - Fixing osapulie-ddl-drop.sql ...
12:53:45,406 DEBUG main ddl.DDLGeneratorTool:98 - Creating work file C:\DOCUME~1\AULACO~1\IMPOST~1\Temp\fix_2281073402477530870.tmp ...
ALTER TABLE tb_comune DROP FOREIGN KEY FK_tb_comune_idProvincia
ALTER TABLE tb_profilo_utente_cittadino DROP FOREIGN KEY FK_tb_profilo_utente_cittadino_fk_comune_isa
ALTER TABLE tb_profilo_utente_cittadino DROP FOREIGN KEY FK_tb_profilo_utente_cittadino_fk_id
ALTER TABLE tb_profilo_utente_cittadino DROP FOREIGN KEY FK_tb_profilo_utente_cittadino_fk_ind_comune
ALTER TABLE tb_profilo_utente_professionista DROP FOREIGN KEY tbprfloutenteprofessionistafkprfiloutentecittadino
ALTER TABLE tb_fascicolo_utente DROP FOREIGN KEY FK_tb_fascicolo_utente_fk_cittadino
ALTER TABLE tb_richiesta_servizio DROP FOREIGN KEY FK_tb_richiesta_servizio_fk_delegante
ALTER TABLE tb_richiesta_servizio DROP FOREIGN KEY FK_tb_richiesta_servizio_fk_fascicolo
ALTER TABLE tb_richiesta_servizio DROP FOREIGN KEY FK_tb_richiesta_servizio_fk_comune
ALTER TABLE tb_servizio_erogato DROP FOREIGN KEY FK_tb_servizio_erogato_fk_servizio
ALTER TABLE tb_area_aggregata_comune DROP FOREIGN KEY FK_tb_area_aggregata_comune_comune_id
ALTER TABLE tb_area_aggregata_comune DROP FOREIGN KEY FK_tb_area_aggregata_comune_area_id
DROP TABLE tb_area_aggregata
DROP TABLE tb_comune
DROP TABLE tb_provincia
DROP TABLE tb_comune_isa
DROP TABLE tb_profilo_utente_cittadino
DROP TABLE tb_profilo_utente_professionista
DROP TABLE tb_fascicolo_utente
DROP TABLE tb_richiesta_servizio
DROP TABLE tb_servizio
DROP TABLE tb_servizio_erogato
DROP TABLE tb_area_aggregata_comune
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
