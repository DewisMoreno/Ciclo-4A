const mongoose = require ('mongoose');
const {Schema} = require ('mongoose');


let pedidoSchema = new Schema ({
    numeroPedido: Number,
    cliente: String,
    fecha: Date,
    producto: String
});

const Pedido = mongoose.model('Pedido', pedidoSchema);

module.exports = Pedido;