const facturaController = {};
const Factura = require('../model/factura.model')


facturaController.getFacturas = async (req, res) => {
    try {
        const facturas = await Factura.find({});
        res.status(200).json(facturas);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 1");
    }

};


facturaController.getFactura = async (req, res) => {
    try {
        const factura = await Factura.findOne({ numeroFactura: req.params.numeroFactura });

        res.status(200).json(factura);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 2");
    }
};


facturaController.createFactura = async (req, res) => {
    try {
        const {
            numeroFactura,    
            cliente,
            fecha,
            numPedido,
            lugarEntrega,
            modoPago
        } = req.body;

        let _factura = new Factura({numeroFactura, cliente, fecha, numPedido, lugarEntrega, modoPago});
        await _factura.save();

        res.status(201).send("Factura creado satisfactoriamente.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 3");
    }

};

facturaController.editFactura = async (req, res) => {
    try {
        const {
            numeroFactura,    
            cliente,
            fecha,
            numPedido,
            lugarEntrega,
            modoPago
        } = req.body;


        await Factura.updateOne({ numeroFactura: req.params.numeroFactura }, {numeroFactura, cliente, fecha, numPedido, lugarEntrega, modoPago});

        res.status(200).send("Actualizacion de factura satisfactoria.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 4");
    }
};

facturaController.deleteFactura = async (req, res) => {
    try {

        await Factura.deleteOne({numeroFactura: req.params.numeroFactura });
        res.status(200).send("Factura eliminado con éxito.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 5");
    }
};

module.exports = facturaController;
