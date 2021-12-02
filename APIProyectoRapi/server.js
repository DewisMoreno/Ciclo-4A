const express = require("express");
const app = express();
const bodyParser = require("body-parser");

//middlewares
app.use(bodyParser.json());

//Rutas
app.use(require('./src/routes/main.route'));
app.use(require('./src/routes/usuario.route'));
app.use(require('./src/routes/producto.route'));
app.use(require('./src/routes/pedido.route'));
app.use(require('./src/routes/factura.route'));
app.use(require('./src/routes/categoria.route'));


module.exports = app;
