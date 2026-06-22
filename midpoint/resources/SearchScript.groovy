import groovy.sql.Sql

def sql = new Sql(connection)
def results = []

// Si se proporciona un filtro de búsqueda
if (options?.filter) {
    // Buscar un usuario específico por username
    def username = options.filter.username
    if (username) {
        sql.eachRow("SELECT * FROM clients WHERE username = ?", [username]) { row ->
            results << rowToMap(row)
        }
    }
} else {
    // Si no hay filtro, devolver todos los usuarios activos
    sql.eachRow("SELECT * FROM clients WHERE active = 1") { row ->
        results << rowToMap(row)
    }
}

return results

def rowToMap(row) {
    return [
        username: row.username,
        fullName: row.full_name,
        phoneExtension: row.phone_extension,
        active: row.active ? true : false
    ]
}