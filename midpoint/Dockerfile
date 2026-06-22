FROM evolveum/midpoint:${MIDPOINT_VERSION}

# Copiamos los recursos de importación (donde va el resource-asterisk.xml)
COPY resources /opt/midpoint/var/import

# Variables de entorno para conexión a DB (se inyectan desde compose)
ENV MIDPOINT_REPOSITORY_DATABASE=postgresql