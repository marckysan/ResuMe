var express = require("express");
const bodyParser = require("body-parser");
const { check, validationResult } = require('express-validator');
var router = express.Router();

router.get("/", function(req, res, next) {
    res.render("myResumes");
});

module.exports = router;
