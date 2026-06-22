import groovy.sql.Sql

def sql = new Sql(connection)

def username = object.getAttribute('username')

def query = "DELETE FROM clients WHERE username = ?"
sql.execute(query, [username])

log.info("Usuario eliminado de BD: ${username}")
return object