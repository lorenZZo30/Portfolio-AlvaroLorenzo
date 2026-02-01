INSERT INTO INFO (descripcion, email, foto_url, github, linkedin, nombre) VALUES ('Apasionado de la informática, me defino por ser una

persona con ganas de aprender y mejorar.', 'alvarolc06@gmail.com', '/img/perfil.jpeg', 'https://github.com/lorenZZo30', 'https://www.linkedin.com/in/alvaro-lorenzo301', 'Álvaro Lorenzo Carrillo');


INSERT INTO LENGUAJES(icono_url, name) VALUES
('/img/java.png', 'Java'),
('/img/html.png', 'HTML'),
('/img/css.png', 'CSS'),
('/img/mysql.png', 'MySQL'),
('/img/spring.png', 'Spring'),
('/img/python.jpg', 'Python'),
('/img/bash.png', 'Bash'),
('/img/wpf.png', 'WPF'),
('/img/c-sharp.png', 'C#'),
('/img/kotlin.png', 'Kotlin'),
('/img/unity.png', 'Unity'),
('/img/fastapi.png', 'FastAPI'),
('/img/mongodb.png', 'MongoDB');


INSERT INTO PROYECTOS(descripcion, fecha, github_url, imagen_url, nombre) values
('Aplicación de gestión de empleados que recoge los datos de una base de datos SQL.

La aplicación consta de varias pantallas, entre las cuales hay una de "Configuración" en la cual se puede cambiar el idioma de la aplicación en caliente entre español e inglés.

El front está hecho con WPF, el back con WPF y la recolección de datos con MySQL.)',
'2026-01-20', '', '/img/wpf-gestionempleados-png', 'Gestión de empleados');


INSERT INTO proyecto_lenguaje(proyecto_id, lenguaje_id) VALUES
(1, 2),
(1, 9),
(1, 12);

INSERT INTO USUARIOS(id, email, enabled, password, role, username) VALUES
(1, 'alvarolc06@gmail.com', true, '$2a$10$/JftDXJAenzMb0RYnMqGg.GqMPpEfSbuZYACLeYd9yV8rrfpuiWXS', 'ROLE_USER', 'alvaro'),
(2, 'admin@admin', true, '$2a$10$20PeGzNeV4L.qYOgY06zr.iZYZtXPSlEII1/smPgScD6nrPGsN74C', 'ROLE_USER', 'admin');