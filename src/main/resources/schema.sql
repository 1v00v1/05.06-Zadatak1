CREATE TABLE  Type
(
id  IDENTITY PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE  Hardware
(
id  IDENTITY PRIMARY KEY,
naziv VARCHAR(50)    NOT NULL,
sifra VARCHAR(50)    NOT NULL,
cijena DECIMAL(10,2) NOT NULL,
typeId INT NOT NULL,
kolicina INT NOT NULL,
FOREIGN KEY(typeId) REFERENCES Type(id)


);