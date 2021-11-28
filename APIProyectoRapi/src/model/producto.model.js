const mongoose = require ('mongoose');
const {Schema} = require ('mongoose');


let productoSchema = new Schema ({
    categoria: String,
    nombre: String,
    codigo: String,
    descripcion: String,
    precio: Number,
    unidades: Number
});

const Producto = mongoose.model('Producto', productoSchema);

module.exports = Producto;