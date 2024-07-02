### Backend
**Dir Path:** `src/main/java`

### Frontend
**Dir Path:** `src/main/resources/static`

### Database Setup

```sql
CREATE SCHEMA monserrat;
```

```sql
CREATE TABLE monserrat.libros (
    ID INT PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(45)
);
```

```sql
INSERT INTO monserrat.libros (ID, titulo, genero) VALUES
(1, 'HSTÉRICA', 'poesia'),
(2, 'CERROJO', 'poesia'),
(3, 'SILENCIO', 'poesia'),
(4, 'LUZ Y FUERZA', 'poesia'),
(5, 'REALIDARK', 'poesia'),
(6, 'La lógica de lo perecedero', 'plaqueta'),
(7, 'Ojas', 'plaqueta'),
(8, 'Polvareda', 'plaqueta');
```

