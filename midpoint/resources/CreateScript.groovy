import groovy.sql.Sql

def sql = new Sql(connection)
def username = object.getAttribute('username')
def fullName = object.getAttribute('fullName')
def extension = object.getAttribute('phoneExtension')

def query = """
    INSERT INTO clients (username, full_name, phone_extension, active)
    VALUES (?, ?, ?, 1)
"""
sql.execute(query, [username, fullName, extension])
log.info("Usuario creado en BD: ${username}")
return object