const express = require('express');
const router = express.Router();
const peçasController = require('../controllers/peçasController')


router.get("/search", peçasController.findPerName)
router.get("/", peçasController.findAllPeças);

router.get("/:id", peçasController.findByPk);
router.post("/", peçasController.createPeça);

router.delete("/:id", peçasController.deleteByPk);


module.exports = router;

