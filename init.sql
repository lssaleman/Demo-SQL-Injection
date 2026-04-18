DROP TABLE IF EXISTS BancData;
DROP TABLE IF EXISTS UserData;

CREATE TABLE UserData
(
    user_id    INTEGER PRIMARY KEY AUTOINCREMENT,
    nutzername TEXT UNIQUE,
    passwort   TEXT,
    vorname    TEXT,
    nachname   TEXT
);

INSERT INTO UserData (nutzername, passwort, vorname, nachname)
VALUES
    ('max', 'pass123', 'Max', 'Mustermann'),
    ('peter', 'test', 'Peter', 'Schmidt'),
    ('laura', 'qwerty', 'Laura', 'Fischer'),
    ('tom', '123456', 'Tom', 'Weber');

CREATE TABLE BancData
(
    bank_id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER,
    bic     TEXT,
    iban    TEXT,
    pin     TEXT,
    FOREIGN KEY (user_id) REFERENCES UserData (user_id)
);

INSERT INTO BancData (user_id, bic, iban, pin)
VALUES
    (1, 'DEUTDEFFXXX', 'DE89370400440532013000', '1234'),
    (1, 'COBADEFFXXX', 'DE12500105170648489890', '5678'),
    (2, 'BYLADEM1001', 'DE44500105175407324931', '0000'),
    (3, 'GENODEF1S01', 'DE21500500009876543210', '4321'),
    (4, 'INGDDEFFXXX', 'DE75512108001245126199', '9999');