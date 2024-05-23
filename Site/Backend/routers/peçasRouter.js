const express = require('express');
const router = express.Router();
const peçasController = require('../controllers/peçasController')


router.get("/", peçasController.findAllPeças);
router.post("/", peçasController.createPeça);
router.get("/search/", peçasController.findPerName)
router.get("/:id", peçasController.findByPk);


module.exports = router;