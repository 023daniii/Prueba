-- database: storage\Databases\antCiberDron.sqlite
DROP TABLE IF EXISTS LdAntCiberDron;
DROP TABLE IF EXISTS LdHormiga;
DROP TABLE IF EXISTS LdSexo;
DROP TABLE IF EXISTS LdEstado;
DROP TABLE IF EXISTS LdHormigaTipo;
DROP TABLE IF EXISTS LdAlimentoTipo;
CREATE TABLE LdAlimentoTipo(
    IdLdAlimentoTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    LdNombre VARCHAR(15) NOT NULL UNIQUE,
    LdDescripcion VARCHAR(100) NULL,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE LdHormigaTipo (
    IdLdHormigaTipo INTEGER PRIMARY KEY AUTOINCREMENT,
    LdNombre VARCHAR(15) NOT NULL UNIQUE,
    LdDescripcion VARCHAR(100) NULL,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE LdEstado (
    IdLdEstado INTEGER PRIMARY KEY AUTOINCREMENT,
    LdNombre VARCHAR(15) NOT NULL UNIQUE,
    LdDescripcion VARCHAR(100) NULL,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE LdSexo (
    IdLdSexo INTEGER PRIMARY KEY AUTOINCREMENT,
    LdNombre VARCHAR(15) NOT NULL UNIQUE,
    LdDescripcion VARCHAR(100) NULL,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE LdHormiga (
    IdLdHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    IdLdHormigaTipo INTEGER NOT NULL REFERENCES HormigaTipo (IdHormigaTipo),
    IdLdSexo INTEGER NOT NULL REFERENCES Sexo (IdSexo),
    IdLdEstado INTEGER NOT NULL REFERENCES Estado (IdEstado),
    LdNombre VARCHAR(20) NOT NULL UNIQUE,
    LdDescripcion VARCHAR(20) NULL,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
CREATE TABLE LdAntCiberDron (
    IdLdAntCiberDron INTEGER PRIMARY KEY AUTOINCREMENT,
    LdSerie VARCHAR(10) NOT NULL UNIQUE,
    LdEstado VARCHAR(1) NOT NULL DEFAULT 'A',
    LdFechaCreacion DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    LdFechaModifica DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))
);
-- Insert initial data into Sexo table
INSERT INTO LdSexo (LdNombre, LdDescripcion)
VALUES ('Macho', ' masculino'),
('Hembra', ' femenina'),
('Hibrido', ' Hibrido'),
('Asexual', ' Asexual');
INSERT INTO LdAlimentoTipo (LdNombre, LdDescripcion)
VALUES ('Carnivoro', 'Azucar'),
('Herbívoro', 'Proteina'),
('Omnívoro', 'Lipidico'),
('Nectarivoro', 'Vitaminico');
INSERT INTO LdHormigaTipo (LdNombre, LdDescripcion)
VALUES ('Larva', ' en etapa de larva'),
('Soldado', ' encargada de la defensa'),
('Rastreadora', ' encargada de buscar alimento'),
('Reina', ' encargada de la reproducción'),
('Zángano', ' macho para reproducción');
INSERT INTO LdEstado (LdNombre, LdDescripcion)
VALUES ('Vive', ' está viva'),
    ('Muere', ' ha muerto'),
    ('Finge', ' su muerte');
INSERT INTO LdAntCiberDron (LdSerie)
VALUES ('S001'),
    ('S002'),
    ('S003'),
    ('S004');
INSERT INTO LdHormiga (
        IdLdHormigaTipo,
        IdLdSexo,
        IdLdEstado,
        LdNombre,
        LdDescripcion
    )
VALUES (1, 2, 1, 'Hormiga1', 'Primera hormiga'),
    (2, 1, 1, 'Hormiga2', 'Segunda hormiga'),
    (3, 2, 1, 'Hormiga3', 'Tercera hormiga'),
    (4, 1, 1, 'Hormiga4', 'Cuarta hormiga');
select *
from LdSexo;
select *
from LdHormigaTipo;
select *
from LdEstado;
select *
from LdAlimentoTipo;
SELECT *
FROM LdHormiga;
DROP VIEW IF EXISTS LdvwHormiga;
CREATE VIEW LdvwHormiga AS
SELECT H.IdLdHormiga,
    HT.LdNombre AS LdTipo,
    S.LdNombre AS LdSexo,
    E.LdNombre AS LdEstadoHormiga,
    H.LdNombre AS LdNombre,
    H.LdDescripcion,
    H.LdEstado,
    H.LdFechaCreacion,
    H.LdFechaModifica
FROM LdHormiga H
    JOIN LdHormigaTipo HT ON H.IdLdHormigaTipo = HT.IdLdHormigaTipo
    JOIN LdSexo S ON H.IdLdSexo = S.IdLdSexo
    JOIN LdEstado E ON H.IdLdEstado = E.IdLdEstado
WHERE H.LdEstado = 'A';
SELECT *
FROM LdvwHormiga;
SELECT IdLdHormiga,
    LdTipo,
    LdSexo,
    LdEstadoHormiga,
    LdNombre,
    LdDescripcion,
    LdEstado,
    LdFechaCreacion,
    LdFechaModifica
FROM LdvwHormiga;
SELECT *
FROM LdHormiga;
UPDATE LdEstado
SET LdNombre = 'VIVA'
WHERE IdLdEstado = 1;
UPDATE LdEstado
SET LdNombre = 'MUERTA'
WHERE IdLdEstado = 2;
UPDATE LdEstado
SET LdEstado = 'X'
WHERE IdLdEstado = 3;
select *
from LdEstado;
ALTER TABLE AlimentoTipo
    RENAME TO LdAlimentoTipo;
ALTER TABLE AntCiberDron
    RENAME TO LdAntCiberDron;
ALTER TABLE Estado
    RENAME TO LdEstado;
ALTER TABLE Hormiga
    RENAME TO LdHormiga;
ALTER TABLE HormigaTipo
    RENAME TO LdHormigaTipo;
ALTER TABLE Sexo
    RENAME TO LdSexo;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN IdAlimentoTipo TO IdLdAlimentoTipo;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN Nombre TO LdNombre;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN Descripcion TO LdDescripcion;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdAlimentoTipo
    RENAME COLUMN FechaModifica TO LdFechaModifica;
ALTER TABLE LdAntCiberDron
    RENAME COLUMN IdAntCiberDron TO IdLdAntCiberDron;
ALTER TABLE LdAntCiberDron
    RENAME COLUMN Serie TO LdSerie;
ALTER TABLE LdAntCiberDron
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdAntCiberDron
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdAntCiberDron
    RENAME COLUMN FechaModifica TO LdFechaModifica;
ALTER TABLE LdEstado
    RENAME COLUMN IdEstado TO IdLdEstado;
ALTER TABLE LdEstado
    RENAME COLUMN Nombre TO LdNombre;
ALTER TABLE LdEstado
    RENAME COLUMN Descripcion TO LdDescripcion;
ALTER TABLE LdEstado
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdEstado
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdEstado
    RENAME COLUMN FechaModifica TO LdFechaModifica;
ALTER TABLE LdHormiga
    RENAME COLUMN IdHormiga TO IdLdHormiga;
ALTER TABLE LdHormiga
    RENAME COLUMN IdHormigaTipo TO IdLdHormigaTipo;
ALTER TABLE LdHormiga
    RENAME COLUMN Descripcion TO LdDescripcion;
ALTER TABLE LdHormiga
    RENAME COLUMN IdSexo TO IdLdSexo;
ALTER TABLE LdHormiga
    RENAME COLUMN IdEstado TO IdLdEstado;
ALTER TABLE LdHormiga
    RENAME COLUMN Nombre TO LdNombre;
ALTER TABLE LdHormiga
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdHormiga
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdHormiga
    RENAME COLUMN FechaModifica TO LdFechaModifica;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN IdHormigaTipo TO IdLdHormigaTipo;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN Nombre TO LdNombre;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN Descripcion TO LdDescripcion;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdHormigaTipo
    RENAME COLUMN FechaModifica TO LdFechaModifica;
ALTER TABLE LdSexo
    RENAME COLUMN IdSexo TO IdLdSexo;
ALTER TABLE LdSexo
    RENAME COLUMN Nombre TO LdNombre;
ALTER TABLE LdSexo
    RENAME COLUMN Descripcion TO LdDescripcion;
ALTER TABLE LdSexo
    RENAME COLUMN Estado TO LdEstado;
ALTER TABLE LdSexo
    RENAME COLUMN FechaCreacion TO LdFechaCreacion;
ALTER TABLE LdSexo
    RENAME COLUMN FechaModifica TO LdFechaModifica;
DROP VIEW IF EXISTS LdvwHormiga;
CREATE VIEW LdvwHormiga AS
SELECT H.IdLdHormiga AS IdLdHormiga,
    HT.LdNombre AS LdTipo,
    S.LdNombre AS LdSexo,
    E.LdNombre AS LdEstadoHormiga,
    H.LdNombre AS LdNombre,
    H.LdDescripcion AS LdDescripcion,
    H.LdEstado AS LdEstado,
    H.LdFechaCreacion AS LdFechaCreacion,
    H.LdFechaModifica AS LdFechaModifica
FROM LdHormiga H
    JOIN LdHormigaTipo HT ON H.IdLdHormigaTipo = HT.IdLdHormigaTipo
    JOIN LdSexo S ON H.IdLdSexo = S.IdLdSexo
    JOIN LdEstado E ON H.IdLdEstado = E.IdLdEstado
WHERE H.LdEstado = 'A';