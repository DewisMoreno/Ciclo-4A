const {Router} = require('express');
const router = Router();
const auth = require('../Auth/Auth');

const {getCategorias, getCategoria, createCategoria, editCategoria, deleteCategoria} = require('../controller/categoria.controller');

router.get('/categorias', getCategorias);
router.get('/categoria/:codigo', getCategoria);
router.post('/categoria', auth, createCategoria);
router.put('/categoria/:codigo', auth, editCategoria);
router.delete('/categoria/:codigo', auth, deleteCategoria);

module.exports = router;