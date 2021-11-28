const { Router } = require("express");
const router = Router();

const {getProductos, getProducto, createProducto, editProducto, deleteProducto } = require ('../controller/producto.controller');

router.get('/productos', getProductos); // pedir todos los productos
router.get('/producto/:codigo', getProducto); // pedir un solo producto
router.post('/producto', createProducto); // Crear un producto
router.put('/producto/:codigo', editProducto); // Editar un producto
router.delete('/producto/:codigo', deleteProducto); // Eliminar un producto

module.exports = router;