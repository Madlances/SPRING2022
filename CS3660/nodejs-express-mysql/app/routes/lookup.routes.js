const sql = require('../models/db.js');
module.exports = (app) => {
    app.get('/lookups/:lookupTable', async (req, res) => {
        let query = '';
        switch (req.params.lookupTable) {
            case 'coaches':
                query =
                    "SELECT CONCAT(first_name, ' ', last_name) as label, id as value FROM people WHERE person_type='coach'";
                break;
            case 'teams':
                query = 'SELECT name as label, id as value FROM teams';
                break;
        }
        let result = sql.query(query);
        sql.query(query, (err, result) => {
            if (err) {
                res.send(err);
                console.log(err.message);
            }
            console.log(`Looked up`, req.params.lookupTable, 'and got', result);
            res.send(result);
        });
    });
};
