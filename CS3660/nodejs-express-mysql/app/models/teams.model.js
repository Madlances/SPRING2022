const sql = require('./db.js');

const Team = function (team) {
    this.id = team.id;
    this.name = team.name;
    this.coach_id = team.coach_id;
    this.league_id = team.league_id;
    this.notes = team.notes;
};

Team.create = (newTeam, result) => {
    sql.query('INSERT INTO teams SET ?', newTeam, (err, res) => {
        if (err) {
            console.log('error inserting into teams table', err);
            result(err, null);
            return;
        }
        console.log('created team: ', { ...newTeam, id: res.insertId });
        result(null, { ...newTeam, id: res.insertId });
    });
};

Team.findById = (id, result) => {
    sql.query(`SELECT * FROM teams WHERE id = ${id}`, (err, res) => {
        if (err) {
            console.log('error selecting team by id', err);
            result(null, res[0]);
            return;
        }
        if (res.length) {
            console.log('found team', res[0]);
            result(null, res[0]);
            return;
        }
        result({ kind: 'not_found' }, null);
    });
};

Team.findByName = (teamName, result) => {
    sql.query(
        `SELECT COUNT(name) AS count FROM teams WHERE name = ${teamName}`,
        (err, res) => {
            if (err) {
                console.log(`error selecting teams with the name ${teamName}`);
                result(null, res[0]);
                return;
            }
            if (res.length) {
                console.log(
                    `found teams with the name ${teamName}, count: ` +
                        res[0].count,
                );
                result(null, res[0]);
                return;
            }
            result({ kind: 'not_found' }, null);
        },
    );
};

Team.getAll = (
    filterCol,
    filterStr,
    sortCol,
    sortDir,
    limitNum,
    offsetNum,
    result,
) => {
    let query = 'SELECT * FROM teams';
    let filterQuery = ` WHERE ${filterCol} LIKE \'%${filterStr}%\'`;
    let limitOffsetQuery = ` LIMIT ${limitNum} OFFSET ${offsetNum}`;

    if (filterCol != undefined && filterStr != undefined) query += filterQuery;
    if (sortCol != undefined && sortDir != undefined) {
        if (sortDir == 'dsc' || sortDir == 'DSC') sortDir = 'DESC';
        let sortQuery = ` ORDER BY ${sortCol} ${sortDir}`;
        query += sortQuery;
    }

    if (limitNum != undefined && offsetNum != undefined)
        query += limitOffsetQuery;
    console.log('hi', query);
    sql.query(query, (err, res) => {
        if (err) {
            console.log('error getting all teams: ', err);
            result(null, err);
            return;
        }
        //console.log('teams: ', res)
        result(null, res);
    });
};

Team.updateById = (id, team, result) => {
    sql.query(
        'UPDATE teams SET name = ?, coach_id = ?, league_id = ?, notes = ? WHERE id = ?',
        [team.name, team.coach_id, team.league_id, team.notes, id],
        (err, res) => {
            if (err) {
                console.log('error updating by id: ', err);
                result(null, err);
                return;
            }
            if (res.affectedRows == 0) {
                result({ kind: 'not_found' }, null);
                return;
            }
            console.log('updated teams: ', { id: id, ...team });
            result(null, { id: id, ...team });
        },
    );
};

Team.remove = (id, result) => {
    sql.query('DELETE FROM teams WHERE id = ?', id, (err, res) => {
        if (err) {
            console.log('error deleting team: ', err);
            result(null, err);
            return;
        }
        if (res.affectedRows == 0) {
            result({ kind: 'not_found' }, null);
            return;
        }
        console.log('deleted team with id: ', id);
        result(null, res);
    });
};

Team.removeAll = (result) => {
    sql.query('DELETE FROM teams', (err, res) => {
        if (err) {
            console.log('error deleting the teams table: ', err);
            result(null, err);
            return;
        }
        console.log(`deleted ${res.affectedRows} teams`);
        result(null, res);
    });
};

Team.checkDuplicateName = async (value) => {
    return new Promise((resolve, reject) => {
        sql.query('SELECT * FROM teams WHERE name = ?', [value], (err, res) => {
            if (err) {
                console.log('error checking for duplicate name: ', err);
                error();
            }
            if (res.length > 0) {
                console.log(`Name ${value} is a duplicate`);
                reject('duplicate team name');
            } else {
                console.log(`Name ${value} is not a duplicate`);
                resolve(false);
            }
        });
    });
};

module.exports = Team;
