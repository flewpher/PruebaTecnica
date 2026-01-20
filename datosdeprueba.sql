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
INSERT INTO producto (cliente_id, nombre) VALUES
(1, 'Leche entera marca A'),
(2, 'Leche 1L entera'),
(3, 'Leche entera clásica'),
(4, 'Leche entera premium'),
(1, 'Pan de molde blanco'),
(5, 'Pan sandwich'),
(6, 'Pan de molde familiar'),
(4, 'Arroz largo'),
(8, 'Arroz grano largo'),
(9, 'Arroz largo calidad extra'),
(1, 'Spaghetti clásicos'),
(10, 'Pasta spaghetti'),
(6, 'Spaghetti nº5');

-- Equivalencias entre productos (pares ordenados producto_a < producto_b)
INSERT INTO producto_equivalencia (producto_a, producto_b) VALUES
(1, 2),
(2, 3),
(3, 4),
(5, 6),
(6, 7),
(8, 9),
(9, 10),
(11, 12),
(11, 13);
