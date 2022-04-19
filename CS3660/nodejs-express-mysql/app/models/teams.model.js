const connection = require('./db.js');

const Team = function (team) {
    this.id = team.id;
    this.name = team.name;
    this.coach_id = team.coach_id;
    this.league_id = team.league_id;
    this.notes = team.notes;
};

Team.create = async (newTeam) => {
    try {
        const conn = await connection;
        const res = await conn.query('INSERT INTO teams SET ?', newTeam);
        console.log('created team: ', { ...newTeam, id: res.insertId });
        return { ...newTeam, id: res[0].insertId };
    } catch (err) {
        console.log('error inserting into teams table', err);
        throw err;
    }
};

Team.findById = async (id) => {
    try {
        const conn = await connection;
        const res = await conn.query('SELECT * FROM teams WHERE id = ?', id);
        if (res[0].length > 0) {
            console.log('found team', res[0][0]);
            return res[0][0];
        } else {
            throw { kind: 'not_found' };
        }
    } catch (err) {
        console.log('error selecting team by id', err);
        throw err;
    }
};

Team.getAll = async (
    filterCol,
    filterStr,
    sortCol,
    sortDir,
    limitNum,
    offsetNum,
) => {
    let query = 'SELECT * FROM teams';
    let filterQuery = ` WHERE ${filterCol} LIKE \'%${filterStr}%\'`;
    let limitOffsetQuery = ` LIMIT ${limitNum} OFFSET ${offsetNum}`;

    if (filterCol != undefined && filterStr != undefined) {
        query += filterQuery;
    }

    if (sortCol != undefined && sortDir != undefined) {
        if (sortDir == 'dsc' || sortDir == 'DSC') sortDir = 'DESC';
        let sortQuery = ` ORDER BY ${sortCol} ${sortDir}`;
        query += sortQuery;
    }

    if (limitNum != undefined && offsetNum != undefined)
        query += limitOffsetQuery;
    try {
        const conn = await connection;
        const res = await conn.query(query);
        return res[0];
    } catch (err) {
        console.log('error getting all teams: ', err);
        throw err;
    }
};

Team.updateById = async (id, team) => {
    try {
        const conn = await connection;
        const res = await conn.query(
            'UPDATE teams SET name = ?, coach_id = ?, league_id = ?, notes = ? WHERE id = ?',
            [team.name, team.coach_id, team.league_id, team.notes, id],
        );
        if (res[0].affectedRows > 0) {
            console.log('updated teams: ', { id: id, ...team });
            return { id: id, ...team };
        } else {
            throw { kind: 'not_found' };
        }
    } catch (err) {
        console.log('error updating by id: ', err);
        throw err;
    }
};

Team.remove = async (id) => {
    try {
        const conn = await connection;
        const res = await conn.query('DELETE FROM teams WHERE id = ?', id);
        if (res[0].affectedRows > 0) {
            console.log('deleted team with id: ', id);
            return;
        } else {
            throw { kind: 'not_found' };
        }
    } catch (err) {
        console.log('error deleting team: ', err);
        throw err;
    }
};

Team.checkDuplicateName = async (value) => {
    try {
        const conn = await connection;
        const res = await conn.query(
            'SELECT * FROM teams WHERE name = ?',
            value,
        );
        if (res[0].length > 0) {
            console.log(`Name ${value} is a duplicate`);
            throw new Error('duplicate team name');
        } else {
            console.log(`Name ${value} is not a duplicate`);
            return false;
        }
    } catch (err) {
        console.log('error checking for duplicate name', err);
        throw err;
    }
};

module.exports = Team;
