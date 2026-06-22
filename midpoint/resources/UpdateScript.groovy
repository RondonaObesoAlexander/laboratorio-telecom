import groovy.sql.Sql

def sql = new Sql(connection)

def username = object.getAttribute('username')
def fullName = object.getAttribute('fullName')
def extension = object.getAttribute('phoneExtension')
def active = object.getAttribute('active')

def query = """
    UPDATE clients
    SET full_name = ?, phone_extension = ?, active = ?
    WHERE username = ?
"""
sql.execute(query, [fullName, extension, active ? 1 : 0, username])

log.info("Usuario actualizado en BD: ${username}")
return object