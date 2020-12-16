var express = require("express");
const bodyParser = require("body-parser");
const { check, validationResult } = require('express-validator');
var router = express.Router();

router.get("/myAchievements", function(req, res, next) {
    res.render("myAchievements");
});

module.exports = router;
