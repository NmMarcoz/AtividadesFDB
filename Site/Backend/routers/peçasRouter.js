const express = require('express');
const router = express.Router();
const peçasController = require('../controllers/peçasController')


router.get("/", peçasController.findAllPeças);
router.post("/", peçasController.createPeça);


module.exports = router;