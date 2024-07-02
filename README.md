### Backend
**Dir Path:** `src/main/java`

### Frontend
**Dir Path:** `src/main/resources/static`

### Database Setup
> **ATENCION:** Respetar los campos tal cual están para que funcione correctamente el Back End.

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
#### User Database
```sql
CREATE TABLE monserrat.usuarios (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) UNIQUE NOT NULL,
    pass VARCHAR(45) NOT NULL
);
```
