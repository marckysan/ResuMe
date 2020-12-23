// jshint esversion: 6

const express = require("express");
const bodyParser = require("body-parser");
const ejs = require("ejs");
const flash = require("connect-flash");
const cookieParser = require('cookie-parser');
const session = require('express-session'); // Allow storing of session data
const passport = require("passport"); // Authentication of user
// var passportinit = require("./passportinit");


// Files for the Routes
var homeRouter = require('./routes/home');
var aboutUsRouter = require('./routes/aboutUs');
var myAchievementsRouter = require('./routes/myAchievements');
var myResumesRouter = require('./routes/myResumes');
var myProfileRouter = require('./routes/myProfile');
var dashboardRouter = require('./routes/dashboard');
var forgetPasswordRouter = require('./routes/forgetPassword');
var addNewProjectRouter = require('./routes/addNewProject');
var addNewResumeRouter = require('./routes/addNewResume');
var editProfileRouter = require('./routes/editProfile');

const app = express();

app.set('view engine', 'ejs');

app.use(express.json());
app.use(express.urlencoded({extended: false}));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static("public"));

app.use(cookieParser());
app.use(session({
  secret: "secret",
  saveUninitialized: true,
  resave: false
}));
//
// app.use(passport.initialize());
// app.use(passport.session());
// passportinit();

app.use(flash());
app.use(function (req, res, next) {
  res.locals.message = req.flash("message");
  req.flash("message");
  next();
});


// Routes
app.use('/', homeRouter);
app.use('/aboutUs', aboutUsRouter);
app.use('/myAchievements', myAchievementsRouter);
app.use('/myResumes', myResumesRouter);
app.use('/myProfile', myProfileRouter);
app.use('/dashboard', dashboardRouter);
app.use('/forgetPassword', forgetPasswordRouter);
app.use('/addNewProject', addNewProjectRouter);
app.use('/addNewResume', addNewResumeRouter);
app.use('/editProfile', editProfileRouter);

app.listen(process.env.PORT || 3030, function() {
  console.log("Server started on port 3030")
});
