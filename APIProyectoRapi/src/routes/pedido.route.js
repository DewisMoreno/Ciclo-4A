const { Router } = require("express")
const router = Router();

const {getPedidos, getPedido, createPedido, editPedido, deletePedido } = require ('../controller/pedido.controller');

router.get('/pedidos', getPedidos); // pedir todos los pedidos
router.get('/pedido/:numeroPedido', getPedido); // pedir un solo pedido
router.post('/pedido', createPedido); // Crear un pedido
router.put('/pedido/:numeroPedido', editPedido); // Editar un pedido
router.delete('/pedido/:numeroPedido', deletePedido); // Eliminar un pedido

module.exports = router;