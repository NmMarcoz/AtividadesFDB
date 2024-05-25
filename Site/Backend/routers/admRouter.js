const admController = require('../controllers/admController')
const express = require('express')
const router = express.Router();

router.post("/", admController.create);
router.post("/auth", admController.auth);

module.exports = router;