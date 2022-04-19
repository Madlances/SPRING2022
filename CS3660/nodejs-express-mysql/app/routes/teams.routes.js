const { validationResult } = require('express-validator');

module.exports = (app) => {
    const teams = require('../controllers/teams.controller.js');
    let router = require('express').Router();

    router.post('/teams/', teams.validate('createTeam'), (req, res) => {
        try {
            const errors = validationResult(req);
            if (errors) {
                console.log(errors);
            }
            teams.create(req, res);
        } catch (err) {
            res.send(err);
            console.log(err.message);
        }
    });
    router.get('/teams', teams.findAll);
    router.get('/teams/:id', teams.findOne);
    router.put('/teams/:id', teams.validate('updateTeam'), teams.update);
    router.delete('/teams/:id', teams.delete);
    router.delete('/teams', teams.deleteAll);

    app.use('/', router);
};
