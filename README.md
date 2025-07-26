# HostelMarket Secondhand

Aplicación web para la **compra-venta de maquinaria de hostelería de segunda mano**.

---

## Autor

- **Nombre:** Leo V
- **Email:** [blureddoor@universidad.com](mailto:blureddoor@universidad.com)
- **GitHub:** [blureddoor](https://github.com/blureddoor)

---

## Tabla de Contenidos

- [Descripción](#descripción)
- [Estado del proyecto](#estado-del-proyecto)
- [Entidades principales](#entidades-principales)
- [Permisos de usuario](#permisos-de-usuario)
- [Diagrama de entidades](#diagrama-de-entidades)
- [Cómo ejecutar](#cómo-ejecutar)
- [Licencia](#licencia)

---

## Descripción

Esta aplicación permite publicar, buscar y gestionar anuncios de maquinaria usada para el sector HORECA (Hoteles, Restaurantes y Cafeterías).

---

## Estado del proyecto

- Proyecto iniciado con Spring Boot (versión 3.5.4).
- Dependencias mínimas configuradas (web, mustache, JPA, MySQL connector, lombok).
- Seguridad aún **no implementada**.
- Primer commit subido a GitHub.
- Pendiente: Implementar modelo, controladores y vistas principales.

---

## Entidades principales

- **Usuario** (User): Publica y gestiona anuncios.
- **Anuncio** (Listing): Maquinaria a la venta.
- **Imagen** (Image): Fotos de cada máquina.

---

## Permisos de usuario

- Usuario registrado: Puede publicar, editar y eliminar sus propios anuncios.
- Usuario anónimo: Puede ver anuncios.

---

## Diagrama de entidades

```plaintext
+---------+          +-----------+         +---------+
|  User   | 1     *  |  Listing  |  1   * |  Image  |
+---------+----------+-----------+---------+---------+
| id      |          | id        |         | id      |
| name    |          | title     |         | url     |
| email   |          | desc      |         | ...     |
| ...     |          | owner_id  |         |         |
+---------+          +-----------+         +---------+
