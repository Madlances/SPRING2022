const { body, validationResult, check } = require('express-validator');
const Team = require('../models/teams.model.js');

exports.validate = (method) => {
    let rules = [
        check('name', 'name cannot be empty').trim().escape().not().isEmpty(),
        check('coach_id', 'coach id cannot be empty')
            .trim()
            .escape()
            .isInt()
            .not()
            .isEmpty(),
        check('league_id', 'league id cannot be empty')
            .trim()
            .escape()
            .isInt()
            .notEmpty(),
        check('notes').trim().escape().optional(),
    ];
    switch (method) {
        case 'updateTeam':
            return rules;
        case 'createTeam': {
            return [
                ...rules,
                body('name').custom(async (value) => {
                    return await Team.checkDuplicateName(value); //custom validation to check if team exists
                }),
            ];
        }
    }
};

exports.create = (req, res) => {
    if (!req.body) {
        res.status(400).send({
            message: 'Content cannot be empty!',
        });
    }
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(422).json({ errors: errors.array() });
    }

    const team = new Team({
        name: req.body.name,
        coach_id: req.body.coach_id,
        league_id: req.body.league_id,
        notes: req.body.notes,
    });

    Team.create(team, (err, data) => {
        if (err) {
            res.status(500).send({
                message:
                    err.message ||
                    'Some error occurred while creating the Team.',
            });
        } else {
            res.status(201).send(data);
        }
    });
};

exports.findAll = (req, res) => {
    let queryFilterCol = req.query.filterCol;
    let queryFilterStr = req.query.filterStr;
    let querySortCol = req.query.sortCol;
    let querySortDir = req.query.sortDir;
    let queryLimit = req.query.limit;
    let queryOffset = req.query.offset;

    Team.getAll(
        queryFilterCol,
        queryFilterStr,
        querySortCol,
        querySortDir,
        queryLimit,
        queryOffset,
        (err, data) => {
            if (err) {
                res.status(500).send({
                    message:
                        err.message ||
                        'Some error occured while retrieving all teams.',
                });
            } else {
                res.send(data);
            }
        },
    );
};

exports.findOne = (req, res) => {
    Team.findById(req.params.id, (err, data) => {
        if (err) {
            if (err.kind === 'not_found') {
                res.status(404).send({
                    message: `Not found Team with id ${req.params.id}.`,
                });
            } else {
                res.status(500).send({
                    message: 'Error retrieving Team with id ' + req.params.id,
                });
            }
        } else {
            res.send(data);
        }
    });
};

exports.findName = (req, res) => {
    Team.findByName(req.query.name, (err, data) => {
        if (err) {
            if (err.kind === 'not_found') {
                res.status(404).send({
                    message: `Not found Team with name ${req.params.name}.`,
                });
            } else {
                res.status(500).send({
                    message:
                        'Error retrieving Team with name ' + req.params.name,
                });
            }
        } else {
            res.send(data);
        }
    });
};

exports.update = (req, res) => {
    if (!req.body) {
        res.status(404).send({
            message: 'Content cannot be empty!',
        });
    }
    const errors = validationResult(req);
    if (!errors.isEmpty()) {
        return res.status(422).json({ errors: errors.array() });
    }
    console.log(req.body);

    Team.updateById(req.params.id, new Team(req.body), (err, data) => {
        if (err) {
            if (err.kind === 'not_found') {
                res.status(404).send({
                    message: `Not found Team with id ${req.params.id}.`,
                });
            } else {
                res.status(500).send({
                    message: 'Error updating Team with id ' + req.params.id,
                });
            }
        } else {
            res.send(data);
        }
    });
};

exports.delete = (req, res) => {
    Team.remove(req.params.id, (err, data) => {
        if (err) {
            if (err.kind === 'not_found') {
                res.status(404).send({
                    message: `Not found Team with id ${req.params.id}.`,
                });
            } else {
                res.status(500).send({
                    message: 'Could not delete Team with id ' + req.params.id,
                });
            }
        } else {
            res.send({ message: `Team was deleted successfully!` });
        }
    });
};

exports.deleteAll = (req, res) => {
    Team.removeAll((err, data) => {
        if (err) {
            res.status(500).send({
                message:
                    err.message ||
                    'Some error occurred while removing all teams',
            });
        } else {
            res.send({ message: 'All teams were deleted successfully!' });
        }
    });
};
