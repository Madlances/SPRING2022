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

exports.create = async (req, res) => {
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

    try {
        const data = await Team.create(team);
        res.status(201).send(data);
    } catch (err) {
        res.status(500).send({
            message:
                err.message || 'Some error occurred while creating the Team.',
        });
    }
};

exports.findAll = async (req, res) => {
    let queryFilterCol = req.query.filterCol;
    let queryFilterStr = req.query.filterStr;
    let querySortCol = req.query.sortCol;
    let querySortDir = req.query.sortDir;
    let queryLimit = req.query.limit;
    let queryOffset = req.query.offset;

    try {
        const data = await Team.getAll(
            queryFilterCol,
            queryFilterStr,
            querySortCol,
            querySortDir,
            queryLimit,
            queryOffset,
        );
        res.send(data);
    } catch (err) {
        res.status(500).send({
            message:
                err.message || 'Some error occured while retrieving all teams.',
        });
    }
};

exports.findOne = async (req, res) => {
    try {
        const data = await Team.findById(req.params.id);
        res.send(data);
    } catch (err) {
        console.log(err);
        if (err.kind === 'not_found') {
            res.status(404).send({
                message: `Not found Team with id ${req.params.id}.`,
            });
        } else {
            res.status(500).send({
                message:
                    err.message ||
                    'Error retrieving Team with id ' + req.params.id,
            });
        }
    }
};

exports.update = async (req, res) => {
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

    try {
        const data = await Team.updateById(req.params.id, new Team(req.body));
        res.send(data);
    } catch (err) {
        if (err.kind === 'not_found') {
            res.status(404).send({
                message: `Not found Team with id ${req.params.id}.`,
            });
        } else {
            res.status(500).send({
                message: 'Error updating Team with id ' + req.params.id,
            });
        }
    }
};

exports.delete = async (req, res) => {
    try {
        const data = await Team.remove(req.params.id, new Team(req.body));
        res.send({ message: `Team was deleted successfully!` });
    } catch (err) {
        if (err.kind === 'not_found') {
            res.status(404).send({
                message: `Not found Team with id ${req.params.id}.`,
            });
        } else {
            res.status(500).send({
                message: 'Could not delete Team with id ' + req.params.id,
            });
        }
    }
};
