drop table if exists SANITAREST_CFG_CategorieAbilitate;
drop table if exists SANITAREST_CategoriaStruttura;
drop table if exists SANITAREST_News;
drop table if exists SANITAREST_StrutturaSanitaria;
drop table if exists SANITAREST_StrutturaSanitariaFiglia;

create table SANITAREST_CFG_CategorieAbilitate (
	titoloStruttura VARCHAR(255) not null primary key,
	denominazione VARCHAR(255) null,
	ordine INTEGER,
	className VARCHAR(255) null,
	defaultRicerca BOOLEAN
);

create table SANITAREST_CategoriaStruttura (
	idTipoStruttura VARCHAR(75) not null primary key,
	denominazione VARCHAR(75) null
);

create table SANITAREST_News (
	pk LONG not null primary key,
	idNews LONG,
	idAzienda VARCHAR(75) null,
	titolo VARCHAR(2000) null,
	immagine VARCHAR(255) null,
	descrizione TEXT null,
	dataPubblicazione LONG,
	autore VARCHAR(255) null,
	locale VARCHAR(75) null
);

create table SANITAREST_StrutturaSanitaria (
	pk LONG not null primary key,
	idStruttura LONG,
	groupId LONG,
	idTipoStruttura VARCHAR(255) null,
	tipoStruttura VARCHAR(255) null,
	tipologia VARCHAR(255) null,
	denominazione VARCHAR(500) null,
	immagine VARCHAR(255) null,
	descrizione TEXT null,
	indirizzo VARCHAR(255) null,
	lat DOUBLE,
	lng DOUBLE,
	distanza DOUBLE,
	telefono VARCHAR(75) null,
	email VARCHAR(255) null,
	fax VARCHAR(75) null,
	orari VARCHAR(500) null,
	locale VARCHAR(75) null,
	stato INTEGER,
	childrenEdottoOspedaleCollegato VARCHAR(500) null,
	childrenEdottoAmbulatorio VARCHAR(2000) null,
	childrenEdottoUnitaOperativa VARCHAR(2000) null,
	childrenEdottoUnitaps VARCHAR(500) null,
	relazioneAmbulatorio VARCHAR(2000) null
);

create table SANITAREST_StrutturaSanitariaFiglia (
	idStrutturaFiglia LONG not null primary key,
	tipoStruttura VARCHAR(75) null,
	denominazione VARCHAR(75) null,
	indirizzo VARCHAR(75) null,
	direttore VARCHAR(75) null,
	responsabileSanitario VARCHAR(75) null,
	telefono VARCHAR(75) null,
	email VARCHAR(75) null
);

insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('Ospedale', 'Struttura Ospedaliera', 1, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('UfficioSemplice.ps', 'Pronto Soccorso', 2, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('UfficioSemplice.GuardiaMedica', 'Continuit� Assistenziale', 3, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('UfficioSemplice.pi', 'Punti di Primo Intervento', 4, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('Farmacia', 'Farmacia', 5, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('CUP', 'Centro Unico Prenotazioni', 6, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('Poliambulatorio', 'Poliambulatorio', 7, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('Ambulatorio', 'Ambulatorio', 8, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('AziendaSanitaria', 'Azienda Sanitaria Locale (ASL)', 9, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('RSA', 'RSA', 10, 'it.sincon.sanita.services.model.StrutturaSanitaria', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('20182', 'Portale Regionale', 11, 'it.sincon.sanita.services.model.News', true);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('25619', 'ASL Bari', 12, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36008', 'ASL Barletta Andria Trani', 13, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36031', 'ASL Brindisi', 14, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36044', 'ASL Foggia', 15, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('25176', 'ASL Lecce', 16, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36057', 'ASL Taranto', 17, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36067', 'Policlinico di Bari Ospedale Giovanni XXIII', 18, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36096', 'Istituto Tumori Bari Giovanni Paolo II - IRCCS', 19, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36092', 'IRCCS de Bellis', 20, 'it.sincon.sanita.services.model.News', false);
insert into SANITAREST_CFG_CategorieAbilitate (titoloStruttura, denominazione, ordine, className, defaultRicerca) values ('36080', 'Azienda Ospedaliero Universitaria Ospedali Riuniti - Foggia', 21, 'it.sincon.sanita.services.model.News', false);