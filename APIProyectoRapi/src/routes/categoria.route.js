const {Router} = require('express');
const router = Router();

const {getCategorias, getCategoria, createCategoria, editCategoria, deleteCategoria} = require('../controller/categoria.controller');

router.get('/categorias', getCategorias);
router.get('/categoria/:codigo', getCategoria);
router.post('/categoria', createCategoria);
router.put('/categoria/:codigo', editCategoria);
router.delete('/categoria/:codigo', deleteCategoria);

module.exports = router;