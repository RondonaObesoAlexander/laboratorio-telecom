# Laboratorio de Integración de Sistemas
## Infraestructura Unificada de Comunicaciones y Gestión de Identidad

### 📌 Descripción del Proyecto
Este laboratorio tiene como objetivo diseñar e implementar un prototipo funcional de una plataforma de telecomunicaciones para una empresa del sector financiero. La solución integra:

- **Central telefónica (PBX)** basada en **Asterisk** (código abierto).
- **Sistema de gestión de identidades** con **midPoint** (Identity Governance and Administration).
- **Orquestación mediante Docker** para desplegar todos los servicios de manera aislada y escalable.
- **Cumplimiento de estándares** ISO 27001 (seguridad) e ISO/IEC 25010 (calidad de software).

El sistema permite a los agentes de call center autenticarse de forma centralizada, recibir y realizar llamadas VoIP, y gestionar extensiones SIP de manera automatizada a través de la sincronización de usuarios entre midPoint y Asterisk.

---

### 🎯 Objetivos del Laboratorio
1. Diseñar una arquitectura de microservicios que integre telefonía VoIP, base de datos y control de accesos.
2. Implementar un entorno de contenedores con Docker Compose para Asterisk, midPoint y MariaDB.
3. Automatizar pruebas unitarias y de integración, y aplicar análisis de código estático.
4. Aplicar controles de seguridad basados en ISO 27001 (cifrado TLS/SRTP, autenticación centralizada, logs de auditoría).
5. Documentar el ciclo de vida del desarrollo de software (SDLC) mediante un tablero Kanban y control de versiones con Git.

---

### 🧱 Arquitectura Propuesta
El sistema se compone de los siguientes bloques lógicos:

| Componente         | Tecnología              | Descripción                                                                 |
|--------------------|-------------------------|-----------------------------------------------------------------------------|
| **Frontend / Softphone** | WebRTC / Linphone       | Interfaz para que los agentes realicen y reciban llamadas.                  |
| **Motor de Comunicación** | Asterisk (PBX)          | Enrutamiento de llamadas, conferencias, generación de CDRs.                 |
| **Gestión de Identidad**  | midPoint (IGA)          | Orquestación de identidades, aplicación de políticas RBAC.                  |
| **Persistencia**          | MariaDB                 | Almacenamiento de repositorios de midPoint y tabla de clientes/usuarios.    |
| **Seguridad**             | TLS + SRTP + midPoint   | Cifrado de comunicaciones, autenticación centralizada y logs de auditoría.  |

---

### 🚀 Requisitos para Ejecutar el Proyecto
- **Sistema operativo**: Ubuntu 22.04 LTS (recomendado) u otro con Docker compatible.
- **Docker** y **Docker Compose** instalados.
- **Git** para clonar el repositorio.
- Puertos abiertos: `3306` (MariaDB), `8080` (midPoint), `5060/udp` (SIP), `10000-10100/udp` (RTP).

---

### 📂 Estructura del Proyecto
