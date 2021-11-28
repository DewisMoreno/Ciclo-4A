const productoController = {};
const Producto = require('../model/producto.model');

//const Categoria = require('../model/categoria.model');

/*productoController.getCategoria = async(req, res) =>{ 
    try {
        const categorias = await Categoria.find({});
        res.status(200).json(categorias);
    } catch (error) {
       console.log(error);
       res.status(400).send("Ocurrió un error en la operacion");
    }

}; */

productoController.getProductos = async (req, res) => {
    try {
        const productos = await Producto.find({});
        res.status(200).json(productos);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 1");
    }

};


productoController.getProducto = async (req, res) => {
    try {
        const producto = await Producto.findOne({ codigo: req.params.codigo });

        res.status(200).json(producto);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 2");
    }
};


productoController.createProducto = async (req, res) => {
    try {
        const {
            categoria,
            nombre,
            codigo,
            descripcion,
            precio,
            unidades

        } = req.body;

        let _producto = new Producto({categoria, nombre, codigo, descripcion, precio, unidades });
        await _producto.save();

        res.status(201).send("Producto creado satisfactoriamente.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 3");
    }

};

productoController.editProducto = async (req, res) => {
    try {
        const {
            categoria,
            nombre,
            codigo,
            descripcion,
            precio,
            unidades
        } = req.body;


        await Producto.updateOne({ codigo: req.params.codigo }, { categoria, nombre, codigo, descripcion, precio, unidades });

        res.status(200).send("Actualizacion de producto satisfactoria.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 4");
    }
};

productoController.deleteProducto = async (req, res) => {
    try {

        await Producto.deleteOne({ codigo: req.params.codigo });
        res.status(200).send("Producto eliminado con éxito.");

    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrió un error en la operacion 5");
    }
};

module.exports = productoController;
