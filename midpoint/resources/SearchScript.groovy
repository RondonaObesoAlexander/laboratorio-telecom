import groovy.sql.Sql

def sql = new Sql(connection)
def results = []

if (options?.filter) {
    def username = options.filter.username
    if (username) {
        sql.eachRow("SELECT * FROM clients WHERE username = ?", [username]) { row ->
            results << rowToMap(row)
        }
    }
} else {
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