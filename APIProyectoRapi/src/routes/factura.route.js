const {Router} = require("express")
const router = Router();

const {getFacturas, getFactura, createFactura, editFactura, deleteFactura } = require ('../controller/factura.controller');

router.get('/facturas', getFacturas); // pedir todos los facturas
router.get('/factura/:numeroFactura', getFactura); // pedir un solo factura
router.post('/factura', createFactura); // Crear un factura
router.put('/factura/:numeroFactura', editFactura); // Editar un factura
router.delete('/factura/:numeroFactura', deleteFactura); // Eliminar un factura

module.exports = router;