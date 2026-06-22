# Laboratorio de Integración - Telecom + IAM

## Objetivo
Modernizar central telefónica con Asterisk y control de acceso con midPoint.

## Tecnologías
- Docker / Docker Compose
- Asterisk 18 (PJSIP + ARI)
- midPoint 4.8 (Identity Governance)
- PostgreSQL 15

## Historias de Usuario (Sprint 1)
- [US-01] Como agente, quiero autenticarme con mi usuario LDAP (vía midPoint) para recibir llamadas.
- [US-02] Como administrador, quiero ver los CDRs en tiempo real.

## Cómo Levantar el Entorno
1. `docker-compose up --build`
2. Acceder a midPoint: `https://localhost:8443/midpoint` (admin / 5ecr3t)
3. Acceder a Asterisk ARI: `http://localhost:8088/ari`