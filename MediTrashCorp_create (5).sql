-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-02-07 15:39:33.385

-- tables
-- Table: Odpad
CREATE TABLE Odpad (
                       ODP_NAZEV nvarchar(255)  NOT NULL,
                       ODP_KATEG nvarchar(1)  NOT NULL,
                       ODP_MNOZ float(17)  NOT NULL,
                       ODP_ODPID int  NOT NULL,
                       CONSTRAINT Odpad_pk PRIMARY KEY  (ODP_ODPID)
);

-- Table: Opravnena_osoba
CREATE TABLE Opravnena_osoba (
                                 ODP_ID int  NOT NULL,
                                 ODP_NAZEVP nvarchar(255)  NOT NULL,
                                 ODP_PARTNER nvarchar(8)  NOT NULL,
                                 ODP_ULICE nvarchar(74)  NOT NULL,
                                 ODP_MISTOP nvarchar(60)  NOT NULL,
                                 ODP_PSCP nvarchar(5)  NOT NULL,
                                 ODP_DATUMPOT datetime  NOT NULL,
                                 ODP_PROVOZP nvarchar(12)  NOT NULL,
                                 ODP_ICZUJP nvarchar(6)  NOT NULL,
                                 ODP_UPRES nvarchar(60)  NOT NULL,
                                 CONSTRAINT Opravnena_osoba_pk PRIMARY KEY  (ODP_ID)
);

-- Table: Uzivatel
CREATE TABLE Uzivatel (
                          FIR_ID int  NOT NULL,
                          FIR_NAZEV nvarchar(255)  NOT NULL,
                          FIR_ULICE nvarchar(74)  NOT NULL,
                          FIR_MISTO nvarchar(60)  NOT NULL,
                          FIR_PSC nvarchar(5)  NOT NULL,
                          FIR_KOD nvarchar(8)  NOT NULL,
                          FIR_TEL nvarchar(12)  NOT NULL,
                          FIR_MAIL nvarchar(60)  NOT NULL,
                          FIR_FAX nvarchar(12)  NOT NULL,
                          FIR_PRAV nvarchar(1)  NOT NULL,
                          FIR_LOGIN nvarchar(25) UNIQUE NOT NULL,
                          FIR_HESLO nvarchar(25)  NOT NULL,
                          FIR_PROVOZ nvarchar(12)  NOT NULL,
                          CONSTRAINT Uzivatel_pk PRIMARY KEY  (FIR_ID)
);

-- Table: Vyhazovani_Odpadu
CREATE TABLE Vyhazovani_Odpadu (
                                   ODP_ID int  NOT NULL,
                                   ODP_DATUM datetime  NOT NULL,
                                   ODP_VHID int  NOT NULL,
                                   ODP_ZPNAKL nvarchar(4)  NOT NULL,
                                   ODP_ODPID int  NOT NULL,
                                   FIR_ID int  NOT NULL,
                                   CONSTRAINT Vyhazovani_Odpadu_pk PRIMARY KEY  (ODP_VHID)
);

-- Table: Zpusob_nakladani
CREATE TABLE Zpusob_nakladani (
                                  ODP_ZPNAKL nvarchar(4)  NOT NULL,
                                  ODP_NAKNAZEV nvarchar(255)  NOT NULL,
                                  CONSTRAINT Zpusob_nakladani_pk PRIMARY KEY  (ODP_ZPNAKL)
);

-- foreign keys
-- Reference: Vyhazovani_Odpadu_Odpad (table: Vyhazovani_Odpadu)
ALTER TABLE Vyhazovani_Odpadu ADD CONSTRAINT Vyhazovani_Odpadu_Odpad
    FOREIGN KEY (ODP_ODPID)
        REFERENCES Odpad (ODP_ODPID);

-- Reference: Vyhazovani_Odpadu_Opravnena_osoba (table: Vyhazovani_Odpadu)
ALTER TABLE Vyhazovani_Odpadu ADD CONSTRAINT Vyhazovani_Odpadu_Opravnena_osoba
    FOREIGN KEY (ODP_ID)
        REFERENCES Opravnena_osoba (ODP_ID) ON UPDATE CASCADE ON DELETE CASCADE;

-- Reference: Vyhazovani_Odpadu_Uzivatel (table: Vyhazovani_Odpadu)
ALTER TABLE Vyhazovani_Odpadu ADD CONSTRAINT Vyhazovani_Odpadu_Uzivatel
    FOREIGN KEY (FIR_ID)
        REFERENCES Uzivatel (FIR_ID) ON UPDATE CASCADE ON DELETE CASCADE;

-- Reference: Vyhazovani_Odpadu_Zpusob_nakladani (table: Vyhazovani_Odpadu)
ALTER TABLE Vyhazovani_Odpadu ADD CONSTRAINT Vyhazovani_Odpadu_Zpusob_nakladani
    FOREIGN KEY (ODP_ZPNAKL)
        REFERENCES Zpusob_nakladani (ODP_ZPNAKL);

-- End of file.
