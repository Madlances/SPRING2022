const express = require('express');
const cors = require('cors');
const app = express();
const teamRoutes = require('./app/routes/teams.routes.js');
const lookupRoutes = require('./app/routes/lookup.routes.js');

var corsOptions = {
    origin: 'amazonaws.com',
};
app.use(cors(corsOptions));
// parse requests of content-type
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
// simple route
app.get('/', (req, res) => {
    res.json({ message: "Welcome to Kassandra's Server." });
});

teamRoutes(app);
lookupRoutes(app);

// set port, listen for requests
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}.`);
});
