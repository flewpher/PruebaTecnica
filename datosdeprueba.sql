INSERT INTO cliente (nombre) VALUES
('Empresa A'),
('Empresa B'),
('Empresa C'),
('Empresa D'),
('Empresa E'),
('Empresa F'),
('Empresa G'),
('Empresa H'),
('Empresa I'),
('Empresa J');
INSERT INTO grupo_producto (nombre) VALUES
('Leche entera 1L'),
('Pan de molde'),
('Aceite de oliva 1L'),
('Arroz largo'),
('Pasta spaghetti');
INSERT INTO producto (cliente_id, grupo_id, nombre) VALUES
(1, 1, 'Leche entera marca A'),
(2, 1, 'Leche 1L entera'),
(3, 1, 'Leche entera clásica'),
(4, 1, 'Leche entera premium');
INSERT INTO producto (cliente_id, grupo_id, nombre) VALUES
(1, 2, 'Pan de molde blanco'),
(5, 2, 'Pan sandwich'),
(6, 2, 'Pan de molde familiar');
INSERT INTO producto (cliente_id, grupo_id, nombre) VALUES
(4, 4, 'Arroz largo'),
(8, 4, 'Arroz grano largo'),
(9, 4, 'Arroz largo calidad extra');
INSERT INTO producto (cliente_id, grupo_id, nombre) VALUES
(1, 5, 'Spaghetti clásicos'),
(10, 5, 'Pasta spaghetti'),
(6, 5, 'Spaghetti nº5');
