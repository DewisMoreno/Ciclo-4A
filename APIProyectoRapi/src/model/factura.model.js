const mongoose = require ('mongoose');
const {Schema} = require ('mongoose');

let facturaSchema = new Schema ({

    numeroFactura: Number,    
    cliente: String,
    fecha: Date,
    numPedido: String,
    lugarEntrega: String,
    modoPago: String
});

const Factura = mongoose.model('Factura', facturaSchema);

module.exports = Factura;