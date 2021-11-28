const pedidoController = {};
const Pedido = require('../model/pedido.model')


pedidoController.getPedidos = async (req, res) => {
    try {
        const pedidos = await Pedido.find({});
        res.status(200).json(pedidos);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 1");
    }

};


pedidoController.getPedido = async (req, res) => {
    try {
        const pedido = await Pedido.findOne({ numeroPedido: req.params.numeroPedido });

        res.status(200).json(pedido);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 2");
    }
};


pedidoController.createPedido = async (req, res) => {
    try {
        const pedidoTemp = {
            numeroPedido: req.body.numeroPedido,
            cliente: req.body.cliente,
            fecha: req.body.fecha,
            producto: req.body.producto

        };

        let _pedido = new Pedido(pedidoTemp );
        await _pedido.save();

        res.status(201).send("Pedido creado satisfactoriamente.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 3");
    }

};

pedidoController.editPedido = async (req, res) => {
    try {
        const {
            numeroPedido,
            cliente,
            fecha,
            producto
        } = req.body;


        await Pedido.findOneAndUpdate({ numeroPedido: req.params.numeroPedido }, {numeroPedido, cliente, fecha, producto });

        res.status(200).send("Actualizacion de pedido satisfactoria.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 4");
    }
};

pedidoController.deletePedido = async (req, res) => {
    try {

        await Pedido.deleteOne({numeroPedido: req.params.numeroPedido });
        res.status(200).send("Pedido eliminado con éxito.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 5");
    }
};

module.exports = pedidoController;
