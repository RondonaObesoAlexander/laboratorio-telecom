# ===================================================
# ETAPA 1: COMPILACIÓN (Build)
# ===================================================
FROM debian:bullseye AS builder

ARG ASTERISK_VERSION=18.26.0

# Instalar dependencias de compilación
RUN apt-get update && apt-get install -y \
    wget build-essential cmake \
    libssl-dev libxml2-dev libjansson-dev \
    libedit-dev libsqlite3-dev \
    libsrtp2-dev libpcre3-dev \
    uuid-dev libcurl4-openssl-dev \
    libmariadb-dev libmariadb-dev-compat \
    unixodbc-dev \
    && rm -rf /var/lib/apt/lists/*

# Descargar y descomprimir Asterisk
RUN wget http://downloads.asterisk.org/pub/telephony/asterisk/releases/asterisk-${ASTERISK_VERSION}.tar.gz \
    && tar -xzf asterisk-${ASTERISK_VERSION}.tar.gz \
    && cd asterisk-${ASTERISK_VERSION} \
    && ./configure --with-pjproject-bundled --with-mysql=yes

# Seleccionar módulos
RUN cd asterisk-${ASTERISK_VERSION} \
    && make menuselect.makeopts \
    && menuselect/menuselect --enable chan_pjsip \
    && menuselect/menuselect --enable cdr_mysql \
    && menuselect/menuselect --enable res_ari \
    && menuselect/menuselect --enable res_ari_channels \
    && menuselect/menuselect --enable res_ari_endpoints \
    && make -j$(nproc) \
    && make install \
    && make samples

# ===================================================
# ETAPA 2: IMAGEN FINAL (Ejecución)
# ===================================================
FROM debian:bullseye

RUN apt-get update && apt-get install -y \
    libssl1.1 libxml2 libjansson4 \
    libedit2 libsqlite3-0 \
    libsrtp2-1 libcurl4 \
    libmariadb3 unixodbc \
    && rm -rf /var/lib/apt/lists/*

# Copiar binarios y librerías desde la etapa builder
COPY --from=builder /usr/sbin/asterisk /usr/sbin/
COPY --from=builder /usr/lib/asterisk /usr/lib/asterisk
COPY --from=builder /etc/asterisk /etc/asterisk-base
COPY --from=builder /var/lib/asterisk /var/lib/asterisk-base

# Copiar explícitamente la librería SSL
COPY --from=builder /usr/lib/x86_64-linux-gnu/libasteriskssl.so.1 /usr/lib/x86_64-linux-gnu/

# Crear directorios necesarios
RUN mkdir -p /etc/asterisk /var/log/asterisk /var/run/asterisk

# Exponer puertos
EXPOSE 5060/udp 5060/tcp 10000-10100/udp

CMD ["asterisk", "-f", "-vvv", "-c"]