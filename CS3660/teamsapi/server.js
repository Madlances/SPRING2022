/*
 
Project:  LMS5
Name: Kassandra Madsen
Submitted: 04-29-22
 
I declare that the following source code was written by me, or provided
by the instructor for this project. I understand that copying source
code from any other source, providing source code to another student, 
or leaving my code on a public web site constitutes cheating.
I acknowledge that  If I am found in violation of this policy this may result
in a zero grade, a permanent record on file and possibly immediate failure of the class.
 
Reflection (1-2 paragraphs):
This project was pretty good as well, I enjoyed the backend more than the frontend,
it was cool to learn more about routing and hashing. Also learning how to setup a backend
and integrate that into our frontend. Wish I could have had more time to deploy it to
AWS.
 

*/
const express = require('express');
const cors = require('cors');
const app = express();
const teamRoutes = require('./app/routes/teams.routes.js');
const lookupRoutes = require('./app/routes/lookup.routes.js');

var corsOptions = {
    origin: 'amazonaws.com',
    origin: 'http://127.0.0.1:5500',
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
